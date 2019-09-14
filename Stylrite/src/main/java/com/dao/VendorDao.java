package com.dao;

import java.util.List;

import com.pojo.Vendor;

public interface VendorDao 
{
	public boolean addVendor(Vendor vendor);
	public List getAllVendors();
	public List<Vendor> vendorValidate(Vendor vendor);
	public Vendor getVendorById(int id);
	public List<Vendor> getVendorByEmail(String email);
	public boolean updateVendor(Vendor vendor);
	public boolean deleteVendor(int rowNo, Vendor vendor);
	public boolean checkVendorContactNo(long contactNo);
	public boolean checkVendorGSTNo(String gstNo);
	public boolean checkUpdateVendorContactNo(long contactNo, int rowNo);
	public boolean checkUpdateVendorGSTNo(String gstNo, int rowNo);
}
