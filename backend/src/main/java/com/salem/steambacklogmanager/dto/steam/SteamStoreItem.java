package com.salem.steambacklogmanager.dto.steam;

public class SteamStoreItem {

    private Long appid;
    private SteamStoreAssets assets;

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public SteamStoreAssets getAssets() {
        return assets;
    }

    public void setAssets(SteamStoreAssets assets) {
        this.assets = assets;
    }
}
