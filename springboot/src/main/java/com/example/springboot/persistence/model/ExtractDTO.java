package com.example.springboot.persistence.model;

import org.springframework.web.multipart.MultipartFile;

public class ExtractDTO {
    MultipartFile file ;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
