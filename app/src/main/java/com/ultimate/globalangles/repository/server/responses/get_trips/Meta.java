package com.ultimate.globalangles.repository.server.responses.get_trips;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("api_version")
    private String api_version;
    @SerializedName("webservice")
    private String webservice;

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getWebservice() {
        return webservice;
    }

    public void setWebservice(String webservice) {
        this.webservice = webservice;
    }
}
