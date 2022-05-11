package com.ultimate.globalangles.repository.server.responses.get_category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCategoryData {
    @SerializedName("translations")
    private List<Translations> translations;
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private int id;

    public List<Translations> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translations> translations) {
        this.translations = translations;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
