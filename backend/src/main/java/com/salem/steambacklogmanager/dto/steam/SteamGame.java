package com.salem.steambacklogmanager.dto.steam;

public class SteamGame {
    private long appid;
    private String name;
    private int playtime_forever;
    private String img_icon_url;

    public SteamGame() {}

    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public int getPlaytime_forever() {
        return playtime_forever;
    }

    public void setPlaytime_forever(int playtime_forever) {
        this.playtime_forever = playtime_forever;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_icon_url() {
        return img_icon_url;
    }

    public void setImg_icon_url(String img_icon_url) {
        this.img_icon_url = img_icon_url;
    }
}
