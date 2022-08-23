package com.devdutt.upload.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadModel {

    private String jsName;
    private String jsDesg;
    private MultipartFile resumeFile;
    private MultipartFile photoFile;

}
