package com.jjc.java.learn.bussness.designpattern.facade;

/**
 * @program: demo
 * @description: ${门面模式}
 * @author: Skipper
 * @create: 2021-04-08 17:15
 **/

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.excute();
    }


}

class Facade{

    System1 system1 = new System1();
    System2 system2 = new System2();
    System3 system3 = new System3();

    public void excute(){
        system1.excute();
        system2.excute();
        system3.excute();
    }
}

class System1{
    public void excute(){
        System.out.println("调用System1");
    }
}

class System2{
    public void excute(){
        System.out.println("调用System2");
    }
}

class System3{
    public void excute(){
        System.out.println("调用System3");
    }
}
