package com.zhangkai.spring.springboot.configbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

	@SuppressWarnings("unused")
	@Autowired
	private User user;

	@Test
	public void test() {
		// assertEquals(32, user.getAge());
		// assertEquals("zhangkai", user.getName());
	}

}
