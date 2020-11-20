package com.gloryh.entity;

import lombok.Data;

/**
 * 管理员实体类
 *
 * @author 黄光辉
 * @since 2020/10/31
 **/
@Data
public class Admin {
    private long id;
    private String username;
    private String password;
}
