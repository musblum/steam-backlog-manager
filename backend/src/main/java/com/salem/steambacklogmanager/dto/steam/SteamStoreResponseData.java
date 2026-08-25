package com.salem.steambacklogmanager.dto.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SteamStoreResponseData {

    @JsonProperty("store_items")
    private List<SteamStoreItem> storeItems;

    public List<SteamStoreItem> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<SteamStoreItem> storeItems) {
        this.storeItems = storeItems;
    }
}
