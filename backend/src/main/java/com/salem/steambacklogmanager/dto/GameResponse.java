package com.salem.steambacklogmanager.dto;

import com.salem.steambacklogmanager.model.Game;

public class GameResponse {

    private Long id;
    private String title;
    private int rating;
    private int hoursPlayed;
    private String status;

    public GameResponse() {
    }

    public GameResponse(Long id, String title, int rating, int hoursPlayed, String status) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.hoursPlayed = hoursPlayed;
        this.status = status;
    }


    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public String getStatus() {
        return status;
    }

    public int getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
