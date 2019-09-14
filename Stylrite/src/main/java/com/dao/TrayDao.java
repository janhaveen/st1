package com.dao;

import java.util.List;

import com.pojo.ProductLegend;
import com.pojo.Tray;

public interface TrayDao {

	public List getAllTrays();

	
	public boolean addTray(Tray tray);
	public boolean updateTray(Tray tray);


	public List<ProductLegend> getAllTypes();


	public boolean deleteTray(int rowNo, Tray tray);


}
