package com.playlist.music_playlist.controller;

import com.playlist.music_playlist.model.SongNode;
import com.playlist.music_playlist.service.PlaylistService;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/playlist")
@CrossOrigin(origins = "*")

public class PlaylistController {

    private final  PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/all")
    public List<SongNode> getAllSongs() {
        return playlistService.getAllSongs();
    }

    @GetMapping("/current")
    public SongNode getCurrentSong() {
        return playlistService.getCurrentSong();
    }

    @PostMapping("/next")
    public SongNode playNext() {
        return playlistService.playNext();
    }

    @PostMapping("/previous")
    public SongNode playPrevious() {
        return playlistService.playPrevious();
    }

    @PostMapping("/add")
    public List<SongNode> addSong(@RequestBody SongNode song) {
        playlistService.addSong(song);
        return playlistService.getAllSongs();
    }

    @DeleteMapping("/remove/{id}")
    public List<SongNode> removeSong(@PathVariable int id) {
        playlistService.removeSong(id);
        return playlistService.getAllSongs();
    }
    
}