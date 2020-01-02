package com.xy.door.service;


import com.xy.door.vo.PermissionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Permission;
import java.util.List;
import java.util.Map;

@FeignClient(value = "zuul")
public interface PermissionService {

    @PostMapping(value = "/api-permission/user/login")
    Map<String,Object> login(@RequestParam String loginName, @RequestParam String password);

    @GetMapping(value = "/api-permission/role/getRolesByUserId/{id}")
    List<Map<String,Object>> getRolesByUserId(@PathVariable Integer id);

    @RequestMapping(value = "/api-permission/permission/getPermissionsByUserId/{id}", method = RequestMethod.GET,produces={"application/json;","text/html;charset=UTF-8;"} )
    List<PermissionVo> getPermissionsByUserId(@PathVariable Integer id);
}
