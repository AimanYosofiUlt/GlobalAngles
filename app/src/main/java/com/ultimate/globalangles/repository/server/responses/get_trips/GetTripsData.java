package com.ultimate.globalangles.repository.server.responses.get_trips;

import com.google.gson.annotations.SerializedName;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.Meta;

import java.util.List;

public class GetTripsData {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("to")
    private int to;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("path")
    private String path;
    @SerializedName("from")
    private int from;
    @SerializedName("first_page_url")
    private String first_page_url;
    @SerializedName("data")
    private List<GetTripData> data;
    @SerializedName("current_page")
    private int current_page;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
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

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public List<GetTripData> getData() {
        return data;
    }

    public void setData(List<GetTripData> data) {
        this.data = data;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
