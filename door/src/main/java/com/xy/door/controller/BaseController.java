package com.xy.door.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiayun
 * @version V1.0.0
 * @description BaseController
 * @date   2019/12/25 13:40
 */
public class BaseController {
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected final String SUCCESS = "success";

    protected final String FAILURE = "failure";
}
