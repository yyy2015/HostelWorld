package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.model.Bill;
import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.service.ManagerService;
import edu.nju.hostelworld.vo.HostelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
@Controller
@RequestMapping("/hostelManage")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 获取未审批客栈列表
     * @return
     */
    @RequestMapping("/applicationList")
    @ResponseBody
    public List<HostelVo> getApplicationList(){
        List<HostelVo> voList = managerService.getApplicationList();
        System.out.println(voList.get(0).getRooms());
        return voList;
    }

    @RequestMapping("/approve/{hostelId}")
    @ResponseBody
    public List<HostelVo> approve(@PathVariable int hostelId){
        managerService.examine(hostelId,1);
        return getApplicationList();
    }

    @RequestMapping("/refuse/{hostelId}")
    public List<HostelVo> refuse(@PathVariable int hostelId){
        managerService.examine(hostelId,-1);
        return getApplicationList();
    }

    @RequestMapping("/bill")
    @ResponseBody
    public List<Bill> getBills(){
        return managerService.getBillList();
    }

    @RequestMapping("/settle/{hostelId}")
    @ResponseBody
    public List<Bill> settleAccount(@PathVariable int hostelId){
        managerService.settleAccount(hostelId);
        return getBills();
    }



}
