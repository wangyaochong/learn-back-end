package com.example.learnmybatis.config.readWriteMultiMapper;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.example.learnmybatis.config.DBProperties;
import com.example.learnmybatis.config.readWriteAnnotation.MybatisConfigurations;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@ConditionalOnMissingBean(MybatisConfigurations.class)
@Configuration
@MapperScan(basePackages = "com.example.learnmybatis.mapper.read", sqlSessionTemplateRef = Constant.DATASOURCE_READ + "SqlSessionTemplate")
public class ReadDBSource extends BaseDbSource {

    @Resource
    private DBProperties properties;

    private final static String DATASOURCE = Constant.DATASOURCE_READ;

    @Bean(name = DATASOURCE)
    public DataSource writeDataSource() {
        return properties.getRead();
    }


    public ReadDBSource(MybatisPlusProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider, ApplicationContext applicationContext) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider, applicationContext);
    }

    @Bean(name = DATASOURCE + "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATASOURCE) DataSource dataSource) throws Exception {
        return super.sqlSessionFactory(dataSource);
    }

    @Bean(name = DATASOURCE + "SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(DATASOURCE + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return super.sqlSessionTemplate(sqlSessionFactory);
    }


}
