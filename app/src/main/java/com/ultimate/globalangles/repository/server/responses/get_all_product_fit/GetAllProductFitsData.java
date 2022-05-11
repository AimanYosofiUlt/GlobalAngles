package com.ultimate.globalangles.repository.server.responses.get_all_product_fit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAllProductFitsData {
    @SerializedName("translations")
    private List<Translations> translations;
    @SerializedName("product_fit_translations")
    private List<Product_fit_translations> product_fit_translations;
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;
    @SerializedName("image_base64")
    private String image_base64;
    @SerializedName("langs")
    private Langs langs;
    //todo show this is effect the development or not
    @SerializedName("")
    private String EmptyFieldFromResponse;
    @SerializedName("id")
    private int id;

    public List<Translations> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translations> translations) {
        this.translations = translations;
    }

    public List<Product_fit_translations> getProduct_fit_translations() {
        return product_fit_translations;
    }

    public void setProduct_fit_translations(List<Product_fit_translations> product_fit_translations) {
        this.product_fit_translations = product_fit_translations;
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

    public String getImage_base64() {
        return image_base64;
    }

    public void setImage_base64(String image_base64) {
        this.image_base64 = image_base64;
    }

    public Langs getLangs() {
        return langs;
    }

    public void setLangs(Langs langs) {
        this.langs = langs;
    }

    public String getTHIS_IA_AN_INVALID_JAVA_IDENTIFIER_MANUALLY_RESOLVE_THE_ISSUE() {
        return EmptyFieldFromResponse;
    }

    public void setTHIS_IA_AN_INVALID_JAVA_IDENTIFIER_MANUALLY_RESOLVE_THE_ISSUE(String THIS_IA_AN_INVALID_JAVA_IDENTIFIER_MANUALLY_RESOLVE_THE_ISSUE) {
        this.EmptyFieldFromResponse = THIS_IA_AN_INVALID_JAVA_IDENTIFIER_MANUALLY_RESOLVE_THE_ISSUE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
