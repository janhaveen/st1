package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GRNDao;
import com.pojo.CreateBarCode;
import com.pojo.GRN;
import com.pojo.Product;
import com.pojo.GRNItem;
import com.service.GRNService;

@Service
public class GRNServiceImpl implements GRNService
{

	//HttpSession session;
	
	@Autowired
	private GRNDao grnDao;

	public void setGrnDao(GRNDao grnDao)
	{
		this.grnDao = grnDao;
	}

	@Override
	public int addNewProduct(Product product) 
	{
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = grnDao.addNewProduct(product);
			
			if(bol)
			{
				status = 3001;
			}
			else
			{
				status = 3002;
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addNewGRNProduct(GRN grn)
	{
		boolean bol = false;
		
		int status = 0;
		
		try 
		{
			grn.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = grnDao.addNewGRNProduct(grn);
			
			if(bol)
			{
				status = 2001;
			}
			else
			{
				status = 2002;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addNewGRNItem(GRNItem grnItem) 
	{
		boolean bol = false;
		
		int status = 0;
		
		try 
		{
			grnItem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = grnDao.addNewGRNItem(grnItem);
			
			if(bol)
			{
				status = 4001;
			}
			else
			{
				status = 4002;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addNewBarcode(CreateBarCode cBarCode)
	{
		boolean bol = false;
		
		int status = 0;
		
		try 
		{
			cBarCode.setStatus("401");
			
			cBarCode.setStockInDate(CurrentDateTime.CurrentTimestamp());
			
			cBarCode.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = grnDao.addNewBarcode(cBarCode);
			
			if(bol)
			{
				status = 6001;
			}
			else
			{
				status = 6002;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List getAllGRNList()
	{
		return grnDao.getAllGRNList();
	}

	@Override
	public List getProductBasedBarcodeList(String grnId) 
	{
		return grnDao.getProductBasedBarcodeList(grnId);
	}

}
