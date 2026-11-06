package com.playlist.music_playlist.model;
public class SongNode{

    private int id;
    private String artist;
    private String title;
    private double duration;
    private SongNode next;
    private SongNode previous;


    public SongNode() {
        this.id = 0;
        this.artist = "";
        this.title = "";
        this.duration = 0.0;
        this.next = null;
        this.previous = null;
    }

    public SongNode(int id, String artist, String title, double duration){
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.next = null;
        this.previous = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    } 

    public void serDuration(double duration) {
        this.duration = duration;
    }

    public SongNode getNext() {
        return next;
    }

    public void setNext(SongNode next) {
        this.next = null;
    }

    public SongNode getPrevious() {
        return previous;
    }

    public void setPrevious(SongNode previous) {
        this.previous = null;
    }

    // Song Hot and Talking- Say Now (3.11)
    @Override 
    public String toString() {
        return "Song " + title + "- " + artist
                + " (" + duration + "";
    }
}