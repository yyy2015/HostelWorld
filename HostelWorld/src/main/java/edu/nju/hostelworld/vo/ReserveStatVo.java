package edu.nju.hostelworld.vo;

import java.util.List;

/**
 * Created by yyy on 2017/3/29.
 */
public class ReserveStatVo {
    private String name;
    private List<Integer> data;

    public ReserveStatVo(String name, List<Integer> data){
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
