package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.vo.RecordVo;
import edu.nju.hostelworld.vo.UserVo;

import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(String username);

    User findUser(String username, String password);

    User findUser(String username);

    boolean isCardExist(String cardId);


/***********************************我是洗心革面的分割线*************************************************/
    /**
     * 新增一名用户
     * @param username 用户名
     * @param password 密码
     * @param cardId 卡号
     * @param bankAccount 银行账户
     * @return {@link UserVo}
     */
    UserVo saveUser(String username,String password,String cardId,String bankAccount);

    /**
     * 会员充值
     * @param userId 用户id
     * @param topValue 充值金额
     * @return {@link UserVo}
     */
    UserVo topUp(int userId,double topValue);

    /**
     * 积分兑换
     * @param userId 用户id
     * @param credit 要兑换的积分值
     * @return
     */
    UserVo changeCredit(int userId,int credit);

    /**
     * 修改密码
     * @param userId 用户id
     * @param password 新密码
     * @return
     */
    UserVo changePwd(int userId,String password);


    List<UserVo> findAllUser();

    RecordVo saveRecord(String message, double money, User user);

    List<RecordVo> getRecordList(int userId);

    UserVo pay(User user,double money);

    User addBalance(User user,double money);






}
