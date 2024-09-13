package com.inOneminute.rest.webservices.restful_web_services.models;


public class Employee extends EmployeeData{
	
	private int Id;
	private String Name;
	private String Surname;
	private String Role;
	private String Position;
	private String Salary;
	private String Years;
	
	
	public Employee() {}

	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getSurname() {
		return Surname;
	}


	public void setSurname(String surname) {
		Surname = surname;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	public String getPosition() {
		return Position;
	}


	public void setPosition(String position) {
		Position = position;
	}


	public String getSalary() {
		return Salary;
	}


	public void setSalary(String salary) {
		Salary = salary;
	}


	public String getYears() {
		return Years;
	}


	public void setYears(String years) {
		Years = years;
	}


	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", Role=" + Role + ", Position=" + Position
				+ ", Salary=" + Salary + ", Years=" + Years + "]";
	}
}
