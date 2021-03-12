package com.jjc.lj.demo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-12 15:35
 **/

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i =0;i<100000 ; ++i){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        Long end = System.currentTimeMillis();

        System.out.println("消耗时间 : "+(end - start));
        System.out.println("size  : "+list.size());

    }

}
