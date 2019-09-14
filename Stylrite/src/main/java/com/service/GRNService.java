package com.service;

import java.util.List;

import com.pojo.CreateBarCode;
import com.pojo.GRN;
import com.pojo.Product;
import com.pojo.GRNItem;

public interface GRNService 
{
	public int addNewProduct(Product product);

	public int addNewGRNProduct(GRN grn);

	public int addNewGRNItem(GRNItem grnItem);

	public int addNewBarcode(CreateBarCode cBarCode);

	public List getAllGRNList();

	public List getProductBasedBarcodeList(String grnId);
}
