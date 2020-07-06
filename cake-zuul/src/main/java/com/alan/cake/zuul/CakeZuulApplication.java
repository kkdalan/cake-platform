package com.alan.cake.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CakeZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeZuulApplication.class, args);
	}

}
