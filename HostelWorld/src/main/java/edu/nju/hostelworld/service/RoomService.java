package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.vo.BillVo;
import edu.nju.hostelworld.vo.LiveVo;
import edu.nju.hostelworld.vo.ReserveVo;
import edu.nju.hostelworld.vo.RoomVo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yyy on 2017/3/26.
 */
public interface RoomService {

    /**
     * 发布房间计划
     * @param hostelId 客栈id
     * @param type 房间类型  0：普通单间 1：大床房 2：标准间
     * @param price 单价
     * @param address 地址
     * @param num 房间总数量
     * @param start 计划开始日期
     * @param end 计划结束日期
     * @return {@link Room}
     */
    RoomVo releaseRoomPlan(int hostelId, int type, double price, String address, int num,
                           Timestamp start, Timestamp end);

    /**
     * 获取客栈的房间计划
     * @param hostelId 客栈id
     * @return {@link List<Room>}
     */
    List<RoomVo> getRoom(int hostelId);

    /**
     * 会员预订
     * @param userId 用户id
     * @param roomId 房间类id
     * @param start 入住时间
     * @param end   退房时间
     * @param roomNum   房间数
     * @param payMoney  订金金额
     * @return {@link Reserve}
     */
    ReserveVo reserve(int userId, int roomId, Timestamp start, Timestamp end,
                      int roomNum, double payMoney);

    /**
     * 取消预约
     * @param reserveId 预约id
     */
    void cancelReserve(int reserveId);

    /**
     * 新增或更新hostel对客栈的待结算账单
     * @param hostel 客栈对象
     * @param money，为正数则增加金额，为负数则减少金额
     * @return
     */
    BillVo generateBill(Hostel hostel, double money);

    /**
     * 入住登记
     * @param reserveId  预订id 如果没有则传入-1
     * @param roomId 房间类 id
     * @param start 入住时间
     * @param end 退房时间
     * @param livers 入住人姓名列表
     * @return {@link Live}
     */
    LiveVo checkIn(int reserveId, int roomId, int roomNum, Timestamp start, Timestamp end, List<String> livers);

    /**
     * 退房登记
     * @param liveId 入住id
     */
    void checkOut(int liveId);

    /**
     * 获取已预约未入住列表
     * @param hostelId 客栈id
     * @param status 0：已预约 1：已完成 -1：已取消预约
     * @return {@link List<Reserve>}
     */
    List<ReserveVo> getReserveList(int hostelId,int status);

    /**
     * 获取该宾馆已入住房间情况列表
     * @param hostelId 客栈id
     * @return {@link List<Live>}
     */
    List<LiveVo> getLiveList(int hostelId,int status);

}
