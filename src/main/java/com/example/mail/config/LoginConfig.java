package com.example.mail.config;

import com.example.mail.interrupt.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class LoginConfig implements WebMvcConfigurer {
    /**
     * 将写好的拦截器注册进入配置类中，该配置类用于配置拦截路径以及过滤拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        //所有路径都拦截
        interceptorRegistration.addPathPatterns("/**");
        //不拦截的路径(注册登陆以及静态资源不进行拦截)
        interceptorRegistration.excludePathPatterns("/login","/register","/**/*.htm","/**/*.css","/**/*.js","/index","/");
    }
}
