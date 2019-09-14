package com.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.EmployeeDao;
import com.pojo.Customer;
import com.pojo.Employee;
import com.pojo.EmployeeListView;
import com.pojo.Legend;
import com.pojo.LogLogInAndLogOutTime;
import com.service.Impl.CurrentDateTime;


@Repository("employeeDaoImpl")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao
{
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;

	@PersistenceContext(unitName="demoRestPersistenceLegacy")
	private EntityManager entityManagerLegacy;
	/*@PersistenceContext
	private EntityManager entityManager;
	*/
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public boolean addEmployee(Employee employee)
	{
		boolean bol = false;
		
		System.out.println("employee.... "+employee);
		
		try
		{
			entityManager.persist(employee);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public List getAllEmployees()
	{
		return entityManager.createQuery("select empListView from EmployeeListView empListView",EmployeeListView.class).getResultList();
	}

	

	@Override
	public List<Employee> employeeValidate(Employee employee) {
		List<Employee> list=entityManager.createQuery("Select emp from Employee emp where emp.emailId='"+employee.getEmailId()+"'and emp.password='"+employee.getPassword()+"'").getResultList();
        	System.out.println("list of employee Login"+list);
		  
		  return list;
	}

	@Override
	public void loginlog(LogLogInAndLogOutTime logTime) {
		  boolean bool =false;
			
			try 
			{
				entityManager.persist(logTime);
				
				bool = true;
		    }
		    catch (Exception e)
			{
		       e.printStackTrace();
			} 
		
	}

	@Override
	public void logOutEmployee(String email) {
		try 
		{
			
			  String hql ="UPDATE LogLogInAndLogOutTime lg set lg.logOut ='"+CurrentDateTime.CurrentTime()+"',lg.reasonOfLogOut='manual' where lg.emailId='"+email+"'";
			  
			  System.out.println("Query of login and logout"+hql);
			  
			  javax.persistence.Query query = entityManager.createQuery(hql);
			  
			  
			  int i=query.executeUpdate();
			  
			  System.out.println("Iffected Row in Task Modified-->"+i);
			 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
		