package com.example.sqlite.entity;

import androidx.annotation.NonNull;

public class User {

    private int _id;
    private String username;
    private String userpass;
    private int age;

    public User() {
    }

    public User(String username, String userpass, int age) {
        this.username = username;
        this.userpass = userpass;
        this.age = age;
    }

    public User(int _id, String username, String userpass, int age) {
        this._id = _id;
        this.username = username;
        this.userpass = userpass;
        this.age = age;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "info :" + get_id() + "-" + getUsername() + "-" + getUserpass() + "-" + getAge();
    }
}

