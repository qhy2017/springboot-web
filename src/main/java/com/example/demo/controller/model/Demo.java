package com.example.demo.controller.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author quHongyuan
 * Comparable<T> 用于对象
 * Comparator<T> 用于sort（）第二个参数
 */
public class Demo implements Serializable, Comparable<Demo> {
    private static final long serialVersionUID = 1145394000583923125L;

    /**
     * 开始年度
     */
    private String beginYear;

    /**
     * 结束年度
     */
    private String endYear;

    /**
     * 时间戳
     */
    private String longTime;
    /**
     * 年龄
     */
    private int age;

    public Demo() {
    }

    public Demo(String beginYear, String endYear, String longTime, int age) {
        this.beginYear = beginYear;
        this.endYear = endYear;
        this.longTime = longTime;
        this.age = age;
    }

    public String getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(String beginYear) {
        this.beginYear = beginYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Demo{" +
                "beginYear='" + beginYear + '\'' +
                ", endYear='" + endYear + '\'' +
                ", longTime='" + longTime + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        /**
         * if 正规写法
         * if(condition){
         *     todo
         * }
         */
        if (this == o) {return true;}
        if (!(o instanceof Demo)) {return false;}
        Demo demo = (Demo) o;
        /**
         *int long boolean
         */
        return String.valueOf(getAge()).equals(demo.getAge()+ "")   &&
                Objects.equals(getBeginYear(), demo.getBeginYear()) &&
                Objects.equals(getEndYear(), demo.getEndYear()) &&
                Objects.equals(getLongTime(), demo.getLongTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBeginYear(), getEndYear(), getLongTime(), getAge());
    }

    @Override
    public int compareTo(Demo o) {
        /**
         * 按年龄排序
         */
        if(age > o.getAge()){
            return 1;
        } else if(age < o.getAge()){
            return -1;
        }else {
            /**
             * 如果等于0 ，可以按第二个条件排序
             */
            return 0;
        }
    }

}
