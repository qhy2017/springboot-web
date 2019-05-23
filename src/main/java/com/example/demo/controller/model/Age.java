package com.example.demo.controller.model;

public class Age {
    private String uuid;
    private String str;

    private int sex;

    public Age(String str, int sex) {
        this.str = str;
        this.sex = sex;
    }
    public Age(int i){
        this("渠",i);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Age{" +
                "str='" + str + '\'' +
                ", sex=" + sex +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
