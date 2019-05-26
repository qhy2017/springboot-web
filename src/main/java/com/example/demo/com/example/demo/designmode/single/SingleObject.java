package com.example.demo.com.example.demo.designmode.single;

/**
 * 饿汉式
 */
public class SingleObject {
    private String name;
    private static SingleObject ourInstance = null;

    public static synchronized SingleObject getInstance() {

        if(ourInstance == null){
            ourInstance = new SingleObject();
            ourInstance.setName("hello world");
        }
        return ourInstance;

    }

    private SingleObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args){
        SingleObject instance = SingleObject.getInstance();
        System.out.println(instance.getName());
        SingleObject instance1 = SingleObject.getInstance();
        System.out.println(instance1.getName());
    }
}
