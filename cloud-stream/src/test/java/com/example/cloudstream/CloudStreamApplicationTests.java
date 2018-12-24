package com.example.cloudstream;

import com.example.cloudstream.personChannel.bean.Person;
import com.example.cloudstream.testForWork.WorkMq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudStreamApplicationTests {
	@Resource
	WorkMq workMq;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testSend() {
		workMq.send(new Person("test", 23));
	}
}
