package com.xy.permission.service;

import com.xy.permission.pojo.Role;
import com.xy.permission.vo.ResponseBean;
import com.xy.permission.vo.UserVo;

import java.util.List;

public interface RoleService {

    List<Role> selectAll();

    List<Role> selectByUser(UserVo user);

    List<Role> selectByUserId(Integer id);

    ResponseBean addRole(Role role);

    ResponseBean updateRole(Role role);

}
