package com.example.mail.service.goodsservice;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchGoodsService {

    List<String> searchGoods(@Param("keyWord") String keyWord);
}
