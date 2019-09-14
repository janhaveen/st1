package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Customer;
import com.pojo.LogLogInAndLogOutTime;
import com.pojo.PrescriptionDetails;

public interface CustomerDao 
{
	public boolean addCustomer(Customer customer);
	public List getAllCustomers();
	/*public List<Customer> customerValidate(Customer customer);*/
	/*public void loginlog(LogLogInAndLogOutTime logTime);*/
     public boolean updateCustomer(Customer customer);
/*	public void logOutCustomer(String email);*/
	public void deleteCustomer(int rowNo, Customer customer);
	public boolean checkContactNo(long contactNo);
	public boolean checkGSTNo(String gstNo);
	public boolean checkUpdateContactNo(long contactNo, int rowNo);
	public boolean checkUpdateGSTNo(String gstNo, int rowNo);
	public List getAllPrescriptionData(String clientId);
	public boolean addPrescriptionDetails(PrescriptionDetails prescriptiondetails);
	public List getAllCustomerOrderData(String clientId);
	public List getCustomerCardView(String orderId);
	public List getAllCustomerOrderListData(String clientId);

}
