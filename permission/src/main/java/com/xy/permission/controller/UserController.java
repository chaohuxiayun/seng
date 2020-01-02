package com.xy.permission.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xy.permission.service.UserService;
import com.xy.permission.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description   
 * @author xiayun     
 * @date   2019/12/11 11:16  
 * @version V1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public UserVo login(String loginName,String password){
        System.out.println(loginName + " " + password);
        UserVo vo =userService.login(loginName,password);
        try {
            System.out.println(objectMapper.writeValueAsString(vo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return vo;
    }

}
