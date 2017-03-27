package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Live;
import edu.nju.hostelworld.model.Liver;
import edu.nju.hostelworld.model.Room;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/27.
 */
public class LiveVo {
    private int id;
    private int status;
    private RoomVo room;
    private List<LiverVo> livers;
    private Timestamp startDate;
    private Timestamp endDate;
    private int roomNum;

    public LiveVo(Live live){
        BeanUtils.copyProperties(live,this,"room","livers");
        room = new RoomVo(live.getRoom());
        livers = new ArrayList<LiverVo>();
        for(Liver tenant:live.getLivers()){
            livers.add(new LiverVo(tenant));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RoomVo getRoom() {
        return room;
    }

    public void setRoom(RoomVo room) {
        this.room = room;
    }

    public List<LiverVo> getLiverVos() {
        return livers;
    }

    public void setLiverVos(List<LiverVo> liverVos) {
        this.livers = liverVos;
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

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
}
