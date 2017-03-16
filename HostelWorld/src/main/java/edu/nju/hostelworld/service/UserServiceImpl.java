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
        if(!isUsernameExist(user.getUsername())&&!isCardExist(user.getCardId())){
            return userDao.save(user);
        }
        return null;
    }


    public void deleteUser(String username) {
        User user = userDao.findByUsername(username);
        if(user != null) {
            userDao.delete(user);
        }
    }

    public User findUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    public User findUser(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAllUser() {
        return userDao.findAll();
    }


    private boolean isUsernameExist(String username){
        if(userDao.findByUsername(username) == null){
            return false;
        }else{
            return true;
        }

    }

    public boolean isCardExist(String cardId){
        if(userDao.findByCardId(cardId) == null){
            return false;
        }else{
            return true;
        }

    }
}
