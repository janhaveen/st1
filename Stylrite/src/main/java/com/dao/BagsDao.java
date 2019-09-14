package com.dao;

import java.util.List;

import com.pojo.Bags;

public interface BagsDao {

public	List getAllBags();

public	boolean addBags(Bags bags);

public	boolean updateSelvet(Bags bags);

public	boolean deleteSelvet(Bags bags, int rowNo);

}
