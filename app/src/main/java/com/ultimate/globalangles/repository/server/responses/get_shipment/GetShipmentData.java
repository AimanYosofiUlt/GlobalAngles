package com.ultimate.globalangles.repository.server.responses.get_shipment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetShipmentData {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("path")
    private String path;
    @SerializedName("first_page_url")
    private String first_page_url;
    @SerializedName("data")
    private List<String> data;
    @SerializedName("current_page")
    private int current_page;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
