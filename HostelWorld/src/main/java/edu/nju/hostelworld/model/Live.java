package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
@Entity
public class Live {
    private int id;
    private int status;
    private Room room;
    private List<Liver> livers;
    private Timestamp startDate;
    private Timestamp endDate;
    private int roomNum;

    public Live(){}

    public Live(Room room,Timestamp start,Timestamp end,int roomNum){
        this.room = room;
        this.startDate = start;
        this.endDate = end;
        this.roomNum = roomNum;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Basic
    @Column(name = "roomNum")
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Live live = (Live) o;

        if (id != live.id) return false;
        if (status != live.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @OneToMany
    @JoinColumn(name = "liveId", referencedColumnName = "id")
    public List<Liver> getLivers() {
        return livers;
    }

    public void setLivers(List<Liver> liversById) {
        this.livers = liversById;
    }
}
