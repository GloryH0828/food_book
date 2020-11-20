package com.gloryh.repository;

import com.gloryh.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜品分类相关操作接口类
 *
 * @author 黄光辉
 * @since 2020/10/28
 **/
@Repository
public interface TypeRepository {
    /**
     * 查询所有菜品分类信息
     * @return List
     */
    public List<Type> findAll();
}
