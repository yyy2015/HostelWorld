package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.*;
import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private HostelDao hostelDao;

    @Autowired
    private ReserveDao reserveDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BillDao billDao;

    @Autowired
    private LiveDao liveDao;

    @Autowired
    private LiverDao liverDao;

    @Transactional
    public RoomVo releaseRoomPlan(int hostelId, int type, double price, String address, int num,
                                  Timestamp start, Timestamp end) {
        Room room = new Room();
        room.setHostel(hostelDao.findById(hostelId));
        room.setType(type);
        room.setPrice(price);
        room.setAddress(address);
        room.setNum(num);
        room.setStartDate(start);
        room.setEndDate(end);

        Room entity = roomDao.save(room);

        if(entity.getLives() == null){
            System.out.println("live list is null!");
        }

        return new RoomVo(entity);
    }

    public List<RoomVo> getRoom(int hostelId) {
        List<RoomVo> list = new ArrayList<RoomVo>();
        for(Room room:roomDao.findByHostel_Id(hostelId)){
            list.add(new RoomVo(room));
        }
        return list;
    }

    public RoomVo getOneRoom(int roomId) {
        Room room = roomDao.findById(roomId);
        RoomVo vo = new RoomVo(room);
        HostelVo hvo = new HostelVo(room.getHostel());
        vo.setHostel(hvo);
        return vo;
    }

    @Transactional
    public ReserveVo reserve(int userId, int roomId, Timestamp start, Timestamp end,
                             int roomNum, double payMoney) {
        Room room = roomDao.findById(roomId);
        User user = userDao.findById(userId);
        //扣除user的账户余额
        userService.pay(user,payMoney);
        //更新待结算列表
        Hostel hostel = room.getHostel();
        generateBill(hostel,payMoney);
        //新增账单记录
        Record record = new Record("预订客栈房间",-payMoney,user);
        recordDao.save(record);
        //客栈房间数减少
        room.setNum(room.getNum()-roomNum);
        roomDao.save(room);

        Reserve reserve = new Reserve(start,end,roomNum,user,room,payMoney);
        return new ReserveVo(reserveDao.save(reserve));
    }

    @Transactional
    public void cancelReserve(int reserveId) {
        Reserve reserve = reserveDao.findById(reserveId);
        User user = reserve.getUser();
        //返还一半的钱
        user = userService.addBalance(user,reserve.getPayMoney()*0.5);
        userDao.save(user);
        //更新待结算账单
        Room room = reserve.getRoom();
        Hostel hostel = room.getHostel();
        generateBill(hostel,-0.5*reserve.getPayMoney());
        //新增账单记录
        Record record = new Record("取消预订退款",0.5*reserve.getPayMoney(),user);
        recordDao.save(record);
        //客栈房间数增加
        room.setNum(room.getNum()+reserve.getRoomNum());
        roomDao.save(room);
        //预订置为取消状态
        reserve.setStatus(-1);
        reserveDao.save(reserve);
    }

    @Transactional
    public BillVo generateBill(Hostel hostel, double money) {
        Bill bill = billDao.findByHostel_Id(hostel.getId());
        if(bill==null){//数据库中尚未有此客栈金额记录
            bill = new Bill();
            bill.setHostel(hostel);
            bill.setMoney(money);
        }else{//数据库中已有此客栈金额记录
            bill.setMoney(bill.getMoney()+money);
        }

        return new BillVo(billDao.save(bill));
    }

    @Transactional
    public LiveVo checkIn(int reserveId, int roomId, int roomNum, Timestamp start, Timestamp end, List<String> livers) {
        if(reserveId > 0){//会员预订好的房间入住登记
            Reserve reserve = reserveDao.findById(reserveId);
            reserve.setStatus(1);//预订订单已完成
            reserveDao.save(reserve);
        }

        Room room = roomDao.findById(roomId);
        room.setNum(room.getNum()-roomNum);//客栈房间数减少

        Live live = new Live(room,start,end,roomNum);
        live = liveDao.save(live);

        List<Liver> tenantList = new ArrayList<Liver>();
        for(String name:livers){
            Liver tenant = new Liver();
            tenant.setLivername(name);
            tenant.setId(live.getId());
            liverDao.save(tenant);//这里是否重复操作了？
            tenantList.add(tenant);
        }
        live.setLivers(tenantList);//这里是否重复操作了？

        return new LiveVo(liveDao.save(live));

    }

    @Transactional
    public void checkOut(int liveId) {
        Live live = liveDao.findById(liveId);
        Room room = live.getRoom();

        room.setNum(room.getNum()+live.getRoomNum());//更改客栈房间剩余数量
        roomDao.save(room);

        live.setStatus(1);//入住完成,状态置为已退房
        liveDao.save(live);

    }

    @Transactional
    public List<ReserveVo> getReserveList(int hostelId, int status) {
        Hostel hostel = hostelDao.findById(hostelId);
        List<Room> roomList = hostel.getRooms();
        List<ReserveVo> reserveList = new ArrayList<ReserveVo>();
        for(Room room:roomList){
            List<Reserve> tempList = reserveDao.findByRoom_IdAndStatus(room.getId(),status);
            for(Reserve reserve:tempList){
                ReserveVo vo = new ReserveVo(reserve);
                vo.setHostelName(hostel.getHostelName());
                reserveList.add(vo);
            }
        }
        return reserveList;
    }

    @Transactional
    public List<LiveVo> getLiveList(int hostelId,int status) {
        Hostel hostel = hostelDao.findById(hostelId);
        List<Room> roomList = hostel.getRooms();
        List<LiveVo> liveList = new ArrayList<LiveVo>();
        for(Room room:roomList){
            List<Live> tempList = liveDao.findByRoom_IdAndStatus(room.getId(),status);
            for(Live live:tempList){
                liveList.add(new LiveVo(live));
            }
        }
        return liveList;
    }

    public List<ReserveVo> getUserReserveList(int userId, int status) {
        List<Reserve> reserves = reserveDao.findByUser_IdAndStatus(userId,status);
        List<ReserveVo> list = new ArrayList<ReserveVo>();
        for(Reserve reserve:reserves){
            ReserveVo vo = new ReserveVo(reserve);
            Room room = reserve.getRoom();
            Hostel hostel = room.getHostel();
            vo.setHostelName(hostel.getHostelName());
            list.add(vo);
        }
        return list;
    }

}
