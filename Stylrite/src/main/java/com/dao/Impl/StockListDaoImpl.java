package com.dao.Impl;

import java.util.List;

import com.dao.StockListDao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.dao.LensesDao;
import com.pojo.BarcodeList;
import com.pojo.BrandWiseStock;
//import com.pojo.BarcodeList;
import com.pojo.Lenses;
@Repository("stockListDao")
@Transactional
public class StockListDaoImpl implements StockListDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public List<BarcodeList> getAllBarcodeList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select barcode from BarcodeList barcode",BarcodeList.class  ).getResultList();
	}


	@Override
	public List<BrandWiseStock> getAllBrandWiseStockList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select brandwiseStock from BrandWiseStock brandwiseStock",BrandWiseStock.class).getResultList();
	}


	@Override
	public List<BarcodeList> getAllInBarcodeList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select barcode from BarcodeList barcode where barcode.status_txt='IN'",BarcodeList.class).getResultList();
	}

}
