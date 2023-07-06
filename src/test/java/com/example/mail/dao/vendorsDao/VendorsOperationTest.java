package com.example.mail.dao.vendorsDao;

import com.example.mail.entity.Vendors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorsOperationTest {
    @Resource
    private VendorsOperation operation;

    @Test
    public void register(){
        boolean register = operation.register(new Vendors("8569","qi", "北京", "17895456", "wu", "245900", "商品"));
        if (register){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void selectProvince(){
        System.out.println(operation.convertProvince("p1"));
        System.out.println(operation.convertCity("p5c10"));
        System.out.println(operation.convertRegion("p5c10r1"));
    }

    @Test
    public void vendorsLogin(){
        Vendors res = operation.vendorsLogin("威康", "17894637569");
        System.out.println(res);
    }
}
