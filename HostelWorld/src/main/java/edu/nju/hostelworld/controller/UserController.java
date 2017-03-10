package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> test(){

//        userService.deleteUser("aaa");
//        userService.deleteUser("bbb");

//        User user1 = new User();
//        user1.setUsername("ccc");
//        user1.setPassword("ccc");
//        user1.setCardId("2121213");
//        userService.saveUser(user1);
//
//        User user2 = new User();
//        user2.setUsername("ddd");
//        user2.setPassword("ddd");
//        user2.setCardId("3434567");
//        userService.saveUser(user2);

        List<User> list = userService.findAllUser();

        return list;

    }
}
