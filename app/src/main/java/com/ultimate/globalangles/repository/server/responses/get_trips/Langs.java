package com.ultimate.globalangles.repository.server.responses.get_trips;

import com.google.gson.annotations.SerializedName;

public class Langs {
    @SerializedName("en")
    private En en;
    @SerializedName("ar")
    private Ar ar;

    public En getEn() {
        return en;
    }

    public void setEn(En en) {
        this.en = en;
    }

    public Ar getAr() {
        return ar;
    }

    public void setAr(Ar ar) {
        this.ar = ar;
    }
}
