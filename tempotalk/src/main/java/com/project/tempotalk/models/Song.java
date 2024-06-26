package com.project.tempotalk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document(collection="songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    private String id;
    private String title;
    @DocumentReference
    private Artist artist = null;
    private String releaseDate;
    private int score = 0;
    private List<String> genres = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();

    public Song(String title, String releaseDate){
        this.title = title;
        this.releaseDate = releaseDate;
    }
}
