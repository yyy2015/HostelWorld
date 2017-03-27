package edu.nju.hostelworld.vo;

import edu.nju.hostelworld.model.Live;
import edu.nju.hostelworld.model.Liver;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/27.
 */
public class LiverVo {

    private int id;
    private String livername;
    private LiveVo live;

    public LiverVo(Liver liver){
        BeanUtils.copyProperties(liver,this,"live");
        live = new LiveVo(liver.getLive());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivername() {
        return livername;
    }

    public void setLivername(String livername) {
        this.livername = livername;
    }

    public LiveVo getLive() {
        return live;
    }

    public void setLive(LiveVo live) {
        this.live = live;
    }
}
