package com.jjc.java.learn.bussness.spring.ioc;

import com.jjc.java.learn.bussness.spring.ioc.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-30 16:36
 **/

public class IOCTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Car car = (Car)context.getBean("car");
        System.out.println(car.getName());
        context.close();
    }

}
