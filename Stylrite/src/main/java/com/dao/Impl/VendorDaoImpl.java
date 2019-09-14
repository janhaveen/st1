package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.VendorDao;
import com.pojo.Vendor;

@Repository("vendorDaoImpl")
@Transactional
public class VendorDaoImpl implements VendorDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public boolean addVendor(Vendor vendor)
	{
		boolean bol = false;
		
		System.out.println("ven "+vendor);
		
		try
		{
			entityManager.persist(vendor);
			
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
	public List<Vendor> getAllVendors()
	{
		/*
		 * Query q = entityManager.createQuery("from Customer",Customer.class); List
		 * listCustomers = q.getResultList(); return listCustomers;
		 */
		
		return entityManager.createQuery("select vendor from Vendor vendor where vendor.isdeleted='0' ",Vendor.class).getResultList();
		
	}

	
	  @Override public List<Vendor> vendorValidate(Vendor vendor) 
	  {
		
		  List<Vendor> list = entityManager.createQuery("Select cust from Customer cust where cust.email='"+vendor.getEmail()+"' and cust.password='"+vendor.getPassword()+"'").getResultList();
		  
		  return list;
		  
	  }
	 

	@Override
	public Vendor getVendorById(int id) 
	{
		Vendor vendor = entityManager.find(Vendor.class, id);
		return vendor;
	}

	@Override
	public List<Vendor> getVendorByEmail(String email) 
	{
		List<Vendor> list = entityManager.createQuery("Select cust from d_customer cust where list.email='"+email+"'").getResultList();
		
		return list;
	}

	@Override
	public boolean updateVendor(Vendor vendor)
	{
		//entityManager.merge(customer);
		boolean bool =false;
		
		try
		{
			 String hql = "UPDATE Vendor vendor set vendor.alternateContactNo ='"+vendor.getAlternateContactNo()+"',vendor.companyName='"+vendor.getCompanyName()+ "',"+"vendor.vendorName ='"+vendor.getVendorName()+"',vendor.contactNo='"+vendor.getContactNo()+"',vendor.email='"+vendor.getEmail()+"'," +"vendor.gstNo ='"+vendor.getGstNo()+"',vendor.location ='"+vendor.getLocation()+"', " +"vendor.state='"+vendor.getState()+"', vendor.updatedBy='"+vendor.getUpdatedBy()+"',vendor.updatedOn='"+vendor.getUpdatedOn()+"' where vendor.rowNo="+vendor.getRowNo();
			  
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
	public boolean deleteVendor(int rowNo, Vendor vendor)
	{
		boolean bol = false;
		try
		{
			String hql = "UPDATE Vendor ven set ven.isdeleted='1', ven.updatedBy='"+vendor.getUpdatedBy()+"',ven.updatedOn='"+vendor.getUpdatedOn()+"' where ven.rowNo="+rowNo;
			
			System.out.println("Query"+hql);
					
			javax.persistence.Query query = entityManager.createQuery(hql);
					
			int i=query.executeUpdate();
					
			System.out.println("Task Modified-->"+i);
			
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
	public boolean checkVendorContactNo(long contactNo) 
	{
		boolean bol = false;
		
	    List list = new ArrayList();
	
	    String query1 = "select ven.contactNo from Vendor ven where ven.contactNo="+contactNo+"";
		
		Query q = entityManager.createQuery(query1);

		list = q.getResultList();
 		
		System.out.println("load23........."+list);
		
		if(list.size() == 0)
		{
			bol=true;
		}
		
		return bol;
	}

	@Override
	public boolean checkVendorGSTNo(String gstNo) 
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select ven1.gstNo from Vendor ven1 where ven1.gstNo='"+gstNo+"'";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load12........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean checkUpdateVendorContactNo(long contactNo, int rowNo) 
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select ven2.contactNo from Vendor ven2 where ven2.contactNo="+contactNo+" and ven2.rowNo="+rowNo+"";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load57........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean checkUpdateVendorGSTNo(String gstNo, int rowNo)
	{
		boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select ven3.gstNo from Vendor ven3 where ven3.gstNo='"+gstNo+"' and ven3.rowNo="+rowNo+"";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load87........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;
	}

}
	