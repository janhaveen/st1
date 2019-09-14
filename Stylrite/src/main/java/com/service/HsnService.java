package com.service;

import java.util.List;

import com.pojo.Hsn;

    public interface HsnService {

	public List getAllHsn();

	public int addHsn(Hsn hsn, String action);

	public int updateHsn(Hsn hsn, String action);

	public int deleteHsn(int rowno, Hsn hsn);

}
