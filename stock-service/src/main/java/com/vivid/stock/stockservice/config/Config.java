package com.vivid.stock.stockservice.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@Configuration - indicates that a class is a configuration class that may contain bean definitions.
@Configuration
public class Config {
//indicate to spring that RestTemplate must be a singleton
@Bean
// client side load balancing
@LoadBalanced
public RestTemplate restTemplate(){
	//This is what I had originally
//	return new RestTemplate();
	// do this for a slow service to timeout to avoid from delaying other blocked request threads. But this solved the problem only if the request frequency is more than 3000 ms
	// but if that's not the case we still can run out of resources. Calls to the blocking threads is causing run out of resource issue
	// use circuit pattern for fault tolerance (like the electric fuse going off in case of a spike to prevent burn of other appliances
	// 1- detect something is wrong i.e. a certain MS is not responding or is slow
	// 2- Take temporary steps to avoid the situation from getting worse, stop sending requests
	// 3- Deactivate the "problem" component so that it doesn't affect downstream components
	HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
	clientHttpRequestFactory.setConnectTimeout(3000);
	return new RestTemplate(clientHttpRequestFactory);
}
}
