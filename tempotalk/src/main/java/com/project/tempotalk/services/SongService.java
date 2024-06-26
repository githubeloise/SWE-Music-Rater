package com.project.tempotalk.services;

import com.project.tempotalk.models.Song;
import com.project.tempotalk.payload.request.SongRequest;
import com.project.tempotalk.payload.response.MessageResponse;
import com.project.tempotalk.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    // Return a list of all songs in songRepository
    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    // Return a list of all songs that exist by a title, if there are any
    public Optional<List<Song>> songsByTitle(String title){
        return songRepository.findSongsByTitle(title);
    }

    // Create a new Song object and store it in our "songs" collection
    public MessageResponse createSong(SongRequest songRequest){
        Song song = new Song(songRequest.getTitle(), songRequest.getReleaseDate());
        songRepository.save(song);
        return new MessageResponse("Song created successfully!");
    }
}
