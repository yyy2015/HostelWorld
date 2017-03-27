package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Room;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/27.
 */

public class HostelVo {
    private int id;
    private String hostelName;
    private String password;
    private String hostelSeq;
    private int status;
    private String bankAccount;
    private double balance;
    private String description;
    private String host;
    private List<RoomVo> rooms;
    private String address;

    public HostelVo(Hostel hostel){
        BeanUtils.copyProperties(hostel,this,"rooms");
        rooms = new ArrayList<RoomVo>();
        for(Room room:hostel.getRooms()){
            rooms.add(new RoomVo(room));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostelSeq() {
        return hostelSeq;
    }

    public void setHostelSeq(String hostelSeq) {
        this.hostelSeq = hostelSeq;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<RoomVo> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomVo> rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
