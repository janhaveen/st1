package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StockListDao;
import com.service.StockListService;

@Service
public class StockListServiceImpl  implements StockListService{
	@Autowired
	private StockListDao stockListDao;

	@Override
	public List getAllBarcodeList() {
		// TODO Auto-generated method stub
		return stockListDao.getAllBarcodeList();
	}

	@Override
	public List getAllBrandWiseStockList() {
		// TODO Auto-generated method stub
		return stockListDao.getAllBrandWiseStockList();
	}

	@Override
	public List getAlliNBarcodeList() {
		// TODO Auto-generated method stub
		return stockListDao.getAllInBarcodeList();
	}
	

}
