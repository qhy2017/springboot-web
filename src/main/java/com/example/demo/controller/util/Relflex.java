package com.example.demo.controller.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.model.Age;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Relflex<T> {

    public static<T>  List<T> getList(T obj){
        List<T> list = new ArrayList<T>();
        try {
            T o = (T) obj.getClass().newInstance();
            Class<?> aClass = o.getClass();
            Field[] fields = aClass.getDeclaredFields();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method item : declaredMethods){
                String name = item.getName();
            }
            //数组
            String[] filter = new String[12];
            //map
            Map<String,String> map = new HashMap<String,String>();
            map.put("serialVersionUID","serialVersionUID");
            for(Field item : fields){
                if(map.containsKey(item.getName())){
                    continue;
                }
                String name = item.getName();
                System.out.println(name.toUpperCase());
                item.setAccessible(true);
                item.set(o,"你好");
                item.get("");
            }
            list.add(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args){
//        String str = "write abc换个环境规划局";
//        System.out.println(stringToCapitalize(str));


            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i< 100;i++){
//                    String jsonString = Picturecontroller.getJsonString();
//                    System.out.println(Picturecontroller.unicodeTo2(jsonString));
//            String x = unicodeTo2(jsonString);
//            System.out.println(x);
                    String sdf = sdf(new Date(),"2018-02-03");
                    String dateString = getDateString(new Date(),"2017-02-06");
                        System.out.println(sdf+ "A-1-> yyyy-MM-dd");

                        System.out.println(dateString + "B-1-> yyyy-MM-dd HH:mm:ss");
                   }
                }

            }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i< 100;i++){
//                    String jsonString = Picturecontroller.getJsonString();
//                    System.out.println(Picturecontroller.unicodeTo2(jsonString));
//            String x = unicodeTo2(jsonString);
//            System.out.println(x);
                    String dateString = getDateString(new Date(),"2016-02-02");
                    String sdf = sdf(new Date(),"2015-03-05");
                    System.out.println(dateString +"B -2-> yyyy-MM-dd HH:mm:ss.SSS");
                    System.out.println(sdf + "A-2-> yyyy-MM-dd");
                }
            }

        }).start();
    }
 private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static  Object object = "lock";
    public static String getDateString(Date date,String str){
        synchronized (object){
        String format = sdf.format(date);
        try {
            System.out.println(sdf.parse(str) + "getDate");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
        }
    }
    public static String sdf(Date date,String str){
        synchronized (object) {
            String format = sdf.format(date);
            try {
                System.out.println(sdf.parse(str) + "sdf");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return format;
        }
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String stringToCapitalize(String str) {
        if (str == null) {
            throw new NullPointerException(" str is null");
        }
        if(StringUtils.isEmpty(str)){

            return null;
        }
        /**
         * 去除空格
         */
//        str = str.replaceAll("[\\s]+", "");
        StringBuffer a = new StringBuffer(str.length());
        int count = 0;
        while (count < str.length()) {
            if (count == 0) {
                a.append(String.valueOf(str.charAt(count)).toUpperCase());
            } else {
                a.append(str.charAt(count));
            }
            count++;
        }
        return a.toString();
    }
    public static void fanShe(){
        Age age = new Age("中国一个一个一个一个一个一个一个一个一个一个",2);
        Class<? extends Object> aClass = age.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        String[] str = new String[]{"sex","str","a","b","c","v","a","b","c","v","a","b","c","v","a","b","c","v"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        long l = System.currentTimeMillis();
        Map<String,Object> map = new HashMap<>();
        m:for(Method item : declaredMethods){
            if(!item.getName().startsWith("get")){
                continue m;
            }
            System.out.println();
            String attr = item.getName().replaceFirst("[get]+", "").toLowerCase();
            int i = Arrays.binarySearch(str, 0, str.length, attr);
            if(i >= 0){
                try {
                    map.put(attr,item.invoke(age,new Object[]{}));
                    System.out.println(item.invoke(age));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
              }
            }
            System.out.println(System.currentTimeMillis() -l);
        System.out.println(JSON.toJSONString(map));
        }

        public static String  demos(Object obj,String key){
            Object o = null;
            try {

                Field field = obj.getClass().getDeclaredField(key);
                field.setAccessible(true);
                try {
                     o = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return o == null ? "" : o.toString();
        }

        public static String getByKeyString(Object object,String str){
            if(str.length() == 0){
                str.toUpperCase();
            }else if(str.length() > 0){
               str = String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1));
            }

            char c = str.charAt(0);
            String.valueOf(c).concat(str.substring(1));
            Object invoke = null;
            try {
                Method declaredMethod = object.getClass().getDeclaredMethod("get".concat(str));
                try {
                     invoke = declaredMethod.invoke(object);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return invoke == null ? "" : invoke.toString();
        }

        public static String getAStr(String string){

        return "";
        }
}
