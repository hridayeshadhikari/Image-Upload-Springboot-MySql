package com.uploadfiles.Service;

import com.uploadfiles.Entity.FileData;
import com.uploadfiles.Repository.ImageRepository;
import com.uploadfiles.Util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private ImageRepository imageRepository;

    public String uploadFile(MultipartFile file) throws IOException {
        FileData imageData=imageRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if(imageData!=null){
            return file.getOriginalFilename()+ " uploaded successfully";
        }
        return null;
    }


    public byte[] downloadFile(String fileName) {
        Optional<FileData> getImageData= imageRepository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(getImageData.get().getImageData());
        return images;
    }
}
