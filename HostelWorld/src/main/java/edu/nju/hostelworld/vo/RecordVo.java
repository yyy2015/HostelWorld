package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.User;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/27.
 */
public class RecordVo {
    private int id;
    private Timestamp createdAt;
    private String reason;
    private double money;
    private UserVo user;

    public RecordVo(Record record){
        BeanUtils.copyProperties(record,this,"user");
        user = new UserVo(record.getUser());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }
}
