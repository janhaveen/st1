package com.service;

import java.util.List;

import com.pojo.Lenses;

public interface LensesService {

	
    
	public List getAllLenses();

	public int addLenses(Lenses lenses, String action);

	public int updateLenses(Lenses lenses, String action);

	public int deleteLenses(int rowNo, Lenses lenses);

}
