package com.example.learnmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan({"com.example.learnmybatis.mapper.other", "com.example.learnmybatis.mapper.zReadWriteAnnotationMapper"})
@EnableAspectJAutoProxy
@SpringBootApplication
public class LearnMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMybatisApplication.class, args);
	}
}
