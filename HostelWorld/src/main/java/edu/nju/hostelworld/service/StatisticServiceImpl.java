package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.BillDao;
import edu.nju.hostelworld.dao.HostelDao;
import edu.nju.hostelworld.dao.ReserveDao;
import edu.nju.hostelworld.dao.RoomDao;
import edu.nju.hostelworld.model.Bill;
import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Reserve;
import edu.nju.hostelworld.model.Room;
import edu.nju.hostelworld.vo.HostelMoneyBar;
import edu.nju.hostelworld.vo.HostelMoneyVo;
import edu.nju.hostelworld.vo.ReserveStatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/29.
 */
@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private HostelDao hostelDao;

    @Autowired
    private BillDao billDao;

    @Autowired
    private ReserveDao reserveDao;

    @Autowired
    private RoomDao roomDao;


    public List<HostelMoneyVo> getHostelMoney() {
        List<Bill> bills = billDao.findAll();
        List<HostelMoneyVo> list = new ArrayList<HostelMoneyVo>();

        for(Bill bill:bills){
            Hostel hostel = bill.getHostel();
            HostelMoneyVo vo = new HostelMoneyVo(hostel.getHostelName(),(int)(hostel.getBalance()/0.7+bill.getMoney()));
            list.add(vo);
        }
        return list;
    }

    public List<HostelMoneyBar> getHostelMoneyBar() {
        List<Bill> bills = billDao.findAll();
        List<HostelMoneyBar> list = new ArrayList<HostelMoneyBar>();

        for(Bill bill:bills){
            Hostel hostel = bill.getHostel();
            HostelMoneyBar vo = new HostelMoneyBar(hostel.getHostelName(),(int)(hostel.getBalance()/0.7+bill.getMoney()),hostel.getHostelName());
            list.add(vo);
        }
        return list;
    }

    public List<String> getHostelName() {
        List<String> names = new ArrayList<String>();
        List<Hostel> hostelList = hostelDao.findAll();
        for(Hostel hostel:hostelList){
            if(hostel.getId()!=1) {
                names.add(hostel.getHostelName());
            }
        }
        return names;
    }

    public List<ReserveStatVo> getReserveStatVo() {
        List<ReserveStatVo> list = new ArrayList<ReserveStatVo>();
        List<Hostel> hostelList = hostelDao.findAll();

        List<Integer> ingList = new ArrayList<Integer>();
        List<Integer> cancelList = new ArrayList<Integer>();
        List<Integer> finishList = new ArrayList<Integer>();

        for(Hostel hostel:hostelList){

            if(hostel.getId()==1){
                continue;
            }

            int ing = 0;
            int cancel = 0;
            int finish = 0;

            List<Room> roomList = roomDao.findByHostel_Id(hostel.getId());
            for(Room room:roomList){
                List<Reserve> reserveIng = reserveDao.findByRoom_IdAndStatus(room.getId(),0);
                ing += reserveIng.size();
                List<Reserve> reserveCancel = reserveDao.findByRoom_IdAndStatus(room.getId(),-1);
                cancel += reserveCancel.size();
                List<Reserve> reserveFinish = reserveDao.findByRoom_IdAndStatus(room.getId(),1);
                finish += reserveFinish.size();
            }

            ingList.add(ing);
            cancelList.add(-cancel);
            finishList.add(finish);
        }

        ReserveStatVo ingVo = new ReserveStatVo("ing",ingList);
        ReserveStatVo cancelVo = new ReserveStatVo("cancel",cancelList);
        ReserveStatVo finishVo = new ReserveStatVo("ing",finishList);
        list.add(ingVo);
        list.add(cancelVo);
        list.add(finishVo);

        return list;
    }
}
