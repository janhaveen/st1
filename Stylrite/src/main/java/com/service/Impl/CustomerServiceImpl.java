package com.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.pojo.Customer;
import com.pojo.LogLogInAndLogOutTime;
import com.pojo.OrderCardView;
import com.pojo.PrescriptionDetails;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
	//HttpSession session;
	
	@Autowired
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) 
	{
		this.customerDao = customerDao;
	}

	@Override
	public int addCustomer(Customer customer, String action) 
	{
		boolean bool = false;
	
		int  status = 0;
		
		
		customer.setPassword("pass123");
		
		customer.setIsdeleted("0");
		
		customer.setCreatedBy(customer.getCustomerName());
		
		customer.setCreatedOn(CurrentDateTime.CurrentTime());
		
		if(action.equals("insertCustomer"))
		{
			boolean bol = false;
			
			bool = customerDao.checkContactNo(customer.getContactNo());
			
			System.out.println(bool+".................poa"+action);
			
			if(bool)
			{
				bol = customerDao.checkGSTNo(customer.getGstNo());
				
				if(bol)
				{
					boolean bool1= customerDao.addCustomer(customer);
					
					System.out.println(bool1+".................cusy");
					
					if(bool1)
					{
						status  = 501;
					}
					else 
					{
						status = 502;
					}
				}
				else
				{
					status = 503;
				}
				
				bool = true;
			}
			else
			{
				status = 504;
			}
		}
		
		return status;
	}

	@Override
	public List getAllCustomers()
	{
		return customerDao.getAllCustomers();
	}
	
	@Override
	public int updateCustomer(Customer customer, String action) 
	{
		boolean bool = false;
		
		boolean bool1 = false;
		
		boolean bool2 = false;
		
		boolean bool3 = false;
		
		boolean bool5 = false;
		
		boolean bool6 = false;
		
		int  status = 0;
		
		try
		{
			customer.setUpdatedBy(customer.getCustomerName());
			
			customer.setUpdatedOn(CurrentDateTime.CurrentTime());
			
			if(action.equals("updateCustomer"))
			{
				
				bool = customerDao.checkUpdateContactNo(customer.getContactNo(), customer.getRowNo());
				
				if(bool)
				{
					System.out.println("yte..........."+bool);
					
					bool2 = customerDao.checkContactNo(customer.getContactNo());
					
					if(bool2)
					{
						
						System.out.println("bool2 if........"+bool2);
						
						bool3 = customerDao.checkUpdateGSTNo(customer.getGstNo(), customer.getRowNo());
						
						if(bool3)
						{
							System.out.println("bool3 if........"+bool3);
							
							boolean bool4 = false;
							 
							bool4 = customerDao.checkGSTNo(customer.getGstNo());
							
							if(bool4)
							{
								System.out.println("bool4 if........"+bool4);
								
								bool1 = customerDao.updateCustomer(customer);
								
								if(bool1)
								{
									status  = 601;
								}
								else
								{
									status = 602;
								}

							}
							else
							{
								System.out.println("bool4 else..........."+bool4);
								
								status = 603;
							}
						}
						else
						{
							System.out.println("bool3 else........"+bool3);
							
							bool1 = customerDao.updateCustomer(customer);

							if(bool1)
							{
								status = 604;
							}
							else
							{
								status = 100;
							}

						}
					}
					else
					{
						System.out.println("bool2 else..........."+bool2);
						
						status = 605;
					}
				}
				else
				{
					System.out.println("bool else........"+bool);
					
					 bool5 = customerDao.checkUpdateGSTNo(customer.getGstNo(), customer.getRowNo());
					
					if(bool5)
					{
						System.out.println("bool5 else if........"+bool5);
						
						bool6 = customerDao.checkGSTNo(customer.getGstNo());
						
						if(bool6)
						{
							System.out.println("bool6 else if........"+bool6);
							
							bool1 = customerDao.updateCustomer(customer);

							if(bool1)
							{
								status = 606;
							}
							else
							{
								status = 200;
							}
						}
						else
						{
							System.out.println("bool6 else else........"+bool6);
							
							status = 607;
						}
					}
					else
					{
						System.out.println("bool5 else else........"+bool5);
						
						bool1 = customerDao.updateCustomer(customer);

						if(bool1)
						{
							status = 608;
						}
						else
						{
							status = 609;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public void deleteCustomer(int rowNo, Customer customer)
	{
		customer.setUpdatedBy(customer.getCustomerName());
		
		customer.setUpdatedOn(CurrentDateTime.CurrentTime());
		
		customerDao.deleteCustomer(rowNo, customer);
	}

	@Override
	public List getAllOrderPrescriptionData(String clientId) {
		PrescriptionDetails ps=new PrescriptionDetails();
		
		// TODO Auto-generated method stub
		return customerDao.getAllPrescriptionData(clientId);
	}

	@Override
	public int addPrescriptionDetails(PrescriptionDetails prescriptiondetails) {
		// TODO Auto-generated method stub
		int status=0;
		boolean b1=false;
		prescriptiondetails.setCreatedOn(timestamp);
        prescriptiondetails.setUpdatedOn(timestamp);		
		try {
			b1=customerDao.addPrescriptionDetails(prescriptiondetails);
			if(b1) {
				status=170001;
			}
			else {
				status=170002;
			}
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

	@Override
	public List getAllCustomerOrderData(String clientId) {
		// TODO Auto-generated method stub
		/*List lstfinal=null;
		List lst=customerDao.getAllCustomerOrderData(clientId);
		for(int i=0;i<lst.size();i++) {
			OrderCardView OrderCardView=new OrderCardView();
			OrderCardView=(com.pojo.OrderCardView) lst.get(i);
			OrderCardView.setCreatedOn(CurrentDateTime.timestemptostring(OrderCardView.getCreatedOn()));
			lstfinal.add(OrderCardView);
		}*/
		return customerDao.getAllCustomerOrderData(clientId);
	}

	@Override
	public List getCustomerOrderCardView(String orderId)
	{
		
		// TODO Auto-generated method stub
		return customerDao.getCustomerCardView(orderId);
	}

	@Override
	public List getCutomerOrderListData(String clientId) {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomerOrderListData(clientId);
	}


	/*@Override
	public void logOutCustomer(String email) 
	{
		customerDao.logOutCustomer(email);
	}*/

	/*@Override
	public boolean customerValidate(Customer customer)
	{
		boolean bol = false;
		
		List<Customer> list = customerDao.customerValidate(customer);
		
		if(list.size()==0) 
		{
			bol =  false;
		}
		else
		{
			
			 * for (Customer cust : list) { //System.out.println(cust.getCustomerName());
			 * 
			 * session.setAttribute("name", cust.getCustomerName()); }
			 
			
			//customerDao.updateLogin(email,CurrentDateTime.CurrentTime());
			
			//Customer LogIn Log
			Customer cous=new Customer();
			cous=list.get(0);
			LogLogInAndLogOutTime logTime = new LogLogInAndLogOutTime();
			logTime.setCustomerId(cous.getRowNo());
			logTime.setLogIn(CurrentDateTime.CurrentTime()); 
			logTime.setTypeOfLogIn("manual");
			  
			  if(!customer.equals(null))
			  {
				  customerDao.loginlog(logTime);
				  
				  bol = true; 
			  }
			  
			
		}
		
		return bol;
	}*/
}
