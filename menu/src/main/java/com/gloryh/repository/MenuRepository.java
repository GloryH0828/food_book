package com.gloryh.repository;

import com.gloryh.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis 与数据库交互的调用接口类
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@Repository
public interface MenuRepository {
    /**
     * 查询菜单列表
     *
     * @param index 起始下标
     * @param limit 长度
     * @return  菜单列表List
     */
    public List<Menu> findAll(int index,int limit);

    /**
     * 统计菜单内菜品数量
     * @return int
     */
    public int count();

    /**
     *  按id 查询菜品
     * @param id
     * @return 菜品
     */
    public Menu findById(long id);

    /**
     * 添加菜品信息
     * @param menu
     */
    public void save(Menu menu);

    /**
     * 修改菜品信息
     * @param menu
     */
    public void update(Menu menu);

    /**
     * 按 id 删除菜品信息
     * @param id
     */
    public void deleteById(long id);
}
