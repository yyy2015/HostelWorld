package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.BillDao;
import edu.nju.hostelworld.dao.HostelDao;
import edu.nju.hostelworld.model.Bill;
import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.vo.BillVo;
import edu.nju.hostelworld.vo.HostelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private HostelDao hostelDao;

    @Autowired
    private BillDao billDao;

    @Transactional
    public Hostel examine(int hostelId,int isApprove) {
        Hostel hostel = hostelDao.findById(hostelId);
        hostel.setStatus(isApprove);
        return hostelDao.save(hostel);
    }

    @Transactional
    public List<HostelVo> getApplicationList() {
        List<Hostel> hostelList = hostelDao.findByStatus(0);
        List<HostelVo> voList = new ArrayList<HostelVo>();
        for(Hostel hostel:hostelList){
            voList.add(new HostelVo(hostel));
        }
        return  voList;//获取未审批的hostel列表
    }
    @Transactional
    public List<BillVo> getBillList() {
        List<Bill> bills = billDao.findAll();
        List<BillVo> list = new ArrayList<BillVo>();
        for(Bill bill:bills){
            list.add(new BillVo(bill));
        }
        return list ;
    }

    @Transactional
    public boolean settleAccount(int hostelId) {
        Bill bill = billDao.findByHostel_Id(hostelId);
        Hostel hostel = hostelDao.findById(hostelId);
        hostel.setBalance(hostel.getBalance()+bill.getMoney()*0.7);//结算给客栈

        Hostel manager = hostelDao.findById(1);//1号为总经理
        manager.setBalance(manager.getBalance()+bill.getMoney()*0.3);//hostel到账

        hostelDao.save(hostel);
        hostelDao.save(manager);

        bill.setMoney(0);//被结算后，账单归零

        return true;
    }
}
