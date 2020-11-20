package com.gloryh.repository;

import com.gloryh.entity.User;

import java.util.List;

/**
 *  User MyBatis 与数据库交互的调用接口类
 *
 * @author 黄光辉
 * @since 2020/10/30
 **/
public interface UserRepository {
    /**
     * 查询所有用户信息
     * @param index 起始下标
     * @param limit 长度
     * @return List<User>
     */
    public List<User> findAll(int index,int limit);

    /**
     * 按 id 查询用户信息
     * @param id
     * @return User
     */
    public User findById(long id);

    /**
     * 查询用户总数
     * @return int
     */
    public int count();

    /**
     * 添加新用户
     * @param user
     */
    public void save(User user);

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user);

    /**
     * 按 id 删除用户信息
     * @param id
     */
    public void deleteById(long id);
}
