package com.example.demo.dao;


public interface IDemo {

    default void setMessage(String message) {
    }


    default String getMessage() {
        String s = null;
        return s;
    }


    default void getMsg() {
    }

}
