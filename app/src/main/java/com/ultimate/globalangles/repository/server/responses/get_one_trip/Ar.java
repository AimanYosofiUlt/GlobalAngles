package com.ultimate.globalangles.repository.server.responses.get_one_trip;

import com.google.gson.annotations.SerializedName;

public class Ar {
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
