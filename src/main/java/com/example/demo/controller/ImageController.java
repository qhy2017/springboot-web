package com.example.demo.controller;

import com.example.demo.controller.util.ImageRamdom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qhy
 * @date
 */
@Controller
public class ImageController {
    int a = 0;
    @RequestMapping(value = "/getImage")
    public void getImage(HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-Cache");
        response.setHeader("Cache-Control", "No-Cache");
        response.setDateHeader("Expires", 0);
         ///       response.setHeader("Refresh","1");

        final String random1 = ImageRamdom.random();
        ImageRamdom.outputImage(random1,response.getOutputStream());
        System.err.println(random1);
    }
}
