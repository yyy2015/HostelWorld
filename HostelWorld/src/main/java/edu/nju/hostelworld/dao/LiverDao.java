package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Liver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface LiverDao extends JpaRepository<Liver,Serializable> {

    List<Liver> findByLive_Id(int liveId);
}
