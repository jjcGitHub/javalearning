package com.jjc.java.learn.bussness.designpattern.factory;

/**
 * @program: demo
 * @description: ${工厂模式}
 * @author: Skipper
 * @create: 2021-04-01 16:45
 **/

public class FactoryTest {

    public static void main(String[] args) {

        IObjectFactory iObjectFactory = new Product_1Creater();
        iObjectFactory.create();

        iObjectFactory = new Product_2Creater();
        iObjectFactory.create();

    }
}


interface IObjectFactory{

    /**
     * 统一创建对象接口
     * @return
     */
    Object create();

}

/**
 * 产品1
 */
class Product_1{
    Product_1(){
        System.out.println("Product_1 创建了!!!");
    }
}

/**
 * 产品2
 */
class Product_2{
    Product_2(){
        System.out.println("Product_2 创建了!!!");
    }

}


class Product_1Creater implements IObjectFactory{

    @Override
    public Object create() {
        return new Product_1();
    }
}


class Product_2Creater implements IObjectFactory{

    @Override
    public Object create() {
        return new Product_2();
    }
}

