package com.jjc.java.learn.bussness.designpattern.decorated;

/**
 * @program: demo
 * @description: ${装饰着模式}
 * @author: Skipper
 * @create: 2021-03-26 14:49
 **/

public class TestDecoratted {

    public static void main(String[] args) {
        Phone phone = new Phone();

        //先在原相机基础上添加美颜效果 再在美颜相机基础上添加滤镜效果
        IPicture picture = new FilterPhone(new BeautyPhone(phone))   ;
        picture.takePicture();
    }
}

/**
 * 拍照功能
 */
interface IPicture{
    void takePicture();
}

/**
 * 原生相机
 */
class Phone implements IPicture{
    @Override
    public void takePicture() {
        System.out.println("照相");
    }
}

/**
 * 添加美颜效果
 */
class BeautyPhone implements IPicture{

    IPicture iPicture;

    public BeautyPhone(IPicture iPicture) {
        this.iPicture = iPicture;
    }

    @Override
    public void takePicture() {
        iPicture.takePicture();
        System.out.println("添加美颜效果");
    }
}

/**
 * 添加滤镜效果
 */
class FilterPhone implements IPicture{

    IPicture iPicture;

    public FilterPhone(IPicture iPicture) {
        this.iPicture = iPicture;
    }

    @Override
    public void takePicture() {
        iPicture.takePicture();
        System.out.println("添加滤镜效果");
    }
}

