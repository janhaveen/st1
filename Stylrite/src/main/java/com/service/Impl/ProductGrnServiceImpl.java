package com.service.Impl;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductGrnDao;

import com.pojo.GrnProduct;
import com.pojo.GrnProductItem;
import com.service.ProductGrnService;
@Service
public class ProductGrnServiceImpl implements ProductGrnService {
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       @Autowired
	private ProductGrnDao productGrnDao;
	@Override
	public List getAllProductGrnList() {
		// TODO Auto-generated method stub
		return productGrnDao.getAllProductGrnList();
		
	}
	@Override
	public int addNewGRNProduct(GrnProduct grnProduct)
	{
		
		boolean bol = false;
		
		
		int status = 0;
	
		/*
		grnProduct.setPurchaseDateText(CurrentDateTime.convertToSqlDate(String.valueOf(grnProduct.getPurchaseDateText())));
		grnProduct.setReceiptDateText(CurrentDateTime.convertToSqlDate(String.valueOf(grnProduct.getPurchaseDateText())));*/
		grnProduct.setCreatedOn(timestamp);
		grnProduct.setUpdatedOn(timestamp);
		bol = productGrnDao.addNewGRNProduct(grnProduct);
		
		if(bol)
		{
			status = 9001;
		}
		else
		{
			status = 9002;
		}
		
		return status;
	}
	@Override
	public int addNewGrnProductItem(GrnProductItem grnItm) {
boolean bol = false;	
		int status = 0;
		grnItm.setCreatedOn(timestamp);
		grnItm.setUpdatedOn(timestamp);
		try 
		{
			bol = productGrnDao.addNewGrnProductItem(grnItm);
			
			if(String.valueOf(grnItm.getQuantity()).equals("")) 
			{
				grnItm.setQuantity(0);
				System.out.println(grnItm.getQuantity());
			}
			
			if(bol)
			{
				status = 10001;
			}
			else
			{
				status = 10002;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	@Override
	public List getAllGrnProductList() {
		// TODO Auto-generated method stub
		return productGrnDao.getAllGrnProductList();
	}
	@Override
	public List getAllViewGrnProductList(String grnId) {
		// TODO Auto-generated method stub
		return productGrnDao.getAllViewProductGrnList(grnId);
	}
	
	

}
