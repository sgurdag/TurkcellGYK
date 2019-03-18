package com.sagu.turkcellgyk.models;

public class Haber {

    private String ad;
    private int avatar;
    private int id;

    public Haber(String ad, int avatar, int id) {
        this.ad = ad;
        this.avatar = avatar;
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getId() {
        return id;
    }
}
