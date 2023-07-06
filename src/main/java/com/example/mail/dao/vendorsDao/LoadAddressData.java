package com.example.mail.dao.vendorsDao;

import com.example.mail.entity.City;
import com.example.mail.entity.Province;
import com.example.mail.entity.Region;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.ValueMapping;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface LoadAddressData {
    /**
     * 运行结果:Province(provinceId=p1, provinceName=北京)
     * Province(provinceId=p2, provinceName=上海)
     * 获取所有的省份信息  MapKey的作用是指定对应的key不然会出现过多结果的情况
     * @return
     */
   //@MapKey("province_id")//设置数据库中的字段为map中的key
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
