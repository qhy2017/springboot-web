package com.example.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

@SpringBootApplication
@MapperScan("com.example.demo.service.mapper")
public class ProjectJspApplication {
	@Bean
	public HttpMessageConverters fastJsonConfigure() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//日期格式化
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		converter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(converter);

	}
	public static void main(String[] args) {
//		SpringApplication.run(ProjectJspApplication.class, args);
//		String reg = "(jpg|png|mv|txt|xls|xlsx)$";\
//		String reg = ".+(.JPEG|.jpeg|.JPG|.jpg)$";
//String reg = ".+(.jpg|.png)$";
		String reg = "^.+(jpg|png|xls)$";
		System.out.println(Pattern.matches(reg,"asdasd.jpg"));
		System.out.println("erer.xls".replaceFirst("^[^\\.]+",""));
	}

}
