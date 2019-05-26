package com.example.demo.dao.FactoryDemo.impl;

import com.example.demo.dao.FactoryDemo.IFactoryDemo;
import com.example.demo.dao.IDemo;
import com.example.demo.dao.impl.DemoChildren;

public class FactoryDemo implements IFactoryDemo {

    @Override
    public IDemo setMsg(String s) {
         IDemo idemo = null;
        if(true){
             idemo = new DemoChildren();
             idemo.setMessage("成功啦！！！ 高兴高兴".concat("参数-->").concat(s));
        }
        return idemo;
    }
}
