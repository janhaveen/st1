package com.dao;

import java.util.List;

import com.pojo.Vendor;
import com.pojo.VendorAddress;
import com.pojo.VendorContactPerson;

public interface VendorDao {

	public boolean addVendor(Vendor vendor);

	public boolean addVendorAddress(VendorAddress vaddress);

	public boolean addVendorContactPerson(VendorContactPerson vperson);

	public List getAllVendorList();

	public List getAllVendorAddressList(String vendorId);

	public List getAllVendorContactPerson(String vendorId);

	public boolean updateVendor(Vendor vendor);

	public boolean updateIsDefaultOfVendorContactPerson(String vendorId);

	public boolean updateVendorContactDetail(VendorContactPerson vperson);

	public boolean updateIsDefaultOfVendorAddress(String vendorId);

	public boolean updateVendorAddressDetails(VendorAddress vaddress);

	public boolean addNewVendorContactPersonDetails(VendorContactPerson vperson);

	public boolean addNewVendorAddressDetails(VendorAddress vaddress);

}
