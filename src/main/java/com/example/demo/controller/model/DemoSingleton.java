package com.example.demo.controller.model;

public class DemoSingleton {
    private static DemoSingleton ourInstance = new DemoSingleton();

    public static DemoSingleton getInstance() {
        return ourInstance;
    }

    private DemoSingleton() {
    }
}
