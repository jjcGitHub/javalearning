package com.jjc.java.learn.bussness.designpattern.chain;

/**
 * @program: demo
 * @description: ${责任链模式}
 * @author: Skipper
 * @create: 2021-03-31 18:01
 **/

public class TestChain {

    public static void main(String[] args) {

        MyRequest myRequest = new MyRequest();
        myRequest.setName("Skipper");
        myRequest.setPhoneNum(123456789L);

        ChainNode obtainInfo = new   ObtainInfo(null);
        ChainNode login = new Login(obtainInfo);
        ChainNode inputPhone = new InputPhone(login);

        TaskChain taskChain = new TaskChain(inputPhone);
        taskChain.setMyRequest(myRequest);
        taskChain.processTaskChain();
    }
}


/**
 * 责任链中的一个责任节点
 */
abstract  class ChainNode{

    public ChainNode(ChainNode next) {
        this.next = next;
    }

    /**
     * 下一个责任节点
     */
    ChainNode next;

    /**
     * 处理
     * @param
     * @return true 则可以继续进行下一个
     */
    abstract boolean process(MyRequest  request);

}

/**
 * 责任链任务
 */
class TaskChain {

    ChainNode chainNode;

    MyRequest myRequest;

    public MyRequest getMyRequest() {
        return myRequest;
    }

    public void setMyRequest(MyRequest myRequest) {
        this.myRequest = myRequest;
    }

    public TaskChain(ChainNode chainNode) {
        this.chainNode = chainNode;
    }

    public  void processTaskChain(){
        if (chainNode != null && chainNode.process(myRequest)){
            chainNode = chainNode.next;
            //递归调用链
            processTaskChain();
        }else {
            return;
        }
    }

}


/**
 * 请求
 */
class  MyRequest {

    String name;
    boolean isPhoneOk ;
    boolean isLogin ;
    Long phoneNum ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPhoneOk() {
        return isPhoneOk;
    }

    public void setPhoneOk(boolean phoneOk) {
        isPhoneOk = phoneOk;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }
}


/**
 * 输入手机号
 */
class InputPhone extends ChainNode{

    /**
     *
     * @param next
     */
    public InputPhone(ChainNode next) {
        super(next);
    }

    @Override
    boolean process(MyRequest request) {

        if (request.getPhoneNum() > 0){
            System.out.println("检测手机号...........通过");
            request.setPhoneOk(true);
            return true;
        }else {
            System.out.println("检测手机号...........不通过");
            request.setPhoneOk(false);
            return false;
        }
    }
}

/**
 * 登录
 */
class Login extends ChainNode{

    public Login(ChainNode next) {
        super(next);
    }

    @Override
    boolean process(MyRequest myRequest) {
        if (myRequest.isPhoneOk){
            System.out.println( "用户 : " + myRequest.getName()+" 登录.....成功");
            myRequest.setLogin(true);
            return true;
        }else {
            System.out.println( "用户 : " + myRequest.getName()+" 登录.....失败");
            myRequest.setLogin(false);
            return false;
        }
    }
}

/**
 * 获取信息
 */
class ObtainInfo extends ChainNode {
    public ObtainInfo(ChainNode next) {
        super(next);
    }
    @Override
    boolean process(MyRequest myRequest) {
        if (myRequest.isLogin){
            System.out.println( "用户 : " + myRequest.getName()+" 获取信息.....");
            return true;
        }else {
            System.out.println( "用户 : " + myRequest.getName()+"未登录 ,不能 获取信息.....");
            return false;
        }

    }
}
