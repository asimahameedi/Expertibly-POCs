package com.expertibly.customerprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expertibly.customerprofile.entity.Customer;
import com.expertibly.customerprofile.repository.CustomerRepo;

@SpringBootApplication
@Controller
public class CustomerProfileApplication implements CommandLineRunner{
//	@Autowired
//	private CustomerRepo repo;
	private CustomerRepo repo= new CustomerRepo();
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileApplication.class, args);
	}
	
	@PostMapping("/addCustomer/{customerId}")
	public Customer addCustomer(@RequestBody Customer customer) {
		return repo.addCustomer(customer);
		
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable String id) {
		return repo.findCustomerByCustomerId(id);
		
	}
//	
//	
////	@DeleteMapping("/deleteCustomer/{customerId}")
//	@DeleteMapping("/deleteCustomer")
//	public String deleteCustomer(@RequestBody Customer customer) {
//		return repo.deleteCustomer(customer);
//		
//	}
	
	
//	@PutMapping("/editCustomer/{customerId}")
//	@PutMapping("/editCustomer")
//	public String editCustomer(@RequestBody Customer customer) {
//		return repo.editCustomer(customer);
//		
//	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
