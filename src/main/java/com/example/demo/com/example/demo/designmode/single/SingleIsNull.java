package com.example.demo.com.example.demo.designmode.single;

/**
 * 懒汉式
 */
public class SingleIsNull {
    private static SingleIsNull ourInstance = new SingleIsNull();

    public static synchronized SingleIsNull getInstance() {
         return ourInstance;
    }
    private SingleIsNull() {
    }
}
