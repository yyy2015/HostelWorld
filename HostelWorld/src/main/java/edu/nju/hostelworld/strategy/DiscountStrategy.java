package edu.nju.hostelworld.strategy;

/**
 * Created by yyy on 2017/3/26.
 */
public interface DiscountStrategy {
    /**
     * 会员折扣策略
     * @param level
     * @param money
     * @return
     */
    double getDiscountPrice(int level,double money);
}
