package com.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.GRNDao;
import com.pojo.CreateBarCode;
import com.pojo.Employee;
import com.pojo.GRN;
import com.pojo.GRNItem;
import com.pojo.GRNListView;
import com.pojo.Product;
import com.pojo.ProductBasedBarcodeListView;

@Repository("grnDaoImpl")
@Transactional
public class GRNDaoImpl implements GRNDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public boolean addNewProduct(Product product)
	{
		boolean bol = false;
		
		System.out.println("Product.... "+product);
		
		try
		{
			entityManager.persist(product);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public boolean addNewGRNProduct(GRN grn)
	{
		boolean bol = false;
		
		System.out.println("grnProduct.... "+grn);
		
		try
		{
			entityManager.persist(grn);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public boolean addNewGRNItem(GRNItem grnItem) 
	{
		boolean bol = false;
		
		System.out.println("grnItem.... "+grnItem);
		
		try
		{
			entityManager.persist(grnItem);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public boolean addNewBarcode(CreateBarCode cBarCode) 
	{
		boolean bol = false;
		
		System.out.println("cBarCode.... "+cBarCode);
		
		try
		{
			entityManager.persist(cBarCode);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public List getAllGRNList() 
	{
		return entityManager.createQuery("select g from GRNListView g",GRNListView.class).getResultList();
	}

	@Override
	public List getProductBasedBarcodeList(String grnId)
	{
		return entityManager.createQuery("select pb from ProductBasedBarcodeListView pb where pb.grnId='"+grnId+"'",ProductBasedBarcodeListView.class).getResultList();
	}

	@Override
	public List<ProductBasedBarcodeListView> getExportBarcodeAsCSVList(String barcodes)
	{
		return entityManager.createQuery("select pb from ProductBasedBarcodeListView pb where pb.rowId in("+barcodes+")",ProductBasedBarcodeListView.class).getResultList();
	}
}
		