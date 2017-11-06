package com.zhangkai.spring.springboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangkai.spring.springboot.configbean.Book;

/**
 * 
 * @author and04
 *
 */
@RestController
@RequestMapping("/hello")
public class HelleController {

	@Autowired
	private Book book;

	@Autowired
	private Registration client;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Resource(name = "bookRedisTemplate")
	private RedisTemplate<String, Book> bookRedisTemplate;

	@GetMapping("/redis-book")
	public Book saveBook2Redis() {
		ValueOperations<String, Book> ops = bookRedisTemplate.opsForValue();
		ops.set("book:" + book.getName(), book);
		return ops.get("book:" + book.getName());
	}

	@GetMapping("/redis")
	public String redis() {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set("test", "測試");
		String name = ops.get("name");
		return name;
	}

	@GetMapping
	public String hello() {
		String serviceId = client.getServiceId();
		List<ServiceInstance> list = discoveryClient.getInstances(serviceId);
		int port = list.get(0).getPort();
		System.out.println("端口为：" + port);
		return "Hello";
	}
}
