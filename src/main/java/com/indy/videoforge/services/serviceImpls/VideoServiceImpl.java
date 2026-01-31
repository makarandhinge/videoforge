package com.indy.videoforge.services.serviceImpls;

import com.indy.videoforge.model.Video;
import com.indy.videoforge.repositories.VideoRepository;
import com.indy.videoforge.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final String basePath = System.getProperty("user.home");
    private final Path videoStoragePath = Paths.get(basePath).resolve("videoStorage");

    @Override
    public void uploadVideo(MultipartFile file, String title, String description) {
        // Implementation for uploading video
        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setContentType(file.getContentType());

        Video savedVideo = videoRepository.save(video);

        String id = String.valueOf(savedVideo.getId());
        if(!Files.exists(videoStoragePath)) {
            try {
                Files.createDirectories(videoStoragePath);
            } catch (Exception e) {
                throw new RuntimeException("Could not create storage directory", e);
            }
        }

        String type = savedVideo.getContentType().split("/")[1];
        Path filePath = videoStoragePath.resolve(id + "." + type);
        try {
            Files.write(filePath, file.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }

    }
}
