package com.gloryh.feign;

import com.gloryh.entity.User;
import com.gloryh.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * User 的 Feign 声明式接口
 *
 * @author 黄光辉
 * @since 2020/10/30
 **/
@Repository
@FeignClient(value = "user")
public interface UserFeign {
    /**
     * 调用 user 微服务的相关方法
     *
     * @param index
     * @param limit
     * @return List<User>
     */
    @GetMapping("/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable int index, @PathVariable int limit);

    /**
     * 按 id 删除用户信息
     *
     * @param id
     */
    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable long id);


    /**
     * 添加用户信息
     * @param user
     */
    @PostMapping("/user/save")
    public void save(User user);

    /**
     * 修改用户信息
     * @param user
     */
    @PutMapping("/user/update")
    public void update(User user);

    /**
     * 按 id 查询 用户信息
     * @param id
     * @return User
     */
    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable long id);
}
