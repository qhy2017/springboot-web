package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {
    @RequestMapping("upload")
    @CrossOrigin("http://127.0.0.1:8848")
    public void upload(HttpServletResponse response, HttpServletRequest request){

    }
}
