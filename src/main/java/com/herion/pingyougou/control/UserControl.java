package com.herion.pingyougou.control;

import com.herion.pingyougou.util.SendMessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserControl {
    @RequestMapping(value = "/login")
    public String login(){
        return "user-login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "user-register";
    }

    @RequestMapping(value = "sendCode")
    @ResponseBody
    //request是页面上传回来的信息
    public Object sendCode(HttpServletRequest request){
        //获取页面上传来的tel值
        String tel = request.getParameter("tel");
        //获取6位验证码
        String code = SendMessageUtil.getRandomCode(6);
        //向手机发送验证码
//        int mobCode = SendMessageUtil.send("herion","d41d8cd98f00b204e996",tel,code);
//        String message = SendMessageUtil.getMessage(mobCode);
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        //test向页面发送验证码
        map.put("message",code);
//        map.put("message",message);
        return map;
    }

//    @RequestMapping(value = "login")
//    public String register2(){
//        return "user-login";
//    }

    @RequestMapping(value = "/test")
    public String login1() {
        return "test/login";
    }
}
