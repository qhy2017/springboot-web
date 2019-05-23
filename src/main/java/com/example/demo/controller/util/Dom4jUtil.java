package com.example.demo.controller.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Dom4jUtil {

    public static void  main(String[] args){
        dom4j();
    }

    public static void dom4j(){
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(new File("D:\\xml\\contentType.xml"));
            Element rootElement = doc.getRootElement();
            getElement(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归调用
     * @param ele
     */
    public static void getElement(Element ele){
        String textTrim = ele.getTextTrim();
        System.out.println(textTrim);
        Iterator<Element> iterator = ele.elementIterator();
        while (iterator.hasNext()){
            Element next = iterator.next();
            getElement(next);
        }
    }
}
