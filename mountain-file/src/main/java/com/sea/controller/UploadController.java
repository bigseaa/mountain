package com.sea.controller;

import com.sea.service.UploadService;
import com.sea.vo.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("file/upload")
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping
    public UploadResult upload(@RequestParam("file") MultipartFile uploadFile) {
        return this.uploadService.upload(uploadFile);
    }
}
