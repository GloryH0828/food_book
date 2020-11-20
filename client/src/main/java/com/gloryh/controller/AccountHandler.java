package com.gloryh.controller;

import com.gloryh.entity.Admin;
import com.gloryh.entity.User;
import com.gloryh.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 服务消费者 account controller
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        //这里由于 object 为LinkedHashMap 类型，强转会出现错误
        Object object = accountFeign.login(username, password, type);
        //为处理错误将object先强转为 LinkedHashMap
        LinkedHashMap<String, Object> hashMap =(LinkedHashMap) object;
        String result=null;
        if (object != null){
            switch (type){
                case "user":
                    //单个赋值处理强转错误
                    User user = new User();
                    user.setId(Long.parseLong(hashMap.get("id").toString()));
                    user.setNickname((String)hashMap.get("nickname"));
                    session.setAttribute("user",user);
                    result="index";
                    break;
                case "admin":
                    //单个赋值处理强转错误
                    Admin admin = new Admin();
                    admin.setId(Long.parseLong(hashMap.get("id").toString()));
                    admin.setUsername((String)hashMap.get("username"));
                    session.setAttribute("admin",admin);
                    result="main";
                    break;
            }
        }else {
           result="login";
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
