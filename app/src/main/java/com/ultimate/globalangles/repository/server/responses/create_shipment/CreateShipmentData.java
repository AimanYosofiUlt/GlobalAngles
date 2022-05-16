package com.ultimate.globalangles.repository.server.responses.create_shipment;

import com.google.gson.annotations.SerializedName;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.Meta;

import java.util.List;

public class CreateShipmentData {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("products")
    private List<Products> products;
    @SerializedName("comment")
    private String comment;
    @SerializedName("address")
    private String address;
    @SerializedName("recommend_delivery_date")
    private String recommend_delivery_date;
    @SerializedName("total_value")
    private int total_value;
    @SerializedName("total_weight")
    private int total_weight;
    @SerializedName("delivery_method")
    private String delivery_method;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecommend_delivery_date() {
        return recommend_delivery_date;
    }

    public void setRecommend_delivery_date(String recommend_delivery_date) {
        this.recommend_delivery_date = recommend_delivery_date;
    }

    public int getTotal_value() {
        return total_value;
    }

    public void setTotal_value(int total_value) {
        this.total_value = total_value;
    }

    public int getTotal_weight() {
        return total_weight;
    }

    public void setTotal_weight(int total_weight) {
        this.total_weight = total_weight;
    }

    public String getDelivery_method() {
        return delivery_method;
    }

    public void setDelivery_method(String delivery_method) {
        this.delivery_method = delivery_method;
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
