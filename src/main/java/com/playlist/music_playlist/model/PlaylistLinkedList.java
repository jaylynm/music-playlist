package com.playlist.music_playlist.model;

import java.util.ArrayList;
import java.util.List;

public class PlaylistLinkedList {

    SongNode head;
    SongNode tail;
    SongNode current;
    SongNode previous;

    public PlaylistLinkedList() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.previous = null;
    }

    public void addSong(SongNode song) throws NullPointerException {
        if(song == null) {
            throw new NullPointerException("Please add a song to continue");
        }
            if(head == null) {
                head = song;
                tail = song;
                current = song;
            } else {
                tail.setNext(song);
                song.setPrevious(tail);
                tail = song;
            }
        
    }

    public void playNext()  throws NullPointerException{
       //check if the end of the playlist has been reached
        if(current == null ||current.getNext() == null ) {
            throw new NullPointerException("End of playlist");
        }
        //create temporary song node to hold cureent, this way we can keep track of preiously played songs
        SongNode tempSong = current;
        //movre current to the next song
        current = current.getNext();

        //save previous song in previous node
        previous = tempSong;
        
    }

    public void playPrevious() throws NullPointerException {
        if(current == head || current == null) {
            throw new NullPointerException("Rewind not available.");
        }

        current = current.getPrevious();
    }



    public boolean removeSong(int id) {
       
       if(head == null) {
        return false;
       }

       if(id < 1) {
        throw new IllegalArgumentException("Please enter a valid song");
       }  
       
       SongNode temp = head;

       while(temp != null && temp.getId() != id){
        temp = temp.getNext();
       }

       if(temp == null){
        return false;
       }

       SongNode before = temp.getPrevious();
       SongNode after = temp.getNext();

       if(before == null){
        head = after;
       } else {
        before.setNext(after);
       }

       if(after == null){
        tail = before;
       } else {
        after.setPrevious(before);
       }

       if(current == temp) {
        current = after != null ? after : before;
       }

       if(previous == temp){
        previous = before;
       }

       temp.setNext(null);
       temp.setPrevious(null);

       return true;
    }

  public List<SongNode> getSongsAsList() {
    List<SongNode> list = new ArrayList<>();

    SongNode temp = head;

    while(temp != null) {
        list.add(temp);
        temp = temp.getNext();
    }
    return list;
}

public SongNode getCurrentSong() {
    return current;
    }

public void printPlaylist() {
    SongNode temp = head;

    while(temp != null){
        System.out.println(temp.getTitle());
        temp = temp.getNext();
    }
}

/*

public SongNode getCurrentSong() {
            return playlist.getCurrentSong();
        }

*/
}
