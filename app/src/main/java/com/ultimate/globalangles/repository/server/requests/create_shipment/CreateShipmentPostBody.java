package com.ultimate.globalangles.repository.server.requests.create_shipment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateShipmentPostBody {

    @SerializedName("products")
    private List<Products> products;
    @SerializedName("comment")
    private String comment;
    @SerializedName("address")
    private String address;
    @SerializedName("recommend_delivery_date")
    private String recommend_delivery_date;
    @SerializedName("type")
    private String type;
    @SerializedName("order_method")
    private String order_method;
    @SerializedName("delivery_method")
    private String delivery_method;
    @SerializedName("location_id_to")
    private int location_id_to;
    @SerializedName("location_id_from")
    private int location_id_from;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_method() {
        return order_method;
    }

    public void setOrder_method(String order_method) {
        this.order_method = order_method;
    }

    public String getDelivery_method() {
        return delivery_method;
    }

    public void setDelivery_method(String delivery_method) {
        this.delivery_method = delivery_method;
    }

    public int getLocation_id_to() {
        return location_id_to;
    }

    public void setLocation_id_to(int location_id_to0) {
        this.location_id_to = location_id_to0;
    }

    public int getLocation_id_from() {
        return location_id_from;
    }

    public void setLocation_id_from(int location_id_from0) {
        this.location_id_from = location_id_from0;
    }
}
