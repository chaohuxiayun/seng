package com.xy.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname PermissionApplication
 * @Description
 * @Date 2019/11/27 15:59
 * @Author xiayun
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xy.permission.dao")
public class PermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class, args);
    }



}
