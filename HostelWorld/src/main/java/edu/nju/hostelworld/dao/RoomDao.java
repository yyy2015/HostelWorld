package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface RoomDao extends JpaRepository<Room,Serializable> {

    Room findById(int id);

    List<Room> findByHostel_Id(int hostelId);




}
