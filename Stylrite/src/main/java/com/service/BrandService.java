package com.service;

import java.util.List;

import com.pojo.Brand;

public interface BrandService 
{
	
	public int addBrand(Brand brand,String action);
	public List getAllBrands();
	public int updateBrand(Brand brand,String action);
	public int deleteBrand(int rowno,Brand brand);
	
}