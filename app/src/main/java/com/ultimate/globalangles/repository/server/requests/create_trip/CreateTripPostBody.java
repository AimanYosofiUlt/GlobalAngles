package com.ultimate.globalangles.repository.server.requests.create_trip;

import com.google.gson.annotations.SerializedName;
import com.ultimate.globalangles.repository.server.requests.create_shipment.Products;

import java.util.List;

public class CreateTripPostBody {
    @SerializedName("products")
    private List<Products> products;
    @SerializedName("categories")
    private List<Integer> categories;
    @SerializedName("reservation_confirmation")
    private String reservation_confirmation;
    @SerializedName("consumed_weight")
    private int consumed_weight;
    @SerializedName("avaliable_weight")
    private int avaliable_weight;
    @SerializedName("total_rewards")
    private String total_rewards;
    @SerializedName("trip_arrive_date")
    private String trip_arrive_date;
    @SerializedName("trip_date")
    private String trip_date;
    @SerializedName("location_id_from0")
    private int location_id_from0;
    @SerializedName("location_id_to0")
    private int location_id_to0;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public String getReservation_confirmation() {
        return reservation_confirmation;
    }

    public void setReservation_confirmation(String reservation_confirmation) {
        this.reservation_confirmation = reservation_confirmation;
    }

    public int getConsumed_weight() {
        return consumed_weight;
    }

    public void setConsumed_weight(int consumed_weight) {
        this.consumed_weight = consumed_weight;
    }

    public int getAvaliable_weight() {
        return avaliable_weight;
    }

    public void setAvaliable_weight(int avaliable_weight) {
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

    public int getLocation_id_from0() {
        return location_id_from0;
    }

    public void setLocation_id_from0(int location_id_from0) {
        this.location_id_from0 = location_id_from0;
    }

    public int getLocation_id_to0() {
        return location_id_to0;
    }

    public void setLocation_id_to0(int location_id_to0) {
        this.location_id_to0 = location_id_to0;
    }
}
