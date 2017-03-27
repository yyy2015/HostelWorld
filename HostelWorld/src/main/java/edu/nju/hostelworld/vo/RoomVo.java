package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Live;
import edu.nju.hostelworld.model.Reserve;
import edu.nju.hostelworld.model.Room;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/27.
 */
public class RoomVo {
    private int id;
    private int type;
    private double price;
    private String address;
    private int num;
    private List<LiveVo> lives;
    private List<ReserveVo> reserves;
    private HostelVo hostel;
    private Timestamp startDate;
    private Timestamp endDate;

    public RoomVo(Room room){
        BeanUtils.copyProperties(room,this,"lives","reserves","hostel");
        hostel = new HostelVo(room.getHostel());
        lives = new ArrayList<LiveVo>();
        for(Live live:room.getLives()){
            lives.add(new LiveVo(live));
        }
        reserves = new ArrayList<ReserveVo>();
        for(Reserve reserve:room.getReserves()){
            reserves.add(new ReserveVo(reserve));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<LiveVo> getLives() {
        return lives;
    }

    public void setLives(List<LiveVo> lives) {
        this.lives = lives;
    }

    public List<ReserveVo> getReserves() {
        return reserves;
    }

    public void setReserves(List<ReserveVo> reserves) {
        this.reserves = reserves;
    }

    public HostelVo getHostel() {
        return hostel;
    }

    public void setHostel(HostelVo hostel) {
        this.hostel = hostel;
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
}
