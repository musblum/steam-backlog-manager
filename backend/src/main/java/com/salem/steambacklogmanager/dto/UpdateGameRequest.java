package com.salem.steambacklogmanager.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateGameRequest {

    @NotBlank
    private String title;

    @Min(0)
    @Max(10)
    private int rating;

    @Min(0)
    private int hoursPlayed;

    @NotBlank
    private String status;

    public UpdateGameRequest() {
    }

    public UpdateGameRequest(int hoursPlayed, int rating, String status, String title) {
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
