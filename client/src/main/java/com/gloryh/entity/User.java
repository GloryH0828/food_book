package com.gloryh.entity;

import lombok.Data;

import java.util.Date;

/**
 * user 用户实体类
 *
 * @author 黄光辉
 * @since 2020/10/30
 **/
@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;
}
