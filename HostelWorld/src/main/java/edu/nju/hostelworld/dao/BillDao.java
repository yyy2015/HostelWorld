package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface BillDao extends JpaRepository<Bill,Serializable> {

    Bill findByHostel_Id(int hostelId);


}
