package com.jjc.java.learn.bussness.designpattern.build;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: ${建造者模式}
 * @author: Skipper
 * @create: 2021-04-02 18:22
 **/

public class BuildTest {
    public static void main(String[] args) {
        MysqlCommand command = MysqlCommand.build("aa","table")
                .andEquals("id","1")
                .andEquals("user_id","2")
                .andNotEquals("m","1");
        command.insert();
    }

}


class MysqlCommand{

    String dbName;
    String tableName;

    public  static  MysqlCommand build(String dbName, String tableName ){
        System.out.println("连接数据库 : " +dbName );
        return new MysqlCommand(dbName,tableName);
    }

    public MysqlCommand(String dbName, String tableName) {
        this.dbName = dbName;
        this.tableName = tableName;
    }



    private Map<String,String> equalsMap = new HashMap<>();

    private  Map<String,String> notEqualsMap =new HashMap<>();

    public MysqlCommand andEquals(String key, String value){

        equalsMap.put(key,value);
        return this;
    }

    public MysqlCommand andNotEquals(String key, String value){
        notEqualsMap.put(key,value);
        return this;
    }

    public void insert(){
        System.out.println("执行 insert 命令");
        excute("instert into " + tableName);

    }
    private void excute(String sql){
        System.out.println(sql);
        System.out.println("相当条件 :" +sqlEqCondition())  ;
        System.out.println("不相等条件 :" +sqlNotEqCondition());
    }

    String sqlEqCondition(){
        String cdt = "";
        for (Map.Entry<String, String> entry : equalsMap.entrySet()) {
            cdt += entry.getKey() + " = " +  entry.getValue() + " , ";
        }
        return cdt;
    }

    String sqlNotEqCondition(){
        String cdt = "";
        for (Map.Entry<String, String> entry : notEqualsMap.entrySet()) {
            cdt += entry.getKey() + " != " +  entry.getValue() + " , ";
        }
        return cdt;
    }

}

