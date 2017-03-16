package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password, HttpServletRequest request){
        User user = userService.findUser(username,password);
        if(user != null) {
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.removeAttribute("nameOrpwd_wrong");
            return "home";
        }else{
            request.setAttribute("nameOrpwd_wrong",true);
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password,HttpServletRequest request){

        //用户名重复
        if(userService.findUser(username)!= null){
            request.setAttribute("name_repeat",true);
            return "register";
        }

        //生成7位的随机卡号
        int icardId;
        do {
            icardId = (int) ((Math.random() * 9 + 1) * 1000000);
        }while(userService.isCardExist(icardId+""));
        String cardId = icardId+"";

        User user = new User(username,password,cardId);
        userService.saveUser(user);

        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.removeAttribute("name_repeat");
        return "home";

    }



    //test
    @RequestMapping("/test")
    @ResponseBody
    public List<User> test(){

        User u1 = new User();
        u1.setUsername("qwe");
        u1.setPassword("aaa");
        u1.setCardId("0099887");
        User r1 = userService.saveUser(u1);

        if(r1 == null){
            System.out.println("r1 is null because the repeated column value");
        }

        System.out.println("R1's id is "+r1.getId());

        User r2 = userService.findUser("qwe","aaa");
        r2.setPassword("wantchange");
        r2 = userService.saveUser(r2);

        List<User> list = userService.findAllUser();

        return list;

    }
}
