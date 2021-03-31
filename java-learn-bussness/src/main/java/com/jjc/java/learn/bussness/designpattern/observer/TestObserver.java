package com.jjc.java.learn.bussness.designpattern.observer;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @program: demo
 * @description: ${观察者模式}
 * @author: Skipper
 * @create: 2021-03-31 16:36
 **/

public class TestObserver {

    public static void main(String[] args) {

        ObserverGeneral observerGeneral = new ObserverGeneral();

        System.out.println("骑兵,步兵,弓箭手 待命  !!! ");

        MyObserver cavalryOs = new CavalryOs();
        MyObserver footMan = new FootMan();
        MyObserver archer = new Archer();


        String task1 = "全体命令 -> 今晚三更 进攻敌营 !!";
        observerGeneral.addObserver(cavalryOs);
        observerGeneral.addObserver(footMan);
        observerGeneral.addObserver(archer);
        observerGeneral.notify(task1);

        String task2 = "骑兵命令 -> 今晚二更 先去突袭 !!";

        //将步兵和弓箭手从通知者中移除
        observerGeneral.delObserver(footMan);
        observerGeneral.delObserver(archer);
        observerGeneral.notify(task2);

    }
}

/**
 * 将军
 */
class ObserverGeneral{


    List<MyObserver> observerList = new ArrayList<>();

    /**
     * 添加一个观察者
     * @param observer
     */
    public void addObserver( MyObserver observer){
        observerList.add(observer);
    }

    /**
     * 删除一个观察者
     * @param observer
     */
    public void delObserver( MyObserver observer ){
        observerList.remove(observer);
    }


    /**
     * 通知观察者
     * @param o
     */
    public void notify( Object o ){
        System.out.println("将军发布命令 : " + o.toString());
        for (MyObserver observer :observerList ){
            observer.update(o);
        }
    }

}

interface MyObserver{
    void update( Object o);
}


/**
 * 骑兵
 */
class CavalryOs implements  MyObserver{

    @Override
    public void update(Object o) {
        System.out.println("骑兵接受到了通知 : " + o.toString());
    }
}

/**
 * 步兵
 */
class FootMan implements  MyObserver{

    @Override
    public void update(Object o) {
        System.out.println("步兵接受到了通知 : " + o.toString());
    }
}

/**
 * 弓箭手
 */
class Archer implements  MyObserver{

    @Override
    public void update(Object o) {
        System.out.println("弓箭手接受到了通知 : " + o.toString());
    }
}

