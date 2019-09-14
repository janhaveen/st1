package com.dao;

import java.util.List;

import com.pojo.Brand;

public interface BrandDao 
{
	public List getAllBrands();
	public boolean addBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public boolean deleteBrand(int rowno, Brand brand);
	public boolean checkBrandName(String brandName);
	public boolean checkUpdateBrandName(String brandName, int rowNo);
}