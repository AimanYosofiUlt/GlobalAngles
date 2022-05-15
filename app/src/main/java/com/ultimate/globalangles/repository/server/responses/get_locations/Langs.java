package com.ultimate.globalangles.repository.server.responses.get_locations;

import com.google.gson.annotations.SerializedName;
import com.ultimate.globalangles.repository.server.responses.create_shipment.Language;

public class Langs {
    @SerializedName("en")
    private LocationLang en;
    @SerializedName("ar")
    private LocationLang ar;

    public LocationLang getEn() {
        return en;
    }

    public void setEn(LocationLang en) {
        this.en = en;
    }

    public LocationLang getAr() {
        return ar;
    }

    public void setAr(LocationLang ar) {
        this.ar = ar;
    }
}
