package com.mark.java.controller;

import com.mark.java.entity.User;
import com.mark.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by yyy on 2017/2/17.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String home(){
        List<User> us =new ArrayList<User>();
        User u = new User();
        u.setUsername("Mark");
        us.add(u);
        User u1 = new User();
        u1.setUsername("Fawofolo");
        us.add(u1);
        userService.saveUsers(us);

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> json(){
        return userService.getAllUsernames();
    }
}
