package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.BrandDao;
import com.pojo.Brand;
import com.pojo.Employee;
import com.pojo.Vendor;

@Repository("BrandDaoImpl")
@Transactional
public class BrandDaoImpl implements BrandDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Brand> getAllBrands() {
		
		return entityManager.createQuery("select brand from Brand brand where brand.isDeleted='0'",Brand.class).getResultList();
	}

	@Override
	public boolean addBrand(Brand brand) {
		
		
			boolean bol = false;
			
			System.out.println("brand.... "+brand);
			
			try
			{
				entityManager.persist(brand);
				
				bol = true;
			}
			catch (Exception e) 
			{
				bol = false;
				
				e.printStackTrace();
			}
			
			return bol;
		}

	@Override
	public boolean updateBrand(Brand brand) {
		boolean b1=false;
		System.out.println("brand"+brand);
		try {
		String hql="update Brand br set br.brandName='"+brand.getBrandName()+"',br.remarks='"+brand.getRemarks()+"' where br.rowNo="+brand.getRowNo();
		
		System.out.println("UpdateQuery"+hql);
		javax.persistence.Query query = entityManager.createQuery(hql);
		int i=query.executeUpdate();
		
		System.out.println("Iffected Row in Task Modified-->"+i);
		/*emp.birthDate='"+employee.getBirthDate()+"',emp.joinDate='"+employee.getJoinDate()+"',*/
		b1 = true;
		
	}catch (Exception e) 
	{
		b1 = false;
		
		e.printStackTrace();
	}
	
	return b1;
}

	@Override
	public boolean deleteBrand(int rowno, Brand brand) 
	{
		boolean b1=false;System.out.println("brand"+brand);
	
	try 
	{
		String hql="update Brand br set br.isDeleted='1'where br.rowNo="+rowno;
		
		System.out.println("Query"+hql);
		
		javax.persistence.Query query = entityManager.createQuery(hql);
				
		int i=query.executeUpdate();
				
		System.out.println("Task Modified-->"+i);
		
		b1 = true;
	}
	catch (Exception e)
	{
		b1 = false;
		
		e.printStackTrace();
	}
	
	return b1;
}

	@Override
	public boolean checkBrandName(String brandname) {
		List list = new ArrayList();
		boolean bol=false;
	    String query1 = "select br.brandName from Brand br where br.brandName='"+brandname+"'";
		
		Query q = entityManager.createQuery(query1);

		list = q.getResultList();
 		
		System.out.println("load23........."+list);
		
		if(list.size() == 0)
		{
			bol=true;
		}
		
		return bol;
	}

	@Override
	public boolean checkUpdateBrandName(String brandName, int rowNo) {
		
        boolean bol = false;
		
	    List list1 = new ArrayList();
	
	    String query2 = "select br.brandName from Brand br where br.brandName='"+brandName+"' and br.rowNo='"+rowNo+"'";
		
		Query q1 = entityManager.createQuery(query2);

		list1 = q1.getResultList();
 		
		System.out.println("load5002........."+list1);
		
		if(list1.size() == 0)
		{
			bol=true;
		}
		return bol;	
		
		
		
	}

	
}