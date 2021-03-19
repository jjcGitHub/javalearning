package com.jjc.lj.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-12 16:42
 **/

public class ThreadPoolDemo {

    public static void main(String[] args) {

        /**
         *
         */

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        //自定义线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (10,20,0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));


        for (int i =0;i<100;++i){
            executor.execute(new myTask(i));
        }
    }
}

class myTask implements  Runnable {

    public myTask(int i) {
        this.i = i;
    }

    int i =0;
    @Override
    public void run() {
        System.out.println(i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
