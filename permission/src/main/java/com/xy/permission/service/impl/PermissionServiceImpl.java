package com.xy.permission.service.impl;

import com.xy.permission.dao.PermissionMapper;
import com.xy.permission.dao.RolePermissionMapper;
import com.xy.permission.pojo.*;
import com.xy.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiayun
 * @version V1.0.0
 * @description PermissionServiceImpl
 * @date   2019/12/11 14:14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> selectByRoles(List<Role> roles) {

        List<Integer> roleIds = new ArrayList<>();
        roles.forEach(role -> roleIds.add(role.getId()));

        RolePermissionExample example = new RolePermissionExample();
        RolePermissionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdIn(roleIds);
        List<RolePermission> rpList = rolePermissionMapper.selectByExample(example);

        List<Integer> pIds = new ArrayList<>();
        rpList.forEach(rp -> pIds.add(rp.getPermissionId()));

        PermissionExample pe = new PermissionExample();
        PermissionExample.Criteria pc = pe.createCriteria();
        pc.andIdIn(pIds);

        return permissionMapper.selectByExample(pe);
    }
}
