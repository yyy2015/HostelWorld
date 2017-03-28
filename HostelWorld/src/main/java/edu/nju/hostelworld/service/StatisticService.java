package edu.nju.hostelworld.service;

import edu.nju.hostelworld.vo.HostelMoneyBar;
import edu.nju.hostelworld.vo.HostelMoneyVo;
import edu.nju.hostelworld.vo.ReserveStatVo;

import java.util.List;

/**
 * Created by yyy on 2017/3/29.
 */
public interface StatisticService {

    /**
     * 获得各客栈盈利列表
     * @return {@link HostelMoneyVo}
     */
    List<HostelMoneyVo> getHostelMoney();

    List<HostelMoneyBar> getHostelMoneyBar();

    List<String> getHostelName();

    List<ReserveStatVo> getReserveStatVo();

}
