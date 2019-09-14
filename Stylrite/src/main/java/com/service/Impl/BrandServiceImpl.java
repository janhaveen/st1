package com.service.Impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BrandDao;
import com.mysql.cj.Session;
import com.pojo.Brand;
import com.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	HttpSession session;
	
	@Autowired
	private BrandDao branddao;

	public BrandDao getBranddao() {
		return branddao;
	}

	public void setBranddao(BrandDao branddao) {
		this.branddao = branddao;
	}

	@Override
	public List getAllBrands() {

		return branddao.getAllBrands();
	}

	@Override
	public int addBrand(Brand brand, String action) {
		int status = 0;
		boolean bool = false;
		brand.setIsDeleted("0");
		brand.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		brand.setCreatedOn(CurrentDateTime.CurrentTime());
		System.out.println("action is" + action);
		if (action.equals("insertBrand")) {
			boolean bol = false;
			bool = branddao.checkBrandName(brand.getBrandName());
			System.out.println("brandnameunique" + brand);
			if (bool) {
				bol = branddao.addBrand(brand);
				if (bol) {
					status = 501;
				} else {
					status = 502;
				}
			} else {
				status = 503;
			}
		} else {
			status = 504;
		}
		return status;
	}

	@Override
	public int updateBrand(Brand brand, String action) {
		boolean b1 = false;
		int status = 0;
		try {
			brand.setUpdateBy(String.valueOf(session.getAttribute("empName")));
			brand.setUpdatedOn(CurrentDateTime.CurrentTime());
			System.out.println("action is" + action);
			if (action.equals("updateBrand")) {
				b1 = branddao.checkUpdateBrandName(brand.getBrandName(), brand.getRowNo());

				if (b1) {
					b1 = branddao.updateBrand(brand);
					if (b1) {
						status = 5001;
					} else {
						status = 5002;
					}

				} else {
					status = 5003;
				}

			}

			else {
				status = 5002;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int deleteBrand(int rowno, Brand brand) {
		int status = 0;
		boolean b = false;
		try {
			b = branddao.deleteBrand(rowno, brand);
			if (b) {
				status = 21;

			} else {
				status = 22;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}