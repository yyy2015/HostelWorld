package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Reserve;
import edu.nju.hostelworld.model.Room;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.util.DateTrans;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/27.
 */
public class ReserveVo {

    private int id;
    private int status;
    private String startDate;
    private String endDate;
    private int roomNum;
    private UserVo user;
    private RoomVo room;
    private double payMoney;

    private String hostelName;
    private String userName;

    public ReserveVo(Reserve reserve){
        BeanUtils.copyProperties(reserve,this,"startDate","endDate","user","room");
//        user = new UserVo(reserve.getUser());
        startDate = DateTrans.time2String(reserve.getStartDate());
        endDate = DateTrans.time2String(reserve.getEndDate());
        room = new RoomVo(reserve.getRoom());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public RoomVo getRoom() {
        return room;
    }

    public void setRoom(RoomVo room) {
        this.room = room;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
