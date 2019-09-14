package org.service;

import java.util.List;

import org.dao.CustomerDao;
import org.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class CustomerService
{

	@Autowired
	private CustomerDao employeeDao;
	
	public void setEmployeedao(CustomerDao employeeDao) 
	{
		this.employeeDao = employeeDao;
	}

	public void addEmployee(EmployeePojo employeePojo) 
	{
		employeePojo.setCreatedBy(employeePojo.getName());
		
		employeePojo.setCreatedOn(CurrentDateTime.CurrentTime());
		
		employeeDao.addEmployee(employeePojo);
	}

	public List<EmployeePojo> getAllEmployees() 
	{
		
		return employeeDao.getAllEmployees();
	}
	
	public boolean validate(EmployeePojo employeePojo,String email)
	 {
		List<EmployeePojo> list = employeeDao.validate(employeePojo);
		
		if(list.size()==0) 
		{
			return false;
		}
		else
		{
			employeeDao.updateLogin(email,CurrentDateTime.CurrentTime());
			return true;
		}
		//return employeeDao.validate(employeePojo);
	 }
	
	public void logOut(String email)
	 {
		employeeDao.updateLogOut(email,CurrentDateTime.CurrentTime());
	 }

	public EmployeePojo getEmployeeById(int id) 
	{	
		return employeeDao.getEmployeeById(id);
	}
	
	public boolean getEmployeeByEmail(String email) 
	{	
		List<EmployeePojo> list = employeeDao.getEmployeeByEmail(email);
		
		if(list.size()==0) 
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public void updateEmployee(EmployeePojo employeePojo)
	{
		employeePojo.setUpdatedBy(employeePojo.getName());
		
		employeePojo.setUpdatedOn(CurrentDateTime.CurrentTime());
		
		employeeDao.updateEmployee(employeePojo);
	}

	public void deleteById(int id) 
	{
		employeeDao.deleteById(id);
	}

}
