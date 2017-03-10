package com.mark.java.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by yyy on 2017/2/17.
 */
@Entity
@Table
public class User implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue
    private  int id;

    @Size(min=3)
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
