package com.ultimate.globalangles.repository.server.responses.info;

import com.google.gson.annotations.SerializedName;

public class DeliveryMethods {
    @SerializedName("address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
