package com.example.mail.dao.goods;

import com.example.mail.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsOperationTest {
    @Resource
    private GoodsOperation goodsOperation;

    @Test
    public void loadGoods(){
        List<Goods> goods = goodsOperation.loadGoodsWithVendorsId();
        System.out.println(goods.toString());
    }

    @Test
    public void addProducts(){
        goodsOperation.addProduct(new Goods("1","2","3", "1579779b98ce9edb98dd85606f2c119d",15,false,"1", "12"));
    }
}
