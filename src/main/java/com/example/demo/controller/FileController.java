package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Controller
public class FileController {
    @RequestMapping("getFile")
    @ResponseBody
    public  void getFile(HttpServletResponse response, HttpServletRequest request)throws Exception{
        String s;
        /**
         * 具体设置看 前台页面字符集
         */
       s = URLEncoder.encode("你好","UTF-8") ;
        String s1 = new String("你好呀".getBytes("UTF-8"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + System.currentTimeMillis() +  s1 + ".txt");
        response.setHeader("Connection", "close");
        response.setContentType("application/txt");
        OutputStream os = response.getOutputStream();
        FileInputStream f = new FileInputStream(new File("C:\\Users\\12423\\Desktop\\abc.txt"));
        FileChannel channel = f.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //读取下载
        int read = 0;
        byte[] arr;
        StringBuffer sb = new StringBuffer();
        while((read = channel.read(bb)) != -1){
            // 从输入通道中将数据读到缓冲区
            bb.flip();
            arr = new byte[read];
            bb.get(arr);
            sb.append(new String(arr,0,read));
            ///byte[] array = bb.array();
            os.write(arr);
            // clear方法重设缓冲区，使它可以接受读入的数据
            bb.clear();
        }
        System.out.println(sb.toString());
        channel.close();
        os.flush();
    }
}
