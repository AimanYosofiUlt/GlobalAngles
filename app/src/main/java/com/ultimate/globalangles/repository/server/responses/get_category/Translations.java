package com.ultimate.globalangles.repository.server.responses.get_category;

import com.google.gson.annotations.SerializedName;

public class Translations {
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("locale")
    private String locale;
    @SerializedName("id")
    private int id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
