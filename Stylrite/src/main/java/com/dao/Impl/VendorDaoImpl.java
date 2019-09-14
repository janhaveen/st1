package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.VendorDao;
import com.pojo.DetailedVendorAddress;
import com.pojo.DetailedVendorContactPerson;
import com.pojo.DetailedVendorInfo;
import com.pojo.Vendor;
import com.pojo.VendorAddress;
import com.pojo.VendorContactPerson;

@Repository("VendorDaoImpl")
@Transactional
public class VendorDaoImpl  implements VendorDao
{
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
    {
        this.entityManager = entityManager;
    }

	@Override
	public boolean addVendor(Vendor vendor) {
        boolean bol = false;
        System.out.println("vendor"+vendor);
        
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
	public boolean addVendorAddress(VendorAddress vaddress) {
        boolean bol = false;
        
        System.out.println("VendorAddress"+vaddress);
        
        try
        {
            entityManager.persist(vaddress);
            
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
	public boolean addVendorContactPerson(VendorContactPerson vperson) {
        boolean bol = false;
        
        System.out.println("VendorContactPerson"+vperson);
        
        try
        {
            entityManager.persist(vperson);
            
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
	public List getAllVendorList() {
		// TODO Auto-generated method stub
		 return entityManager.createQuery("select detailvendorInfo from DetailedVendorInfo detailvendorInfo where detailvendorInfo.isDeleted='0' ",DetailedVendorInfo.class ).getResultList();
	}

	@Override
	public List getAllVendorAddressList(String vendorId) {
		// TODO Auto-generated method stub
		   return entityManager.createQuery("select detailedvaddress from DetailedVendorAddress detailedvaddress where detailedvaddress.vendorId='"+vendorId+"' and detailedvaddress.isDeleted='0'",DetailedVendorAddress.class).getResultList();
	}

	@Override
	public List getAllVendorContactPerson(String vendorId) {
		// TODO Auto-generated method stub
		 return entityManager.createQuery("select detailedvcp from DetailedVendorContactPerson detailedvcp where detailedvcp.vendorId='"+vendorId+"' and detailedvcp.isDeleted='0' ",DetailedVendorContactPerson.class).getResultList();
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
        boolean b1=false;
        try {
        String hql="update Vendor vendor set vendor.companyName='"+vendor.getCompanyName()+"',vendor.location='" + vendor.getLocation() + "',"
                + "vendor.vendorType='"+vendor.getVendorType()+"',vendor.source='"+vendor.getSource()+"',"
                + "vendor.referenceBy='"+vendor.getReferenceBy()+"',vendor.creditTime='"+vendor.getCreditTime()+"',"
                + "vendor.creditLimit='"+vendor.getCreditLimit()+"'where vendor.rowId='"+vendor.getRowId()+"'";
        
         System.out.println("update VendorDetails" + vendor);
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         System.out.println("affected row" + i);
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }
     return b1;
    }
	
	@Override
	public boolean updateIsDefaultOfVendorAddress(String vendorId) {
		boolean bool = false;
		try
		{
			String hql="update VendorAddress Vaddress set Vaddress.isDefault='0' where Vaddress.vendorId='"+vendorId+"'";
			
			 System.out.println("VendorAddressDetails" + hql);
			 
	         Query q = entityManager.createQuery(hql);
	         
	         int i = q.executeUpdate();
	         
	         System.out.println("affected row" + i);
	         
	         bool = true;
	         
		}
		catch (Exception e)
		{
	         e.printStackTrace();
	         
	         bool = false;
		}

     return bool;
     
	}
	@Override
	public boolean updateIsDefaultOfVendorContactPerson(String vendorId) {

		boolean bool = false;
		try
		{
			String hql="update VendorContactPerson vperson set vperson.isDefault='0' where vperson.vendorId='"+vendorId+"'";
			
			 System.out.println("VendorContactPerson" + hql);
			 
	         Query q = entityManager.createQuery(hql);
	         
	         int i = q.executeUpdate();
	         
	         System.out.println("affected row" + i);
	         
	         bool = true;
	         
		}
		catch (Exception e)
		{
	         e.printStackTrace();
	         
	         bool = false;
		}

     return bool;
     
	
	}
    
	 @Override
	    public boolean updateVendorAddressDetails(VendorAddress vaddress) {
	        boolean b1=false;
	        try {
	        String hql="update VendorAddress vaddress set vaddress.branchName='"+vaddress.getBranchName()+"',vaddress.contactNo='" + vaddress.getContactNo() + "',"
	                + "vaddress.addressLine1='"+vaddress.getAddressLine1()+"',vaddress.addressLine2='"+vaddress.getAddressLine2()+"',"
	                + "vaddress.ledgerName='"+vaddress.getLedgerName()+"',vaddress.location='"+vaddress.getLocation()+"',"
	                + "vaddress.city='"+vaddress.getCity()+"',vaddress.state='"+vaddress.getState()+"',"
	                + "vaddress.gstNo='"+vaddress.getGstNo()+"',vaddress.pincode='"+vaddress.getPincode()+"',vaddress.isDefault='"+vaddress.getIsDefault()+"' where vaddress.rowId='"+vaddress.getRowId()+"'";
	        
	         System.out.println("update VendorAddressDetails" + vaddress);
	         Query q = entityManager.createQuery(hql);
	         int i = q.executeUpdate();
	         System.out.println("affected row" + i);
	         b1 = true;
	     } catch (Exception e) {
	         e.printStackTrace();
	         b1 = false;
	     }
	     return b1;
	    }
	    @Override
	    public boolean updateVendorContactDetail(VendorContactPerson vperson) {
	        boolean b1=false;
	        try {
	        String hql="update VendorContactPerson vperson set vperson.firstName='"+vperson.getFirstName()+"',vperson.lastName='" + vperson.getLastName() + "',"
	                + "vperson.contactNo='"+vperson.getContactNo()+"',vperson.altContactNo='"+vperson.getAltContactNo()+"',"
	                + "vperson.emailId='"+vperson.getEmailId()+"',vperson.department='"+vperson.getDepartment()+"',"
	                + "vperson.designation='"+vperson.getDesignation()+"',vperson.birthdate='"+vperson.getBirthdate()+"',"
	                + "vperson.location='"+vperson.getLocation()+"',vperson.isDefault='"+vperson.getIsDefault()+"' where vperson.rowId='"+vperson.getRowId()+"'";
	        
	         System.out.println("updateVendorContactDetail" + vperson);
	         Query q = entityManager.createQuery(hql);
	         int i = q.executeUpdate();
	         System.out.println("affected row" + i);
	         b1 = true;
	     } catch (Exception e) {
	         e.printStackTrace();
	         b1 = false;
	     }
	     return b1;
	    }
	    @Override
		public boolean addNewVendorContactPersonDetails(VendorContactPerson vperson) {
			 boolean bol = false;
				
				System.out.println("vendorContactPerson"+vperson);
				
				try
				{
					entityManager.persist(vperson);
					
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
		public boolean addNewVendorAddressDetails(VendorAddress vaddress) {
	          boolean bol = false;
			
			System.out.println("vendorAddress"+vaddress);
			
			try
			{
				entityManager.persist(vaddress);
				
				bol = true;
			}
			catch (Exception e) 
			{
				bol = false;
				
				e.printStackTrace();
			}
			
			return bol;
		}
}
