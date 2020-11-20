package com.gloryh.repository;

import com.gloryh.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Admin MyBatis 与数据库交互的调用接口类
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@Repository
public interface AdminRepository {
    /**
     * 查询数据库中对应的Admin信息
     * @param username 用户名
     * @param password 密码
     * @return Admin
     */
    public Admin login(String username,String password);
}
