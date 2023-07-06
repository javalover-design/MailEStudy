package com.example.mail.service.vendorsService;

import com.example.mail.entity.City;
import com.example.mail.entity.Province;
import com.example.mail.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface LoadAddressDataService {

   List<Province> getProvince();

   /**
    *
    * @param provinceId 省份的id值
    * @return 返回对应省份id所对应的所有城市
    */
   List<City> getCities(@Param("provinceId") String provinceId);

   /**
    *
    * @param cityId 对应城市的id
    * @return 返回对应id城市的所有区
    */
   List<Region>getRegions(@Param("cityId")String cityId);
}
