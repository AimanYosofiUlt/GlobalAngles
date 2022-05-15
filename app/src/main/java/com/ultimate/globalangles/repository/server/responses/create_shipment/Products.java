package com.ultimate.globalangles.repository.server.responses.create_shipment;

import com.google.gson.annotations.SerializedName;

public class Products {
    @SerializedName("product_created_at")
    private String product_created_at;
    @SerializedName("langs")
    private Langs langs;
    @SerializedName("with_packing")
    private int with_packing;
    @SerializedName("product_weight")
    private String product_weight;
    @SerializedName("link")
    private String link;
    @SerializedName("price")
    private int price;
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("product_fit_id")
    private int product_fit_id;
    @SerializedName("location_id_from")
    private int location_id_from;
    @SerializedName("location_id_to")
    private int location_id_to;
    @SerializedName("id")
    private int id;

    public String getProduct_created_at() {
        return product_created_at;
    }

    public void setProduct_created_at(String product_created_at) {
        this.product_created_at = product_created_at;
    }

    public Langs getLangs() {
        return langs;
    }

    public void setLangs(Langs langs) {
        this.langs = langs;
    }

    public int getWith_packing() {
        return with_packing;
    }

    public void setWith_packing(int with_packing) {
        this.with_packing = with_packing;
    }

    public String getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getProduct_fit_id() {
        return product_fit_id;
    }

    public void setProduct_fit_id(int product_fit_id) {
        this.product_fit_id = product_fit_id;
    }

    public int getLocation_id_from() {
        return location_id_from;
    }

    public void setLocation_id_from(int location_id_from) {
        this.location_id_from = location_id_from;
    }

    public int getLocation_id_to() {
        return location_id_to;
    }

    public void setLocation_id_to(int location_id_to) {
        this.location_id_to = location_id_to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
