package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/26.
 */
@Entity
public class Reserve {
    private int id;
    private int status;
    private Timestamp startDate;
    private Timestamp endDate;
    private int roomNum;
    private User user;
    private Room room;
    private double payMoney;

    public Reserve(){}

    public Reserve(Timestamp start,Timestamp end,int roomNum,User user,Room room,double payMoney){
        this.startDate = start;
        this.endDate = end;
        this.roomNum = roomNum;
        this.user = user;
        this.room = room;
        this.payMoney = payMoney;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "startDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp liveDate) {
        this.startDate = liveDate;
    }

    @Basic
    @Column(name = "endDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp leaveDate) {
        this.endDate = leaveDate;
    }

    @Basic
    @Column(name = "roomNum")
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    @Basic
    @Column(name = "payMoney")
    public double getPayMoney(){
        return payMoney;
    }

    public void setPayMoney(double payMoney){
        this.payMoney = payMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserve reserve = (Reserve) o;

        if (id != reserve.id) return false;
        if (status != reserve.status) return false;
        if (roomNum != reserve.roomNum) return false;
        if (startDate != null ? !startDate.equals(reserve.startDate) : reserve.startDate != null) return false;
        if (endDate != null ? !endDate.equals(reserve.endDate) : reserve.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + roomNum;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userByUserId) {
        this.user = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room roomByRoomId) {
        this.room = roomByRoomId;
    }
}
