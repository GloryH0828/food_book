package com.gloryh.controller;

import com.gloryh.entity.*;
import com.gloryh.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 服务消费者 order controller
 *
 * @author 黄光辉
 * @since 2020/11/1
 **/
@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAll(@RequestParam("page") int page ,@RequestParam("limit") int limit){
        int index =(page-1)*limit;
        return orderFeign.findAll(index,limit);
    }

    @GetMapping("/save/{mid}")
    public String save(@PathVariable long mid, HttpSession session){
        //mid通过传值获取，uid通过session获取，后台获取当前时间date
        User user =(User) session.getAttribute("user");
        Menu menu =new Menu();
        menu.setId(mid);
        Order order = new Order();
        order.setDate(new Date());
        order.setMenu(menu);
        order.setUser(user);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        int index =(page-1)*limit;
        return orderFeign.findAllByUid(user.getId(),index,limit);
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        int index =(page-1)*limit;
        return orderFeign.findAllByState(0,index,limit);
    }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable long id,HttpSession session){
        Order order =new Order();
        order.setId(id);
        Admin admin=(Admin)session.getAttribute("admin");
        order.setAdmin(admin);
        orderFeign.update(order);
        return "order_handler";
    }
}
