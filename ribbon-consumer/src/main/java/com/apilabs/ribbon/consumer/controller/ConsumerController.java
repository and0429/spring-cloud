package com.apilabs.ribbon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon-consumer")
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public String consumer() {
		return restTemplate.getForObject("http://FIRST/dev/hello", String.class);
	}

}
