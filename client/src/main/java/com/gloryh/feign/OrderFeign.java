package com.gloryh.feign;

import com.gloryh.entity.Order;
import com.gloryh.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * Order 的 Feign 声明式接口
 *
 * @author 黄光辉
 * @since 2020/11/1
 **/
@Repository
@FeignClient(value = "order")
public interface OrderFeign {
    /**
     * 查询订单列表列表
     *
     * @param index 起始下标
     * @param limit 长度
     * @return  订单列表OrderVO
     */
    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable int index,@PathVariable int limit);

    /**
     * 统计订单数量
     * @return int
     */
    @GetMapping("/order/count")
    public int count();

    /**
     *  按id 查询订单
     * @param id
     * @return Order
     */
    @GetMapping("/order/findById/{id}")
    public Order findById(@PathVariable long id);

    /**
     * 添加订单信息
     * @param order
     */
    @PostMapping("/order/save")
    public void save(Order order);

    /**
     * 管理员审核订单
     * @param order
     */
    @PutMapping("/order/update")
    public void update(Order order);

    /**
     * 按用户 id 查询订单列表
     * @param uid 用户 id
     * @param index 起始下标
     * @param limit 数据长度
     * @return OrderVO
     */
    @GetMapping("/order/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(@PathVariable long uid,@PathVariable int index,@PathVariable int limit);

    /**
     * 按订单状态查询订单信息
     * @param state 状态
     * @param index 起始下标
     * @param limit 数据长度
     * @return OrderVO
     */
    @GetMapping("/order/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable int state,@PathVariable int index,@PathVariable int limit);

}
