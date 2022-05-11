package com.ultimate.globalangles.repository.server.responses.info;

import com.google.gson.annotations.SerializedName;

public class ShipmentTypes {
    @SerializedName("ship")
    private String ship;
    @SerializedName("online")
    private String online;

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }
}
