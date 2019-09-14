package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.CasesDao;
import com.pojo.Cases;
@Repository("CasesDaoImpl")
@Transactional
public class CasesDaoImpl implements CasesDao {
	
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;

	@PersistenceContext(unitName="demoRestPersistenceLegacy")
	private EntityManager entityManagerLegacy;
	/*@PersistenceContext
	private EntityManager entityManager;*/
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Cases> getAllCases() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select casess from Cases casess where casess.isDeleted='0'",Cases.class).getResultList();
	}

	@Override
	public boolean addCases(Cases cases) {
	   boolean b1=false;
	   System.out.println("cases data");
	   try {
		   entityManager.persist(cases);
		   b1=true;
	   }
	   catch(Exception e) {
		   b1=false;
		   e.printStackTrace();
	   }
		return b1;
	}

	@Override
	public boolean updateCases(Cases cases) {
		boolean b1=false;
		System.out.println("cases update"+cases);
		try {
		String hql="update Cases casess set casess.brandName='"+cases.getBrandName()+"',casess.type='"+cases.getType()+"',casess.quantity='"+cases.getQuantity()+"'where casess.rowNo="+cases.getRowNo();
		System.out.println("update cases"+hql);
		Query q=entityManager.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		}
		catch(Exception e)
		{
			b1=false;
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public boolean deleteCases(int rowNo, Cases cases) {
		boolean b1=false;
		System.out.println("cases delte"+cases);
		try {
			String hql="update Cases casess set casess.isDeleted='1' where casess.rowNo="+rowNo;
			System.out.println("delete Cases"+hql);
			Query q=entityManager.createQuery(hql);
			int i =q.executeUpdate();
			System.out.println("infected delete row "+i);
			b1=true;
		}
		catch (Exception e) {
			// TODO: handle exception
		   b1=false;
		}
		return b1;
	}
	
	}

	
