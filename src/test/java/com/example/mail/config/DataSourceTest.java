package com.example.mail.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {
    @Resource
    private DataSource dataSource;

    @Test
    public void testDataSource() throws Exception{
        System.err.println(dataSource.getClass());
    }
}
