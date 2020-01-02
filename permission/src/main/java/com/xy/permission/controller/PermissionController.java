package com.xy.permission.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xy.permission.pojo.Permission;
import com.xy.permission.pojo.Role;
import com.xy.permission.service.PermissionService;
import com.xy.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiayun
 * @version V1.0.0
 * @description Permiss
 * @date   2019/12/11 14:29
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/getPermissionsByUserId/{id}", method = RequestMethod.GET,produces={"application/json;","text/html;charset=UTF-8;"})
    public List<Permission> getPermissionsByUserId(@PathVariable Integer id) {
        List<Role> list = roleService.selectByUserId(id);
        List<Permission>  result = permissionService.selectByRoles(list);
        try {
            System.out.println(objectMapper.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
