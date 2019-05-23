package com.example.demo.controller.lianxi;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Suanshu {
    public  static void main(String[] args){

        int width = 20;
        System.out.println(String.format("大家好 %1$,0"+width+"d", 999999999,"你好"));
//        System.out.println(toBinary(8));
//        listSort()
//        System.out.println(addPlus(15L));
//        System.out.println("a".compareTo("b"));

        /**
         * 初始化大小
         */

//        List<Demo> list = new ArrayList<>(12);
//        Demo demo = new Demo("张三丰","","",23);
//        demo.setAge(23);
//        demo.setBeginYear("张三丰");
//        list.add(demo);
//        Demo demo1 = new Demo("渠红元","","",15);
//        demo1.setAge(15);
//        demo1.setBeginYear("渠红元");
//        list.add(demo1);
//        Demo demo2 = new Demo("hello world","","",230);
//        demo2.setBeginYear("hello world");
//        demo2.setAge(100);
//        list.add(demo2);
//        Collections.sort(list,null);
//        for(Demo item : list){
//            System.out.println(item.toString());
//        }
//        System.out.println(factorial(10));

//        Map<String,String> map = new HashMap<>();
//        map.put("A","2");
//        map.put("B","1.5");
//        map.put("C","1");
//        map.put("D","0.5");
//        System.out.println(getIntegral("A,B,C",map));
//        BigInteger bg = new BigInteger("0");
////      Objects.requireNonNull(null,"空指针异常！！！");
//        List list = new ArrayList();
//        Calendar calendar = Calendar.getInstance();
//        Date time = calendar.getTime();
//        int i = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(i);
//        Object[] obj = {"日","一","二","三","四","五","六"};
//        DateFormat formatter = DateFormat.getDateTimeInstance();
//        try {
//            Date parse = formatter.parse("2019-01-01 12:12:01");
//            System.out.println(parse);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String format = formatter.format(time);
//        System.out.println("今天是" + format +"星期" + obj[i -1] + "，晴天");
//        String dateToStringYMD = parseDateToStringYMD(new Date(),null);
//        System.out.println(dateToStringYMD);
//        System.out.println(formatStringToDateYMD("20180405",null));
    }


    public static String getIntegral(String level, Map<String,String> integral){
        String var3 = "0";
        if("".equals(level) || level == null){
            return var3;
        }
        BigDecimal var1 = new BigDecimal(var3);
        BigDecimal var2;
        List<String> levels = Arrays.asList(level.split("[\\,\\，\\s]+"));
        for(String l : levels){
//            if(integral.containsKey(l)){
                var2 = new BigDecimal(integral.get(l));
                var1 = var1.add(var2);
//            }
        }
        var3 = var1.toString();
        return var3;
    }

    public static  String parseDateToStringYMD(Date date,@NotNull String patter){
        if(patter == null){
            patter = "yyyyMMdd";
        }
        String format;
        SimpleDateFormat sdf = new SimpleDateFormat(patter);
        format = sdf.format(date);
        return format;
    }

    public static String parseDateToStringY_S(Date date,@NotNull String patter){
        String format;
        SimpleDateFormat sdf = new SimpleDateFormat(patter);
        format = sdf.format(date);
        return format;
    }

    public static Date formatStringToDateYMD(String string,String reg){
        if(reg == null){
            reg = "yyyyMMdd";
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        try {
            date = sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * long类型阶乘
     * @param params
     * @return
     */
    public static long factorial(Long params){
        if(params == null){
            Objects.requireNonNull(params,"params is null");
        }
        if(params <= 1){
            return 1;
        }
        long var1 = params - 1;
        //recursive call 递归调用
        long var2 = factorial(var1) * params;
        return var2;
    }
    /**
     * 递归阶乘
     * @param params
     * @return
     */
    public static int factorial(Integer params){
        if(params == null){
            /**
             * 对象为空， 抛出异常
             */
            Objects.requireNonNull(params,"params is null");
        }
        if(params <= 1){
            return 1;
        }
        int var1 = params - 1;
        //recursive call 递归调用
        int var2 = factorial(var1) * params;
        return var2;
    }
    public static void listSort(){

        List<String> list = new ArrayList<String>();
        list.add("你你呀");list.add("你-呀");list.add("你你呀");
        list.add("中国你好--------------我不好");
        list.add("好好");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("a" +o1);
                System.out.println("b"+o2);
                if(o1.length() > o2.length()){
                    return  1;
                } else if(o1.length() < o2.length()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
         System.out.println(list.toString());
    }
    public static String toBinary(int num){
        String str = "";

        while(num != 0){
            str = num % 2 + str;
            num = num /2;
        }
        return str;
    }
}
