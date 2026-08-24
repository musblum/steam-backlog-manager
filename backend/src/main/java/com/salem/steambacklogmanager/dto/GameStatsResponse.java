package com.salem.steambacklogmanager.dto;

public class GameStatsResponse {
    private int totalGames;
    private int totalHours;

    private int backlog;
    private int playing;
    private int completed;
    private int dropped;
    private int liveService;

    public GameStatsResponse() {
    }

    public GameStatsResponse(int totalHours, int totalGames, int playing, int backlog, int completed, int dropped, int liveService) {
        this.totalHours = totalHours;
        this.totalGames = totalGames;
        this.playing = playing;
        this.backlog = backlog;
        this.completed = completed;
        this.dropped = dropped;
        this.liveService = liveService;
    }

    public int getBacklog() {
        return backlog;
    }

    public int getCompleted() {
        return completed;
    }

    public int getDropped() {
        return dropped;
    }

    public int getLiveService() {
        return liveService;
    }

    public int getPlaying() {
        return playing;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getTotalHours() {
        return totalHours;
    }
}
