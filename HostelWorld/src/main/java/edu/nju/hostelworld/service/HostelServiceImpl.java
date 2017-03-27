package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.HostelDao;
import edu.nju.hostelworld.dao.RoomDao;
import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.Room;
import edu.nju.hostelworld.vo.HostelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
@Service
@Transactional
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelDao hostelDao;

    @Autowired
    private RoomDao roomDao;


    public Hostel saveHostel(Hostel hostel) {
        if(isHostelSeqExist(hostel.getHostelSeq())){
            return null;
        }
        return hostelDao.save(hostel) ;
    }

    public HostelVo saveHostel(String hostelName, String password, String hostelSeq, String bankAccount) {
        return null;
    }

    public Hostel updateHostel(Hostel hostel) {
        return hostelDao.save(hostel);
    }

    public HostelVo updateHostel(int hostelId, String hostelName,String bankAccount,String description,
                                 String host,String address) {
        Hostel hostel = hostelDao.findById(hostelId);
        hostel.setHostelName(hostelName);
        hostel.setBankAccount(bankAccount);
        hostel.setDescription(description);
        hostel.setHost(host);
        hostel.setAddress(address);
        hostel.setStatus(0);
        return new HostelVo(hostelDao.save(hostel));
    }

    public Hostel findHostel(String hostelSeq) {
        return hostelDao.findByHostelSeq(hostelSeq);
    }

    public Hostel findHostel(String hostelSeq, String password) {
        return hostelDao.findByHostelSeqAndPassword(hostelSeq, password);
    }

    public List<HostelVo> findHostel(int status) {
        List<HostelVo> list = new ArrayList<HostelVo>();
        for(Hostel hostel:hostelDao.findByStatus(status)){
            list.add(new HostelVo(hostel));
        }
        return list;
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

    public HostelVo findHostelDetail(int hostelId) {
        return new HostelVo(hostelDao.findById(hostelId));
    }

}
