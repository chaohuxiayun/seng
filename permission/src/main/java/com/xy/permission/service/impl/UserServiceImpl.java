package com.xy.permission.service.impl;

import com.xy.permission.dao.UserMapper;
import com.xy.permission.pojo.User;
import com.xy.permission.pojo.UserExample;
import com.xy.permission.service.UserService;
import com.xy.permission.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int onLineCount() {
        return userMapper.onlineCount();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public UserVo login(String loginName, String password) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        criteria.andPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            User user = users.get(0);
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(user, vo);

            // 修改登录状态
            user.setLoginCount(user.getLoginCount() + 1);
            user.setLastLoginTime(new Date());
            user.setIsOnline("1");
            userMapper.updateByPrimaryKey(user);

            return vo;
        }
        return null;
    }

    @Override
    public boolean offline(User user) {

        User user1 = new User();
        user1.setId(user.getId());
        user1.setIsOnline("0");
        int i = userMapper.updateByPrimaryKeySelective(user1);
        return i == 1;
    }


}
