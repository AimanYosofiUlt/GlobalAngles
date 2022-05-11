package com.ultimate.globalangles.repository.server.responses.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("expires_in")
    private int expires_in;
    @SerializedName("token_type")
    private String token_type;
    @SerializedName("access_token")
    private String access_token;
    @SerializedName("user")
    private RegisterUser user;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public RegisterUser getUser() {
        return user;
    }

    public void setUser(RegisterUser user) {
        this.user = user;
    }
}
