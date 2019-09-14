package com.service;

import java.util.List;

import com.pojo.Customer;
import com.pojo.Employee;
import com.pojo.Jobs;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.OrderLensItem;
import com.pojo.PrescriptionDetails;

public interface OrderService 
{
	public int addOrder(Order order, String action);

	public List getAllOrder();

	public List getAllCustomerInfo( long mobileno);

	public int addNewCustomer(Customer customer);

	public List checkScanBarcode(String barcode);

	public int addNewGRNItem(OrderItem orderItemData, String barcodeValue, String statusBarcode);

	public List checkScanBarcodeStockOut(String barcode);

	public List getAllOrderProductView(String orderId);

	public int addNewOrderJobsVendor(Jobs jobs);

	public int addPrescriptionDetails(PrescriptionDetails prescription);

	public int addNewOrderLenseItemData(OrderLensItem oLensItem);
	
	public List getAllPrescriptionList(String customerId);
}