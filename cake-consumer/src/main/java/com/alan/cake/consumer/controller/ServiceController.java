package com.alan.cake.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/services")
	public Object services() {
		return discoveryClient.getInstances("cake-producer");
	}

	@RequestMapping(value = "/discover")
	public Object discover() {
		return loadBalancerClient.choose("cake-producer").getUri().toString();
	}
}
