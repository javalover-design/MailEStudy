package com.example.mail.controller.vendors;

import com.alibaba.fastjson.JSON;
import com.example.mail.entity.City;
import com.example.mail.entity.Province;
import com.example.mail.entity.Region;
import com.example.mail.service.vendorsService.LoadAddressDataService;
import com.example.mail.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class LoadAddressDataController {
    @Autowired
    private LoadAddressDataService loadAddressDataService;

    @RequestMapping("/getProvince")
    @ResponseBody
    public String getProvince(){
        List<Province> provinces = loadAddressDataService.getProvince();
        return JSON.toJSONString(provinces);
    }


    @RequestMapping("/getCities")
    @ResponseBody
    public String getCities( String provinceId){
        System.out.println("获取到的省份id为"+provinceId);
        List<City> cities = loadAddressDataService.getCities(provinceId);
        return JSON.toJSONString(cities);
    }


    @RequestMapping("/getRegions")
    @ResponseBody
    public String getRegions(String cityId){
        System.out.println("获取到城市id为"+cityId);
        List<Region> regions = loadAddressDataService.getRegions(cityId);
        return JSON.toJSONString(regions);
    }

}
