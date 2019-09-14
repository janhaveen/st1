package com.service;

import java.util.List;

import com.pojo.Customer;
import com.pojo.PrescriptionDetails;

public interface CustomerService 
{
	public int addCustomer(Customer customer, String action);
	public List getAllCustomers();
	/*public boolean customerValidate(Customer customer);
	public void logOutCustomer(String email);*/
	public int updateCustomer(Customer customer, String action);
	public void deleteCustomer(int rowNo, Customer customer);
	public List getAllOrderPrescriptionData(String clientId);
	public int addPrescriptionDetails(PrescriptionDetails prescriptiondetails);
	public  List getAllCustomerOrderData(String clientId);
	public List getCustomerOrderCardView(String orderId);
	
	public List getCutomerOrderListData(String clientId);
}
