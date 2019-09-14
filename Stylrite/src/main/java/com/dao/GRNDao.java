package com.dao;

import java.util.List;

import com.pojo.CreateBarCode;
import com.pojo.GRN;
import com.pojo.Order;
import com.pojo.Product;
import com.pojo.ProductBasedBarcodeListView;
import com.pojo.GRNItem;

public interface GRNDao 
{
	public boolean addNewProduct(Product product);

	public boolean addNewGRNProduct(GRN grn);

	public boolean addNewGRNItem(GRNItem grnItem);

	public boolean addNewBarcode(CreateBarCode cBarCode);

	public List getAllGRNList();

	public List getProductBasedBarcodeList(String grnId);

	public List<ProductBasedBarcodeListView> getExportBarcodeAsCSVList(String barcodes);
}
