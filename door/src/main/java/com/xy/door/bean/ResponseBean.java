package com.xy.door.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * @author xiayun
 * @version V1.0.0
 * @description ResponseBean
 * @date   2019/12/26 16:53
 */
@Data
public class ResponseBean {
    private String code;
    private String message;
    private String content;
    private Object data;

    private String source;
    private String time;

    public ResponseBean() {
    }

    public ResponseBean(String code, String message, String content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBean(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    @SneakyThrows
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public ResponseBean toBean(String beanJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(beanJson, ResponseBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseBean();
    }

    public static ResponseBean OK() {
        return new ResponseBean("200", "success");
    }

    public static ResponseBean OK(Object data) {
        return new ResponseBean("200", "success", data);
    }

    public static ResponseBean FAILURE() {
        return new ResponseBean("500", "failure");
    }
}
