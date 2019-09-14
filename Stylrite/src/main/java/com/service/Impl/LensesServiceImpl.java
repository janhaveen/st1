package com.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LensesDao;
import com.pojo.Lenses;
import com.service.LensesService;

@Service
public class LensesServiceImpl implements LensesService{
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
	@Autowired
	private LensesDao lensesDao;
	public void setLensesDao(LensesDao lensesDao) {
		this.lensesDao = lensesDao;
	}
	@Override
	public List getAllLenses() {
		// TODO Auto-generated method stub
		return lensesDao.getAllLenses();
		
	}
	@Override
	public int addLenses(Lenses lenses, String action) 
	{
		int status =0;
		boolean b1=false;
		lenses.setIsDeleted("0");
		lenses.setQty(1);
		lenses.setCreatedOn(timestamp);
		lenses.setUpdatedOn(timestamp);
		System.out.println("lenses insert query"+lenses);
		try {
			
			if(action.equals("insertLenses")) 
			{
			   b1=lensesDao.addLenses(lenses);
			}  
			
			if(b1) {
				status=180001;
			}
			else {
				status=180002;
			}
			
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	
}
	@Override
	public int updateLenses(Lenses lenses, String action) {
	    int status =0;
	    boolean b1=false;
	    lenses.setUpdatedOn(timestamp);
	    try {
	    	if(action.equals("updateLenses")) {
	    		b1=lensesDao.updateLenses(lenses);
	    		
	    	}
	    	if(b1) {
	    		status=19001;
	    	}
	    	else {
	    		status=19002;
	    	}
	    }catch (Exception e) {
			// TODO: handle exception
		}
	    
		
		return status;
	}
	@Override
	public int deleteLenses(int rowNo, Lenses lenses) {
		int status=0;
		boolean b1=false;
		
		lenses.setCreatedOn(timestamp);
		
		try {
			b1=lensesDao.deleteLenses(rowNo,lenses);
		
		if(b1) {
			status=1901;
		}
		else {
			status=1902;
		}
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	}

