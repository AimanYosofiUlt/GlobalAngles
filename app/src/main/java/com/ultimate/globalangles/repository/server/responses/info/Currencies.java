package com.ultimate.globalangles.repository.server.responses.info;

import com.google.gson.annotations.SerializedName;

public class Currencies {
    @SerializedName("pound")
    private String pound;
    @SerializedName("eur")
    private String eur;
    @SerializedName("egp")
    private String egp;
    @SerializedName("dollar")
    private String dollar;

    public String getPound() {
        return pound;
    }

    public void setPound(String pound) {
        this.pound = pound;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getEgp() {
        return egp;
    }

    public void setEgp(String egp) {
        this.egp = egp;
    }

    public String getDollar() {
        return dollar;
    }

    public void setDollar(String dollar) {
        this.dollar = dollar;
    }
}
