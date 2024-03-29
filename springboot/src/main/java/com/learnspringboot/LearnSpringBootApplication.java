package com.learnspringboot;

import com.learnspringboot.learnSubject.springDataJpa.repo.ZExcludeTestRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = "entity")
@EnableJpaRepositories(
        //启用spring-data-jpa并设置扫描路径
        basePackages = "com.learnspringboot.learnSubject.springDataJpa.repo",

        //排除一些
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ZExcludeTestRepo.class)}
)
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement
@EnableAsync


public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}
