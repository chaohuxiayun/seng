package com.xy.door.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname Constants
 * @Description
 * @Date 2019/11/19 15:13
 * @Author xiayun
 */
@Configuration
@ConfigurationProperties(prefix = "constants")
@PropertySource("classpath:constants.properties")
public class Constants {

    private String imageUploadPath;

    public String getImageUploadPath() {
        return imageUploadPath;
    }

    public void setImageUploadPath(String imageUploadPath) {
        this.imageUploadPath = imageUploadPath;
    }
}
