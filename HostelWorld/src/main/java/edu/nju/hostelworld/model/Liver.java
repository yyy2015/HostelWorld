package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by yyy on 2017/3/26.
 */
@Entity
public class Liver {
    private int id;
    private String livername;
    private Live live;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "livername")
    public String getLivername() {
        return livername;
    }

    public void setLivername(String livername) {
        this.livername = livername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liver liver = (Liver) o;

        if (id != liver.id) return false;
        if (livername != null ? !livername.equals(liver.livername) : liver.livername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (livername != null ? livername.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "liveId", referencedColumnName = "id", nullable = false)
    public Live getLive() {
        return live;
    }

    public void setLive(Live liveByLiveId) {
        this.live = liveByLiveId;
    }
}
