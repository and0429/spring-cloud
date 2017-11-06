package com.zhangkai.spring.springboot.configbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author and04
 *
 */
@Component
public class User {

	@Value("${user.name}")
	private String name;

	@Value("#{user.age}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
