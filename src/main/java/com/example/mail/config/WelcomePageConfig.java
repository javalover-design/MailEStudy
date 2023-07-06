package com.example.mail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**设置欢迎界面的路径跳转*/
@Configuration
public class WelcomePageConfig implements WebMvcConfigurer {

    /**
     * 设置主页面的访问路径
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // "/"是springboot自动装配访问index.html的，所以能够访问到
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置访问static下面的所有静态资源文件，第一个表示外部访问路径（文件所在路径，即static以下的所有文件），第二个表示文件资源具体在哪个位置，即在classpath下的static文件夹下
            registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
            registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        //addResourceHandler指定了资源访问的外部路径，和spring.mvc.static-path-pattern作用一致
        //addResourceLocations指定了资源的实际所在地址，和spring.web.resources.static-locations作用一致
    }
}
