package com.ws.test;

public class Employee {
 private String empName;
 private String address;
public String getAddress() {
	address = "3400 N Wallis St, Bentonville AR 72712.$";
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Employee(){}
public Employee(String loginName){}
public String getEmpName() {
	//
	empName =  "Andrew Rogers.$";
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}
 
}
