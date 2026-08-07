package com.salem.steambacklogmanager.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateGameRequest {

    @NotBlank
    private String title;

    @Min(0)
    @Max(10)
    private int rating;

    @Min(0)
    private int hoursPlayed;

    @NotBlank
    private String status;

    public CreateGameRequest(){}

    public CreateGameRequest(String title , int rating , int hoursPlayed, String status ) {
        this.title = title;
        this.rating = rating;
        this.hoursPlayed = hoursPlayed;
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
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
