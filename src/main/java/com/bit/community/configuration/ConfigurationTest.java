package com.bit.community.configuration;

import com.bit.community.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {
    @Bean
    public Person creatPerson(){
        return new Person("zhang", "13126726866");
    }
}
