package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LegendDao;
import com.service.LegendService;

@Service
public class LegendServiceImpl implements LegendService {
	  
	  @Autowired
	  private LegendDao legendDao;

	public void setLegendDao(LegendDao legendDao) {
		this.legendDao = legendDao;
	}

	@Override
	public List getLegendList() {
		// TODO Auto-generated method stub
		return legendDao.getLegendList();
	}

	@Override
	public List getAllState() {
		// TODO Auto-generated method stub
		return legendDao.getAllState();
	}
	  

}
