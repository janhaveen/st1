package com.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GRNDao;
import com.pojo.CreateBarCode;
import com.pojo.GRN;
import com.pojo.GRNItem;
import com.pojo.Product;
import com.pojo.ProductBasedBarcodeListView;
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

	@Override
	public List<ProductBasedBarcodeListView> getExportBarcodeAsCSVList(String barcodes) 
	{
		HashMap<String, Object> hm1 = null ;
		
		List<ProductBasedBarcodeListView> list = grnDao.getExportBarcodeAsCSVList(barcodes);
		
		List list1 = new ArrayList();
		
		for (ProductBasedBarcodeListView pb : list) 
		{
			System.out.println("list size is........."+list.size());
			
	    	hm1= new HashMap();
	    	
	    	hm1.put("rowNo", pb.getRowNo());
	    	hm1.put("BarCode", pb.getRowId());
	    	hm1.put("grnNumber", pb.getGrnNo());
	    	hm1.put("brand_text", pb.getBrand());
	    	hm1.put("modelNo", pb.getModelNo());
	    	hm1.put("color", pb.getColor());
	    	hm1.put("size", pb.getSize());
	    	hm1.put("type_txt", pb.getType());
	    	hm1.put("location", pb.getLocation());
	    	hm1.put("status", pb.getStatus());
	    	
	    	list1.add(hm1);
		}
		
		return list1;
	}

}
