package com.xy.permission.service;

import com.xy.permission.pojo.User;
import com.xy.permission.vo.UserVo;

public interface UserService {
    int onLineCount();

    UserVo login(String loginName, String password);

    boolean offline(User user);
}
