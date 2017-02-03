package com.ws.test;

public class TestWebService implements EmployeeService {

	@Override
	public String getEmplyeeName(String loginname) {
		Employee emp = new Employee(loginname);
		String fullName = emp.getEmpName();
		return fullName;
	}

}
