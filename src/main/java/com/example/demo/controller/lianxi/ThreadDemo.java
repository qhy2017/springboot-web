package com.example.demo.controller.lianxi;

import com.zaxxer.hikari.util.UtilityElf;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class ThreadDemo {
    //定义变量
    //构造函数
    //方法
    private boolean fast = Boolean.FALSE;
    Object lock = "lock";
    public final String name="hello";
    public synchronized void showA(){
        try {
            Thread.sleep(3000);
            System.out.println("showA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void showB(){
        synchronized (lock){
            System.out.println("showB");
        }
    }

    public void showC(){
        if(fast){
            System.out.println(fast);
        }
        synchronized (lock){
            System.out.println("showC");
        }
    }

    public static void main(String[] args){
//        String a= "123";
//           Map<String,String> map = new HashMap<String,String>();
//        String s;
//        try {
////                   s = IOUtils.toString(new URL("http://www.sohu.com"));
//            s = IOUtils.toString(new URL("http://localhost:8080/getSession"));
//            System.out.println(JSONObject.parseObject(s).get("name"));
//            map.put("c",s);
//            System.out.println(JSONObject.parseObject(s.replaceAll("[\"]","'")).get("name"));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//          map.put("a",a);
//          map.put("b","qbc");
//
//             System.out.println(a);
//        final List<Student> list = Relflex.getList(new Student());
//        for (Student item : list){
//            System.out.println(item.toString());
//        };
        //复制数组
        //System.arraycopy();
//        String s2 = "中国你好呀！！！";
//        final byte[] bytes = s2.getBytes();
//        char[] s2c = new char[s2.length()];
//        s2.getChars(0,s2.length(),s2c,0);
//        String s2cs = new String(s2c,0,s2c.length);
//        System.out.println(s2cs);
//        List<String> list = new ArrayList<>();
//        list.add("你好呀");
//        Object[] objects = list.toArray();
//        list.contains("");
//        //转换字符串数组
//        String s1 = Arrays.toString(objects);
//        System.out.println(s1);
//        /**
//         * 判断数组是否相等
//         */
//        int[] aq = new int[]{1,2,3,4,5,6};
//        int[] aq1 = new int[]{1};
//        boolean equals = Arrays.equals(aq, aq1);
//        System.out.println(equals);
//        int hashCode = Arrays.hashCode(aq);
//        //复制数组
//        int[] ints = Arrays.copyOf(aq, 12);
//        int[] ints1 = Arrays.copyOfRange(aq, 2, 4);
//        Arrays.spliterator(aq).forEachRemaining((IntConsumer) value ->System.out.println(value + "jdk1.8新特性"));
//        /**
//         * fill 填充数组 值都为2
//         */
//        Arrays.fill(aq,2);
//        System.out.println(Arrays.toString(aq));
//        String s12 = "12";
//        String s123 = new String("12");
//        System.out.println(s12 == s123);
//        System.out.println(Objects.deepEquals(s12,s123));
//        /**
//         * Math
//         */
//        //取绝对值 大小判断 三木运算符 选择
//        int abs = Math.abs(-1);
//        System.out.println(abs);
//        double acos = Math.acos(45);
//        System.out.println(acos);
//        //两个数相加
//        int i = Math.addExact(1, 2);
//        Math.floorDiv(1,2);
//        int min = Math.min(1, 3);
//        int max = Math.max(2, 4);
//        Integer.min(1,2);
//        Integer decode = Integer.decode("12");
//        String property = System.getProperty("123");
//        Integer dhfhkah2323 = Integer.getInteger("name");
//        int reverse = Integer.reverse(12);
//        System.out.println(reverse);
//        //字符串反转
//        int abcd = 123456789;
//        String str = "1234";
//        StringBuilder sb = new StringBuilder(String.valueOf(abcd));
//        StringBuilder reverse1 = sb.reverse();
//        System.out.println(reverse1 instanceof StringBuilder);
//        System.out.println(Integer.valueOf(reverse1 != null ? "0": reverse1.toString()) instanceof  Integer);
//
//        String lineSeparatorWindows = IOUtils.LINE_SEPARATOR_WINDOWS;
//        URL url ;
//        InputStream inputStream = null;
//
//        try {
//            url = new URL("");
//            try {
//                IOUtils.toString(new URL(""));
//                URLConnection urlConnection = url.openConnection();
//                inputStream = urlConnection.getInputStream();
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                close(inputStream);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        String str123 = "ewre";
//        com.alibaba.fastjson.util.IOUtils.close(inputStream);
//        String s3 = "中国是哪呀！！！";
//        CharSequence a = "";
//        Number a12q = 12;
//        System.out.println(a12q instanceof Number);
//        char c = s3.charAt(0);
//        int aw = 0x7fffffff;
//        int aa = Integer.MIN_VALUE;
//        System.out.println(Integer.MAX_VALUE);
          threadDemo();
          List<String> list = new ArrayList<String>();
          list.add("admin");
          list.add("中国");

        //数组转list list 转数组
        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[list.size()]);
        Class<?> componentType = strings.getClass().getComponentType();
        System.out.println(componentType);
        System.out.println(Arrays.toString(strings));
        //char byte int String
        //String 校验
        System.out.println("你好 你好 你好 你好！！！");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key","中国");
        map.put("keyq","中国");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println(key + "hh" + value);
        }
        /**
         * 正则表达式
         */
        String reg = "^[\\w\\s]+|[a-zA-Z]+$";
        String str = "1234 asas ___124中华人民共和国hello";
       out.println(str.replaceAll(reg,""));
       String regg = "\\d\\d";
       String var2 = "12windows";
        /**
         * 判断是否存在校验规则的字符串
         */
        boolean matches = Pattern.matches("\\d", "12213ggytyyt");
        out.println(matches);

        /**
         * 获取组
         */
        Pattern compile = Pattern.compile(regg);
        Matcher matcher = compile.matcher(var2);
        while(matcher.find()){
          out.println(matcher.group(0));
        }
        String regex = "a*b";
        String input = "aabfooaabfooabfoobkkk";
        String s = input.replaceAll("a*b", "-");
        out.println(s);
    }
    public static void close(Closeable close){
        try {
            if(close != null){
                close.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getByIndexObjectString(Object[] obj, int index, boolean flag){
        //定义变量 使用变量
        String s;
        if(obj == null){
            throw new NullPointerException("obj is null");
        }
         s = obj[index] == null ? "" : obj[index].toString();
        return s;
    }
    public static void systemOut(){
        System.out.println(Integer.MAX_VALUE * 2 * 2 * 8989);
        System.out.println(Boolean.FALSE);
    }

    public static void getClassName(Object obj){
        Class<?> aClass = obj.getClass();
        String s = aClass.toString();
        //去掉开始处的空格
        String s1 = s.replaceFirst("^[a-z]+", "").trim();
        try{
            Class<?> aClass1 = Class.forName(s1);
        }catch (Exception e){

        }
        System.out.println(s1);
        System.out.println(aClass);


    }                   //ss

    public static void threadDemo(){

        //设置线程的名称 区分业务
        ThreadFactory namedThreadFactory = new UtilityElf.DefaultThreadFactory("demo",true);
        //四种线程池
        ExecutorService executorService = Executors.newCachedThreadPool(namedThreadFactory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
             System.out.println("多线程 哈哈 啊哈哈哈 ！！！");
            }
        });

        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        //创建线程池
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                134L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1024),namedThreadFactory, abortPolicy);
        //执行
        singleThreadPool.execute(()-> {System.out.println(Thread.currentThread().getName());
            while(true){
                //获取当前系统时间戳
                System.out.println(System.currentTimeMillis());
            }
        });
        //销毁
        singleThreadPool.shutdown();



        ThreadPoolExecutor th = new ThreadPoolExecutor(1,3,0, TimeUnit.DAYS,new LinkedBlockingQueue<>());
        ThreadDemo d = new ThreadDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.showA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d.showB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d.showC();
            }
        }).start();
    }



}
