package com.bit.community;

import com.bit.community.dao.TestDao;
import com.bit.community.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
class CommunityApplicationTests implements ApplicationContextAware {
    @Autowired
    Person person;

    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplication(){
        System.out.println(person);
        System.out.println(applicationContext);
        Person newPerson = applicationContext.getBean(Person.class);
        System.out.println(newPerson);
    }
    @Test
    public void testDao(){
        TestDao bean = applicationContext.getBean(TestDao.class);
        System.out.println(bean.testStr);
    }
}
