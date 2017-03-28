package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface ReserveDao extends JpaRepository<Reserve,Serializable> {

    Reserve findById(int id);

    Reserve findByStatus(int status);

    List<Reserve> findByRoom_IdAndStatus(int roomId,int status);

    List<Reserve> findByUser_Id(int userId);

    List<Reserve> findByUser_IdAndStatus(int userId,int status);

    List<Reserve> findByStartDate(Timestamp liveDate);

    List<Reserve> findByEndDate(Timestamp leaveDate);

}
