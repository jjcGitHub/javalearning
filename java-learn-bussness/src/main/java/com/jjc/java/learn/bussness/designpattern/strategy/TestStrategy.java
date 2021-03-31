package com.jjc.java.learn.bussness.designpattern.strategy;

/**
 * @program: demo
 * @description: ${策略模式}
 * @author: Skipper
 * @create: 2021-03-31 15:09
 **/

public class TestStrategy {

    public static void main(String[] args) {
        System.out.println("角色出生.........  ");
        Boy boy = new Boy();
        boy.attack();

        System.out.println("装备木棍");
        IAttack iAttack = new WoodenStick();
        boy.setiAttack(iAttack);
        boy.attack();


        System.out.println("装备枪");
        iAttack = new GunShoot();
        boy.setiAttack(iAttack);
        boy.attack();
    }




}

/**
 * 角色
 */
class Boy{

    /**
     * 初始化拳头
     */
    Boy(){
        this.setiAttack( new Punches() );
    }

    IAttack iAttack;


    public void setiAttack(IAttack iAttack) {
        this.iAttack = iAttack;
        System.out.println("当前武器  " + iAttack.name());
    }

    public void  attack(){

        System.out.println("进攻方式 : ");
        iAttack.attacking();
    }

}


/**
 * 武器和 进攻方式
 */
interface  IAttack{
    void attacking();

    String name();
}

/**
 * 拳头打
 */
class Punches implements   IAttack{

    @Override
    public String name() {
        return  "拳头";
    }

    @Override
    public void attacking() {
        System.out.println("揍");
    }
}

/**
 * 木棍打
 */
class WoodenStick implements IAttack{

    @Override
    public String name() {
       return  "木棍";
    }


    @Override
    public void attacking() {
        System.out.println("抡");
    }
}

/**
 * 枪
 */
class GunShoot implements  IAttack{

    @Override
    public String name() {
        return  "枪";
    }

    @Override
    public void attacking() {
        System.out.println("射击");
    }
}
