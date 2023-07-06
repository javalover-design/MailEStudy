package com.example.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MailMain {
    public static void main(String[] args) {
        SpringApplication.run(MailMain.class);
    }

//    /**
//     * 这里配置静态资源文件的路径导包都是默认的直接导入就可以
//     * @param registry
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
//        super.addResourceHandlers(registry);
//
//    }
}
