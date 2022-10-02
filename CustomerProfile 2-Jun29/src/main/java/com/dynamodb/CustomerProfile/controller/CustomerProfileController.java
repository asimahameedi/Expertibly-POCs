package com.dynamodb.CustomerProfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import com.dynamodb.CustomerProfile.bean.*;


import com.dynamodb.CustomerProfile.bean.CustomerProfile;
import com.dynamodb.CustomerProfile.service.CustomerProfileService;

import jakarta.websocket.server.PathParam;



@RestController
public class CustomerProfileController {
	
@Autowired
CustomerProfileService customerProfileService;


@PostMapping(value="saveCustomerProfile", consumes ="application/json")
public ResponseEntity saveCustomerProfile(@RequestBody CustomerProfile custProfile ) {
	try {
		
		customerProfileService.saveCustomerProfile(custProfile);
		return new ResponseEntity(HttpStatus.OK);
		
	}catch (Exception e) {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}


@GetMapping(value = "/getCustomerProfile", produces = "application/json")
public ResponseEntity<CustomerProfile> getCustomerProfile(@PathParam("id") String id, 
														  @PathParam("name") String name) {
	try {
		return new ResponseEntity(customerProfileService.getCustomerProfile(id, name), HttpStatus.OK);
//		return new ResponseEntity(customerProfileService.getCustomerProfile(id, name));
	} catch (Exception e) {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}


//@GetMapping(value = "/getAllCustomerProfiles", produces = "application/json")
//public List<CustomerProfile> getAllCustomerProfiles() {
////public ResponseEntity<CustomerProfile> getAllCustomerProfiles(@PathParam("id") String id, 
////														      @PathParam("name") String name) {
//	try {
//		//return new ResponseEntity(customerProfileService.getCustomerProfile(id, name), HttpStatus.OK);
//		return customerProfileService.getAllCustomerProfiles();
//	} catch (Exception e) {
//		return (List<CustomerProfile>) new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//}



@DeleteMapping(value = "/deletetable/tableName")
public ResponseEntity deleteTable(@PathParam("tableName") String tableName) {

	try {
		customerProfileService.deleteTable(tableName);
		return new ResponseEntity(HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

@PutMapping(value = "/updatecustomerprofile")
public ResponseEntity updateCustomerProfile(@PathParam("id") String id, 
											@PathParam("name") String name,
											@PathParam("specialty") String specialty, 
											@PathParam("membershipStatus") String membershipStatus) {

	try {
		customerProfileService.updateCustomerProfile(id, name, specialty, membershipStatus);

		return new ResponseEntity(HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
@DeleteMapping(value = "/deletecustomerprofile")
public ResponseEntity  deleteCustomerProfile(@PathParam("id") String id, 
											@PathParam("name") String name) {
	try {
		customerProfileService.deleteCustomerProfile(id, name);
	}
	
	return null;
	
}

@GetMapping(value = "/getCustomerProfiles")
public ResponseEntity <List<CustomerProfile>> getCustomerPofiles(){
	return 
}



}
