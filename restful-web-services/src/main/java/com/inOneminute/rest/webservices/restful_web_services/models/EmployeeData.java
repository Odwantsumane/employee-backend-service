package com.inOneminute.rest.webservices.restful_web_services.models;

//import java.time.LocalDate;
import com.inOneminute.rest.webservices.restful_web_services.Service.EmployeeService.datenhours;;

public class EmployeeData {
	
	class datenhourss {
		public String date;
		public String hours;
		
		datenhourss(String date, String hours){this.date=date; this.hours=hours;}
	}
	
	private float hoursWorked;
	private int countDays = 0;
	private int countWeeks = 0;
	private int countMonths = 0;
	private String day;
	private datenhours[] days = new datenhours[7];
	private datenhours[][] weeks = new datenhours[4][7];
	private datenhours[][][] Months = new datenhours[12][4][7];
	//private String[] Years;
	//private String[] Decade; 
	

	EmployeeData() {
		
	}



	public double getHoursWorked() {
		return hoursWorked;
	}



	public void setHoursWorked(float hoursWorked) {
		this.hoursWorked = hoursWorked; 
	}



	public datenhours[] getDays() {
		return days;
	}



	public void setDays(datenhours today) { 
		days[this.countDays-1] = today;
	}
	
	public void refreshDays() {
		this.days = new datenhours[7];
	}


	public datenhours[][] getWeeks() {
		return weeks;
	}



	public void setWeeks(datenhours[] days) {
		weeks[countWeeks-1] = days;
	}
	
	public void refreshWeeks() {
		this.weeks = new datenhours[4][7];
	}



	public datenhours[][][] getMonths() {
		return Months;
	}



	public void setMonths(datenhours[][] months) {
		Months[countMonths-1] = months;
	}
	
	public void refreshMonths() {
		this.Months = new datenhours[12][4][7];
	}



	public int getCountDays() {
		return countDays;
	}



	public void setCountDays(int countDays) {
		if(countDays > 7) this.countDays = 0;
		else this.countDays = countDays;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public int getCountWeeks() {
		return countWeeks;
	}



	public void setCountWeeks(int countWeeks) {
		this.countWeeks = countWeeks;
	}



	public int getCountMonths() {
		return countMonths;
	}



	public void setCountMonths(int countMonths) {
		this.countMonths = countMonths;
	}



//	public String[] getYears() {
//		return Years;
//	}



//	public void setYears(String[] years) {
//		Years = years;
//	}
	
	
}
