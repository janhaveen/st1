package com.service;

import java.util.List;

import com.pojo.Bags;

public interface BagsService {

	public List getAllBags();

public 	int addBags(Bags bags, String action);

public	int updateBags(Bags bags, String action);

	public int deleteBags(Bags bags, int rowNo);

}
