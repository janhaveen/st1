package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.BagsDao;
import com.pojo.Bags;
import com.pojo.Selvet;

@Repository("BagsDaoImpl")
@Transactional
public class BagsDaoImpl implements BagsDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Bags> getAllBags() {
		return entityManager.createQuery("select bags from Bags bags where bags.isDeleted='0'",Bags.class).getResultList();
		
	}

	@Override
	public boolean addBags(Bags bags) {
		boolean b=false;
		System.out.println("Bags data "+bags);
		try {
			entityManager.persist(bags);
			b=true;
			
		}
		catch(Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean updateSelvet(Bags bags) {
		boolean b1=false;		
		System.out.println("bags update"+bags);
		try {
			
		      String hql="update  Bags bags  set bags.brandName='"+bags.getBrandName()+"',bags.type='"+bags.getType()+"' where bags.rowNo="+bags.getRowNo();
		 System.out.println("update Bags"+bags);
		 Query q=entityManager.createQuery(hql);
		 int i=q.executeUpdate();
		 System.out.println("affected row"+i);
		 b1=true;
		}catch (Exception e) {
			e.printStackTrace();
			b1=false;
				
	}
		return b1;
	}

	@Override
	public boolean deleteSelvet(Bags bags, int rowNo) {
		
		boolean b1=false;
		  try {
			  String hql="update Bags bags set bags.isDeleted='1' where bags.rowNo="+rowNo;
			  System.out.println("delete bags"+bags);
		       Query q=entityManager.createQuery(hql);
		       int i=q.executeUpdate();
		       System.out.println("affected row"+i);
		          b1=true;
		  }catch (Exception e) {
			e.printStackTrace();
			b1=false;
			  // TODO: handle exception
		}
		  
			return b1;
		}
	}
	


