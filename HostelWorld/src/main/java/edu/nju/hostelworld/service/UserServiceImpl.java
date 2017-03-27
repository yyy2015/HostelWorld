package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.RecordDao;
import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.strategy.DiscountStrategy;
import edu.nju.hostelworld.vo.RecordVo;
import edu.nju.hostelworld.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public boolean isCardExist(String cardId){
        if(userDao.findByCardId(cardId) == null){
            return false;
        }else{
            return true;
        }

    }

    /************************************我是洗心革面的分割线*******************************************************/

    public List<UserVo> findAllUser() {
        List<UserVo> list = new ArrayList<UserVo>();
        for(User user:userDao.findAll()){
            list.add(new UserVo(user));
        }
        return list;
    }


    public RecordVo saveRecord(String message, double money, User user) {
        Record record = new Record(message,money,user);
        return new RecordVo(recordDao.save(record));
    }

    public List<RecordVo> getRecordList(int userId) {
        List<RecordVo> list = new ArrayList<RecordVo>();
        for(Record record:recordDao.findByUser_Id(userId)){
            list.add(new RecordVo(record));
        }
        return list;
    }

    public UserVo pay(User user, double money) {
        double pay = discountStrategy.getDiscountPrice(user.getLevel(),money);
        if(user.getBalance()<pay){
            return null;
        }
        user.setBalance(user.getBalance()-pay);
        return new UserVo(userDao.save(user));
    }

    public User addBalance(User user, double money) {
        user.setBalance(user.getBalance()+money);
        user.setLevel(calcLevel(user));
        return userDao.save(user);
    }

    public UserVo saveUser(String username, String password, String cardId, String bankAccount) {
        return null;
    }

    public UserVo topUp(int userId, double topValue) {
        return null;
    }

    public UserVo changeCredit(int userId, int credit) {
        return null;
    }

    public UserVo changePwd(int userId, String password) {
        return null;
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

    private boolean isUsernameExist(String username){
        if(userDao.findByUsername(username) == null){
            return false;
        }else{
            return true;
        }

    }

}
