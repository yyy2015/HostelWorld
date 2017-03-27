package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.RecordDao;
import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private DiscountStrategy discountStrategy;

    //unformal
    public User saveUser(User user) {
        if(!isUsernameExist(user.getUsername())&&!isCardExist(user.getCardId())){
            return userDao.save(user);
        }
        return null;
    }

    //unformal
    public User updateUser(User user) {
        return userDao.save(user);
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

    public boolean isCardExist(String cardId){
        if(userDao.findByCardId(cardId) == null){
            return false;
        }else{
            return true;
        }

    }

    public Record saveRecord(String message,double money,User user) {
        Record record = new Record(message,money,user);
        return recordDao.save(record);
    }

    public List<Record> getRecordList(int userId) {
        return recordDao.findByUser_Id(userId);
    }

    public User pay(User user, double money) {
        double pay = discountStrategy.getDiscountPrice(user.getLevel(),money);
        if(user.getBalance()<pay){
            return null;
        }
        user.setBalance(user.getBalance()-pay);
        return userDao.save(user);
    }

    public User addBalance(User user, double money) {
        user.setBalance(user.getBalance()+money);
        user.setLevel(calcLevel(user));
        return userDao.save(user);
    }


    private boolean isUsernameExist(String username){
        if(userDao.findByUsername(username) == null){
            return false;
        }else{
            return true;
        }

    }

    /**
     * 计算会员等级
     * @param user
     * @return
     */
    private int calcLevel(User user){
        if(user.getBalance()>5000 && user.getLevel()<1){
            return 1;
        }

        if(user.getBalance()>15000 && user.getLevel()<2){
            return 2;
        }

        return user.getLevel();
    }

    private int calcStatus(User user){
        if(user.getBalance()>=1000){
            return 1;
        }
        return user.getStatus();
    }
}
