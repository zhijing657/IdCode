package com.zhijing.shoppingcenter.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//singleton
@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase INSTANCCE;
   public static synchronized UserDatabase getInstance(Context context){
        if (INSTANCCE == null){
            INSTANCCE = Room.databaseBuilder(context.getApplicationContext()
                    ,UserDatabase.class,"user_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCCE;
    }
    public abstract UserDao getUserDao();
}
