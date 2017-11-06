package com.zhangkai.spring.springboot.configbean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookTest {

	@Autowired
	private Book book;

	@Test
	public void test() {
		assertEquals("zhangkai", book.getAuthor());
		assertEquals("Spring cloud", book.getName());
		assertEquals("Spring cloud, zhangkai.", book.getDesc());
	}

}
