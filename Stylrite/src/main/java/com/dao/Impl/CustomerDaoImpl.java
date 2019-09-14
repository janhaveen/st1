package com.dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.CustomerDao;
import com.pojo.Customer;
import com.pojo.LogLogInAndLogOutTime;
import com.pojo.Order;
import com.pojo.OrderCardView;
import com.pojo.PrescriptionCardView;
import com.pojo.PrescriptionDetails;
import com.service.Impl.CurrentDateTime;

@Repository("customerDaoImpl")
@Transactional
public class CustomerDaoImpl implements CustomerDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public boolean addCustomer(Customer customer)
	{
		boolean bol = false;
		
		System.out.println("cus "+customer);
		
		try
		{
			entityManager.persist(customer);
			
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
	public List<Customer> getAllCustomers() 
	{
		/*
		 * Query q = entityManager.createQuery("from Customer",Customer.class); List
		 * listCustomers = q.getResultList(); return listCustomers;
		 */
		
		return entityManager.createQuery("select cust from Customer cust where cust.isdeleted='0' ",Customer.class).getResultList();
		
	}
	
	  /*@Override 
	  public List<Customer> customerValidate(Customer customer) 
	  {
		
		  List<Customer> list = entityManager.createQuery("Select cust from Customer cust where cust.email='"+customer.getEmail()+"' and cust.password='"+customer.getPassword()+"'").getResultList();
		  
		  return list;
		  
	  }
	  */
	  /*@Override
	  public void loginlog(LogLogInAndLogOutTime logTime)
	  {
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
	  }*/

	@Override
	public boolean updateCustomer(Customer customer)
	{
		//entityManager.merge(customer);
		
		boolean bool =false;
		
		try
		{
			long alt = String.valueOf(customer.getAlternateContactNo()) == ""?null:customer.getAlternateContactNo();
			
			String hql = "UPDATE Customer cust set cust.alternateContactNo ='"+alt+"',cust.companyName='"+customer.getCompanyName()+ "',"
					+ "cust.customerName ='"+customer.getCustomerName()+"',cust.contactNo='"+customer.getContactNo()+"',cust.email='"+customer.getEmail()+"',"
					+ "cust.gstNo ='"+customer.getGstNo()+"',cust.location ='"+customer.getLocation()+"',cust.source='"+customer.getSource()+"', "
					+ "cust.state='"+customer.getState()+"', cust.updatedBy='"+customer.getUpdatedBy()+"',cust.updatedOn='"+customer.getUpdatedOn()+"' where cust.rowNo="+customer.getRowNo();
				
			System.out.println("Query"+hql);
					
			javax.persistence.Query query = entityManager.createQuery(hql);
				
			
			int i=query.executeUpdate();
					
			System.out.println("Iffected Row in Task Modified-->"+i);
			
			bool = true;
		}
		catch (Exception e) 
		{
			bool = false;
			
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public void deleteCustomer(int rowNo, Customer customer)
	{
		String hql = "UPDATE Customer cust set cust.isdeleted='1', cust.updatedBy='"+customer.getUpdatedBy()+"',cust.updatedOn='"+customer.getUpdatedOn()+"' where cust.rowNo="+rowNo;
			
		System.out.println("Query"+hql);
				
		javax.persistence.Query query = entityManager.createQuery(hql);
				
		int i=query.executeUpdate();
				
		System.out.println("Task Modified-->"+i);
	}

	/*@Override
	public void logOutCustomer(String email)
	{
		try 
		{
			
			  String hql ="UPDATE LogLogInAndLogOutTime lg set lg.logOut ='"+CurrentDateTime.CurrentTime()+"',lg.reasonOfLogOut='manual' where lg.email="+email;
			  
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
*/
	@Override
	public boolean checkContactNo(long contactNo) 
	{
			boolean bol = false;
		
		    List list = new ArrayList();
		
		    String query1 = "select cust.contactNo from Customer cust where cust.contactNo="+contactNo+"";
			
			Query q = entityManager.createQuery(query1);

			list = q.getResultList();
	 		
			System.out.println("load........."+list);
			
			if(list.size() == 0)
			{
				bol=true;
			}
			return bol;

	}

	@Override
	public boolean checkGSTNo(String gstNo)
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select cust1.gstNo from Customer cust1 where cust1.gstNo='"+gstNo+"'";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean checkUpdateContactNo(long contactNo, int rowNo) 
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select cust.contactNo from Customer cust where cust.contactNo="+contactNo+" and cust.rowNo="+rowNo+"";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean checkUpdateGSTNo(String gstNo, int rowNo) 
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select cust1.gstNo from Customer cust1 where cust1.gstNo='"+gstNo+"' and cust1.rowNo="+rowNo+"";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;

	}

	@Override
	public List<PrescriptionCardView> getAllPrescriptionData(String clientId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select prescription from PrescriptionCardView prescription  where prescription.clientId='"+clientId+"'",PrescriptionCardView.class).getResultList();
	}

	@Override
	public boolean addPrescriptionDetails(PrescriptionDetails prescriptiondetails) {
boolean bol = false;
		
		System.out.println("prescption is "+prescriptiondetails);
		
		try
		{
			entityManager.persist(prescriptiondetails);
			
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
	public List<OrderCardView> getAllCustomerOrderData(String clientId)
	{
		// TODO Auto-generated method stub
		return entityManager.createQuery("select ordercardview from OrderCardView ordercardview where ordercardview.CustomerId='"+clientId+"'and ordercardview.orderStatus='Pending'",OrderCardView.class).getResultList();
	}

	@Override
	public List<OrderCardView> getCustomerCardView(String orderId)
	{
		// TODO Auto-generated method stub
		return entityManager.createQuery("select ordercardview from OrderCardView ordercardview where ordercardview.orderId='"+orderId+"'",OrderCardView.class).getResultList();
	}

	@Override
	public List getAllCustomerOrderListData(String clientId)
	{
		// TODO Auto-generated method stub
		return entityManager.createQuery("select ordercardview from OrderCardView ordercardview where ordercardview.CustomerId='"+clientId+"'",OrderCardView.class).getResultList();
	}
}
	