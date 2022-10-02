package com.example.hello_world;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ApplicationConfiguration {
	@Autowired
	private welcomeService service;
	//private welcomeService service = new welcomeService();
@RequestMapping("/hello")
public String hello(){
	//return "hello world from asima";
	return service.retrieveString();
}

}
