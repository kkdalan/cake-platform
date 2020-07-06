package com.alan.cake.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alan.cake.consumer.service.CakeProducerService;

@RestController
public class FeignHelloController {

	@Autowired
	private CakeProducerService cakeProducerService;

	@RequestMapping(value = "/feign/call")
	public String call() {
		//像呼叫本地服務一樣
		return cakeProducerService.hello();
	}
}
