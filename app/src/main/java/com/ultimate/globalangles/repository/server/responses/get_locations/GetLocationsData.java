package com.ultimate.globalangles.repository.server.responses.get_locations;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLocationsData {
    @SerializedName("translations")
    private List<Translations> translations;
    @SerializedName("location_translations")
    private List<LocationTranslations> locationTranslations;
    @SerializedName("name")
    private String name;
    @SerializedName("langs")
    private Langs langs;
    @SerializedName("children")
    private List<GetLocationsData> children;
    @SerializedName("label")
    private String label;
    @SerializedName("id")
    private int id;


    public List<Translations> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translations> translations) {
        this.translations = translations;
    }

    public List<LocationTranslations> getLocationTranslations() {
        return locationTranslations;
    }

    public void setLocation_translations(List<LocationTranslations> locationTranslations) {
        this.locationTranslations = locationTranslations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Langs getLangs() {
        return langs;
    }

    public void setLangs(Langs langs) {
        this.langs = langs;
    }

    public List<GetLocationsData> getChildren() {
        return children;
    }

    public void setChildren(List<GetLocationsData> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
