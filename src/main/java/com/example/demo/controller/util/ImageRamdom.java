package com.example.demo.controller.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageRamdom {
    public static String[] SYMBOL;

    public static String[] W_SYMOL = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {
        System.out.println(W_SYMOL.length);
    }

    static {
        SYMBOL = new String[]{"+", "-", "*", "÷"};
    }

    public static int num = 0;

    public static String random() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer(4);
        sb.append(W_SYMOL[ran.nextInt(36)]).append(W_SYMOL[ran.nextInt(36)]).append(W_SYMOL[ran.nextInt(36)]).append(W_SYMOL[ran.nextInt(36)]);
        return sb.toString();
    }

    //生成随机算式
    public static String random1() {
        Random ran = new Random();
        int n1 = ran.nextInt(100);
        int n2 = ran.nextInt(10);

        String f = SYMBOL[ran.nextInt(SYMBOL.length)];
        StringBuilder sb = new StringBuilder(4);

        switch (f) {
            case "+":
                num = n1 + n2;
                break;
            case "-":
                num = n1 - n2;
                break;
            case "*":
                num = n1 * n2;
                break;
            case "÷":
                if (n2 == 0) {
                    n2 = ran.nextInt(10) + 1;
                    num = n1 / n2;
                } else {
                    num = n1 / n2;
                }
                break;
            default:
                num = n1 + n2;
        }
        sb.append(n1);
        sb.append(f);
        sb.append(n2);
        sb.append("=");

        return sb.toString();
    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = random.nextInt(2);
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (2.2831853071795862D * (double) phase) / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }

    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {
                 Random random=new Random();
                  int period = 2;

                 boolean borderGap = true;
                  int frames = 1;
                 int phase = random.nextInt(2);

                for (int i = 0; i < h1; i++) {
                    double d = (double) (period >> 1)
                            * Math.sin((double) i / (double) period
                            + (2.2831853071795862D * (double) phase) / (double) frames);
                         g.copyArea(0, i, w1, 1, (int) d, 0);
                         if (borderGap) {
                                 g.setColor(color);
                                g.drawLine((int) d, i, 0, i);
                                 g.drawLine((int) d + w1, i, w1, i);
                             }
                     }

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
        l = 5;
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
        //shearY(g,100,50,new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        //shearX(g,100,50,new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        // 4. 输出结果
        // 常见的压缩格式：jpeg(有损压缩), png(无损压缩) ...
        try {
//            ImageIO.write(img, "png", os);
            ImageIO.write(img, "jpeg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
