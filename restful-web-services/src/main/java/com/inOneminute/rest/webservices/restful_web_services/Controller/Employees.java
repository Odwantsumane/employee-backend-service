package com.inOneminute.rest.webservices.restful_web_services.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inOneminute.rest.webservices.restful_web_services.Service.EmployeeService;
import com.inOneminute.rest.webservices.restful_web_services.models.Employee;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Employees {
	
	//private ArrayList<Employee> EmployeeList;
	                
	@Autowired	
	private EmployeeService employeeService;
	
	Employees(){}
	 
	@SuppressWarnings("static-access")
	@GetMapping("/AllEmployees")
	public ArrayList<Employee> AllEmployees() {
		
		return employeeService.getAllEmployees();
	}
	
	@SuppressWarnings("static-access")
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		
		return employeeService.getEmployee(id);
	}
	
	@SuppressWarnings("static-access")
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		
		
		Employee newEmployee = employeeService.addEmployee(employee.getId(),(float)employee.getHoursWorked(),
				employee.getName(),employee.getSurname(),employee.getYears(),employee.getPosition(),employee.getRole(),employee.getSalary());
		//return employeeService.getEmployee(1);
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
	}
	
	@SuppressWarnings("static-access")
	@PutMapping("/updateEmployeeHours/{id}/{hours}/{today}/{countDay}")
	public ResponseEntity<String> updateHours(@PathVariable int id,@PathVariable float hours, 
			@PathVariable String today, @PathVariable int countDay) {
		
		if(!employeeService.updateEmployeeHours(id, hours, today.toLowerCase(), countDay)) return new ResponseEntity<String>("Employee not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String>(String.format("Employee %s with hours %2f has been successfully updated", employeeService.getEmployee(id).getName(), hours), HttpStatus.OK);
	}

}
