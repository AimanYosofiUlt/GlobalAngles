package com.ultimate.globalangles.repository.server.responses.get_trips;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowTripsData {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("products")
    private List<String> products;
    @SerializedName("cateogries")
    private List<TripCateogries> cateogries;
    @SerializedName("trip_created_at")
    private String trip_created_at;
    @SerializedName("consumed_weight")
    private String consumed_weight;
    @SerializedName("avaliable_weight")
    private String avaliable_weight;
    @SerializedName("total_rewards")
    private String total_rewards;
    @SerializedName("trip_arrive_date")
    private String trip_arrive_date;
    @SerializedName("trip_date")
    private String trip_date;
    @SerializedName("location_id_from")
    private int location_id_from;
    @SerializedName("location_id_to")
    private int location_id_to;
    @SerializedName("id")
    private int id;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<TripCateogries> getCateogries() {
        return cateogries;
    }

    public void setCateogries(List<TripCateogries> cateogries) {
        this.cateogries = cateogries;
    }

    public String getTrip_created_at() {
        return trip_created_at;
    }

    public void setTrip_created_at(String trip_created_at) {
        this.trip_created_at = trip_created_at;
    }

    public String getConsumed_weight() {
        return consumed_weight;
    }

    public void setConsumed_weight(String consumed_weight) {
        this.consumed_weight = consumed_weight;
    }

    public String getAvaliable_weight() {
        return avaliable_weight;
    }

    public void setAvaliable_weight(String avaliable_weight) {
        this.avaliable_weight = avaliable_weight;
    }

    public String getTotal_rewards() {
        return total_rewards;
    }

    public void setTotal_rewards(String total_rewards) {
        this.total_rewards = total_rewards;
    }

    public String getTrip_arrive_date() {
        return trip_arrive_date;
    }

    public void setTrip_arrive_date(String trip_arrive_date) {
        this.trip_arrive_date = trip_arrive_date;
    }

    public String getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(String trip_date) {
        this.trip_date = trip_date;
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
