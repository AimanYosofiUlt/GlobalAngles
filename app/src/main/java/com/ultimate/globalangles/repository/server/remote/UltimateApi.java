package com.ultimate.globalangles.repository.server.remote;

import com.ultimate.globalangles.repository.server.responses.get_all_notifications.GetAllNotificationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_all_product_fit.GetAllProductFitsResponse;
import com.ultimate.globalangles.repository.server.responses.get_all_unread_notifications.GetUnreadNotificationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryResponse;
import com.ultimate.globalangles.repository.server.responses.get_notification.GetNotificationResponse;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripResponse;
import com.ultimate.globalangles.repository.server.responses.get_trips.GetTripsResponse;
import com.ultimate.globalangles.repository.server.responses.info.GetInfoResponse;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;
import com.ultimate.globalangles.repository.server.responses.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UltimateApi {
    public static final String local = "en";
    public static final String accessToken = "QrTss08To5uuYTTqER2022RMKhadia6";
    //todo handel bearrer access token
    public static final String bearerAccessToken = "Bearer ";

    @Headers({"AccessToken: " + accessToken,
            "local: " + local})
    @POST("login")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @Headers({"AccessToken: " + accessToken,
            "local: " + local})
    @POST("register")
    Call<RegisterResponse> register(@Query("name") String name, @Query("user_name") String user_name
            , @Query("email") String email, @Query("password") String password
            , @Query("password_confirmation") String password_confirmation
            , @Query("phone") String phone);

    @Headers({"Authorization: " + bearerAccessToken,
            "local: " + local})
    @GET("trips")
    Call<GetTripsResponse> getTrips();

    @Headers({"Authorization: " + bearerAccessToken,
            "local: " + local})
    @GET("trips/{id}")
    Call<GetTripResponse> getTrip(@Path("id") int tripId);


    @Headers({"AccessToken: " + accessToken,
            "local: " + local,
            "Authorization" + bearerAccessToken})
    @GET("info")
    Call<GetInfoResponse> getInfo();

    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("productFits")
    Call<GetAllProductFitsResponse> getAllProductAllFits();


    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("productFits/{id}")
    Call<GetAllProductFitsResponse> getProductAllFit(@Path("id") int fitId);

    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("categories")
    Call<GetCategoryResponse> getCategories();


    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int fitId);


    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("shipments")
    Call<GetCategoryResponse> getAllShipments();

    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("notifications")
    Call<GetAllNotificationsResponse> getNotifications();

    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("notifications/{id}")
    Call<GetNotificationResponse> getNotification(@Path("id") String notificationId);


    @Headers({"AccessToken: " + accessToken
            , "Authorization" + bearerAccessToken
            , "local: " + local})
    @GET("unreads")
    Call<GetUnreadNotificationsResponse> getUnreadNotifications();
}
