package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.HostelDao;
import edu.nju.hostelworld.model.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelDao hostelDao;


    public Hostel saveHostel(Hostel hostel) {
        if(isHostelSeqExist(hostel.getHostelSeq())){
            return null;
        }
        return hostelDao.save(hostel) ;
    }

    public Hostel updateHostel(Hostel hostel) {
        return hostelDao.save(hostel);
    }

    public Hostel findHostel(String hostelSeq) {
        return hostelDao.findByHostelSeq(hostelSeq);
    }

    public Hostel findHostel(String hostelSeq, String password) {
        return hostelDao.findByHostelSeqAndPassword(hostelSeq, password);
    }

    public List<Hostel> findHostel(int status) {
        return hostelDao.findByStatus(status);
    }

    /**
     * 寻找总经理
     * @param managerName
     * @param password
     * @return
     */
    public Hostel findManager(String managerName,String password) {
        return hostelDao.findByHostelNameAndPassword(managerName, password);
    }

    public boolean isHostelSeqExist(String hostelSeq) {
        if(hostelDao.findByHostelSeq(hostelSeq) == null){
            return false;
        }
        return true;
    }
}
