package com.ultimate.globalangles.repository.server.remote;

import com.ultimate.globalangles.repository.server.requests.create_shipment.CreateShipmentPostBody;
import com.ultimate.globalangles.repository.server.requests.create_trip.CreateTripPostBody;
import com.ultimate.globalangles.repository.server.responses.create_shipment.CreateShipmentResponse;
import com.ultimate.globalangles.repository.server.responses.create_trip.CreateTripResponse;
import com.ultimate.globalangles.repository.server.responses.get_all_notifications.GetAllNotificationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_all_product_fit.GetAllProductFitsResponse;
import com.ultimate.globalangles.repository.server.responses.get_all_unread_notifications.GetUnreadNotificationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryResponse;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_notification.GetNotificationResponse;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripResponse;
import com.ultimate.globalangles.repository.server.responses.get_trips.GetTripsResponse;
import com.ultimate.globalangles.repository.server.responses.info.GetInfoResponse;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;
import com.ultimate.globalangles.repository.server.responses.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UltimateApi {
    public static final String local = "en";
    public static final String accessToken = "QrTss08To5uuYTTqER2022RMKhadia6";

    @Headers({"AccessToken: " + accessToken})
    @POST("login")
    Call<LoginResponse> login(@Header("locale") String langCode, @Query("email") String email, @Query("password") String password);

    @Headers({"AccessToken: " + accessToken})
    @POST("register")
    Call<RegisterResponse> register(@Header("locale") String langCode, @Query("name") String name, @Query("user_name") String user_name
            , @Query("email") String email, @Query("password") String password
            , @Query("password_confirmation") String password_confirmation
            , @Query("phone") String phone);

    @Headers({"AccessToken: " + accessToken})
    @GET("trips")
    Call<GetTripsResponse> getTrips(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

    @Headers({"AccessToken: " + accessToken})
    @GET("trips/{id}")
    Call<GetTripResponse> getTrip(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Path("id") int tripId);

    @Headers({"AccessToken: " + accessToken})
    @GET("info")
    Call<GetInfoResponse> getInfo(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

    @Headers({"AccessToken: " + accessToken})
    @GET("productFits")
    Call<GetAllProductFitsResponse> getAllProductAllFits(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);


    @Headers({"AccessToken: " + accessToken})
    @GET("productFits/{id}")
    Call<GetAllProductFitsResponse> getProductAllFit(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Path("id") int fitId);

    @Headers({"AccessToken: " + accessToken})
    @GET("categories")
    Call<GetCategoryResponse> getCategories(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);


    @Headers({"AccessToken: " + accessToken})
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Path("id") int fitId);


    @Headers({"AccessToken: " + accessToken
            , "local: " + local})
    @GET("shipments")
    Call<GetCategoryResponse> getAllShipments(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

    @Headers({"AccessToken: " + accessToken})
    @GET("notifications")
    Call<GetAllNotificationsResponse> getNotifications(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

    @Headers({"AccessToken: " + accessToken})
    @GET("notifications/{id}")
    Call<GetNotificationResponse> getNotification(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Path("id") String notificationId);

    @Headers({"AccessToken: " + accessToken})
    @GET("unreads")
    Call<GetUnreadNotificationsResponse> getUnreadNotifications(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

    @Headers({"AccessToken: " + accessToken})
    @POST("shipments")
    Call<CreateShipmentResponse> createShipment(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Body CreateShipmentPostBody postBody);


    @Headers({"AccessToken: " + accessToken})
    @POST("trips")
    Call<CreateTripResponse> createTrip(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode, @Body CreateTripPostBody postBody);


    @Headers({"AccessToken: " + accessToken})
    @GET("locations")
    Call<GetLocationsResponse> getLocations(@Header("Authorization") String bearerAccessToken, @Header("locale") String langCode);

}
