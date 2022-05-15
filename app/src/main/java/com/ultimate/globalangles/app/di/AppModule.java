package com.ultimate.globalangles.app.di;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.ultimate.globalangles.repository.local.creation.AppDatabase;
import com.ultimate.globalangles.repository.local.tables.setting.SettingDao;
import com.ultimate.globalangles.repository.local.tables.user.UserDao;
import com.ultimate.globalangles.repository.server.remote.UltimateApi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public abstract class AppModule {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    private @interface UltimateApiBaseLink {
    }

    @ActivityScoped
    @Provides
    public static Context provideContext(Application application) {
        return application;
    }

    @UltimateApiBaseLink
    @Provides
    public static String provideBaseUrl() {
        return "https://global-angels-backend.ultimate-portal.com/mobile/api/";
    }


    @ActivityScoped
    @Provides
    public static HttpLoggingInterceptor provideHttpLogging() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @ActivityScoped
    @Provides
    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
    }

    @ActivityScoped
    @Provides
    public static Retrofit provideRetrofit(@UltimateApiBaseLink String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @ActivityScoped
    @Provides
    public static UltimateApi provideUltimateApi(Retrofit retrofit) {
        return retrofit.create(UltimateApi.class);
    }

    @ActivityScoped
    @Provides
    public static AppDatabase provideAppDatabase(Application application) {
        return AppDatabase.getInstance(application);
    }

    @ActivityScoped
    @Provides
    public static SettingDao provideSettingDao(AppDatabase appDatabase) {
        return appDatabase.settingDao();
    }

    @ActivityScoped
    @Provides
    public static UserDao provideUserDao(AppDatabase appDatabase) {
        return appDatabase.userDao();
    }

    @ActivityScoped
    @Provides
    public static GoogleSignInOptions provideGoogleSignInOptions() {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    }

    @ActivityScoped
    @Provides
    public static GoogleSignInClient provideGoogleSignInClient(Context context, GoogleSignInOptions signInOptions) {
        return GoogleSignIn.getClient(context, signInOptions);
    }
}
