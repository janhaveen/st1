package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VendorDao;
import com.pojo.Vendor;
import com.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService
{

	//HttpSession session;
	
	@Autowired
	private VendorDao vendorDao;
	
	public void setVendorDao(VendorDao vendorDao) 
	{
		this.vendorDao = vendorDao;
	}

	@Override
	public int addVendor(Vendor vendor, String action) 
	{
		boolean bool = false;
		
		int  status = 0;
		
		vendor.setPassword("pass123");
		
		vendor.setIsdeleted("0");
		
		vendor.setCreatedBy(vendor.getVendorName());
		
		vendor.setCreatedOn(CurrentDateTime.CurrentTime());
		
		if(action.equals("insertVendor"))
		{
			boolean bol = false;
			
			bool = vendorDao.checkVendorContactNo(vendor.getContactNo());
			
			System.out.println(bool+".................cdvbd"+action);
			
			if(bool)
			{
				bol = vendorDao.checkVendorGSTNo(vendor.getGstNo());
				
				if(bol)
				{
					boolean bool1= vendorDao.addVendor(vendor);
					
					System.out.println(bool1+".................fvgbn");
					
					if(bool1)
					{
						status  = 301;
					}
					else 
					{
						status = 302;
					}
				}
				else
				{
					status = 303;
				}
				
				bool = true;
			}
			else
			{
				status = 304;
			}
		}
		
		return status;
	}

	@Override
	public List getAllVendors()
	{
		return vendorDao.getAllVendors();
	}

	@Override
	public boolean vendorValidate(Vendor vendor)
	{
		boolean bol = false;
		
		List<Vendor> list = vendorDao.vendorValidate(vendor);
		
		if(list.size()==0) 
		{
			bol =  false;
		}
		else
		{
			/*
			 * for (Customer cust : list) { //System.out.println(cust.getCustomerName());
			 * 
			 * session.setAttribute("name", cust.getCustomerName()); }
			 */
			
			//customerDao.updateLogin(email,CurrentDateTime.CurrentTime());
			bol =  true;
		}
		
		return bol;
	}

	@Override
	public Vendor getVendorById(int id)
	{
		return vendorDao.getVendorById(id);
	}

	@Override
	public boolean getVendorByEmail(String email) 
	{
		List<Vendor> list = vendorDao.getVendorByEmail(email);
		
		if(list.size()==0) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public int updateVendor(Vendor vendor,String action) 
	{
		//vendorDao.updateVendor(vendor);
		
		boolean bool = false;
		
		boolean bool1 = false;
		
		boolean bool2 = false;
		
		boolean bool3 = false;
		
		boolean bool5 = false;
		
		boolean bool6 = false;
		
		int  status = 0;
		
		try
		{
			vendor.setUpdatedBy(vendor.getVendorName());
			
			vendor.setUpdatedOn(CurrentDateTime.CurrentTime());
			
			if(action.equals("updateVendor"))
			{
				
				bool = vendorDao.checkUpdateVendorContactNo(vendor.getContactNo(), vendor.getRowNo());
				
				if(bool)
				{
					System.out.println("vendor bool..........."+bool);
					
					bool2 = vendorDao.checkVendorContactNo(vendor.getContactNo());
					
					if(bool2)
					{
						
						System.out.println("vendor bool2 if........"+bool2);
						
						bool3 = vendorDao.checkUpdateVendorGSTNo(vendor.getGstNo(), vendor.getRowNo());
						
						if(bool3)
						{
							System.out.println("vendor bool3 if........"+bool3);
							
							boolean bool4 = false;
							 
							bool4 = vendorDao.checkVendorGSTNo(vendor.getGstNo());
							
							if(bool4)
							{
								System.out.println("vendor bool4 if........"+bool4);
								
								bool1 = vendorDao.updateVendor(vendor);
								
								if(bool1)
								{
									status  = 701;
								}
								else
								{
									status = 702;
								}

							}
							else
							{
								System.out.println("vendor bool4 else..........."+bool4);
								
								status = 703;
							}
						}
						else
						{
							System.out.println("vendor bool3 else........"+bool3);
							
							bool1 = vendorDao.updateVendor(vendor);

							if(bool1)
							{
								status = 704;
							}
							else
							{
								status = 800;
							}

						}
					}
					else
					{
						System.out.println("vendor bool2 else..........."+bool2);
						
						status = 705;
					}
				}
				else
				{
					System.out.println("vendor bool else........"+bool);
					
					 bool5 = vendorDao.checkUpdateVendorGSTNo(vendor.getGstNo(), vendor.getRowNo());
					
					if(bool5)
					{
						System.out.println("vendor bool5 else if........"+bool5);
						
						bool6 = vendorDao.checkVendorGSTNo(vendor.getGstNo());
						
						if(bool6)
						{
							System.out.println("vendor bool6 else if........"+bool6);
							
							bool1 = vendorDao.updateVendor(vendor);

							if(bool1)
							{
								status = 706;
							}
							else
							{
								status = 900;
							}
						}
						else
						{
							System.out.println("vendor bool6 else else........"+bool6);
							
							status = 707;
						}
					}
					else
					{
						System.out.println("vendor bool5 else else........"+bool5);
						
						bool1 = vendorDao.updateVendor(vendor);

						if(bool1)
						{
							status = 708;
						}
						else
						{
							status = 709;
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
	public int deleteVendor(int rowNo, Vendor vendor)
	{
		boolean bool = false;
		
		int  status = 0;
		
		try
		{
			vendor.setUpdatedBy(vendor.getVendorName());
			
			vendor.setUpdatedOn(CurrentDateTime.CurrentTime());
			
			bool = vendorDao.deleteVendor(rowNo, vendor);
			
			if(bool)
			{
				status = 201;
			}
			else
			{
				status = 202;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	return status;
	
	}
	
}
