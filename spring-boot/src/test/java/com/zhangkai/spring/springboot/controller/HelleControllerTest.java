package com.zhangkai.spring.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HelleControllerTest {

	// private MockMvc mvc;

	@Before
	public void setUp() {
		// mvc = MockMvcBuilders.standaloneSetup(new HelleController()).build();	
	}

	@Test
	public void testHello() throws Exception {

		// mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_PLAIN))
		// //
		// .andExpect(status().isOk()) //
		// .andExpect(content().string(equalTo("Hello"))); //
	}

}
