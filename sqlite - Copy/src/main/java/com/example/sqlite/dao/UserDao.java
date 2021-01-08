package com.example.sqlite.dao;

import com.example.sqlite.entity.User;

import java.util.List;

public interface UserDao {

    public long insertUser(User user);
    public void deleteUser(String username);
    public void updateUser(User user);
    public void getUserById(int id);
    public List<User> getAllUser();

}
