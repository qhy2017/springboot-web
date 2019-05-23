package com.example.demo.controller.model;

import java.util.Objects;

/**
 * @author quHongYuan
 */

public class Student extends Demo {

    private static final long serialVersionUID = -5273812941409595796L;
    private String uuid;

    private String name;

    private String sex;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(uuid, student.uuid) &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
