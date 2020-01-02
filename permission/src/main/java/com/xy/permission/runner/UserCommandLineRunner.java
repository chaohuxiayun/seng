package com.xy.permission.runner;

import com.xy.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        int count = userService.onLineCount();
        // 设置当前在线人数
        redisTemplate.opsForValue().set("onlineCount", count);

        // 上次口令？
        System.out.println(redisTemplate.opsForValue().get("token"));
        // 设置本次口令
        redisTemplate.opsForValue().set("token", UUID.randomUUID().toString());




    }
}
