package com.example.learnmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.learnmybatis.mapper")
@MapperScan("com.example.learnmybatis.mapper")
@SpringBootApplication
public class LearnMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMybatisApplication.class, args);
	}
}
