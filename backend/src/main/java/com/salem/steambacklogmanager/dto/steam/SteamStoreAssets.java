package com.salem.steambacklogmanager.dto.steam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SteamStoreAssets {

    @JsonProperty("asset_url_format")
    private String assetUrlFormat;

    @JsonProperty("library_capsule")
    private String libraryCapsule;

    public String getAssetUrlFormat() {
        return assetUrlFormat;
    }

    public void setAssetUrlFormat(String assetUrlFormat) {
        this.assetUrlFormat = assetUrlFormat;
    }

    public String getLibraryCapsule() {
        return libraryCapsule;
    }

    public void setLibraryCapsule(String libraryCapsule) {
        this.libraryCapsule = libraryCapsule;
    }
}