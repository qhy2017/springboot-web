package com.example.demo.dao;

import com.example.demo.dao.FactoryDemo.impl.FactoryDemo;

/**
 * 测试类
 */
public class DemoTest {

    private final int ignoreCount;



    public DemoTest(int ignoreCount) {
        this.ignoreCount = ignoreCount;
    }

    public int getIgnoreCount() {
        return ignoreCount;
    }

    public static void main(String[] s){

        System.out.println(new DemoTest(23).getIgnoreCount());
        FactoryDemo factoryDemo = new FactoryDemo();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    IDemo demo = factoryDemo.setMsg("1");
//                    IDemo iDemo = factoryDemo.setMsg("2");
//                    demo.getMsg();
//                    iDemo.getMsg();
//                }
//
//            }
//        }).start();


    }
}
