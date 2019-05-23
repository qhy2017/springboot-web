package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Picturecontroller {
    private final static String FILEURL = "D:\\picture-demo\\71X58PICNjx_1024.jpg";

    private final static int CACHE_SIZE = 1024;

    private static Object object = "lock";

    private static String tempStr;

    /**
     * 下载图片
     * @param response
     */
    @RequestMapping("down-png")
    public void download(HttpServletResponse response) throws Exception {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        final File file = new File(FILEURL);
        String name = file.getName();
        String reg = "^[^\\.]+";
        /**
         * 截取文件后缀
         */
        String s = name.replaceFirst(reg, "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = sdf.format(new Date());
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=".concat(format).concat(s));
        bis = new BufferedInputStream(new FileInputStream(file));
        bos = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        int size = 0;
        byte[] b = null;
        b = new byte[256];
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
            size += len;
        }
        bos.flush();
        close(bos);
        close(bis);
    }

    public static void close(Closeable io) {
        try {
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final static Pattern PATTERN = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static void main(String[] args) throws Exception {
//    String a = "eyrif737439hdnvnckfg%tF %tT中国.xls";
//    String reg = "^[^\\.]+";
//    System.out.println(a.replaceFirst(reg, ""));
//    String format = String.format(a, new Date(), new Date());
//    System.out.println(format);
//    System.out.println(String.format("%1$ ,010d%n", 1223131232, 222));
//    int i = Integer.parseInt("6360", 16);
//    System.out.println(String.valueOf((char) i));

        // String ss = "\\{ userId:12363324,collegeName:\u8BA1\u7B97\u673A\u5B66\u9662, className:\u8F6F\u4EF6\u4E00\u73ED}";

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
//        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumIntegerDigits(11);
        numberFormat.setMinimumIntegerDigits(6);
        String format = numberFormat.format(123);
        System.out.println(format);

        NumberFormat instance = ChoiceFormat.getInstance();
        ResourceBundle bundle = PropertyResourceBundle.getBundle("");
        NumberFormat instance1 = DecimalFormat.getInstance();

    }
    public static String setIdNf(String type, int idKey) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        Integer lh = null;
        Integer computKey = null;
        String idkeyStr = String.valueOf(idKey);
        int idkSize = idkeyStr.length();
        if (idkSize <= 8 && idKey < 99999999) {
            lh = 8;
            computKey = idKey + 1;
        } else if (idkSize <= 8 && idKey == 99999999) {
            computKey = idKey + 1;
            String valueOf = String.valueOf(computKey);
            lh = valueOf.length();
        } else {
            computKey = idKey + 1;
            String valueOf = String.valueOf(computKey);
            lh = valueOf.length();
        }
        nf.setMaximumIntegerDigits(11);
        nf.setMinimumIntegerDigits(lh);
        return type + nf.format(computKey);
    }
    public static String unicodeTo2(String string) {
        StringBuffer sb = new StringBuffer();
        synchronized (object) {
            String temp;
            for (int i = 0; i < string.length(); i++) {
                temp = string.substring(i);
                if (isU(temp)) {
                    sb.append(revert(tempStr));
                    i += 5;
                } else {
                    temp = String.valueOf(string.charAt(i));
                    sb.append(temp);
                }
            }
        }
        return sb.toString();
    }

    private static boolean isU(String string) {
        int var0 = 0;
        int var6 = 6;
        String varReg = "\\u";
        if (string == null || string.length() == var0 || !string.startsWith(varReg) || string.length() < var6) {
            return false;
        }
        tempStr = string.substring(0, 6);
        boolean flag = Pattern.matches("\\\\u[0-9a-fA-F]{4}", tempStr);
        return flag;
    }

    public static String getJsonString() {
        FileInputStream fileInputStream = null;
        byte[] b = null;
        int available = 0;
        try {
            fileInputStream = new FileInputStream(new File("D:\\resources\\json\\test.json"));
            try {
                available = fileInputStream.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
            b = new byte[available];
            try {
                fileInputStream.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(fileInputStream);
        }
        return new String(b, 0, b.length);
    }

    public static String unicodeToCn(String string) {
        StringBuffer sb = new StringBuffer();
        String jsonString = getJsonString();
        Matcher matcher = PATTERN.matcher(jsonString);
        while (matcher.find()) {
            String group = matcher.group();
            matcher.appendReplacement(sb, revert(group));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 变量预编译
     */
    private static  String varU = "\\\\u";
    public static String revert(String str) {
        StringBuffer sb = new StringBuffer();
        String[] split = str.split(varU);
        for (int i = 1; i < split.length; i++) {
            int i1 = Integer.parseInt(split[i], 16);
            sb.append((char) i1);
        }
        return sb.toString();
    }
}
