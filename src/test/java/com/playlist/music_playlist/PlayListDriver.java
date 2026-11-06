package com.playlist.music_playlist;

import com.playlist.music_playlist.model.PlaylistLinkedList;
import com.playlist.music_playlist.model.SongNode;

public class PlayListDriver {
    public void main(String[] args) {

        SongNode song1 = new SongNode(1, "Ariana Grande", "we can't be friends", 3.5);
        SongNode song2 = new SongNode(2, "Adela", "Boys", 2.3);
        SongNode song3 = new SongNode(3, "Katseye", "Touch",3.2);
        SongNode song4 = new SongNode(4, "Olivia Rodrigo", "making the bed", 3.5);
        SongNode song5 = new SongNode(5, "PinkPantheress ft Zara Larson", "Stateside", 3.4);
        SongNode song6 = new SongNode(6, "charli xcx", "360", 2.9);

        PlaylistLinkedList myplaylist = new PlaylistLinkedList();

        myplaylist.addSong(song1);
        myplaylist.addSong(song2);
        myplaylist.addSong(song3);
        myplaylist.addSong(song4);
        myplaylist.addSong(song5);
        myplaylist.addSong(song6);
    

        System.out.print(myplaylist);
    }
}
