package com.bit.community.mapper;

import com.bit.community.CommunityApplication;
import com.bit.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
public class DiscussPostTest {
    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 1, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }

    @Test
    public void testSelectDiscussPostRows(){
        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(i);
    }
}
