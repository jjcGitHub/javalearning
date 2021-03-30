package com.jjc.java.learn.bussness.designpattern.Adapter.v1;

/**
 * @program: demo
 * @description: ${适配器模式- 类适配器}
 * @author: Skipper
 * @create: 2021-03-26 13:43
 **/

public class ClassAdapater {

    public static void main(String[] args) {


        IAdapatee adapater5v = new ComputerV();
        adapater5v.outputV();

        IAdapatee adapater20v = new PhoneV();
        adapater20v.outputV();
    }
}

interface  IAdapatee{
    /**
     * 输出5v
     * @return
     */
    int outputV();
}


/**
 * 家庭电压220v
 */
class Voltagee220V{

    int output220V(){
        return 220;
    }
}

//电脑电压5v
class ComputerV   extends  Voltagee220V implements IAdapatee{



    @Override
    public int outputV() {

        int v= output220V();
        //......一些列转换得到5
        System.out.println(String.format("家庭 电压 %d ->  电脑电压 %d " ,v,trans(v)));
        return v;
    }

    private int  trans(int v){
        System.out.println(v + " v电压 经过一些列转换.......");
        return 5;
    }
}


/**
 * 手机电压电压
 */
class PhoneV   extends  Voltagee220V implements IAdapatee{


    @Override
    public int outputV() {

        int v= output220V();
        //......一些列转换得到5
        System.out.println(String.format("家庭 电压 %d ->  手机电压 %d " ,v,trans(v)));
        return v;
    }

    private int  trans(int v){
        System.out.println(v + " v电压 经过一些列转换.......");
        return 6;
    }
}



