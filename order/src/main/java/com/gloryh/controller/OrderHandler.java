package com.gloryh.controller;

import com.gloryh.entity.Order;
import com.gloryh.entity.OrderVO;
import com.gloryh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * order controller
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable int index, @PathVariable int limit){
        List<Order> orders = orderRepository.findAll(index,limit);
        int count =orderRepository.count();
        return new OrderVO(0,"",count,orders);
    }

    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable long id){
        return orderRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Order order){
        orderRepository.update(order);
    }

    @GetMapping("/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(@PathVariable long uid,@PathVariable int index,@PathVariable int limit){
        List<Order> orders= orderRepository.findAllByUid(uid, index, limit);
        int count =orderRepository.countByUid(uid);
        return new OrderVO(0,"",count,orders);
    }

    @GetMapping("/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable int state ,@PathVariable int index,@PathVariable int limit){
        List<Order> orders= orderRepository.findAllByState(state, index, limit);
        int count =orderRepository.countByState(state);
        return new OrderVO(0,"",count,orders);
    }


}
