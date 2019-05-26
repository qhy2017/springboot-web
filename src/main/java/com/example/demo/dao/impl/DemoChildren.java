package com.example.demo.dao.impl;


public class DemoChildren extends Demo {
    @Override
    public void getMsg() {
        System.out.println("DemoChildren--->  " + getMessage());
    }
}
