package com.xy.door.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author xiayun
 * @version V1.0.0
 * @description SessionConfig
 * @date   2019/12/26 11:11
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {

    @Value("${redis.hostname:192.168.99.100}")
    private String hostName;
    @Value("${redis.port:6379}")
    private int port;
    // @Value("${redis.password}")
    // private String password;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(port);
        connection.setHostName(hostName);
        //connection.setPassword(password);
        //connection.setDatabase(0);
        return connection;
    }
}
