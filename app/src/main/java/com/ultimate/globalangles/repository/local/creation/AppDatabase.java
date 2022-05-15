package com.ultimate.globalangles.repository.local.creation;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ultimate.globalangles.repository.local.tables.setting.Setting;
import com.ultimate.globalangles.repository.local.tables.setting.SettingDao;
import com.ultimate.globalangles.repository.local.tables.user.User;
import com.ultimate.globalangles.repository.local.tables.user.UserDao;

@Database(version = 1,
        entities = {Setting.class, User.class},
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SettingDao settingDao();

    public abstract UserDao userDao();

    public static AppDatabase INSTANCE = null;

    public static synchronized AppDatabase getInstance(Context context) {
        AppDatabase temp = INSTANCE;
        if (temp != null)
            return temp;

        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "ECommerceDB"
        ).build();
    }
}
