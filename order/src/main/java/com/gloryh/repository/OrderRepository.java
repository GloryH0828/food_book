package com.gloryh.repository;

import com.gloryh.entity.Menu;
import com.gloryh.entity.Order;
import com.gloryh.entity.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Order MyBatis 与数据库交互的调用接口类
 *
 * @author 黄光辉
 * @since 2020/11/1
 **/
@Repository
public interface OrderRepository {
    /**
     * 查询订单列表列表
     *
     * @param index 起始下标
     * @param limit 长度
     * @return  订单列表List
     */
    public List<Order> findAll(int index, int limit);

    /**
     * 统计订单数量
     * @return int
     */
    public int count();

    /**
     *  按id 查询订单
     * @param id
     * @return Order
     */
    public Order findById(long id);

    /**
     * 添加订单信息
     * @param order
     */
    public void save(Order order);

    /**
     * 管理员审核订单
     * @param order
     */
    public void update(Order order);

    /**
     * 根据用户 id 查询订单信息
     *
     * @param uid 用户id
     * @param index 起始下标
     * @param limit 长度
     * @return List<order>
     */
    public List<Order> findAllByUid(@Param("uid") long uid, @Param("index") int index, @Param("limit") int limit);

    /**
     * 按 用户id 查询 对应订单总数
     * @param uid 用户 id
     * @return int
     */
    public int countByUid(long uid);

    /**
     * 根据订单状态查询订单信息
     * @param state 状态
     * @param index 起始下标
     * @param limit 长度
     * @return List<order>
     */
    public List<Order> findAllByState(@Param("state") int state, @Param("index") int index, @Param("limit") int limit);

    /**
     * 根据订单状态查询订单数量
     * @param state 状态
     * @return int
     */
    public int countByState(int state);

}
