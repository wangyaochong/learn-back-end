package com.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.learnspring.SpringDataJpa")//启用spring-data-jpa并设置扫描路径
public class ModulelearnspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModulelearnspringApplication.class, args);
	}
}
