package com.example.demo.com.example.demo.designmode.single;

public class SingleSynchronized {
    private static SingleSynchronized ourInstance = null;

    public static synchronized SingleSynchronized getInstance() {
        if(ourInstance == null){
            ourInstance = new SingleSynchronized();
        }
        return ourInstance;
    }

    private SingleSynchronized() {
    }
}
