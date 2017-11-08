package com.apilabs.ribbon.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apilabs.ribbon.consumer.domain.Book;
import com.apilabs.ribbon.consumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author and04
 *
 */
@Service
public class HelloServiceImpl implements HelloService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "hellFallBack")
	public Book getBook() {
		return restTemplate.getForObject("http://SPRING-BOOT/hello", Book.class);
	}

	public Book hellFallBack() {
		Book b = new Book();
		return b;
	}

}
