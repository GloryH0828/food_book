package com.gloryh.controller;

import com.gloryh.repository.AdminRepository;
import com.gloryh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * account controller
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    private Object login(@PathVariable String username, @PathVariable String password, @PathVariable String type) {
        //由于不确定验证的是用户还是管理员，使用多台对返回值进行处理
        Object object = null;
        switch (type) {
            case "user":
                object = userRepository.login(username, password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}
