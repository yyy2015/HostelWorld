package com.mark.java.service;

import com.mark.java.entity.User;

import java.util.List;

/**
 * Created by yyy on 2017/2/17.
 */
public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsernames();
}
