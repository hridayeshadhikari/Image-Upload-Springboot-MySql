package com.uploadfiles.Service.Impl;

import com.uploadfiles.Entity.FileData;
import com.uploadfiles.Repository.ImageRepository;
import com.uploadfiles.Service.StorageService;
import com.uploadfiles.Util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    private ImageRepository imageRepository;
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        FileData data=imageRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if(data!=null){
            return file.getOriginalFilename()+ " uploaded successfully";
        }
        return null;
    }

    @Override
    public byte[] downloadFile(String fileName) {
        Optional<FileData> getData= imageRepository.findByName(fileName);
        byte[] image=ImageUtils.decompressImage(getData.get().getImageData());
        return image;
    }
}
