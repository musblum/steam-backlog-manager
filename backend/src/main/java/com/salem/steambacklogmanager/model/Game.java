package com.salem.steambacklogmanager.model;



public class Game {

    private long id;
    private String title;
    private int rating;
    private int hoursPlayed;
    private String status;

    public Game(String title , int rating, int hoursPlayed, String status ) {
        this.hoursPlayed = hoursPlayed;
        this.rating = rating;
        this.status = status;
        this.title = title;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
