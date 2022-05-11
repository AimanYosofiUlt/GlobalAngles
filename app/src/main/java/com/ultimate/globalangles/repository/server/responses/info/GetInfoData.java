package com.ultimate.globalangles.repository.server.responses.info;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetInfoData {
    @SerializedName("currencies")
    private Currencies currencies;
    @SerializedName("productPacking")
    private List<String> productPacking;
    @SerializedName("deliveryMethods")
    private DeliveryMethods deliveryMethods;
    @SerializedName("shipmentTypes")
    private ShipmentTypes shipmentTypes;
    @SerializedName("settings")
    private Settings settings;
    @SerializedName("locale")
    private String locale;
    @SerializedName("langs")
    private List<String> langs;

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public List<String> getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(List<String> productPacking) {
        this.productPacking = productPacking;
    }

    public DeliveryMethods getDeliveryMethods() {
        return deliveryMethods;
    }

    public void setDeliveryMethods(DeliveryMethods deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    public ShipmentTypes getShipmentTypes() {
        return shipmentTypes;
    }

    public void setShipmentTypes(ShipmentTypes shipmentTypes) {
        this.shipmentTypes = shipmentTypes;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }
}
