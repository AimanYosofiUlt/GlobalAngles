package com.ultimate.globalangles.repository.server.responses.create_shipment;

import com.google.gson.annotations.SerializedName;

public class Langs {
    @SerializedName("en")
    private Language en;
    @SerializedName("ar")
    private Language ar;

    public Language getEn() {
        return en;
    }

    public void setEn(Language en) {
        this.en = en;
    }

    public Language getAr() {
        return ar;
    }

    public void setAr(Language ar) {
        this.ar = ar;
    }
}
