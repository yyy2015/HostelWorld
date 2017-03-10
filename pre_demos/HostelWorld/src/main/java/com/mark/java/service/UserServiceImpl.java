package com.mark.java.service;

import com.mark.java.dao.UserDao;
import com.mark.java.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/2/17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

    public void saveUsers(List<User> us) {
        for(User u:us){
            userDao.save(u);
        }

    }

    public List<User> getAllUsernames() {
       return userDao.findAll();
    }
}
