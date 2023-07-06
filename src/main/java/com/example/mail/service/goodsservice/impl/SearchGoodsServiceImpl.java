package com.example.mail.service.goodsservice.impl;

import com.example.mail.dao.goods.SearchGoods;
import com.example.mail.service.goodsservice.SearchGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchGoodsServiceImpl implements SearchGoodsService {

    @Autowired
    private SearchGoods searchGoods;
    @Override
    public List<String> searchGoods(String keyWord) {
        return searchGoods.searchGoods(keyWord);
    }
}
