package com.ultimate.globalangles.repository.server.remote;

import com.ultimate.globalangles.repository.server.responses.login.LoginData;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UltimateApi {
    public static final String local = "en";
    public static final String AccessToken = "QrTss08To5uuYTTqER2022RMKhadia6";
    public static final String ber = "-1";
    public static final String SECRET_KEY = "123456";


    @Headers({"AccessToken: " + AccessToken,
            "local: " + local})
    @POST("login")
    Call<LoginData> getConfiguration(@Body RequestBody requestBody);
}
