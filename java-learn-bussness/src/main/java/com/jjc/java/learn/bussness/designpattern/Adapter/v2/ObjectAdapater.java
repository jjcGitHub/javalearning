package com.jjc.java.learn.bussness.designpattern.Adapter.v2;

/**
 * @program: demo
 * @description: ${适配器模式 - 对象适配器模式}
 * @author: Skipper
 * @create: 2021-03-26 11:29
 **/

/**
 * 比如 家庭电压是 220V  电脑电压是5v
 * 电脑电源就是一个适配器,需要将 家庭220v 电压转成 自己能用的 5v电压
 */



public class ObjectAdapater {


    public static void main(String[] args) {

        Voltage220V v = new Voltage220V();
        IAdapater adapater5v = new PhoneV( v);
        adapater5v.outputV();

        IAdapater adapater20v = new ComputerV( v);
        adapater20v.outputV();
    }
}

/**
 * 家庭电压220v
 */
class Voltage220V{

    int output220V(){
        return 220;
    }
}

interface  IAdapater{
    /**
     * 输出5v
     * @return
     */
    int outputV();
}


//电脑电压5v
class ComputerV implements IAdapater{

    Voltage220V voltage220V;


    public ComputerV(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int outputV() {

        int v= voltage220V.output220V();
        //......一些列转换得到5
        System.out.println(String.format("家庭 电压 %d ->  电脑电压 %d " ,v,trans(v)));
        return 5;
    }

    private int  trans(int v){
        System.out.println(v + " v电压 经过一些列转换操作.......");
        return 5;
    }
}


/**
 * 手机充电电压 6V
 */
class PhoneV implements IAdapater{

    Voltage220V voltage220V;


    public PhoneV(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int outputV() {

        int v= voltage220V.output220V();
        //......一些列转换得到5
        System.out.println(String.format("家庭 电压 %d ->  手机充电电压 %d " ,v,trans(v)));
        return v;
    }

    private int  trans(int v){
        System.out.println(v + " v电压 经过一些列转换操作.......");
        return 6;
    }
}




