package com.alan.cake.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonHelloController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/ribbon/call")
	public Object call() {
		String callServiceResult = restTemplate.getForObject("http://cake-producer/hello",String.class);
		return callServiceResult;
	}
}
