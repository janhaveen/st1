package com.dao;

import java.util.List;

import com.pojo.Cases;

public interface CasesDao {

	public List getAllCases();

	public boolean addCases(Cases cases);

	public boolean updateCases(Cases cases);

	public boolean deleteCases(int rowNo, Cases cases);

	
}
