package com.example.demo.controller;

import com.example.demo.controller.util.ImageRamdom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Controller
public class ImageController {
    int a = 0;
    @RequestMapping("getImage")
    public void getImage(HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-Cache");
        response.setHeader("Cache-Control", "No-Cache");
        response.setDateHeader("Expires", 0);
        //response.setHeader("Refresh","1");
//绘制宽=480，长=640的图板  
        int width=100,hight=40;
BufferedImage image=new BufferedImage(width,hight,BufferedImage.TYPE_3BYTE_BGR);
//获取图形上下文,graphics想象成一个画笔  
Graphics2D graphics = (Graphics2D)image.getGraphics();

//消除线锯齿  
//graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//对指定的矩形区域填充颜色  
graphics.setColor(Color.white);//GREEN:绿色；  红色：RED;   灰色：GRAY  
graphics.fillRect(0,0,width, hight);
//对指定的矩形区域填充颜色  
//graphics.setColor(Color.PINK);
//graphics.fillRect(240,0,240,720);

//生成随机数  
Random random=new Random();
/* 
     * 画线 x,y是坐标，定义线段的两个坐标点 
     */
graphics.setColor(Color.BLACK);
int x=100,y=100,x1=150,y1=y;
graphics.drawLine(x,y,x+x1,y1);
        graphics.setColor(Color.BLACK);
        graphics.drawLine(x+x1 - 20,y1-20,x+x1,y1);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(x+x1 -20,y1+20,x+x1,y1);



/*
     *画出一个折线 
     */
//int[] xPoints = {100,100,250,250};
//int[] yPoints = {180,150,150,180};
//        graphics.drawPolyline(xPoints, yPoints,4);
/* 
     * 画出一个闭合多边形(三角形) 
     */
//int[] xPoints1 ={100,100,200};
//int[] yPoints1={240,320,280};
//graphics.drawPolygon(xPoints1,yPoints1,3);
/* 
     * 画出一个闭合多边形(菱形) 
     */
//int[] xPoints2={240,300,360,300};
//int[] yPoints2 ={280,240,280,320};
//graphics.drawPolygon(xPoints2,yPoints2,4);
//graphics.setColor(Color.ORANGE);
//graphics.fillPolygon(xPoints2,yPoints2,4);
/* 
     *绘制一个椭圆形  
     */
//graphics.setColor(Color.GREEN);
//int xOval=100,yOval=360;
//graphics.drawOval(xOval,yOval,100,100);

/* 
     *绘制一个矩形 
     */
//graphics.setColor(Color.GRAY);//--设置矩形边框颜色 。GREEN:绿色；  红色：RED;   灰色：GRAY  
//int xRect=240,yRect=360;
//graphics.drawRect(xRect,yRect,200,100);

//设置文字颜色  
graphics.setColor(new Color(0, 0, 0));
        Font font = new Font("微软雅黑", Font.BOLD, 80);
        graphics.setFont(font);
//设置文字内容、位置  
graphics.drawString("直线",100+50,100-5);
graphics.drawString("1 2 3 4",200,150-5);
//graphics.drawString("空心三角形",110,280);
//graphics.drawString("实心菱形",300-20,280);
//graphics.drawString("椭圆形",100+50,360+50);
//graphics.drawString("矩形",240+50,360+50);
//graphics.drawString("渠红元",450,500);

//graphics.drawString("错误的背景颜色", 100, 540);  
//grahics.setPaintMode();  
//graphics.translate(400, 600);  
        graphics.dispose();//释放此图形的上下文并释放它所使用的所有系统资源  
       // ImageIO.write(image,"png",response.getOutputStream());
        ImageRamdom.outputImage(ImageRamdom.random(),response.getOutputStream());
        System.err.println(a++);
    }
}
