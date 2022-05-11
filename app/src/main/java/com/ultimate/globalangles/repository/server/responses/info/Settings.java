package com.ultimate.globalangles.repository.server.responses.info;

import com.google.gson.annotations.SerializedName;

public class Settings {
    @SerializedName("phone")
    private String phone;
    @SerializedName("currency")
    private String currency;
    @SerializedName("email")
    private String email;
    @SerializedName("keywords")
    private String keywords;
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
}
