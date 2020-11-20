package com.gloryh.repository;

import com.gloryh.entity.User;
import org.springframework.stereotype.Repository;

/**
 * User MyBatis 与数据库交互的调用接口类
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@Repository
public interface UserRepository {
    /**
     * 查询数据库中对应的User信息
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    public User login(String username, String password);
}
