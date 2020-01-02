package com.xy.image.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname BaseConstant
 * @Description
 * @Date 2019/11/11 17:15
 * @Author xiayun
 */

@Configuration
@ConfigurationProperties(prefix = "base.constant")
@PropertySource("classpath:baseConstant.properties")
public class BaseConstant {

    private String baiduAppID;
    private String baiduSecretKey;
    private String baiduApiKey;

    private String baiduAccessToken;

    public String getBaiduAppID() {
        return baiduAppID;
    }

    public void setBaiduAppID(String baiduAppID) {
        this.baiduAppID = baiduAppID;
    }

    public String getBaiduSecretKey() {
        return baiduSecretKey;
    }

    public void setBaiduSecretKey(String baiduSecretKey) {
        this.baiduSecretKey = baiduSecretKey;
    }

    public String getBaiduApiKey() {
        return baiduApiKey;
    }

    public void setBaiduApiKey(String baiduApiKey) {
        this.baiduApiKey = baiduApiKey;
    }

    public String getBaiduAccessToken() {
        return baiduAccessToken;
    }

    public void setBaiduAccessToken(String baiduAccessToken) {
        this.baiduAccessToken = baiduAccessToken;
    }
}
