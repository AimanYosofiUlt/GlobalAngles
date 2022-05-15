package com.ultimate.globalangles.repository.server.responses.create_shipment;

import com.google.gson.annotations.SerializedName;

public class Language {
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
