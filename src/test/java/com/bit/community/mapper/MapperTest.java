package com.bit.community.mapper;

import com.bit.community.CommunityApplication;
import com.bit.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectByName(){
        User user = userMapper.selectByName("test");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setCreateTime(new Date());
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.newcoder.com/101.png");
        int i = userMapper.insertUser(user);
        System.out.println(i);
        System.out.println(user.getId());
        System.out.println(user);
    }

    @Test
    public void testUpdateStatus(){
        int i = userMapper.updateStatus(150, 2);
        System.out.println(i);
        User user = userMapper.selectById(150);
        System.out.println(user);
    }

}
