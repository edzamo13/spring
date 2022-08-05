package com.platzi.springboot.configuration;

import com.platzi.springboot.bean.MyBean;
import com.platzi.springboot.bean.implementation.MyBeanTwoImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class GeneralConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBeanTwoImpl();
    }

    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;





}