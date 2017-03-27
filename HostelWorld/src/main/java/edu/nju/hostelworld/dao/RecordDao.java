package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface RecordDao extends JpaRepository<Record,Serializable> {

    List<Record> findByUser_Id(int userId);
}
