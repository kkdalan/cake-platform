package com.alan.cake.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cake-producer", fallback = CakeProducerHystrix.class)
public interface CakeProducerService {
	
	@RequestMapping("/hello")
	public String hello();
	
}
