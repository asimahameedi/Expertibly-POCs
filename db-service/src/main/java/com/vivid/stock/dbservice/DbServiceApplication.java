package com.vivid.stock.dbservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
//import com.vivid.stock.dbservice.resource.DBServiceResource;
@EnableEurekaClient
//I added this one to test nullpointerexeception when adding a username & symbol
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.vivid.stock.dbservice.repository")
@SpringBootApplication

public class DbServiceApplication implements CommandLineRunner{
private static final Logger log = LoggerFactory.getLogger(DbServiceApplication.class);
	public static void main(String[] args) {
		
//		com.amazonaws.util.EC2MetadataUtils
		SpringApplication.run(DbServiceApplication.class, args);
	}
//	@Value("${spring.application.name}")
//	private String applicationName;
//	
//	@Value("${ApplicationType}")
//	private String applicationType;
//	
//	@Value("${UserName}")
//	private String userName;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		log.info("Application Name: {}, Application Type: {}, Username: {}", applicationName, applicationType, userName);
	}

}

