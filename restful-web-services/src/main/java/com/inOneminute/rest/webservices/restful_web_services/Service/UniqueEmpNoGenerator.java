package com.inOneminute.rest.webservices.restful_web_services.Service;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmpNoGenerator {
	
	private long unique = 122324;
	UniqueEmpNoGenerator () {
		 
	};
	
	public String getUniqueId() {
		unique += 1;
		return unique + "";
	}
}
