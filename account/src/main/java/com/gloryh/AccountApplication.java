package com.gloryh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * account 服务启动类
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@SpringBootApplication
@MapperScan("com.gloryh.repository")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}