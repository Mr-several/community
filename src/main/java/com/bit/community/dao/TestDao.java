package com.bit.community.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("singleton")
public class TestDao {
    public String testStr;
    public TestDao(){
        System.out.println("实例化TestDao");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化实例");
        testStr = "testStr";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("TetDao被销毁");
    }
}
