package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.pojo.Employee;
import com.pojo.LogLogInAndLogOutTime;
import com.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	//HttpSession session;
	
	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) 
	{
		this.employeeDao = employeeDao;
	}

	@Override
	public int addEmployee(Employee employee, String action) 
	{
		boolean bol = false;
		
		int status = 0;
		
		employee.setRowId(UUID.randomUUID().toString());
		
		employee.setPassword("pass123");
		
		employee.setIsdeleted("0");
		
		employee.setCreatedBy(employee.getFirstName()+ " "+employee.getLastName());
		
		employee.setCreatedOn(CurrentDateTime.CurrentTime());
		
		bol = employeeDao.addEmployee(employee);
		
		if(bol)
		{
			status = 301;
		}
		else
		{
			status = 302;
		}
		
		return status;
	}

	@Override
	public List getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}

	

	@Override
	public boolean employeeValidate(Employee employee) {
		boolean b=false;
		
		List<Employee> list=employeeDao.employeeValidate(employee);
		
		if(list.size()==0) {
			b=false;
		}
		
		else {
			
			Employee emp=new Employee();
			emp=list.get(0);
			LogLogInAndLogOutTime logTime = new LogLogInAndLogOutTime();
			logTime.setEmployeeId(emp.getRowNo());
			logTime.setEmailId(emp.getEmailId());
			logTime.setLogIn(CurrentDateTime.CurrentTime()); 
			logTime.setTypeOfLogIn("manual");
			 if(!employee.equals(null))
			  {
				 employeeDao.loginlog(logTime);
				  
				  b = true; 
			  }
			  
			
		}
		return b;
		
		}

	@Override
	public void logOutEmployee(String email) {
		employeeDao.logOutEmployee(email);
		
	}
	
	
}
