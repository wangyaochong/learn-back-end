package com.example.learnmybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 实际数据源配置
 */
@ConfigurationProperties(prefix = "hikari")
@Slf4j
@Data
@Component
public class DBProperties {
    private HikariDataSource read;
    private HikariDataSource write;

    @Value("${hikari.read.jdbc-url}")
    String readDbUrl;

    @Value("${hikari.write.jdbc-url}")
    String writeDbUrl;

    @PostConstruct
    public void init() {
//        read.setAutoCommit(false);
//        write.setAutoCommit(false);
        log.info("读库url={}", readDbUrl);
        log.info("写库url={}", writeDbUrl);
    }
}