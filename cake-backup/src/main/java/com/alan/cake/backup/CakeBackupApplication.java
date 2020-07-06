package com.alan.cake.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "com.alan.cake" },exclude = DataSourceAutoConfiguration.class)
public class CakeBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeBackupApplication.class, args);
	}

}
