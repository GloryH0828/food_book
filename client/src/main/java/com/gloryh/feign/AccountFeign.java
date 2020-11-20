package com.gloryh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Account 的 Feign 声明式接口
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@Repository
@FeignClient(value = "account")
public interface AccountFeign {

    /**
     * 登录选项 返回一个 Object 对象，即多态处理 登录人身份
     *
     * @param username 用户名
     * @param password 密码
     * @param type     角色
     * @return Object
     */
    @GetMapping("/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable String username, @PathVariable String password, @PathVariable String type);
}
