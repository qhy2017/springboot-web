package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.controller.model.Age;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JxlExcelController {
    @CrossOrigin(origins = {"*"})
    @RequestMapping("jxl2007")
    public void getExcel2007(HttpServletResponse response,HttpServletRequest request) throws Exception {
                    System.out.println(request.getParameter("name"));
                    response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("key","中国");
        writer.write(json.toJSONString());
    }
//    @CrossOrigin(origins={"*"})
    @RequestMapping("jxl")
    public void getExcel(HttpServletResponse response, HttpServletRequest request){
        System.out.println(request.getParameter("type"));
        /**
         * 下载设置头信息 文本类型
         */
        try {
            String s;
            /**
             * 具体设置看 前台页面字符集
             */
            s = URLEncoder.encode("你好","utf-8") ;
            response.setHeader("Content-disposition", "attachment; filename=" + System.currentTimeMillis() +  s + ".xls");
            response.setHeader("Connection", "close");
            response.setContentType("application/msexcel;charset=GBK");
            File file = new File("abc.xls");
            try {
                getFile(file);
                FileInputStream fileInputStream = new FileInputStream(file);
                file.delete();
                ServletOutputStream outputStream = null;
                try {
                    outputStream = response.getOutputStream();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                int length = (int)file.length();
                byte[] b = new byte[1024];
                int len = 0;
                try {
                    while ((len = fileInputStream.read(b)) != -1){
                        bufferedOutputStream.write(b,0,len);
                    }
                    fileInputStream.close();
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void getFile(File file){
        Object[][] title = new Object[][]{{"uuid",20,"主键"},{"str",30,"姓名"},{"sex",50,"性别"}};
        List<Age> list = new ArrayList<Age>();
        Age age = new Age("你好",12);
        list.add(age);
        list.size();
        JSONArray objects = JSONObject.parseArray(JSON.toJSONString(list));
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("测试", 1);
            for(int c = 0; c < title.length;++c){
                sheet.setColumnView(c,Integer.valueOf(title[c][1].toString()));
            }
            int count = 0;
            int sheets = 1;
            for(int i = 0; i < list.size();i++){
                if(count == 6000 || count == 0){
                    if(count != 0) {
                        ++sheets;
                        sheet = workbook.createSheet("测试", sheets);
                        count = 2;
                        for(int c = 0; c < title.length;++c){
                            sheet.setColumnView(c,Integer.valueOf(title[c][1].toString()));
                        }
                    }
                    /**
                     * 设置表头 合并单元格
                     */
                    sheet.mergeCells(0,0,2,0);
                    sheet.addCell(new Label(0,0,"测试",getTitleStyle()));
                    for(int j = 0;j < title.length;++j){
                       sheet.addCell(new Label(j,1,title[j][2].toString(),getTitleStyle()));
                   }
                }
            }
        workbook.write();workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WritableCellFormat getTitleStyle(){
       WritableCellFormat format = new WritableCellFormat();
        try {
            //居中 设置背景 设置边框
            format.setAlignment(Alignment.CENTRE);
            format.setBackground(Colour.ICE_BLUE);
            format.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableFont fontTitle = new WritableFont(WritableFont.createFont("微软雅黑"), 16,WritableFont.BOLD);
            format.setFont(fontTitle);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    public WritableCellFormat getBodyCentreStyle(){
        WritableCellFormat format = new WritableCellFormat();
        try {
            //居中 设置背景 设置边框
            format.setAlignment(Alignment.CENTRE);
            format.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableFont fontBody = new WritableFont(WritableFont.createFont("楷体 _GB2312"), 12, WritableFont.NO_BOLD);
            format.setFont(fontBody);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    public WritableCellFormat getBodyLeftStyle(){
        WritableCellFormat format = new WritableCellFormat();
        try {
            //居中 设置背景 设置边框
            format.setAlignment(Alignment.LEFT);
            format.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableFont fontBody = new WritableFont(WritableFont.createFont("楷体 _GB2312"), 12, WritableFont.NO_BOLD);
            format.setFont(fontBody);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    public WritableCellFormat getBodyRightStyle(){
        WritableCellFormat format = new WritableCellFormat();
        try {
            //居中 设置背景 设置边框
            format.setAlignment(Alignment.RIGHT);
            format.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableFont fontBody = new WritableFont(WritableFont.createFont("楷体 _GB2312"), 12, WritableFont.NO_BOLD);
            format.setFont(fontBody);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }
}
