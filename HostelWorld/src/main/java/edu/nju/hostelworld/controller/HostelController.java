package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.service.HostelService;
import edu.nju.hostelworld.service.RoomService;
import edu.nju.hostelworld.util.DateTrans;
import edu.nju.hostelworld.vo.HostelVo;
import edu.nju.hostelworld.vo.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yyy on 2017/3/19.
 */
@Controller
@RequestMapping("/hostel")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @Autowired
    private RoomService roomService;

    @RequestMapping("/modifyInfo")
    public String modifyInfo(@RequestParam("hostelName")String hostelName,
                             @RequestParam("bankAccount")String bankAccount,
                             @RequestParam("description")String description,
                             @RequestParam("host")String host,
                             @RequestParam("address")String address,
                             HttpSession session,Model model){
        String hostelSeq = (String)session.getAttribute("hostelSeq");
        Hostel hostel = hostelService.findHostel(hostelSeq);
        hostel.setHostelName(hostelName);
        hostel.setBankAccount(bankAccount);
        hostel.setDescription(description);
        hostel.setHost(host);
        hostel.setAddress(address);
        hostel.setStatus(0);//需要重新审核
        hostelService.updateHostel(hostel);

        model.addAttribute("hostel",hostel);

        return "hostelHome";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<HostelVo> getHostelList(HttpSession session){
       return hostelService.findHostel(1);//获得通过审批的客栈列表
    }

    @RequestMapping("/detail/{id}")
    public String getHostelDetail(@PathVariable int id,Model model){
        HostelVo hostel = hostelService.findHostelDetail(id);
        model.addAttribute("hostel",hostel);
        return "hostelDetail";
    }

    @RequestMapping("/roomList/{hostelId}")
    @ResponseBody
    public List<RoomVo> getRoomList(@PathVariable int hostelId){
        return roomService.getRoom(hostelId);
    }

    @RequestMapping("/releasePlan/{hostelId}")
    public String releasePlan(@PathVariable int hostelId,@RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate, @RequestParam("type") String type,
                                    @RequestParam("num") int num,@RequestParam("address") String address,
                                    @RequestParam("price") double price){
        int realType = 0;
        if(type.equals("单人间")){realType = 0;}
        if(type.equals("大床房")){realType = 1;}
        if(type.equals("标准间")){realType = 2;}
        Timestamp start = DateTrans.string2time(startDate);
        Timestamp end = DateTrans.string2time(endDate);
        roomService.releaseRoomPlan(hostelId,realType,price,address,num,start,end);

        return "hostelReleasePlan";
    }



}
