package com.vivid.stock.eurekaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.appinfo.AmazonInfo;

@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication implements CommandLineRunner {
//	public class EurekaServiceApplication  {
	private static final Logger log = LoggerFactory.getLogger(EurekaServiceApplication.class);
	@Value("${server.port:8761}")
	 private int port;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
	//@Bean - indicates that a method produces a bean to be managed by Spring.
	@Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
        EurekaInstanceConfigBean b = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        b.setDataCenterInfo(info);
        return b;
    }
//	@Bean
//	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inet) {
//        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inet);
//        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
//        config.setDataCenterInfo(info);
//        info.getMetadata().put(AmazonInfo.MetaDataKey.localHostname.getName(), info.get(AmazonInfo.MetaDataKey.localIpv4));
//        config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
//        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.localIpv4));
//        config.setNonSecurePort(port);
//        return config;
//    }
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

