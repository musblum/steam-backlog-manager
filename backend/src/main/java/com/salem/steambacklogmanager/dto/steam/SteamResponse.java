package com.salem.steambacklogmanager.dto.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SteamResponse {

    @JsonProperty("game_count")
    private int gameCount;

    private List<SteamGame> games;

    public SteamResponse() {}
    
    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public List<SteamGame> getGames() {
        return games;
    }

    public void setGames(List<SteamGame> games) {
        this.games = games;
    }
}
