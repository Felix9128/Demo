package com.chenm.ssm.service.impl;

import com.chenm.ssm.domain.User;
import com.chenm.ssm.mapper.UserMapper;
import com.chenm.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryByUsername(String username) {
        return userMapper.selectByLoginUsername(username);
    }
}
