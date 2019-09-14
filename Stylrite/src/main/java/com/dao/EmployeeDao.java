package com.dao;

import java.util.List;

import com.pojo.Employee;
import com.pojo.LogLogInAndLogOutTime;

public interface EmployeeDao 
{
	public boolean addEmployee(Employee employee);

	public List getAllEmployees();

	public List getLegendList();

	public List<Employee> employeeValidate(Employee employee);

	public void loginlog(LogLogInAndLogOutTime logTime);

	public void logOutEmployee(String email);
}
