package com.inOneminute.rest.webservices.restful_web_services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	//GET
	//URI - /hello-world
	//method - "hello world"
	
	//@RequestMapping(method=RequestMethod.GET, path = "/")
	@GetMapping(path="/")
	public String menu() {
		return "Welcome";
	}
	
//	@GetMapping(path = "/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	
	@GetMapping(path = "/hello-world")
	public HelloWorldBean helloWorldBean() throws Exception {
		
		//throw new Exception("Some Error has happened, contact support @081828218923");
		return new HelloWorldBean("Hello World"); 	
	}
	
	///hello-world/path-variable/Odwa
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
