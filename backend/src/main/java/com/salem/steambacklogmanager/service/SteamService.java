package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.dto.steam.SteamOwnedGameResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class SteamService {

    @Value("${steam.api.key}")
    private String apiKey;

    private final RestClient restClient = RestClient.create();

    public SteamOwnedGameResponse getOwnedGames(String steamId) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.steampowered.com")
                        .path("/IPlayerService/GetOwnedGames/v1/")
                        .queryParam("key", apiKey)
                        .queryParam("steamid", steamId)
                        .queryParam("include_appinfo", true)
                        .queryParam("include_played_free_games", true)
                        .build())
                .retrieve()
                .body(SteamOwnedGameResponse.class);
    }
}
