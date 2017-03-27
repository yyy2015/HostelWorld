package edu.nju.hostelworld.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
@Entity
public class Room {
    private int id;
    private int type;
    private double price;
    private String address;
    private int num;
    private List<Live> lives;
    private List<Reserve> reserves;
    private Hostel hostel;
    private Timestamp startDate;
    private Timestamp endDate;

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
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "startDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (type != room.type) return false;
        if (Double.compare(room.price, price) != 0) return false;
        if (num != room.num) return false;
        if (address != null ? !address.equals(room.address) : room.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + type;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + num;
        return result;
    }

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    public List<Live> getLives() {
        return lives;
    }

    public void setLives(List<Live> livesById) {
        this.lives = livesById;
    }

    @OneToMany( mappedBy = "room",cascade = CascadeType.ALL)
    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reservesById) {
        this.reserves = reservesById;
    }

    @ManyToOne
    @JoinColumn(name = "hostelId", referencedColumnName = "id", nullable = false)
    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostelByHostelId) {
        this.hostel = hostelByHostelId;
    }
}
