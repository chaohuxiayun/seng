package com.xy.door;

import com.xy.door.listener.UserListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.xy.door.constant.Constants;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


/**
 * @Classname DoorApplication
 * @Description
 * @Date 2019/11/11 16:49
 * @Author xiayun
 */
@SpringBootApplication
// 表明自己是一个client
@EnableEurekaClient
@EnableConfigurationProperties(Constants.class)
@EnableFeignClients
public class DoorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoorApplication.class, args);
    }

}
