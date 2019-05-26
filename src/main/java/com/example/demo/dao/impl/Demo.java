package com.example.demo.dao.impl;

import com.example.demo.dao.IDemo;

public abstract class Demo implements IDemo {

    private String message;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
