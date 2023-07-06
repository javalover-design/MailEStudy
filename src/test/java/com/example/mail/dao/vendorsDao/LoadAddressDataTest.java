package com.example.mail.dao.vendorsDao;

import com.alibaba.fastjson.JSON;
import com.example.mail.entity.City;
import com.example.mail.entity.Province;
import com.example.mail.entity.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadAddressDataTest {
    @Resource
    private LoadAddressData loadAddressData;

    @Test
    public void getProvince() {
        List<Province> provinces = loadAddressData.getProvince();

        System.out.println(JSON.toJSONString(provinces));

    }

    @Test
    public void getCities(){
        List<City> cities = loadAddressData.getCities("p1");
        System.out.println(JSON.toJSONString(cities));

    }

    @Test
    public void getRegions(){
        List<Region> p1c1 = loadAddressData.getRegions("p1c1");
        System.out.println(JSON.toJSONString(p1c1));
    }
}