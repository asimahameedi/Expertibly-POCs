package com.expertibly.customerprofile.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.expertibly.customerprofile.config.CustomerConfig;
import com.expertibly.customerprofile.entity.Customer;

@Repository
public class CustomerRepo {
//
//	@Autowired
//	private CustomerConfig customerConfig= new CustomerConfig();
//	
//	@Autowired
//	private DynamoDBMapper mapper  = customerConfig.mapper();

//	@Autowired
//	private CustomerConfig customerConfig;
//////	
//////	
//	@Autowired
//	private DynamoDBMapper mapper  = customerConfig.mapper();
//	original
	@Autowired
	private DynamoDBMapper mapper;

	
public Customer addCustomer(Customer customer) {
	
	mapper.save(customer);
	return customer;
}


public Customer findCustomerByCustomerId(String id){
	
	return mapper.load(Customer.class, id);
	
	
}


public String deleteCustomer(Customer customer){
	
	 mapper.delete(customer);
	return ("customer removed "+ customer);
}

public String editCustomer(Customer customer){
	
	 mapper.save(customer, buildExpression(customer));
	return ("customer updated "+ customer);
}

private DynamoDBSaveExpression buildExpression(Customer customer) {
	
	DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
	Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
	
	expectedMap.put("customerId", new ExpectedAttributeValue(new AttributeValue().withS(customer.getCustomerId())));
	
	dynamoDBSaveExpression.setExpected(expectedMap);
	
	return dynamoDBSaveExpression;
	
}

}
