package com.service;

import java.util.List;

import com.pojo.Selvet;

public interface SelvetService {

	public List getAllSelvets();

	public int addSelvet(Selvet selvet, String action);

	public int updateSelvet(Selvet selvet, String action);

	public int deleteSelvet(Selvet selvet, int rowNo);

	
}
