package com.example.mail.dao.goods;

import com.example.mail.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsOperation {

    /**
     * 根据供应商的id返回对应供应商提供的商品

     * @return
     */
    List<Goods> loadGoodsWithVendorsId();

    /**
     * 将商品添加至数据库中
     * @param goods 待添加的商品
     */
    void addProduct(Goods goods);

}
