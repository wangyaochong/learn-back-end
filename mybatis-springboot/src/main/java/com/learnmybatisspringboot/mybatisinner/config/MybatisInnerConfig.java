package com.learnmybatisspringboot.mybatisinner.config;

import com.learnmybatisspringboot.mybatisinner.my.MyScan;
import org.springframework.context.annotation.Configuration;
//@ImportResource("classpath:mybatis.xml")
@Configuration
//@MapperScan(basePackages = "com.example.learnmybatisspringboot.mybatisinner.mapper")
@MyScan
//@ConditionalOnMissingBean(MybatisConfig.class)
public class MybatisInnerConfig {
//    @Bean
//    public SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        return sqlSessionFactoryBean.getObject();
//    }
}
