package com.example.kviz.model;

public class Pitanja {

    private int pitanjeId;
    private boolean tocanOdgovor;

    public Pitanja(int pitanjeId, boolean tocanOdgovor) {
        this.pitanjeId = pitanjeId;
        this.tocanOdgovor = tocanOdgovor;
    }

    public int getPitanjeId() {
        return pitanjeId;
    }

    public void setPitanjeId(int pitanjeId) {
        this.pitanjeId = pitanjeId;
    }

    public boolean isTocanOdgovor() {
        return tocanOdgovor;
    }

    public void setTocanOdgovor(boolean tocanOdgovor) {
        this.tocanOdgovor = tocanOdgovor;
    }
}
