package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.dto.steam.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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



    public SteamStoreResponse getStoreItemAssets(List<Long> appIds) {
        StringBuilder idsJson = new StringBuilder();

        for (int i = 0; i < appIds.size(); i++) {
            if (i > 0) {
                idsJson.append(",");
            }

            idsJson.append("{\"appid\":")
                    .append(appIds.get(i))
                    .append("}");
        }
        String inputJson = """
        {
          "ids": [%s],
          "context": {
            "country_code": "US"
          },
          "data_request": {
            "include_assets": true
          }
        }
        """.formatted(idsJson);

        return restClient.get()
                .uri(
                        "https://api.steampowered.com/IStoreBrowseService/GetItems/v1/?key={key}&input_json={inputJson}",
                        apiKey,
                        inputJson
                )
                .retrieve()
                .body(SteamStoreResponse.class);

    }


    public Map<Long, String> getLibraryCapsuleUrls(List<Long> appIds) {
        Map<Long, String> imageUrls = new HashMap<>();

        SteamStoreResponse storeResponse = getStoreItemAssets(appIds);

        List<SteamStoreItem> storeItems =
                storeResponse.getResponse().getStoreItems();

        for (SteamStoreItem storeItem : storeItems) {
            Long appId = storeItem.getAppid();

            SteamStoreAssets assets = storeItem.getAssets();

            if (assets == null) {
                continue;
            }

            String assetUrlFormat = assets.getAssetUrlFormat();
            String libraryCapsule = assets.getLibraryCapsule();

            if (assetUrlFormat == null || libraryCapsule == null) {
                continue;
            }

            String imagePath =
                    assetUrlFormat.replace("${FILENAME}", libraryCapsule);

            String imageUrl =
                    "https://shared.akamai.steamstatic.com/store_item_assets/"
                            + imagePath;

            imageUrls.put(appId, imageUrl);
        }

        return imageUrls;
    }
}
