package com.alan.cake.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "com.alan.cake" })
public class CakeAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeAdminApplication.class, args);
	}

}
