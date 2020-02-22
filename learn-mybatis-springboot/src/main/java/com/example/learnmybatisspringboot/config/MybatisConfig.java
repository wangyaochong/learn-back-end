package com.example.learnmybatisspringboot.config;

import com.example.learnmybatisspringboot.my.MyScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
//@ImportResource("classpath:mybatis.xml")
@Configuration
//@MapperScan(basePackages = "com.example.learnmybatisspringboot.mapper")
@MyScan
public class MybatisConfig {
    @Bean
    public SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
