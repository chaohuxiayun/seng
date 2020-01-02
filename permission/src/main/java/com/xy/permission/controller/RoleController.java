package com.xy.permission.controller;

import com.xy.permission.pojo.Role;
import com.xy.permission.service.RoleService;
import com.xy.permission.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiayun
 * @version V1.0.0
 * @description RoleController
 * @date   2019/12/11 15:36
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/getRolesByUserId/{id}")
    @ResponseBody
    public List<Role> getRolesByUserId(@PathVariable Integer id) {
        return roleService.selectByUserId(id);
    }

    @PostMapping(value = "/addRole")
    @ResponseBody
    public ResponseBean addRole(Role role) {
        return roleService.addRole(role);
    }

    @PutMapping(value = "/updateRole")
    @ResponseBody
    public ResponseBean updateRole(Role role) {
        return roleService.updateRole(role);
    }
}
