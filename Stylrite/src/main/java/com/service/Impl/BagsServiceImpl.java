package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BagsDao;
import com.pojo.Bags;
import com.service.BagsService;
@Service
public class BagsServiceImpl implements BagsService{
	@Autowired
	private BagsDao bagsDao;

	public void setBagsDao(BagsDao bagsDao) {
		this.bagsDao = bagsDao;
	}

	@Override
	public List getAllBags() {
		
		return bagsDao.getAllBags();
	}

	@Override
	public int addBags(Bags bags, String action) {
		
		int status =0;
		boolean b1=false;
		try {
			bags.setRowId(UUID.randomUUID().toString());
			bags.setCreatedBy(bags.getCreatedBy());
			bags.setUpdatedBy(CurrentDateTime.CurrentTime());
			bags.setIsDeleted("0");
			if(action.equals("insertBags")) {
			   b1=bagsDao.addBags(bags);
			   
			}
			if(b1) {
				status=901;
			}
			else {
				status=902;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public int updateBags(Bags bags, String action) {
		boolean b1=false;
		int status=0;
		try {
			bags.setUpdatedBy(bags.getUpdatedBy());
			bags.setUpdatedOn(CurrentDateTime.CurrentTime());
		if(action.equals("updateBags")){
			b1=bagsDao.updateSelvet(bags);
			
		}
		if(b1) {
			status=9001;
		}
		else {
			status=9002;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int deleteBags(Bags bags, int rowNo) {
		boolean b1=false;
		int status=0;
		try {
		  b1=bagsDao.deleteSelvet(bags,rowNo);
		  if(b1) {
			  status=91;
		  }
		  else {
			  status=92;
		  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return status;
		}
			
	}

