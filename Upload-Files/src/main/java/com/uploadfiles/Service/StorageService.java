package com.uploadfiles.Service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String uploadFile(MultipartFile file) throws IOException;
    byte[] downloadFile(String fileName);

}
