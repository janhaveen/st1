package com.dao;

import java.util.List;

import com.pojo.Customer;
import com.pojo.Jobs;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.OrderLensItem;
import com.pojo.PrescriptionCardView;
import com.pojo.PrescriptionDetails;

public interface OrderDao 
{
	public boolean addOrder(Order order);

	public List getAllOrder();

	public List getAllCustomerInfo(long mobileno);

	public boolean addNewCustomer(Customer customer);

	public List checkScanBarcode(String barcode);

	public boolean addNewGRNItem(OrderItem orderItemData);

	public boolean updateBarcodeStatus(String statusBarcode, String barcodeValue);

	public List checkScanBarcodeStockOut(String barcode);

	public List getAllOrderProducView(String orderId);

	public boolean addNewOrderJobsVendor(Jobs jobs);

	public boolean addPrescriptionDetails(PrescriptionDetails prescription);

	public boolean addNewOrderLenseItemData(OrderLensItem oLensItem);

	public List<PrescriptionCardView> getAllPrescriptionList(String customerId);

}