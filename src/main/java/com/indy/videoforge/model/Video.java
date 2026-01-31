package com.indy.videoforge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Video {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String contentType;

}
