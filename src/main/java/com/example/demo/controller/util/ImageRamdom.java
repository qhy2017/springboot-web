package com.example.demo.controller.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageRamdom {
    public static String[] SYMBOL;

    public static String[] W_SYMBOL = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
    }

    static {
        SYMBOL = new String[]{"+", "-", "*", "÷"};
    }

    public static int num = 0;

    public static String random() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer(4);
        int length = W_SYMBOL.length;
        sb.append(W_SYMBOL[ran.nextInt(length)]).append(W_SYMBOL[ran.nextInt(length)]).append(W_SYMBOL[ran.nextInt(length)]).append(W_SYMBOL[ran.nextInt(length)]);
        return sb.toString();
    }

    public static void outputImage(String str, OutputStream os) {
        int l = 0;
        Random ran = new Random();
        //创建图片对象
        BufferedImage img = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        //获取画布
        Graphics g = img.getGraphics();
        //设置背景
        g.setColor(Color.white);
        g.fillRect(0, 0, 100, 50);
        //写字
        g.setColor(Color.black);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        g.drawString(str, 10, 40);
        //随机三条线
        l = 10;
        for (int i = 0; i < l; i++) {
            g.drawLine(ran.nextInt(100), ran.nextInt(40),
                    ran.nextInt(100), ran.nextInt(40));
        }
        //      设置最多100个噪音点
        l= 50;
        for (int i = 0, n = ran.nextInt(l); i < n; i++) {
            g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            g.drawRect(ran.nextInt(100), ran.nextInt(50), 1, 1);
            g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            int i1 = ran.nextInt(100);
            int y = ran.nextInt(50);
            int width = ran.nextInt(6);
            int height = ran.nextInt(6);
            g.drawOval(i1, y, width, height);
            g.fillRect(i1, y, width, height);
        }
        // 4. 输出结果
        // 常见的压缩格式：jpeg(有损压缩), png(无损压缩) ...
        try {
            ImageIO.write(img, "jpeg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
