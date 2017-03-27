package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yyy on 2017/3/26.
 */
@Entity
public class Record {
    private int id;
    private Timestamp createdAt;
    private String reason;
    private double money;
    private User user;

    public Record(){}

    public Record(String reason,double money,User user){
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.reason = reason;
        this.money = money;
        this.user = user;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != record.id) return false;
        if (Double.compare(record.money, money) != 0) return false;
        if (createdAt != null ? !createdAt.equals(record.createdAt) : record.createdAt != null) return false;
        if (reason != null ? !reason.equals(record.reason) : record.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
}
