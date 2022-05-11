package com.ultimate.globalangles.repository.local.tables.setting;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Setting {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    String bearerAccessToken;
    String allowNotification;
    @ColumnInfo(defaultValue = "en")
    String appLanguage;

    public Setting() {
    }

    @Ignore
    public Setting(Integer id, String bearerAccessToken, String allowNotification, String appLanguage) {
        this.id = id;
        this.bearerAccessToken = bearerAccessToken;
        this.allowNotification = allowNotification;
        this.appLanguage = appLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBearerAccessToken() {
        return bearerAccessToken;
    }

    public void setBearerAccessToken(String bearerAccessToken) {
        this.bearerAccessToken = bearerAccessToken;
    }

    public String getAllowNotification() {
        return allowNotification;
    }

    public void setAllowNotification(String allowNotification) {
        this.allowNotification = allowNotification;
    }

    public String getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(String appLanguage) {
        this.appLanguage = appLanguage;
    }
}
