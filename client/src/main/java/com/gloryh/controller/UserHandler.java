package com.gloryh.controller;

import com.gloryh.entity.Menu;
import com.gloryh.entity.User;
import com.gloryh.entity.UserVO;
import com.gloryh.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 服务消费者 user controller
 *
 * @author 黄光辉
 * @since 2020/10/30
 **/
@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;
    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page,@RequestParam("limit")int limit){
        int index=limit*(page-1);
        return userFeign.findAll(index,limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/findById/{id}")
    private User findById(@PathVariable("id") long id) {
        return userFeign.findById(id);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable String location) {
        return location;
    }

}
