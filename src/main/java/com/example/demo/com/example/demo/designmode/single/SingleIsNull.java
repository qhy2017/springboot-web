package com.example.demo.com.example.demo.designmode.single;

/**
 * 懒汉式
 */
public class SingleIsNull {
    private static final SingleIsNull ourInstance = null;

    public static SingleIsNull getInstance() {
        if(ourInstance == null){
            ourInstance = new SingleIsNull();
        }
        return ourInstance;
    }
    private SingleIsNull() {
    }
}
