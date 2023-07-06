package com.example.mail.service.vendorsService.impl;

import com.example.mail.dao.vendorsDao.VendorsOperation;
import com.example.mail.entity.Vendors;
import com.example.mail.service.vendorsService.VendorsOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VendorsOperationServiceImpl implements VendorsOperationService {

    @Autowired
    private VendorsOperation vendorsOperation;
    /**
     * @param vendors 供应商对象
     * @return 添加成功与否
     */
    @Override
    public boolean register(Vendors vendors) {
        return vendorsOperation.register(vendors);
    }

    /**
     * @param vendorsName  供应商名称
     * @param vendorsPhone 供应商电话
     * @return
     */
    @Override
    public Vendors vendorsLogin(String vendorsName, String vendorsPhone) {
        return vendorsOperation.vendorsLogin(vendorsName,vendorsPhone);
    }
}
