package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class Select2Controller {
    @RequestMapping("/getSelect")
    public String getSelectJSON(String q){
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i < 10; i++){
            JSONObject   jsonT = new JSONObject();
            jsonT.put("id",i + 1);
            jsonT.put("text",q+"测试" + i);
            jsonArray.add(jsonT);
        }
        json.put("items",jsonArray);
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }
}
