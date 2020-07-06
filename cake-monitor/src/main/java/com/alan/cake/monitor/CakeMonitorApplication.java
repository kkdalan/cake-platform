package com.alan.cake.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class CakeMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeMonitorApplication.class, args);
	}

}
