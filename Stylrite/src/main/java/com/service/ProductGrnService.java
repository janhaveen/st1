package com.service;

import java.util.List;


import com.pojo.GrnProduct;
import com.pojo.GrnProductItem;

public interface ProductGrnService {

	public List getAllProductGrnList();

	public int addNewGRNProduct(GrnProduct grnProduct);

	public int addNewGrnProductItem(GrnProductItem grnItm);

	public List getAllGrnProductList();

	public List getAllViewGrnProductList(String grnId);

}
