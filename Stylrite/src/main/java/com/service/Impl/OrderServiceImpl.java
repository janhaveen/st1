package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.pojo.Customer;
import com.pojo.Jobs;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.OrderLensItem;
import com.pojo.PrescriptionDetails;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService
{

	//HttpSession session;
	
	@Autowired
	private OrderDao ordereDao;

	public void setOrderDao(OrderDao ordereDao) 
	{
		this.ordereDao = ordereDao;
	}

	@Override
	public int addOrder(Order order, String action) 
	{
		boolean bol = false;
		
		int status = 0;
		
		
		System.out.println(order);
		
		order.setStatus("601");
		order.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
		bol = ordereDao.addOrder(order);
		
		if(bol)
		{
			status = 901;
		}
		else
		{
			status = 902;
		}
		
		return status;
	}

	@Override
	public List getAllOrder()
	{
		return ordereDao.getAllOrder();
	}

	@Override
	public List getAllCustomerInfo(long mobileno) 
	{
		return ordereDao.getAllCustomerInfo(mobileno);	
	}

	@Override
	public int addNewCustomer(Customer customer) 
	{
	      boolean bol=false;
	      int status=0;
	
	      
	      customer.setRowId(customer.getRowId());
	     customer.setContactNo(customer.getContactNo());
	     customer.setCustomerName(customer.getCustomerName());
	     customer.setEmail(customer.getEmail());
	     customer.setIsdeleted("0");
	      bol = ordereDao.addNewCustomer(customer);
			
			if(bol)
			{
				status = 12001;
			}
			else
			{
				status = 12002;
			}
			
			return status;
	}

	@Override
	public List checkScanBarcode(String barcode)
	{
		return ordereDao.checkScanBarcode(barcode);
	}

	@Override
	public int addNewGRNItem(OrderItem orderItemData, String barcodeValue, String statusBarcode)
	{
		boolean bol = false;
		
		int status = 0;
		
		
		
		bol = ordereDao.addNewGRNItem(orderItemData);
		
		if(bol)
		{
			boolean bool = false;
			
			bool = ordereDao.updateBarcodeStatus(statusBarcode, barcodeValue);
			
			if(bool)
			{
				status = 1201;
			}
			else
			{
				status = 1202;
			}
		}
		else
		{
			status = 1203;
		}
		
		return status;
	}

	@Override
	public List checkScanBarcodeStockOut(String barcode)
	{
		return ordereDao.checkScanBarcodeStockOut(barcode);
	}

	@Override
	public List getAllOrderProductView(String orderId) 
	{
		return ordereDao.getAllOrderProducView(orderId);
	}

	@Override
	public int addNewOrderJobsVendor(Jobs jobs)
	{
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			jobs.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = ordereDao.addNewOrderJobsVendor(jobs);
			
			if(bol)
			{
				status = 1301;
			}
			else
			{
				status = 1302;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	  return status;
	  
	}

	@Override
	public int addPrescriptionDetails(PrescriptionDetails prescription)
	{
		boolean bol = false;
		
		int status = 0;
		
		
		
		bol = ordereDao.addPrescriptionDetails(prescription);
		
		if(bol)
		{
			status = 150001;
		}
		else
		{
			status = 150002;
		}
		
		return status;
	}

	@Override
	public int addNewOrderLenseItemData(OrderLensItem oLensItem) 
	{
		boolean bol = false;
		
		int status = 0;
		
		
		
		bol = ordereDao.addNewOrderLenseItemData(oLensItem);
		
		if(bol)
		{
			status = 210001;
		}
		else
		{
			status = 210002;
		}
		
		return status;
	}

	@Override
	public List getAllPrescriptionList(String customerId) 
	{
		return ordereDao.getAllPrescriptionList(customerId);
	}
}