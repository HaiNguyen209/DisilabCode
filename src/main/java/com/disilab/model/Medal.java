package com.disilab.model;

public class Medal {
    private int medalId;
    private String medalName;

    public Medal() {
    }

    public Medal(int medalId, String medalName) {
        this.medalId = medalId;
        this.medalName = medalName;
    }

    public int getMedalId() {
        return medalId;
    }

    public void setMedalId(int medalId) {
        this.medalId = medalId;
    }

    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }
}
