package com.gloryh.entity;

import lombok.Data;

/**
 * 对应 menu 数据表的实体类
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;
}
