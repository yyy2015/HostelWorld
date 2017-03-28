package edu.nju.hostelworld.vo;

/**
 * Created by yyy on 2017/3/29.
 */
public class HostelMoneyVo {
    private String name;
    private int y;

    public HostelMoneyVo(String name,int y){
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
