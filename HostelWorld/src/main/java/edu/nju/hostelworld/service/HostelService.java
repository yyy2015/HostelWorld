package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.Hostel;

import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
public interface HostelService {

    Hostel saveHostel(Hostel hostel);

    Hostel updateHostel(Hostel hostel);

    Hostel findHostel(String hostelSeq);

    Hostel findHostel(String hostelSeq,String password);

    List<Hostel> findHostel(int status);

    Hostel findManager(String managerName,String password);

    boolean isHostelSeqExist(String hostelSeq);

}
