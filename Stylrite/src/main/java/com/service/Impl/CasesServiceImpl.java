package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CasesDao;
import com.pojo.Cases;
import com.service.CasesService;

@Service
public class CasesServiceImpl implements CasesService {
	@Autowired
	private CasesDao casesDao;

	public CasesDao getCasesDao() {
		return casesDao;
	}

	public void setCasesDao(CasesDao casesDao) {
		this.casesDao = casesDao;
	}

	@Override
	public List getAllCases() {
		// TODO Auto-generated method stub
		return casesDao.getAllCases();
	}

	@Override
	public int addCases(Cases cases, String action) {
		int status =0;
        boolean b1=false;
        cases.setRowId(UUID.randomUUID().toString());
        cases.setCreatedBy(cases.getCreatedBy());
        cases.setCreatedOn(CurrentDateTime.CurrentTime());
        cases.setIsDeleted("0");
        if(action.equals("insertCases")) {
        	b1=casesDao.addCases(cases);
        }
        			if(b1) {
        				status=701;
        			}
        			else {
        				status=702;
        			}
		return status;
	}

	@Override
	public int updateCases(Cases cases, String action) {
		int status=0;
		boolean b=false;
		try {
		cases.setUpdatedBy(cases.getUpdatedBy());
		cases.setUpdatedOn(cases.getUpdatedOn());
		if(action.equals("updateCases")) {
		b=casesDao.updateCases(cases);
		}
		if(b) {
			status=7001;
		}
		else {
			status=7002;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteCases(int rowNo, Cases cases) {
		int status=0;
		boolean b1=false;
		cases.setUpdatedBy(cases.getUpdatedBy());
		cases.setCreatedOn(CurrentDateTime.CurrentTime());
		
		try {
			b1=casesDao.deleteCases(rowNo,cases);
		
		if(b1) {
			status=71;
		}
		else {
			status=72;
		}
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}

	
