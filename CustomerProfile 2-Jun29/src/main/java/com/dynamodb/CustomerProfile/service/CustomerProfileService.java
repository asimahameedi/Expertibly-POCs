package com.dynamodb.CustomerProfile.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.amazonaws.services.dynamodbv2.document.GetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.dynamodb.CustomerProfile.bean.CustomerProfile;
import com.dynamodb.CustomerProfile.constant.AppConstant;
import com.dynamodb.CustomerProfile.repo.CustProfileRepo;





public class CustomerProfileService {
	
	@Autowired
	CustProfileRepo custProfileRepo;
	
	public void createTable(String tableName)  throws Exception{
		
		if (custProfileRepo.getCustomerProfileTable(tableName)==null)
		
		custProfileRepo.createCustomerProfileTable();
		
	}

	
	
	public void deleteTable(String tableName ) throws Exception {
		
		custProfileRepo.deleteCustomerProfileTable(tableName);
		
	}

	public  void saveCustomerProfile(CustomerProfile custProfile) throws Exception {
		// TODO Auto-generated method stub
		
		createTable(AppConstant.CUSTPROFILE);
		Table table = custProfileRepo.getCustomerProfileTable(AppConstant.CUSTPROFILE);
		
		try {
			String id = UUID.randomUUID().toString();
			System.out.println("id: " + id);
			PutItemOutcome outcome = table.putItem(new Item()
					.withPrimaryKey("id", id)
					.with("name", custProfile.getName())
					.with("specialty", custProfile.getSpecialty())
					.with("membershipStatus", custProfile.getMembershipStatus()));
			System.out.println("PutItem succeeded:\n" +outcome.getPutItemResult());
	
		}catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
//	public  ResponseEntity<CustomerProfile> getCustomerProfile(String  uuid, String name) {
	public  CustomerProfile getCustomerProfile(String  uuid, String name) {
		
		
		CustomerProfile customerProfile = null;
		Table table = custProfileRepo.getTable(AppConstant.CUSTPROFILE);
		if (table!=null) {
			GetItemSpec spec = new GetItemSpec().withPrimaryKey("id", uuid, "name", name);
			try {
				System.out.println("attempting to read the item... ");
				Item outcome = table.getItem(spec);
				if (outcome != null) {
					 customerProfile=new CustomerProfile();
					 customerProfile.setId(outcome.getString("id"));
					 customerProfile.setName(outcome.getString("name"));
					 customerProfile.setSpecialty(outcome.getString("specialty"));
					 customerProfile.setMembershipStatus(outcome.getString("membershipStatus"));
					 
				}
				System.out.println("GetItem Succeeded... ");
				
				
			}catch (Exception e) {
				System.out.println("Unable to read Item"  + uuid);
				System.out.println(e.getMessage());
				
			}
		}
		return customerProfile;
		
	}

public List<CustomerProfile> getAllCustomerProfiles() throws Exception{
	
//	ScanSpec scanSpec = new ScanSpec();
//	List<CustomerProfile> allCustomerProfiles = new ArrayList<>();
//	
//	ItemCollection<ScanOutcome> items = null;
//	Table table = custProfileRepo.getTable(AppConstant.CUSTPROFILE);
//	if (table!=null) {
//		
//		
//		
//		items = table.scan ( 
//		         null,                                  //FilterExpression 
//		         "id, name, specialty, membershipStatus",     //ProjectionExpression 
//		         null,                                           //No ExpressionAttributeNames  
//		         null);
//		
//		
//	}
//	  
//	Iterator<Item>  it = items.iterator();
//	while (it.hasNext()) { 
//		
//		allCustomerProfiles.addAll(items);
//        System.out.println(it.next().toJSONPretty()); 
//     } 
//	
	
	return null;
	
}

	public void updateCustomerProfile(String id, String name, String specialty, String membershipStatus) {
		// TODO Auto-generated method stub
		
	}



	public void deleteCustomerProfile(String id, String name) {
		// TODO Auto-generated method stub
		
		
		
	}



	
	
	

}
