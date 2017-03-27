package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.Live;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface LiveDao extends JpaRepository<Live,Serializable> {

    Live findById(int id);

    List<Live> findByRoom_IdAndStatus(int roomId,int status);

}
