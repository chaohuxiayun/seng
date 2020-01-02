package com.xy.permission.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description   
 * @author xiayun     
 * @date   2019/12/11 11:16  
 * @version V1.0.0
 */
public class BaseController {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected final String SUCCESS = "success";

    protected final String FAILURE = "failure";

}
