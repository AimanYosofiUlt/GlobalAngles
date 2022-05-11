package com.ultimate.globalangles.repository.server.responses.get_all_product_fit;

import com.google.gson.annotations.SerializedName;

public class Langs {
    @SerializedName("en")
    private EnglishLang en;
    @SerializedName("ar")
    private ArabicLang ar;


    public EnglishLang getEn() {
        return en;
    }

    public void setEn(EnglishLang en) {
        this.en = en;
    }

    public ArabicLang getAr() {
        return ar;
    }

    public void setAr(ArabicLang ar) {
        this.ar = ar;
    }
}
