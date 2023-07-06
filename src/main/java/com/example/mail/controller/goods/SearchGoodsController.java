package com.example.mail.controller.goods;

import com.alibaba.fastjson.JSON;
import com.example.mail.service.goodsservice.SearchGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SearchGoodsController {

    @Autowired
    private SearchGoodsService service;

    @RequestMapping("/search")
    @ResponseBody
    public String searchGoods(String keyWord,@RequestParam("callback")String callBack){
        List<String> result = service.searchGoods(keyWord);
        /*
        * 1、必须要获取callback参数，
        * 2、返回结果要通过callback参数拼接，不是原来的任意对象结构了，变成了字符串形式，
        *3、如果类上注解是@Controller，那么方法名上需要注解@ResponseBody，或者直接在类上注解@RestController 。
        * */
      //  return callBack+"("+result.toString()+")";
        String re= JSON.toJSONString(result);
        return callBack+"("+re+")";
    }

}
