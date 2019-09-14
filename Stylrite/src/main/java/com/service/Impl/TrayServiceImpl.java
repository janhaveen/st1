package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrayDao;
import com.pojo.Tray;
import com.service.TrayService;
@Service
public class TrayServiceImpl implements TrayService {
     @Autowired
	private TrayDao trayDao;
	public TrayDao getTrayDao() {
		return trayDao;
	}
	public void setTrayDao(TrayDao trayDao) {
		this.trayDao = trayDao;
	}
	@Override
	public List getAllTrays() {
		
		return trayDao.getAllTrays();
	}
	@Override
	public int addTray(Tray tray, String action) {
		int status=0;
		boolean b1=false;
		tray.setIsDeleted("0");
		tray.setCreatedBy(tray.getCreatedBy());
		tray.setCreatedOn(CurrentDateTime.CurrentTime());
		if(action.equals("insertTray")) {
			b1=trayDao.addTray(tray);
		}
		
		if(b1) {
			status=601;
			
		}
		else {
			status=602;
		}
		
		return status;
	}
	@Override
	public int updateTray(Tray tray, String action) {
	 int status=0;
	 boolean b1=false;
	 try {
		 tray.setUpdatedBy(tray.getUpdatedBy());
		 tray.setUpdatedOn(CurrentDateTime.CurrentTime());
		 if(action.equals("updateTray")) {
		  b1=trayDao.updateTray(tray); 
		  if(b1) {
			  status=6001;
			  
		  }
		  else {
			  status=6002;
		  }
		 }
		
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
		
		return status;
	}
	@Override
	public List getAllTypes() {
		// TODO Auto-generated method stub
		return trayDao.getAllTypes();
	}
	@Override
	public int deleteTray(int rowNo, Tray tray) {
	    int status=0;
	    boolean b=false;
	    try {
	    	b=trayDao.deleteTray(rowNo,tray);
	    	if(b) {
	    		status=61;
	    	}
	    	else {
	    		status=62;
	    	}
	    	
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		return status;
	}
	

}
