package com.indy.videoforge.controllers;

import com.indy.videoforge.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping()
    public void uploadVideo(@RequestPart MultipartFile file, @RequestPart String title, @RequestPart String description){
        if(file.isEmpty()){
            throw new RuntimeException("File is empty");
        }

        videoService.uploadVideo(file, title, description);

    }
}
