package com.example.mail.dao.goods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchGoods {

    /**
     * 根据关键词搜索商品名字
     * @param keyWord
     * @return
     */
    @Select("select goods_name from goods where goods_name like concat('%',#{keyWord},'%')")
    List<String> searchGoods(@Param("keyWord") String keyWord);
}
