package com.example.sqlite.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(@Nullable Context context) {
        super(context, "test01.db", null, 3);
        Log.e("demo", "create object");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table userinfo(_id integer primary key autoincrement, username text, userpass text, age integer)";
        db.execSQL(sql);
        Log.e("demo", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.e("demo", "oldVersion: " + oldVersion + " newVersion: " + newVersion);
//        String sql = "alter table userinfo add age integer";
//        db.execSQL(sql);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        Log.e("demo", "g etWritableDatabase");
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        Log.e("demo", "getReadableDatabase");
        return super.getReadableDatabase();
    }
}
