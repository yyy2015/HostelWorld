package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Bill;
import edu.nju.hostelworld.model.Hostel;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/27.
 */
public class BillVo {
    private int id;
    private double money;
    private HostelVo hostel;

    public BillVo(Bill bill){
        BeanUtils.copyProperties(bill,this,"hostel");
        hostel = new HostelVo(bill.getHostel());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public HostelVo getHostel() {
        return hostel;
    }

    public void setHostel(HostelVo hostel) {
        this.hostel = hostel;
    }
}
