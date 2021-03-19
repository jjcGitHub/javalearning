package com.jjc.lj.demo.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: demo
 * @description: ${描述}
 * @author: Skipper
 * @create: 2021-03-17 10:08
 **/

public class CollectTest {

    public static void main(String[] args) {

        HashMap<Integer ,String> map = new HashMap<>();
        Integer b = 1;
        String bs = "aa";
        map.put(b,bs);
        map.put(b,bs);

        ConcurrentHashMap<Integer ,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(b,bs);
        concurrentHashMap.put(b,bs);


        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0;i< 10 ;++i){
            linkedList.add(i);
        }
        linkedList.get(6);

        System.out.println("打印 LinkedList");
        linkedList.forEach((t)->{
            System.out.println(t);
        });

        Vector<Integer> vector = new Vector<>();
        Integer a = 1;
        vector.add(a);
        vector.add(a);
        HashSet<String> integers = new HashSet<>();

        for (int i = 0;i< 10 ;++i){
            integers.add(i+"122adas");
        }
        System.out.println("打印 HashSet");
        integers.forEach((t)->{
            System.out.println(t);
        });
    }


}
