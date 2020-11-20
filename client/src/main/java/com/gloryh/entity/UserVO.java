package com.gloryh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 将返回的实体类类型进行二次封装，已达到前端和服务消费者所需要的格式
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
