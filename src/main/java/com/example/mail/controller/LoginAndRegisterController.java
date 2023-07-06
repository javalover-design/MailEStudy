package com.example.mail.controller;

import com.example.mail.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Api("测试")
@Controller
public class LoginAndRegisterController {

    @GetMapping("/home")
    @ResponseBody
    @ApiOperation("get测试")
    public  String test(){
        return "home";
    }

    /**
     * 设置登陆跳转
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        //此处return表示的是外部资源的访问路径
        return "html/login/login";

    }

    /**
     * 设置注册跳转
     * @return
     */
    @RequestMapping({"/register"})
    public String register(){
        return "html/login/register";
    }

    @RequestMapping("/main")
    public String index(){
        return "index";
    }

    @RequestMapping("/e")
    public String error(){
        return "html/404Error";
    }

    @RequestMapping("/vendorsRegister")
    public String vendorsRegister(){
        return "html/login/registerVendors";
    }

    @RequestMapping("/toVendorsLogin")
    public String vendorsLogin(){
        return "html/login/vendorsLogin";
    }

    @RequestMapping("/vendorsindex")
    public String vendorsIndex(){
        return "html/vendors/vendorsindex";
    }

    @RequestMapping("/alert")
    public String alert(){
        return "html/login/document";
    }


    @RequestMapping("/backAddProducts")
    public String backAddProducts(){
        return "html/vendors/vendorsAddProducts";
    }


}
