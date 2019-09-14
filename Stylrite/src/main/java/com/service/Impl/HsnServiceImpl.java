package com.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HsnDao;
import com.pojo.Hsn;
import com.service.HsnService;

@Service
public class HsnServiceImpl implements HsnService{
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
	@Autowired
	private HsnDao hsnDao;
	public void setHsnDao(HsnDao hsnDao) {
		this.hsnDao = hsnDao;
	}

	@Override
	public List getAllHsn() {
		// TODO Auto-generated method stub
		return hsnDao.getAllHsn();
		
	}

	@Override
	public int addHsn(Hsn hsn, String action) {
		boolean b=false;
		int status=0;
		hsn.setIsDeleted("0");
		hsn.setCreatedOn(timestamp);
		hsn.setUpdatedOn(timestamp);
			try {
		if(action.equals("insertHsn"))
		{
			b=hsnDao.addHsn(hsn);
		}
		   	
			if(b) {
				status=21001;
			}
			else {
				status=21002;
			}
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return status;
	}

	@Override
	public int updateHsn(Hsn hsn,String action) {
		int status=0;
		boolean b=false;
		hsn.setUpdatedOn(timestamp);
		
		try {
		if(action.equals("updateHsn")) {
			b=hsnDao.updateHsn(hsn);
		}
		if(b) {
			status=2111;
		}
		else {
			status=2112;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteHsn(int rowno, Hsn hsn) {
		boolean b1=false;
	      int status=0;
	      hsn.setUpdatedOn(timestamp);
	      try {
	    	 b1=hsnDao.deleteHsn(rowno,hsn);
	    	 if(b1) {
	    		 status=1911;
	    	 }
	    	 else {
	    		 status=1912;
	    	 }
	      }catch(Exception e) {
	    	  
	      }
	        return status;
		}
	}


