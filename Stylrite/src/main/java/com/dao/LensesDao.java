package com.dao;

import java.util.List;

import com.pojo.Lenses;

public interface LensesDao {

   public	List getAllLenses();

public boolean addLenses(Lenses lenses);

public boolean updateLenses(Lenses lenses);

public boolean deleteLenses(int rowNo, Lenses lenses);

}
