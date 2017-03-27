package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Room;

import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
public interface HostelService {

    /**
     * 客栈注册时新增客栈
     * @param hostel
     * @return
     */
    Hostel saveHostel(Hostel hostel);

    /**
     * 客栈修改信息
     * @param hostel
     * @return
     */
    Hostel updateHostel(Hostel hostel);

    /**
     * 使用客栈序列号查找客栈
     * @param hostelSeq
     * @return
     */
    Hostel findHostel(String hostelSeq);

    /**
     * 使用客栈序列号和密码查找客栈，登陆时验证账户密码使用
     * @param hostelSeq
     * @param password
     * @return
     */
    Hostel findHostel(String hostelSeq,String password);

    /**
     * 查找相应状态的客栈（审批通过，审批拒绝，未审批）
     * @param status
     * @return
     */
    List<Hostel> findHostel(int status);

    /**
     * 经理登陆时验证账户名和密码
     * @param managerName
     * @param password
     * @return
     */
    Hostel findManager(String managerName,String password);

    /**
     * 验证客栈序列号是否已存在
     * @param hostelSeq
     * @return
     */
    boolean isHostelSeqExist(String hostelSeq);


}
