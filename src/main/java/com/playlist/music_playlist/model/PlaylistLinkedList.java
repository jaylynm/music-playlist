package com.playlist.music_playlist.model;

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
       
       
       if(head.getId() == id) {
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
              if(current == head.getPrevious()) {
                current = head;
              }
        }
        return true;
       }

       if(tail.getId() == id) {
        tail = tail.getPrevious();
        tail.setNext(null);
          if(current == tail.getNext()) {
            current = tail;
          }
          return true;
       }


       SongNode temp = head;
       while(temp != null && temp.getId() != id) {
        temp = temp.getNext();
       }

       if(temp == null) {
        return false;
       }

       temp.getPrevious().setNext(temp.getNext());
       temp.getNext().setPrevious(temp.getPrevious());

       if(current == temp) {
        current = temp.getNext();
       }
       return true;
    }

    public void getAllSongs() {
        if(head == null) {
            System.out.println("Playlist is empty");
            return;
        }
        
        SongNode temp = head;

        while(temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

}