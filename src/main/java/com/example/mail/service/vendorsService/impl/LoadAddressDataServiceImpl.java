package com.example.mail.service.vendorsService.impl;

import com.example.mail.dao.vendorsDao.LoadAddressData;
import com.example.mail.entity.City;
import com.example.mail.entity.Province;
import com.example.mail.entity.Region;
import com.example.mail.service.vendorsService.LoadAddressDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoadAddressDataServiceImpl implements LoadAddressDataService {

    @Autowired
    private LoadAddressData loadAddressData;
    @Override
    public List<Province> getProvince() {
        return loadAddressData.getProvince();
    }

    /**
     * @param provinceId 省份的id值
     * @return 返回对应省份id所对应的所有城市
     */
    @Override
    public List<City> getCities(String provinceId) {
        return loadAddressData.getCities(provinceId);
    }

    /**
     * @param cityId 对应城市的id
     * @return 返回对应id城市的所有区
     */
    @Override
    public List<Region> getRegions(String cityId) {
        return loadAddressData.getRegions(cityId);
    }
}
