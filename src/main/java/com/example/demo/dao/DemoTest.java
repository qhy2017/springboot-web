package com.example.demo.dao;

import com.example.demo.dao.FactoryDemo.impl.FactoryDemo;

/**
 * 测试类
 */
public class DemoTest {

    public static void main(String[] s){

        FactoryDemo factoryDemo = new FactoryDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    IDemo demo = factoryDemo.setMsg("1");
                    IDemo iDemo = factoryDemo.setMsg("2");
                    demo.getMsg();
                    iDemo.getMsg();
                }

            }
        }).start();


    }
}
