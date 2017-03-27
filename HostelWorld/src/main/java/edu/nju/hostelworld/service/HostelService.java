package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Room;
import edu.nju.hostelworld.vo.HostelVo;

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
     * 新增客栈
     * @param hostelName 客栈名
     * @param password 密码
     * @param hostelSeq 客栈序列号
     * @param bankAccount 银行账户
     * @return
     */
    HostelVo saveHostel(String hostelName,String password,String hostelSeq,String bankAccount);

    Hostel updateHostel(Hostel hostel);

    /**
     * 修改客栈信息
     * @param hostelName 客栈名称
     * @param bankAccount 银行账户
     * @param description 描述
     * @param host 客栈主人
     * @param address 地址
     * @return
     */
    HostelVo updateHostel(int hostelId, String hostelName,String bankAccount,String description,
                        String host,String address);

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
    List<HostelVo> findHostel(int status);

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

    HostelVo findHostelDetail(int hostelId);


}
