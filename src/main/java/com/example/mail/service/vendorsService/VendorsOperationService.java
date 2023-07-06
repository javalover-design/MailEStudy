package com.example.mail.service.vendorsService;

import com.example.mail.entity.Vendors;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VendorsOperationService {
    /**
     *
     * @param vendors 供应商对象
     * @return 添加成功与否
     */
    boolean register(Vendors vendors);

    /**
     *
     * @param vendorsName 供应商名称
     * @param VendorsPhone 供应商电话
     * @return
     */
    Vendors vendorsLogin(@Param("vendorsName")String vendorsName, @Param("vendorsPhone")String VendorsPhone);
}
