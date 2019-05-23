package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.HttpSessionConfig;
import com.example.demo.controller.model.Age;
import com.example.demo.controller.model.IndexColors;
import com.example.demo.model.Ttest;
import com.example.demo.model.TtestExample;
import com.example.demo.service.mapper.TtestMapper;
import org.apache.commons.fileupload.FileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class HelloController {

    @Autowired
    private TtestMapper ttestMapper;

    @ResponseBody
    @RequestMapping("/test")
    public String getJSON() {
        TtestExample example = new TtestExample();
        TtestExample.Criteria criteria = example.createCriteria();
        Integer[] ints = {1, 2};
        List<Integer> integers = Arrays.asList(ints);
        TtestExample.Criteria abc = criteria.andAddressLike("你好");
        abc.andIdIn(integers);
        List<Ttest> ttests = ttestMapper.selectByExample(example);
        return JSON.toJSONString(ttests);
    }

    @RequestMapping("login")
    public void set(HttpServletRequest request, String name) {
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("id", "123");
        session.setAttribute("name", json);

    }

    @RequestMapping("hello")
    public Object hello(HttpServletRequest request) {
        System.out.println("123");
//		re.setAttribute("hello", "hello world");
        ModelAndView model = new ModelAndView();
        model.addObject("session", new HttpSessionConfig().getActiveSessions());
        /**
         * 返回字符串
         */
        model.addObject("hello", "我是渠红元");
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("是我的家乡，生在这，死在这");
        list.add("pink 是什么颜色 粉红色");
        /**
         * 返回集合
         */
        model.addObject("list", list);

        List<Map<String, String>> map = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Map m = new HashMap<String, String>();
            m.put("id", i);
            m.put("name", "编号" + i);
            map.add(m);
        }
        model.addObject("map", map);


        /**
         * 返回视图名称
         */
        model.setViewName("hello");
        return model;
    }

    @RequestMapping("bootstrap")
    public String bootstatp_jsp() {

        return "bootstrap_jsp";
    }

    @RequestMapping("getSession")
    @ResponseBody
    public String getSession(HttpServletRequest request, String sessionId) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("name", "渠红元");
        jsonObject.put("sex", "渠红元");
//		return JSON.toJSONString( new HttpSessionConfig().getActiveSessions().get(sessionId).getAttribute("name"));
        return jsonObject.toJSONString();
    }

    @RequestMapping("MultipartFile")
    public void uploadExcel(MultipartFile file, HttpServletResponse response) {

    }

    @RequestMapping("FileUpload")
    public void uploadExcel(FileUpload file, HttpServletResponse response) {

    }

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws Exception{
            response.setHeader("Content-disposition", "attachment; filename=" + System.currentTimeMillis() + new String("你好".getBytes("UTF-8"), "ISO8859-1") + ".xls");
            response.setContentType("application/msexcel;charset=utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            this.Workbook().write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
            outputStream.flush();
    }

    /**
     * 获得workbook对象
     *
     * @return
     */
    public Workbook Workbook() {
        List<Age> age = new ArrayList<Age>();
        Age age1 = new Age("012", 23);
        age.add(age1);
        JSONArray ages = JSONArray.parseArray(JSON.toJSONString(age));
        String[][] title = new String[][]{{"uuid", "2", "主键"}, {"str", "3", "姓名"}, {"sex", "2", "年龄"}};
        Workbook book;
        book = new HSSFWorkbook();
        /**
         * 设置单元格样式
         */
        CellStyle[] cellStyle = getCellStyle(book);
        int count = 0;
        Sheet sheet = book.createSheet();
        Row row = null;
        if (!ages.isEmpty()) {
            for (int j = 0; j < ages.size(); j++) {
                if (count == 6000 || count == 0) {
                    if (count != 0) {
                        sheet = book.createSheet();
                    }
                    setRowTitle(sheet, row, title, cellStyle[0]);
                    count = 2;
                }
                setRowBody(sheet, row, title, cellStyle[1], count, j, ages);
                count++;
            }
        } else {
            setRowTitle(sheet, row, title, cellStyle[0]);
        }
        try {
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    /**
     * 设置表头
     *
     * @param sheet
     * @param row
     * @param title
     * @param cellStyle
     */
    public void setRowTitle(Sheet sheet, Row row, String[][] title, CellStyle cellStyle) {

        row = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            Cell cellq = row.createCell(i);
            if(i==0){
                cellq.setCellValue("学生表");
            }
            cellq.setCellStyle(cellStyle);
        }

        /**
         * 合并表头
         */
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, title.length - 1));
        row = sheet.createRow(1);

        for (int i = 0; i < title.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(title[i][2]);
            cell.setCellStyle(cellStyle);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * Integer.valueOf(title[i][1]));
        }
    }

    /**
     * 填充数据
     *
     * @param sheet
     * @param row
     * @param title
     * @param cellStyle
     * @param count
     * @param j
     * @param ages
     */
    public void setRowBody(Sheet sheet, Row row, String[][] title, CellStyle cellStyle, int count, int j, JSONArray ages) {
        JSONObject obj = ages.getJSONObject(j);
        row = sheet.createRow(count);
        for (int k = 0; k < title.length; k++) {
            Cell cell = row.createCell(k);
            cell.setCellValue(obj.getString(title[k][0]));
            cell.setCellStyle(cellStyle);
        }
    }

    public CellStyle[] getCellStyle(Workbook book) {
        CellStyle[] arr = new CellStyle[2];
        Font font = book.createFont();
        font.setBold(true);
        CellStyle cellStyleT = book.createCellStyle();
        CellStyle cellStyleB = book.createCellStyle();
        cellStyleT.setFont(font);
        cellStyleT.setAlignment(HorizontalAlignment.CENTER);
        cellStyleT.setBorderTop(BorderStyle.THIN);
        cellStyleT.setBorderBottom(BorderStyle.THIN);
        cellStyleT.setBorderLeft(BorderStyle.THIN);
        cellStyleT.setBorderRight(BorderStyle.THIN);
        cellStyleT.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyleB.setFont(font);
        cellStyleB.setAlignment(HorizontalAlignment.CENTER);
        cellStyleB.setBorderTop(BorderStyle.THIN);
        cellStyleB.setBorderBottom(BorderStyle.THIN);
        cellStyleB.setBorderLeft(BorderStyle.THIN);
        cellStyleB.setBorderRight(BorderStyle.THIN);
        cellStyleB.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setFillForegroundColor(IndexedColors.BLACK.getIndex());//黑色
//        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());//白色
//        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());//红色
//        cellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());//蓝色
//        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());//黄色
//        cellStyle.setFillForegroundColor(IndexedColors.PINK.getIndex());//粉色
        cellStyleT.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BLACK.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.PINK.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.MAROON.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.TAN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.DARK_TEAL.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.OLIVE_GREEN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.BROWN.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.PLUM.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
//        cellStyle.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
        arr[0] = cellStyleT;
        arr[1] = cellStyleB;
        return arr;
    }

    public Workbook getNewBook() {
        /**
         * 工作部需要title 每列宽度 单元格样式
         * 业务逻辑 所需条件  数据量小于6000条
         */

        return null;
    }

    public static void main(String[] args) {
       /* try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\color.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line.replaceFirst("[\\(\\)\\d\\,\\;]+$", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
      System.out.println(IndexColors.AQUA.getIndex());
//        System.out.println(IndexedColors.fromInt(IndexedColors.TURQUOISE.getIndex()));
        /**
         * 定义数组
         * 获得数组
         */
        System.out.println(IndexColors.fromInt(IndexColors.RED.getIndex()));
        System.out.println(IndexColors.RED instanceof IndexColors);
    }



}
