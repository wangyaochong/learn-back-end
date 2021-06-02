package com.example.learnmybatis.config.readWriteAnnotation;

import com.example.learnmybatis.config.DBProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 如果要测试多mapper形式的读写分离，则需要将这个类取消加载
 * 注释掉@Configuration和@MapperScan即可
 */
@Configuration
@MapperScan(basePackages = "com.example.learnmybatis.mapper")


public class MybatisConfigurations {

    @Resource
    private DBProperties dataSourceBean;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER, dataSourceBean.getWrite());
        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE, dataSourceBean.getRead());

        //默认数据源
        proxy.setDefaultTargetDataSource(dataSourceBean.getWrite());
        //装入两个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        return proxy;
    }
}
