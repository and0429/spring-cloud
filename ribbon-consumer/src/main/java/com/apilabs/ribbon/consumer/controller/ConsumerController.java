package com.apilabs.ribbon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apilabs.ribbon.consumer.domain.Book;
import com.apilabs.ribbon.consumer.service.HelloService;

@RestController
@RequestMapping("/ribbon-consumer")
public class ConsumerController {

	@Autowired
	private HelloService service;

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public Book consumer() {
		return service.getBook();
	}

}
