package com.jjc.java.learn.bussness.jvm;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-04-08 10:17
 **/

public class JvmTest {

    public static void main(String[] args) {
        JvmTest jvmTest = new JvmTest();
        jvmTest.excute();
        System.out.println("aaaa");
    }

     private int excute(){
        int a =0;
        int b= 1;
        int c = (a+ b)*10;
        return c;
    }

}
