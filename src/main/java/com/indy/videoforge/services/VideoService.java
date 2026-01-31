package com.indy.videoforge.services;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {


    void uploadVideo(MultipartFile file, String title, String description);
}
