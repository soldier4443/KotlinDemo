package com.turastory.kotlindemo.todo.server;

/**
 * VO - data class
 */
public class SongInfo {
    private String title;
    private String artist;
    private int difficulty;
    
    public SongInfo() {
    
    }
    
    public SongInfo(String title, String artist, int difficulty) {
        this.title = title;
        this.artist = artist;
        this.difficulty = difficulty;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}