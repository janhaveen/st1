package com.dao;

import java.util.List;


import com.pojo.GrnProduct;
import com.pojo.GrnProductItem;

public interface ProductGrnDao {

	List getAllProductGrnList();

	boolean addNewGRNProduct(GrnProduct grnProduct);

	boolean addNewGrnProductItem(GrnProductItem grnItm);

	List getAllGrnProductList();

	List getAllViewProductGrnList(String grnId);

}
