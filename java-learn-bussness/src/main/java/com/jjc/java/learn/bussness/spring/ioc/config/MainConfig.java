package com.jjc.java.learn.bussness.spring.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-30 16:40
 **/
@Configuration
@ComponentScan(basePackages = {"com.jjc.java.learn.bussness.spring.ioc"})
public class MainConfig {
}
