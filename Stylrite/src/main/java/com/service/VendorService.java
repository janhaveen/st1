package com.service;

import java.util.List;

import com.pojo.Vendor;
import com.pojo.VendorAddress;
import com.pojo.VendorContactPerson;

  public interface VendorService {

  public int addVendor(Vendor vendor, String action);

  public int addVendorAddress(VendorAddress vaddress, boolean isDefault);

  public int addVendorContactPerson(VendorContactPerson vperson, boolean isDefault);

public List getAllVendorList();

public List getAllVendorAddressList(String vendorId);

public List getAllVendorContactPersonList(String vendorId);

public int updateVendor(Vendor vendor, String action);

public int updateVendorAddressDetails(VendorAddress vaddress, String action, boolean isDefault);

public int updateVendorContactDetail(VendorContactPerson vperson, String action, boolean isDefault);

public int addNewVendorContactPersonDetails(VendorContactPerson vperson, String action, boolean isDefault);

public int addNewVendorAddressDetails(VendorAddress vaddress, String action, boolean isDefault);

}
