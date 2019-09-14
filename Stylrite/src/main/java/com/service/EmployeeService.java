package com.service;

import java.util.List;

import com.pojo.Employee;

public interface EmployeeService 
{
	public int addEmployee(Employee employee, String action);

	public List getAllEmployees();

	public boolean employeeValidate(Employee employee);

	public void logOutEmployee(String email);
}
