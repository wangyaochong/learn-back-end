package com.learnspringboot.aConfig;

import com.learnspringboot.learnSubject.startProcess.MyEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean
    public MyEventListener applicationStartListener(){
        return new MyEventListener();
    }


    @Bean
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
