package com.jjc.lj.demo.lock;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-16 11:27
 **/

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            for (int i = 0;i <1000000;++i){
                a.increase();
            }
        });
        t1.start();
        for (int i =0;i<1000000;++i){
            a.increase();
        }
        t1.join();
        long end  = System.currentTimeMillis();

        System.out.println(String.format("%sms",end - start));
        System.out.println(a.getNum());
    }
}
