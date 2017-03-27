package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
public interface HostelDao extends JpaRepository<Hostel,Serializable> {

    Hostel findById(int id);

    Hostel findByHostelSeq(String hostelSeq);

    Hostel findByHostelSeqAndPassword(String hostelSeq,String password);

    List<Hostel> findByStatus(int status);

    Hostel findByHostelNameAndPassword(String hostelName,String password);

}
