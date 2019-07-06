package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

   @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "mmgg")
    public String indexMmg(){

        return "mmgGrid";
    }

    @ResponseBody
    @RequestMapping(value = "mmgList",produces = "application/json;charset=utf-8")
    public Object indexMmgList(){
        JSONObject jsonObject = new JSONObject();
        JSONArray  array = new JSONArray();
        for(int i=0;i<1000;i++){
            JSONObject jsonObjectd = new JSONObject();
            jsonObjectd.put("name","渠红元");
            jsonObjectd.put("age","27");
            array.add(jsonObjectd);
        }
        jsonObject.put("items",array);
        jsonObject.put("totalCount",array.size());

        return jsonObject;
    }

}
