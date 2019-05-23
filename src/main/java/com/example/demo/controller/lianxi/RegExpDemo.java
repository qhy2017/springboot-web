package com.example.demo.controller.lianxi;


import com.example.demo.controller.model.Student;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.StringBuilderWriter;

import java.io.*;
import java.util.UUID;

public class RegExpDemo {
   static String txtUrl = "C:\\Users\\12423\\Desktop\\abc.txt";
    static String txtOutUrl = "C:\\Users\\12423\\Desktop\\abcd.txt";
    static Object lock = "lock";
    public static void main(String[] args){
//        strRegExp();
//        readTxt();
//        writeTxt();
//        readToWrite();
//        objectOut();
//        objectRead();
//        strDemo();


    }
    public static  void strDemo() {
        String str = new String("你好呀！我不好！！！");
        String str1 = new String("你好呀！我不好！！！");
        int i = str.codePointBefore(1);
        //比较两个字符串是否相等
        boolean b = str.regionMatches(1, str1, 1, str.length() - 2);
         StringBuilder sb = new StringBuilder(str);
         System.out.println(sb.reverse().toString());
        Boolean aFalse = Boolean.FALSE;
        System.out.println(String.valueOf(aFalse) instanceof  String);
        synchronized (lock){
            System.out.println("上锁");
        }
    }

    public static void objectRead(){
        try{

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(txtOutUrl)));
            Object o = ois.readObject();
            if(o instanceof Student){
             System.out.println(o.toString());
            }
            String oisStr = IOUtils.toString(ois);
            System.out.println(oisStr);

        }catch (Exception e){

        }

    }
    public static void objectOut(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(txtOutUrl)));
            Student s = new Student();
            s.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
            s.setName("渠红元");
            s.setSex("男");

            oos.writeObject(s);
            oos.flush();
            oos.close();

        }catch (Exception e){

        }

    }
    public static void readToWrite(){
        try{
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(txtUrl)));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(txtOutUrl)));
            StringBuilderWriter sbw = new StringBuilderWriter();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            InputStreamReader fr = new InputStreamReader(bis);
            //读取char
            BufferedReader br = new BufferedReader(new FileReader(new File(txtUrl)));
             //StringWriter
            StringWriter sw = new StringWriter(100);
            //PipedReader
            //PipedReader pr = new PipedReader();

//            String s = IOUtils.toString(bis);
//            System.out.println(s);
            long count = 0L;
            int n =0;
            char[] storage = new char[10];
            char[] carr = new char[10];
             while ((n = fr.read(storage)) != -1){
                 CharArrayReader car = new CharArrayReader(storage);
                 int read = car.read();
                 System.out.println(read);
                 sw.write(storage,0,n);
//                 sb.append(storage,0,n);
//                 System.out.println(sb1.append(String.copyValueOf(storage,0,n)));
             }
             System.out.println(sw.toString());
//            System.out.println(sb.toString());
//            System.out.println(sb1.toString());
           bis.close();
           bos.flush();
           bos.close();
        }catch (Exception e){

        }
    }
    public static void writeTxt(){
        BufferedOutputStream write = null;
        try{
              write = new BufferedOutputStream(new FileOutputStream(new File(txtUrl),true));
            int count = 0;
            while(count < 10000){
                count++;
              write.write("中国人民共和国".getBytes());
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if(write != null){
                try{
                    write.flush();
                    write.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void readTxt(){
        try {

            InputStream bis = new BufferedInputStream(new FileInputStream(new File(txtUrl)));
            byte[] storage = new byte[bis.available()];
            int len = 0;
            StringBuffer str = new StringBuffer();
            while((len = bis.read(storage)) != -1){
              System.out.println(new String(storage,0,len));
            }
            System.out.println(str);

        }catch (Exception e){

        }

    }

    public static void strRegExp(){
        String str = "（1）.今天是个，高兴的日子；";
        /**
         *
         *
         */
        String str1 = "（1）.今天是个，高兴的日子；";
        String reg = "^([\\(\\)\\（\\）\\d\\.])+|([\\;\\；\\,\\，\\.\\。])+$";
        String concat = str.replaceAll(reg, "").concat("。");
        System.out.println(concat);
    }

}
