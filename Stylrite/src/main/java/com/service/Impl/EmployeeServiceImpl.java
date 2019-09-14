package com.service.Impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.pojo.Employee;
import com.pojo.LogLogInAndLogOutTime;
import com.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	HttpSession session;
	
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
		
		employee.setPassword("pass123");
		
		employee.setIsdeleted("0");
		
		employee.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		
		employee.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
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
	public List getLegendList() 
	{
		return employeeDao.getLegendList();
	}

	@Override
	public boolean employeeValidate(Employee employee) 
	{
		boolean b=false;
		
		List<Employee> list=employeeDao.employeeValidate(employee);
		
		if(list.size()==0) 
		{
			b=false;
		}
		
		else
		{
			for(Employee emp : list)
			{
				session.setAttribute("userId", emp.getUserId());
				session.setAttribute("emailId", emp.getEmailId());
				session.setAttribute("password", emp.getPassword());
				session.setAttribute("empName", emp.getFirstName()+" "+emp.getLastName());
				session.setAttribute("department", emp.getDepartment());
				session.setAttribute("designation", emp.getDesignation());
				session.setAttribute("birthDate", emp.getBirthDate());
				session.setAttribute("mobileNo", emp.getMobileNo());
				session.setAttribute("UserId", emp.getUserId());
			}
			
			Employee emp=new Employee();
			emp=list.get(0);
			/*
			 * LogLogInAndLogOutTime logTime = new LogLogInAndLogOutTime();
			 * logTime.setEmployeeId(emp.getRowNo()); logTime.setEmailId(emp.getEmailId());
			 * logTime.setLogIn(CurrentDateTime.CurrentTime());
			 * logTime.setTypeOfLogIn("manual");
			 */
			 if(!employee.equals(null))
			  {
				// employeeDao.loginlog(logTime);
				  
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
