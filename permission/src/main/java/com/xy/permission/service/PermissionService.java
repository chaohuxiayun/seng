package com.xy.permission.service;

import com.xy.permission.pojo.Permission;
import com.xy.permission.pojo.Role;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByRoles(List<Role> roles);
}
