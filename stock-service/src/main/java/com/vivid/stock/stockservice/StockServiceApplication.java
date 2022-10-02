package com.vivid.stock.stockservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

import com.netflix.appinfo.AmazonInfo;

@EnableEurekaClient
//@SpringBootApplication - enables Spring Boot autoconfiguration and component scanning.
@SpringBootApplication
public class StockServiceApplication implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(StockServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}
//	@Bean
//    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
//        EurekaInstanceConfigBean b = new EurekaInstanceConfigBean(inetUtils);
//        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
//        b.setDataCenterInfo(info);
//        return b;
//    }
//	@Value("${spring.application.name}")
//	private String applicationName;
//	
//	@Value("${ApplicationType}")
//	private String applicationType;
//	
//	@Value("${UserName}")
//	private String userName;
//	@Bean
//    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
//        EurekaInstanceConfigBean b = new EurekaInstanceConfigBean(inetUtils);
//        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
//        b.setDataCenterInfo(info);
//        return b;
//    }
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		log.info("Application Name: {}, Application Type: {}, Username: {}", applicationName, applicationType, userName);
	}

}

