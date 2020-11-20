package com.gloryh.feign;

import com.gloryh.entity.Menu;
import com.gloryh.entity.MenuVO;
import com.gloryh.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Menu 的 Feign 声明式接口
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@Repository
@FeignClient(value = "menu")
public interface MenuFeign {
    /**
     * 调用 menu 微服务的相关方法
     *
     * @param index
     * @param limit
     * @return List<Menu>
     */
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable int index, @PathVariable int limit);

    /**
     * 按 id 删除菜品信息
     *
     * @param id
     */
    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable long id);

    /**
     * 获取菜品分类列表
     *
     * @return List<Type>
     */
    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    /**
     * 添加菜品信息
     * @param menu
     */
    @PostMapping("/menu/save")
    public void save(Menu menu);

    /**
     * 修改菜品信息
     * @param menu
     */
    @PutMapping("/menu/update")
    public void update(Menu menu);

    /**
     * 按 id 查询 菜品信息
     * @param id
     * @return Menu
     */
    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable long id);
}
