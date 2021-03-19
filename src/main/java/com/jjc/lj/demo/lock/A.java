package com.jjc.lj.demo.lock;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-16 11:28
 **/

@Data
public class A {

    private Integer num=0;

    AtomicInteger atomicInteger = new AtomicInteger();



//    //在非静态方法中 锁住的是这个方法
//    public  synchronized void increase(){
//        ++num;
//    }

    //等于上面的锁操作
    public  void increase(){
        synchronized (this){
            ++num;
        }


    }

    public  long getNum(){
        return atomicInteger.get();
    }
}
