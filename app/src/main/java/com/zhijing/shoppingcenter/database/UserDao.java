package com.zhijing.shoppingcenter.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User... users);

    @Query("DELETE FROM User")
    void deleteAllUser();

    @Query("SELECT * FROM User WHERE userName=:name")
    User getUser(String name);
}
