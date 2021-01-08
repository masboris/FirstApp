package com.example.sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.MainActivity;
import com.example.sqlite.R;
import com.example.sqlite.dao.UserDao;
import com.example.sqlite.entity.User;
import com.example.sqlite.util.MyAdapter;
import com.example.sqlite.util.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Context c;
    public UserDaoImpl(Context c){
        this.c = c;
    }
    @Override
    public long insertUser(User user) {
        MyHelper myHelper = new MyHelper(c);
        SQLiteDatabase db = myHelper.getWritableDatabase();

        String s1 = user.getUsername();
        String s2 = user.getUserpass();
        String s3 = String.valueOf(user.getAge());

        ContentValues cv = new ContentValues();
        cv.put("username", s1);
        cv.put("userpass", s2);
        cv.put("age", s3);
        long n = db.insert("userinfo", null, cv);
        db.close();

        return n;
    }

    @Override
    public void deleteUser(String username) {
        MyHelper myHelper = new MyHelper(c);
        SQLiteDatabase db = myHelper.getWritableDatabase();
//        String s1 = et_name.getText().toString();
        String sql = "delete from userinfo where username = '"+ username + "'";
        try {
            Log.e("sql :", ""+sql);
            db.execSQL(sql);
            Toast.makeText(c, "Delete Successful", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(c, "Name not found", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    @Override
    public void updateUser(User user) {
        MyHelper myHelper = new MyHelper(c);
        SQLiteDatabase db = myHelper.getWritableDatabase();
//                String sql = "update userinfo set userpass='qwerty' where _id = 1";
//                db.execSQL(sql);

        String s1 = user.getUsername();
        String s2 = user.getUserpass();
        String s3 = String.valueOf(user.getAge());

        ContentValues cv = new ContentValues();
        cv.put("userpass", s2);
        cv.put("age", s3);

        int i = db.update("userinfo", cv, "username = ?", new String[]{s1});
        if (i > 0) {
            Toast.makeText(c, "Update Successful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(c, "Name not found", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    @Override
    public void getUserById(int id) {

    }

    @Override
    public List<User> getAllUser() {
        MyHelper myHelper = new MyHelper(c);
        SQLiteDatabase db = myHelper.getReadableDatabase();
        String sql = "select * from userinfo";
        Cursor cursor = db.rawQuery(sql, null);

        List<User> users = new ArrayList<User>();

        while (cursor.moveToNext()){
            String s0 = cursor.getString(0);
            String s1 = cursor.getString(1);
            String s2 = cursor.getString(2);
            String s3 = cursor.getString(3);


            Log.e("demo", "info: " + s0 + s1 + s2 + s3 );

            User user = new User(Integer.parseInt(s0), s1, s2, Integer.parseInt(s3));
            users.add(user);

        }

        return users;

    }
}
