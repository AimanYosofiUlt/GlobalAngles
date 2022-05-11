package com.ultimate.globalangles.repository.server.responses.get_all_product_fit;

import com.google.gson.annotations.SerializedName;

public class EnglishLang {
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("locale")
    private String locale;
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;
    @SerializedName("product_fit_id")
    private int product_fit_id;
    @SerializedName("id")
    private int id;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

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

    public int getProduct_fit_id() {
        return product_fit_id;
    }

    public void setProduct_fit_id(int product_fit_id) {
        this.product_fit_id = product_fit_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
