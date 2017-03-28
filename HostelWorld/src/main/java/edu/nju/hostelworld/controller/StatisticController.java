package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.service.StatisticService;
import edu.nju.hostelworld.vo.HostelMoneyBar;
import edu.nju.hostelworld.vo.HostelMoneyVo;
import edu.nju.hostelworld.vo.ReserveStatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yyy on 2017/3/29.
 */
@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping("/hostelMoney")
    @ResponseBody
    public List<HostelMoneyVo> getHostelMoney(){
        return statisticService.getHostelMoney();
    }

    @RequestMapping("/hostelMoneyBar")
    @ResponseBody
    public List<HostelMoneyBar> getHostelMoneyBar(){
        return statisticService.getHostelMoneyBar();
    }

    @RequestMapping("/hostelNames")
    @ResponseBody
    public List<String> getHostelNames(){
        return statisticService.getHostelName();
    }

    @RequestMapping("/getReserveStat")
    @ResponseBody
    public List<ReserveStatVo> getReserveStat(){
        return statisticService.getReserveStatVo();
    }
}
