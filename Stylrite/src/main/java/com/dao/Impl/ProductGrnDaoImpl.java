package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.ProductGrnDao;
import com.pojo.GrnProduct;
import com.pojo.GrnProductItem;
import com.pojo.GrnProductListView;
import com.pojo.ProductListView;

@Repository("ProductGrnDaoImpl")
@Transactional
public class ProductGrnDaoImpl implements ProductGrnDao {
	
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;

	@PersistenceContext(unitName="demoRestPersistenceLegacy")
	private EntityManager entityManagerLegacy;
	/*@PersistenceContext
	private EntityManager entityManager;*/
	@Override
	public List<ProductListView> getAllProductGrnList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select products from ProductListView products",ProductListView.class).getResultList();
	}
	@Override
	public boolean addNewGRNProduct(GrnProduct grnProduct)
	{
		boolean bol = false;
		
		System.out.println("grnProduct.... "+grnProduct);
		
		try
		{
			entityManager.persist(grnProduct);
			
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
	public boolean addNewGrnProductItem(GrnProductItem grnItm) {
boolean bol = false;
		
		System.out.println("grnProductItem.... "+grnItm);
		
		try
		{
			entityManager.persist(grnItm);
			
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
	public List getAllGrnProductList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select grnProducts from GrnProduct grnProducts",GrnProduct.class).getResultList();
	}
	@Override
	public List<GrnProductListView> getAllViewProductGrnList(String grnId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select grnProductview from GrnProductListView grnProductview where grnProductview.grnId='"+grnId+"'",GrnProductListView.class).getResultList();
	}
	}

