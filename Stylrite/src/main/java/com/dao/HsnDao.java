package com.dao;

import java.util.List;

import com.pojo.Hsn;

public interface HsnDao {

public	List getAllHsn();

  public boolean addHsn(Hsn hsn);

	public boolean updateHsn(Hsn hsn);

	public boolean deleteHsn(int rowno, Hsn hsn);

	
}
