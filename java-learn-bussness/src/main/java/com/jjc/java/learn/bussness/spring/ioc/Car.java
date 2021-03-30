package com.jjc.java.learn.bussness.spring.ioc;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-30 16:37
 **/

@Data
@Component
public class Car {


    String name = "汽车";
}
