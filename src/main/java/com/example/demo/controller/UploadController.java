package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @author 12423
 */
@Controller
public class UploadController {
    @Value("${url:D:\\upload-dir\\}")
    private String fileUrl;
    @RequestMapping("upload-index")
    public String ajaxOrFormUpload(){

        return "ajaxUpload";
    }
    @ResponseBody
    @RequestMapping(value = "ky")
    public String  ky(HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", "true");
         return "showData"+"("+jsonObject.toJSONString()+")";
//        return "ky("+ jsonObject.toJSONString()+")";
    }


    @ResponseBody
    @RequestMapping(value = "ajaxFormSubmit",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String ajaxFormUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception{
        MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multi.getFiles("file");
        for (MultipartFile item : files){
            System.out.println(item.getOriginalFilename());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", "true");
       return jsonObject.toJSONString();

    }

    @RequestMapping("upload")
    @CrossOrigin("http://127.0.0.1:8848")
    public void upload(HttpServletResponse response, HttpServletRequest request,MultipartFile file) throws Exception {
//        System.out.println(file.getOriginalFilename());
//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//        List<MultipartFile> files = multipartHttpServletRequest.getFiles("file");
//        for (MultipartFile item : files){
//            System.out.println(item.getOriginalFilename());
//        }

        getFileName(request);

        //--------------------------------------------------第一种
//        String originalFilename = file.getOriginalFilename();
//        Resource resource = file.getResource();
//        String filename = resource.getFilename();
//        String s = UUID.randomUUID().toString().replaceAll("-", "");
//        File file1 = new File(fileUrl + s + filename);
//        InputStream inputStream = file.getInputStream();
//        //file.transferTo(new File());//写入硬盘
//        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file1));
//        byte[] b = new byte[1024];
//        int len = 0;
//        while ((len = bis.read(b)) != -1) {
//            bos.write(b, 0, len);
//        }
//        bos.flush();
//        bos.close();
//        bis.close();

        PrintWriter writer = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", "true");
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }

    public  String getFileName(HttpServletRequest request) throws Exception{
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = upload.parseRequest(request);
        Iterator it = items.iterator();
        while (it.hasNext()) {
            FileItem item = (FileItem) it.next();
            if (item.getName() != null && !"".equals(item.getName())) {
                InputStream inputStream = item.getInputStream();
                System.out.println("上传的文件名称为：" + item.getName());
            }
        }

        return "";

    }

    @CrossOrigin("http://127.0.0.1:8848")
    public void uploadString(HttpServletResponse response, @RequestParam String pic, String name, HttpServletRequest request) throws Exception {
//        response.setContentType("application/json;charset=utf-8");
//        byte[] bytes = Base64Utils.decodeFromString("");
//        FileCopyUtils.copy(bytes, new File(fileUrl + name));
//        PrintWriter writer = response.getWriter();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("success", "true");
//        writer.write(jsonObject.toJSONString());
    }
}
