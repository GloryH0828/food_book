package com.gloryh.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单实体类 order
 *
 * @author 黄光辉
 * @since 2020/11/1
 **/
@Data
public class Order {
    private long id;
    private Admin admin;
    private User user;
    private Menu menu;
    private Date date;
    private int state;
}
