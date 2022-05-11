package com.ultimate.globalangles.repository.server.responses.get_all_notifications;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAllNotificationsData {
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
    private List<NotificationData> dataData;
    @SerializedName("current_page")
    private int current_page;

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

    public List<NotificationData> getDataData() {
        return dataData;
    }

    public void setDataData(List<NotificationData> dataData) {
        this.dataData = dataData;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
