package edu.nju.hostelworld.strategy;

import org.springframework.stereotype.Component;

/**
 * Created by yyy on 2017/3/26.
 */
@Component
public class DiscountStrategyImpl implements DiscountStrategy {

    public double getDiscountPrice(int level, double money) {

        double[] discount = new double[]{0.95,0.85,0.70};

        return money*discount[level];
    }
}
