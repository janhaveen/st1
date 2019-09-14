package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SelvetDao;
import com.pojo.Selvet;
import com.service.SelvetService;
@Service
public class SelvetServiceImpl implements SelvetService{
	@Autowired
	private SelvetDao selvetDao;
	

	@Override
	public List getAllSelvets() {
		return selvetDao.getAllSelvet();
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public int addSelvet(Selvet selvet, String action) {
		int status =0;
		boolean b1=false;
		try {
			selvet.setRowId(UUID.randomUUID().toString());
			selvet.setCreatedBy(selvet.getCreatedBy());
			selvet.setUpdatedBy(CurrentDateTime.CurrentTime());
			selvet.setIsDeleted("0");
			if(action.equals("insertSelvet")) {
			   b1=selvetDao.addSelvet(selvet);
			   
			}
			if(b1) {
				status=801;
			}
			else {
				status=802;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public int updateSelvet(Selvet selvet, String action) {
		boolean b1=false;
		int status=0;
		try {
		selvet.setUpdatedBy(selvet.getUpdatedBy());
		selvet.setUpdatedOn(CurrentDateTime.CurrentTime());
		if(action.equals("updateSelvet")){
			b1=selvetDao.updateSelvet(selvet);
			
		}
		if(b1) {
			status=8001;
		}
		else {
			status=8002;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}


	@Override
	public int deleteSelvet(Selvet selvet, int rowNo) {
	boolean b1=false;
	int status=0;
	try {
	  b1=selvetDao.deleteSelvet(selvet,rowNo);
	  if(b1) {
		  status=81;
	  }
	  else {
		  status=82;
	  }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return status;
	}
		

}
