package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by yyy on 2017/3/13.
 */
@Entity
@Table(uniqueConstraints =
        {@UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "cardId")
        })
public class User {
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

    public User(){}

    public User(String username,String password,String cardId,String bankAccount){
        this.username = username;
        this.password = password;
        this.cardId = cardId;
        this.bankAccount = bankAccount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "cardId")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "last_avail")
    public String getLastAvail() {
        return lastAvail;
    }

    public void setLastAvail(String lastAvail) {
        this.lastAvail = lastAvail;
    }

    @Basic
    @Column(name = "shop_times")
    public int getShopTimes() {
        return shopTimes;
    }

    public void setShopTimes(int shopTimes) {
        this.shopTimes = shopTimes;
    }

    @Basic
    @Column(name = "shop_total")
    public double getShopTotal() {
        return shopTotal;
    }

    public void setShopTotal(double shopTotal) {
        this.shopTotal = shopTotal;
    }

    @Basic
    @Column(name = "credit")
    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    @Basic
    @Column(name = "bankAccount")
    public String getBankAccount(){
        return bankAccount;
    }

    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (status != user.status) return false;
        if (level != user.level) return false;
        if (Double.compare(user.balance, balance) != 0) return false;
        if (shopTimes != user.shopTimes) return false;
        if (Double.compare(user.shopTotal, shopTotal) != 0) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (cardId != null ? !cardId.equals(user.cardId) : user.cardId != null) return false;
        if (lastAvail != null ? !lastAvail.equals(user.lastAvail) : user.lastAvail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + level;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lastAvail != null ? lastAvail.hashCode() : 0);
        result = 31 * result + shopTimes;
        temp = Double.doubleToLongBits(shopTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
