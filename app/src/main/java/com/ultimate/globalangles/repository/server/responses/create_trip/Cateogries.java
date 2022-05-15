package com.ultimate.globalangles.repository.server.responses.create_trip;

import com.google.gson.annotations.SerializedName;

public class Cateogries {
    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
