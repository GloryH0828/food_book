package com.gloryh.controller;

import com.gloryh.entity.User;
import com.gloryh.entity.UserVO;
import com.gloryh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user controller
 *
 * @author 黄光辉
 * @since 2020/10/30
 **/
@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        // 获取所有列表
        List<User> users = userRepository.findAll(index, limit);
        //获取总数
        int count = userRepository.count();
        return new UserVO(0, "", count, users);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }
}
