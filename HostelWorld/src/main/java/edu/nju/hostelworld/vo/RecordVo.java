package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.util.DateTrans;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/27.
 */
public class RecordVo {
    private int id;
    private String createdAt;
    private String reason;
    private String money;
    private UserVo user;

    public RecordVo(Record record){
        BeanUtils.copyProperties(record,this,"createAt","money","user");
        createdAt = DateTrans.time2String(record.getCreatedAt());
        if(record.getMoney()>0){
            money = "+"+record.getMoney();
        }else{
            money = ""+record.getMoney();
        }
//        user = new UserVo(record.getUser());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }
}
