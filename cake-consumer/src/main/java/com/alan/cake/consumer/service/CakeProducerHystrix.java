package com.alan.cake.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CakeProducerHystrix implements CakeProducerService{

	@RequestMapping("/hello")
	public String hello() {
		return "sorry, hello service call failed.";
	}
	
}
