package com.example.learnmybatisspringboot.mybatisinner.config;

import com.example.learnmybatisspringboot.mybatisinner.my.MyScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//@ImportResource("classpath:mybatis.xml")
@Configuration
//@MapperScan(basePackages = "com.example.learnmybatisspringboot.mybatisinner.mapper")
@MyScan
public class MybatisConfig {
    @Bean
    public SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
