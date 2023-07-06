package com.example.mail.controller.goods;

import com.alibaba.fastjson.JSON;
import com.example.mail.entity.Goods;
import com.example.mail.service.goodsservice.GoodsOperationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsOperationController {
    @Resource
    private GoodsOperationService goodsOperationService;
    public Goods goods;
    public List<Goods> newGoods=new ArrayList<>();

    @RequestMapping("/getGoodsData")
    @ResponseBody
    public String loadGoods(){
        List<Goods> goodsList = goodsOperationService.loadGoodsWithVendorsId();
            goodsList.forEach(goods1 -> {
                goods=new Goods(goods1.getGoodsName(),goods1.getGoodsPrice(),goods1.getPictureUrl(),goods1.getDetails());
                newGoods.add(goods);
            });

           return JSON.toJSONString(newGoods);
    }

}
