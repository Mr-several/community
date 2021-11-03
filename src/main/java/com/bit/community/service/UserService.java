package com.bit.community.service;

import com.bit.community.entity.User;
import com.bit.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
