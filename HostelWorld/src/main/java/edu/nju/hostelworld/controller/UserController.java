package edu.nju.hostelworld.controller;

import edu.nju.hostelworld.model.Hostel;
import edu.nju.hostelworld.model.User;
import edu.nju.hostelworld.service.HostelService;
import edu.nju.hostelworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yyy on 2017/3/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HostelService hostelService;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("identity")String identity, HttpSession session){
        //会员登录
        if(identity.equals("member")){
            User user = userService.findUser(username,password);
            if(user != null) {
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                session.removeAttribute("nameOrpwd_wrong");
                return "home";
            }else{
                session.setAttribute("nameOrpwd_wrong",true);
                return "login";
            }
        }
        //客栈登录
        if(identity.equals("hostel") ){
            Hostel hostel = hostelService.findHostel(username,password);//username其实为序列号
            if(hostel != null){
                session.setAttribute("hostelSeq",username);
                session.setAttribute("password",password);
                session.removeAttribute("nameOrpwd_wrong");
                return "hostelHome";
            }else{
                session.setAttribute("nameOrpwd_wrong",true);
                return "login";
            }
        }
        //经理登录
        if(identity.equals("manager")){
            Hostel manager = hostelService.findManager(username,password);
            if(manager != null){
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                session.removeAttribute("nameOrpwd_wrong");
                return "managerHome";
            }else{
                session.setAttribute("nameOrpwd_wrong",true);
                return "login";
            }
        }

        return "login";

    }

    @RequestMapping("/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("bankAccount")String bankAccount,
                           @RequestParam("identity")String identity,
                           HttpSession session){

        if(identity.equals("member")){
            //用户名重复
            if(userService.findUser(username)!= null){
                session.setAttribute("name_repeat",true);
                return "register";
            }

            //生成7位的随机卡号
            int icardId;
            do {
                icardId = (int) ((Math.random() * 9 + 1) * 1000000);
            }while(userService.isCardExist(icardId+""));
            String cardId = icardId+"";

            User user = new User(username,password,cardId,bankAccount);
            userService.saveUser(user);

            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.removeAttribute("name_repeat");
            return "home";
        }
        if(identity.equals("hostel")){
            int seq;
            do{
                seq = (int) ((Math.random() * 9 + 1) * 1000000);
            }while(hostelService.isHostelSeqExist(seq+""));
            String hostelSeq = seq+"";

            Hostel hostel = new Hostel(username,password,hostelSeq,bankAccount);
            hostelService.saveHostel(hostel);

            session.setAttribute("hostelSeq",hostelSeq);
            session.setAttribute("password",password);
            return "hostelHome";
        }

        return "register";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        session = null;
        return "login";
    }


    @RequestMapping("/userInfo")
    public String getUserInfo(Model model,HttpSession session){
        String username;
        if(session.getAttribute("username") == null){
            return "login";
        }
        username = (String)session.getAttribute("username");

        User user = userService.findUser(username);

        model.addAttribute("user",user);

        return "userInfo";
    }

    /**
     * 充值
     * @param topValue
     * @param request
     * @return
     */
    @RequestMapping("/topUp")
    public String topUp(@RequestParam("top-value")String topValue, HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("username");
        User user = userService.findUser(username);
        double num = Double.parseDouble(topValue);
        //积分
        user.setCredit(user.getCredit()+(int)num/10);
        //余额
        user.setBalance(user.getBalance()+num);
        double balance = user.getBalance();

        //会员激活状态和等级
        user.setStatus(getStatus(user));

        user.setLevel(getLevel(user));

        userService.updateUser(user);

        return "redirect:/user/userInfo";
    }

    /**
     * 积分兑换
     * @param changeValue
     * @param request
     * @return
     */
    @RequestMapping("/change")
    public String getChange(@RequestParam("change-value")String changeValue,HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("username");
        User user = userService.findUser(username);
        int num = Integer.parseInt(changeValue);
        int credit = user.getCredit();
        if(num<=credit){
            user.setCredit(credit-num);
            user.setBalance(user.getBalance()+num/10);
            user.setStatus(getStatus(user));
            user.setLevel(getLevel(user));

        }
        userService.updateUser(user);

        return "redirect:/user/userInfo";

    }

    @RequestMapping("/changePwd")
    public String changePassword(@RequestParam("new-password")String password,HttpSession session){
        String username = (String)session.getAttribute("username");
        User user = userService.findUser(username);
        user.setPassword(password);
        userService.updateUser(user);

        session.invalidate();
        session = null;

        return "login";
    }

    @RequestMapping("/stopMember")
    public String stopMember(HttpSession session){
        String username = (String)session.getAttribute("username");
        userService.deleteUser(username);
        session.invalidate();
        session = null;

        return "login";
    }

    /**
     * 计算会员等级
     * @param user
     * @return
     */
    private int getLevel(User user){
        if(user.getBalance()>5000 && user.getLevel()<1){
            return 1;
        }

        if(user.getBalance()>15000 && user.getLevel()<2){
            return 2;
        }

        return user.getLevel();
    }

    private int getStatus(User user){
        if(user.getBalance()>=1000){
            return 1;
        }
        return user.getStatus();
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


        List<User> list = userService.findAllUser();

        return list;

    }
}
