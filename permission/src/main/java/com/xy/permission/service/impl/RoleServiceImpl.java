package com.xy.permission.service.impl;

import com.xy.permission.dao.RoleMapper;
import com.xy.permission.dao.UserRoleMapper;
import com.xy.permission.pojo.*;
import com.xy.permission.service.RoleService;
import com.xy.permission.vo.ResponseBean;
import com.xy.permission.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiayun
 * @version V1.0.0
 * @description RoleServiceIMpl
 * @date   2019/12/11 14:06
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public List<Role> selectByUser(UserVo user) {
        return selectByUserId(user.getId());
    }

    @Override
    public List<Role> selectByUserId(Integer id) {
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);

        List<UserRole> list = userRoleMapper.selectByExample(example);
        List<Integer> ids = new ArrayList<>();

        list.forEach(userRole -> {
            ids.add(userRole.getRoleId());
        });

        RoleExample example1 = new RoleExample();
        RoleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdIn(ids);

        List<Role> roles = roleMapper.selectByExample(example1);

        return roles;
    }

    @Override
    public ResponseBean addRole(Role role) {
        int i = roleMapper.insertSelective(role);
        if (i == 1) {
            return ResponseBean.OK();
        }
        return ResponseBean.FAILURE();
    }

    @Override
    public ResponseBean updateRole(Role role) {
        int i = roleMapper.updateByPrimaryKey(role);
        if (i == 1) {
            return ResponseBean.OK();
        }
        return ResponseBean.FAILURE();
    }
}
