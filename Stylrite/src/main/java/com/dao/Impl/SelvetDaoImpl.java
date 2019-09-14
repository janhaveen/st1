package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.SelvetDao;
import com.pojo.Selvet;
@Repository("SelvetDaoImpl")
@Transactional
public class SelvetDaoImpl implements SelvetDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Selvet> getAllSelvet() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select selvet from Selvet selvet where selvet.isDeleted='0'",Selvet.class).getResultList();
	}
	@Override
	public boolean addSelvet(Selvet selvet) {
		boolean b=false;
		System.out.println("selvet data "+selvet);
		try {
			entityManager.persist(selvet);
			b=true;
			
		}
		catch(Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean updateSelvet(Selvet selvet) {
    boolean b1=false;		
System.out.println("selvet update"+selvet);
try {
	
      String hql="update  Selvet selvet  set selvet.brandName='"+selvet.getBrandName()+"',selvet.type='"+selvet.getType()+"' where selvet.rowNo="+selvet.getRowNo();
 System.out.println("update Selvet"+selvet);
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
	@Override
	public boolean deleteSelvet(Selvet selvet, int rowNo) {
	
	  boolean b1=false;
	  try {
		  String hql="update Selvet selvet set selvet.isDeleted='1' where selvet.rowNo="+rowNo;
		  System.out.println("delete selvet"+selvet);
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
