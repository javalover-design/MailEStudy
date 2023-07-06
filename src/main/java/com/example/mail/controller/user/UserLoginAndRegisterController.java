package com.example.mail.controller.user;


import com.example.mail.entity.User;
import com.example.mail.service.user.UserRegisterAndCancelService;
import com.example.mail.utils.EncryptUtils;
import com.example.mail.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class UserLoginAndRegisterController {

    public  String verifyCodes="";
    @Autowired
    private UserRegisterAndCancelService service;

    @RequestMapping({"/toRegister"})
    @ResponseBody
    public String register(User user) throws IOException {
        System.out.println(user.getPhone());
        System.out.println(user.getPassword());
        User userRegister = new User(user.getPhone(),user.getPassword(),user.getEmail(),user.getUsername(),user.getTrueName());
        System.out.println("进入到注册方法了");
        service.registerUser(userRegister);
        return"success";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        System.out.println(username);
        System.out.println(password);
        System.out.println("进入了登陆方法~~~~~~");
        //模型对象存储相应的属性到前端
        model.addAttribute("username",username);
        //与后台进行校验
        User loginUser = service.login(username, EncryptUtils.md5(password));
        if (loginUser==null){
           // response.sendRedirect("/e");
            return "error";
        }
        Cookie cookie = new Cookie("username",username);
        response.addCookie(cookie);
        HttpSession session = request.getSession(true);
        session.setAttribute("username",username);
        System.out.println("session设置完毕");
        return "success";

    }

    @RequestMapping("/getIdentify")
    @ResponseBody
    public String getIdentify(){
        verifyCodes= VerifyCodeUtils.getRandomVerifyCode();
        return verifyCodes;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession();
        session.removeAttribute("username");
        response.addCookie(new Cookie("username",null));
        return "html/login/login";
    }


    @RequestMapping("/cancel")
    public String cancel(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("获取到"+username);
        session.removeAttribute("username");
        response.addCookie(new Cookie("username",null));
        boolean cancel = service.cancel(username);
        if (cancel){
            return "html/login/login";
        }
//        session.removeAttribute("username");
//        response.addCookie(new Cookie("username",null));

        return "index";
    }


}
