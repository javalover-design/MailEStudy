package com.example.mail.service.goodsservice.impl;

import com.example.mail.dao.goods.GoodsOperation;
import com.example.mail.entity.Goods;
import com.example.mail.service.goodsservice.GoodsOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsOperationServiceImpl implements GoodsOperationService {
    @Resource
    private GoodsOperation goodsOperation;
    /**
     * 根据供应商的id返回对应供应商提供的商品
     *

     * @return
     */
    @Override
    public List<Goods> loadGoodsWithVendorsId() {
        return goodsOperation.loadGoodsWithVendorsId();
    }

    /**
     * 将商品添加至数据库中
     *
     * @param goods 待添加的商品
     */
    @Override
    public void addProduct(Goods goods) {
        goodsOperation.addProduct(goods);
    }
}
