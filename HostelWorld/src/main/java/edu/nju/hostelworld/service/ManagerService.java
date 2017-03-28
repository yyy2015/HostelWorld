package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.Bill;
import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.vo.BillVo;
import edu.nju.hostelworld.vo.HostelVo;

import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface ManagerService {
    /**
     * 审批申请
     * @param hostelId 客栈id
     * @param isApprove 是否通过 1：通过，-1：拒绝
     * @return
     */
    Hostel examine(int hostelId,int isApprove);

    /**
     * 获得申请列表
     * @return
     */
    List<HostelVo> getApplicationList();

    /**
     * 获得待结算账单列表
     * @return
     */
    List<BillVo> getBillList();

    /**
     * 将钱结算给客栈
     * @param hostelId
     * @return
     */
    boolean settleAccount(int hostelId);



}
