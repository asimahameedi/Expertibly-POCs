package com.expertibly.customerprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;

@Configuration
public class CustomerConfig {
	
	
	public static final String KEY="AKIAZ2IMBUWKBD4TKEZW";
	public static final String SECRET="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";
	public static final String REGION="us-east-1";
	public static final String ENDPOINT="dynamodb.us-east-1.amazonaws.com";
	
	

	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amamzonDynamoDBConfig());
	}

	private AmazonDynamoDB amamzonDynamoDBConfig() {
		// TODO Auto-generated method stub
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT, REGION))
				.withCredentials(new AWSStaticCredentialsProvider( new BasicAWSCredentials(KEY,SECRET))).build();
				
		
	}

}

//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.client.builder.AwsClientBuilder;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CustomerConfig {
//
////    public static final String SERVICE_ENDPOINT = "";
////    public static final String REGION = "";
////    public static final String ACCESS_KEY = "";
////    public static final String SECRET_KEY = "";
//    
//	public static final String KEY="AKIAZ2IMBUWKBD4TKEZW";
//	public static final String SECRET="CeVvPcKNI/GQJWpYBcmlOPAR9ZekqPrBvnVCh1iHZ";
//	public static final String REGION="us-east-1";
//	public static final String ENDPOINT="dynamodb.us-east-1.amazonaws.com";
//	
//
//    @Bean
//    public DynamoDBMapper mapper() {
//        return new DynamoDBMapper(amazonDynamoDBConfig());
//    }
//
//    private AmazonDynamoDB amazonDynamoDBConfig() {
//        return AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
//    }
//}
//
