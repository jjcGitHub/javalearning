package com.jjc.lj.demo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-12 15:12
 **/

public class ThreadTest extends  Thread {


    private String name;

    public ThreadTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * start 方法会 在主线程创建一个子线程
         * run 方法不会创建子线程
//         */
//
//        //new ThreadTest("thread_1").run();
//        new ThreadTest("thread_2").start();

        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();

        //由于频繁创建线程,并且切换线程是需要消耗资源的,导致性能下降
        for(int i =0;i<100000 ; ++i){
            Thread thread = new Thread(){

                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        Long end = System.currentTimeMillis();

        System.out.println("消耗时间 : "+(end - start));
        System.out.println("size  : "+list.size());

    }
}
