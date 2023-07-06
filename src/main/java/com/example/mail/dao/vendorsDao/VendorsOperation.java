package com.example.mail.dao.vendorsDao;

import com.example.mail.entity.Vendors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface VendorsOperation {
    /**
     *
     * @param vendors 供应商对象
     * @return 添加成功与否
     */
    boolean register(Vendors vendors);


    /**
     *
     * @param provinceId
     * @return
     */
    String convertProvince(@Param("provinceId") String provinceId);

    /**
     *
     * @param cityId
     * @return
     */
    String convertCity(@Param("cityId") String cityId);

    /**
     *
     * @param regionId
     * @return
     */
    String convertRegion(@Param("regionId") String regionId);

    /**
     *
     * @param vendorsName 供应商名称
     * @param VendorsPhone 供应商电话
     * @return
     */
    Vendors vendorsLogin(@Param("vendorsName")String vendorsName,@Param("vendorsPhone")String VendorsPhone);



}
