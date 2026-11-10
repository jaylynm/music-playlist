package com.playlist.music_playlist.service;

import com.playlist.music_playlist.model.PlaylistLinkedList;
import com.playlist.music_playlist.model.SongNode;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Service 
public class PlaylistService {

    private final PlaylistLinkedList playlist = new PlaylistLinkedList();

    @PostConstruct
    public void initializePlaylist() {

        playlist.addSong(new SongNode(1, "Ariana Grande", "we can't be friends", 3.5));
        playlist.addSong(new SongNode(2, "Adela", "Boys", 2.3));
        playlist.addSong(new SongNode(3, "Katseye", "Touch",3.2));
        playlist.addSong(new SongNode(4, "Olivia Rodrigo", "making the bed", 3.5));
        playlist.addSong(new SongNode(5, "PinkPantheress ft Zara Larson", "Stateside", 3.4));
        playlist.addSong(new SongNode(6, "charli xcx", "360", 2.9));
    
        playlist.printPlaylist();
    }
        
        public List<SongNode> getAllSongs() {
            return playlist.getSongsAsList();
        }

        public SongNode getCurrentSong() {
            return playlist.getCurrentSong();
        }

        public SongNode playNext() {
            playlist.playNext();
            return playlist.getCurrentSong();
        }

        public SongNode playPrevious() {
            playlist.playPrevious();
            return playlist.getCurrentSong();
        }

        public void addSong(SongNode song) {
            playlist.addSong(song);
        }

        public boolean removeSong(int id) {
            return playlist.removeSong(id);
        }
    }
