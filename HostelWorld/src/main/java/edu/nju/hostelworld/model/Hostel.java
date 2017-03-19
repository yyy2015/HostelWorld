package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by yyy on 2017/3/13.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "hostelSeq"))
public class Hostel {
    private int id;
    private String hostelName;
    private String password;
    private String hostelSeq;
    private int status;
    private String bankAccount;
    private double balance;
    private String descrition;

    public Hostel(){}

    public Hostel(String hostelName,String password,String hostelSeq,String bankAccount){
        this.hostelName = hostelName;
        this.password = password;
        this.hostelSeq = hostelSeq;
        this.bankAccount = bankAccount;
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
    @Column(name = "hostelName")
    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
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
    @Column(name = "status")
    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }

    @Basic
    @Column(name = "bankAccount")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
    @Column(name="description")
    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hostel hostel = (Hostel) o;

        if (id != hostel.id) return false;
        if (hostelName != null ? !hostelName.equals(hostel.hostelName) : hostel.hostelName != null) return false;
        if (password != null ? !password.equals(hostel.password) : hostel.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hostelName != null ? hostelName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "hostelSeq")
    public String getHostelSeq() {
        return hostelSeq;
    }

    public void setHostelSeq(String hostelSeq) {
        this.hostelSeq = hostelSeq;
    }
}
