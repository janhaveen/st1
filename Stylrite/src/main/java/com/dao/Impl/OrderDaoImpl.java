package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.EmployeeDao;
import com.dao.OrderDao;
import com.pojo.Customer;
import com.pojo.Employee;
import com.pojo.EmployeeListView;
import com.pojo.Jobs;
import com.pojo.Legend;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.OrderLensItem;
import com.pojo.OrderListView;
import com.pojo.PrescriptionCardView;
import com.pojo.PrescriptionDetails;
import com.pojo.ProductBasedBarcodeListView;
import com.service.Impl.CurrentDateTime;


@Repository("orderDaoImpl")
@Transactional
public class OrderDaoImpl implements OrderDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public boolean addOrder(Order order) 
	{
		boolean bol = false;
		
		try
		{
			entityManager.persist(order);
			
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
	public List getAllOrder() 
	{
		return entityManager.createQuery("select ord from Order ord",Order.class).getResultList();
	}

	@Override
	public List<Customer> getAllCustomerInfo(long mobileno) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select cust from Customer cust where cust.contactNo='"+mobileno+"'",Customer.class).getResultList();
	}
/*
	@Override
	public boolean checkCustomerNumber(long contactNo) {
		boolean bol = false;
		
	    List list = new ArrayList();
	
	    String query1 = "select cust.contactNo from Customer cust where cust.contactNo="+contactNo+"";
	    System.out.println("query of customer"+query1);
		
		Query q = entityManager.createQuery(query1);

		list = q.getResultList();
 		
		System.out.println("load111........."+list);
		
		if(list.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean addNewCustomer(Customer customer) {
         boolean bol = false;
		System.out.println("new Customer in order.... "+customer);
		
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
	}*/

	@Override
	public boolean addNewCustomer(Customer customer)
	{
		boolean bol = false;
		
		System.out.println("new insertion customer....."+customer);
		
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
	public List checkScanBarcode(String barcode)
	{
		return entityManager.createQuery("select pbl from ProductBasedBarcodeListView pbl where pbl.barcode='"+barcode+"'",ProductBasedBarcodeListView.class).getResultList();
	}

	@Override
	public boolean addNewGRNItem(OrderItem orderItemData)
	{
		boolean bol = false;
		
		System.out.println("orderItemData.... "+orderItemData);
		
		try
		{
			entityManager.persist(orderItemData);
			
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
	public boolean updateBarcodeStatus(String statusBarcode, String barcodeValue) 
	{
		boolean bool =false;
		
		try
		{
			String hql = "UPDATE CreateBarCode cb set cb.status='"+statusBarcode+"', cb.stockOutDate='"+CurrentDateTime.CurrentTimestamp()+"', cb.updatedOn='"+CurrentDateTime.CurrentTimestamp()+"' where cb.rowId='"+barcodeValue+"'";
			
			System.out.println("Query"+hql);
					
			javax.persistence.Query query = entityManager.createQuery(hql);
				
			
			int i=query.executeUpdate();
					
			System.out.println("staus update of barcode-->"+i);
			
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
	public List checkScanBarcodeStockOut(String barcode) 
	{
		return entityManager.createQuery("select pbl from ProductBasedBarcodeListView pbl where pbl.barcode='"+barcode+"' and pbl.status='In'",ProductBasedBarcodeListView.class).getResultList();
	}

	@Override
	public List getAllOrderProducView(String orderId)
	{
		return entityManager.createQuery("select orderproductview from OrderListView orderproductview where orderproductview.orderId='"+orderId+"'",OrderListView.class).getResultList();
	}

	@Override
	public boolean addNewOrderJobsVendor(Jobs jobs) 
	{
		boolean bol = false;
		
		try
		{
			entityManager.persist(jobs);
			
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
	public boolean addPrescriptionDetails(PrescriptionDetails prescription)
	{
		boolean bol = false;
	   
		System.out.println("Prescription Details.... "+prescription);
		
		try
		{
			entityManager.persist(prescription);
			
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
	public boolean addNewOrderLenseItemData(OrderLensItem oLensItem)
	{
		boolean bol = false;
		   
		System.out.println("OrderLensItem Details.... "+oLensItem);
		
		try
		{
			entityManager.persist(oLensItem);
			
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
	public List<PrescriptionCardView> getAllPrescriptionList(String customerId) 
	{
		// TODO Auto-generated method stub
		return entityManager.createQuery("select pdetails from PrescriptionCardView pdetails where pdetails.clientId='"+customerId+"'",PrescriptionCardView.class).getResultList();
	}

}