package com.inOneminute.rest.webservices.restful_web_services.Service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.inOneminute.rest.webservices.restful_web_services.models.Employee;

@Service
public class EmployeeService { 
	
	public static class datenhours {
		public LocalDate date;
		public float hours;
		public String day;
		
		datenhours(){}
		datenhours(LocalDate date, float hours, String day){this.date=date; this.hours=hours; this.day=day;}
	}
	
	static ArrayList<Employee> Employees = new ArrayList<>();
	static int countDays = -1;
	
	static {
		
		Employee emp0 = new Employee();
		
		emp0.setId(1);
		emp0.setName("");
		emp0.setPosition("");
		emp0.setRole("");
		emp0.setSalary("");
		emp0.setSurname("");
		emp0.setYears("");
		
		Employee emp1 = new Employee();
		emp1.setId(2);
		emp1.setName("Odwa");
		emp1.setPosition("Senior");
		emp1.setRole("Integration Engineer");
		emp1.setSalary("R30 000 - 40 000");
		emp1.setSurname("Ntsumane");
		emp1.setYears("3");
		
		Employee emp2 = new Employee();
		emp2.setId(3);
		emp2.setName("Aphelele");
		emp2.setPosition("Junior");
		emp2.setRole("Integration Engineer");
		emp2.setSalary("R30 000 - 40 000");
		emp2.setSurname("Ntsumane");
		emp2.setYears("3");
		
		Employee emp3 = new Employee();
		emp3.setId(4);
		//emp3.setDays(7.23, 0);
		emp3.setName("Andiswa");
		emp3.setPosition("Intermediate");
		emp3.setRole("Integration Engineer");
		emp3.setSalary("R30 000 - 40 000");
		emp3.setSurname("Ntsumane");
		emp3.setYears("3");
		//{'yyyy-mm-dd': hoursWorked}
		
		Employees.add(emp0);
		Employees.add(emp1);
		Employees.add(emp2);
		Employees.add(emp3);
	}
	
	EmployeeService() {}
	
	public static ArrayList<Employee> getAllEmployees() {
		
		return Employees;
	}
	
	public static Employee getEmployee(int id) {
		
		// find employee by ID
		id = id - 1;
		
		return Employees.get(id);
	}
	
	public static String[] AllEmployeeData() {
		String[] placeholder = new String[1];
		return placeholder;
	}
	
	// id will be auto-generated
	public static Employee addEmployee(int id, float hours, String name,String surname, String years, String position, String role, String salary) {
		//countDays++;
		
		//
		
		//
		Employee newEmployee = new Employee();
		
		newEmployee.setId(id);
		//newEmployee.setDays(null, countDays);//new datenhours(date, hours)
		newEmployee.setName(name);
		newEmployee.setPosition(position);
		newEmployee.setRole(role);
		newEmployee.setSalary(salary);
		newEmployee.setSurname(surname);
		newEmployee.setYears(years);
		
		//add new employee
		Employees.add(newEmployee);
		
		//
		if(countDays == 4) countDays=-1;
		
		return newEmployee;
	}
	
	public boolean updateEmployeeHours(int id, float hours, String today, int countDay) {
		//String[] days = {"Monday", "Tuesday","Wednesday","Thursday","Friday", "Saturday","Sunday"}; 
		
		//define date 
		LocalDate date = LocalDate.now(); 
		
		try {
			// get employee-byid
			Employee employee = getEmployee(id); 
			
			// employee not found
			//if (employee == null) return false;
			
			// set weeks
			if(employee.getCountDays() == 7) {
				employee.setCountWeeks(employee.getCountWeeks()+1);
				employee.setWeeks(employee.getDays());
				employee.refreshDays();
				}
			// set Months
			if(employee.getCountWeeks() == 4) {
				employee.setCountMonths(employee.getCountMonths()+1);
				employee.setMonths(employee.getWeeks());
				employee.refreshWeeks();
			}
			// set count-days
			employee.setCountDays(countDay);
			 
			// set day
			employee.setDay(today);
			
			// set hours
			employee.setHoursWorked(hours);
			
			// set days 
			employee.setDays(new datenhours(date, hours, today));
		} catch (Exception e) {
			return false;
		}
		
		
		return true;
	}

}
