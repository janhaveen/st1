package com.dao;

import java.util.List;

import com.pojo.Selvet;

public interface SelvetDao {

public 	List getAllSelvet();

public boolean addSelvet(Selvet selvet);

public boolean updateSelvet(Selvet selvet);

public boolean deleteSelvet(Selvet selvet, int rowNo);





}
