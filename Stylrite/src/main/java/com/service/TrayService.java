package com.service;

import java.util.List;

import com.pojo.Tray;

public interface TrayService {
	public List getAllTrays();
	public int addTray(Tray tray, String action);
	public int updateTray(Tray tray, String action);
	public List getAllTypes();
	public int deleteTray(int rowNo, Tray tray);

}
