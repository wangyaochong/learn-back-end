package com.example.shiro.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
@MapperScan(basePackages = {"com.example.shiro.generated." + "shiro" + ".mapper"}, sqlSessionFactoryRef =  "shiroSqlSessionFactory")
@Configuration
public class MybatisConfig {
    @Bean(name = "shiroSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        //注意，如果是使用mybatis-plus，使用的是MybatisSqlSessionFactoryBean
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        String locationPattern = "classpath:mapper/" + "shiro" + "/*.xml";
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(locationPattern));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        SqlSessionFactory object = factoryBean.getObject();
        return object;
    }

}
