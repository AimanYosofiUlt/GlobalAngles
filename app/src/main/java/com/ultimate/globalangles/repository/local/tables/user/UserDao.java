package com.ultimate.globalangles.repository.local.tables.user;

import androidx.room.Dao;
import androidx.room.Query;

import com.ultimate.globalangles.repository.local.creation.BaseDao;

@Dao
public interface UserDao extends BaseDao<User> {
    @Query("DELETE FROM User")
    void deleteCurrentUser();
}
