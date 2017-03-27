package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Reserve;
import edu.nju.hostelworld.model.Room;
import edu.nju.hostelworld.model.User;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/27.
 */
public class ReserveVo {

    private int id;
    private int status;
    private Timestamp startDate;
    private Timestamp endDate;
    private int roomNum;
    private UserVo user;
    private RoomVo room;
    private double payMoney;

    public ReserveVo(Reserve reserve){
        BeanUtils.copyProperties(reserve,this,"user","room");
        user = new UserVo(reserve.getUser());
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
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
}
