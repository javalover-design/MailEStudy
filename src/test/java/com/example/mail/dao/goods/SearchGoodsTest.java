package com.example.mail.dao.goods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchGoodsTest {

    @Autowired
    private SearchGoods goods;

    @Test
    public void search(){
        List<String> re = goods.searchGoods("肉");
        System.out.println(re.toString());
    }
}
