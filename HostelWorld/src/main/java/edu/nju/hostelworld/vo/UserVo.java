package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Record;
import edu.nju.hostelworld.model.Reserve;
import edu.nju.hostelworld.model.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/27.
 */
public class UserVo {
    private int id;
    private String username;
    private String password;
    private String cardId;
    private int status;
    private int level;
    private double balance;
    private String lastAvail;
    private int shopTimes;
    private double shopTotal;
    private int credit;
    private String bankAccount;
    private List<ReserveVo> reserves;
    private List<RecordVo> records;

    public UserVo(User user){
        BeanUtils.copyProperties(user,this,"reserves","records");
        reserves = new ArrayList<ReserveVo>();
        for(Reserve res:user.getReserves()){
            reserves.add(new ReserveVo(res));
        }
        records = new ArrayList<RecordVo>();
        for(Record record:user.getRecords()){
            records.add(new RecordVo(record));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLastAvail() {
        return lastAvail;
    }

    public void setLastAvail(String lastAvail) {
        this.lastAvail = lastAvail;
    }

    public int getShopTimes() {
        return shopTimes;
    }

    public void setShopTimes(int shopTimes) {
        this.shopTimes = shopTimes;
    }

    public double getShopTotal() {
        return shopTotal;
    }

    public void setShopTotal(double shopTotal) {
        this.shopTotal = shopTotal;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<ReserveVo> getReserves() {
        return reserves;
    }

    public void setReserves(List<ReserveVo> reserves) {
        this.reserves = reserves;
    }

    public List<RecordVo> getRecords() {
        return records;
    }

    public void setRecords(List<RecordVo> records) {
        this.records = records;
    }
}
