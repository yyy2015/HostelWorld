package com.mark.java.dao;

import com.mark.java.entity.User;

import java.util.List;

/**
 * Created by yyy on 2017/2/17.
 */
public interface UserDao {
    public int save(User u);
    public List<User> findAll();
}
