package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.Customer;
import com.pojo.Vendor;

public interface VendorService 
{
	public int addVendor(Vendor vendor, String action);
	public List getAllVendors();
	public boolean vendorValidate(Vendor vendor);
	public Vendor getVendorById(int id);
	public boolean getVendorByEmail(String email);
	public int updateVendor(Vendor vendor, String action);
	public int deleteVendor(int rowNo, Vendor vendor);
}
