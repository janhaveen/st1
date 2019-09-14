package com.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Cases;

public interface CasesService {

	public List getAllCases();

	public int addCases(Cases cases, String action);

	public int updateCases(Cases cases, String action);

	public int deleteCases(int rowNo, Cases cases);

	
	

}
