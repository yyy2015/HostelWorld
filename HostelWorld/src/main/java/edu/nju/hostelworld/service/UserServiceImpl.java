package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(String username) {
        User user = userDao.findByUsername(username);
        userDao.delete(user);
    }

    public User findUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    public List<User> findAllUser() {
        return userDao.findAll();
    }
}
