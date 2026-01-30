package com.indy.videoforge.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/video")
public class VideoController {

    @PostMapping()
    public void uploadVideo(@RequestPart MultipartFile file, @RequestPart String title, @RequestPart String description){
        if(file.isEmpty()){
            throw new RuntimeException("File is empty");
        }
    }
}
