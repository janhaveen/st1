package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.HsnDao;
import com.pojo.Cases;
import com.pojo.Hsn;

@Repository("hsnDaoImpl")
@Transactional
public class HsnDaoImpl implements HsnDao  {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Hsn> getAllHsn() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("select hsn1 from Hsn hsn1 where hsn1.isDeleted='0'",Hsn.class).getResultList();
	}

	@Override
	public boolean addHsn(Hsn hsn) { 

			
		boolean b=false;
		System.out.println("hsn..."+hsn);
		
		try
		{
			 entityManager.persist(hsn);
			b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			b=false;
		}
		return b;
	}

	@Override
	public boolean updateHsn(Hsn hsn) {
	   boolean b1=false;
	   System.out.println("hsn update "+hsn);
		try {
			String hql="update Hsn hsn1 set hsn1.hsnName='"+hsn.getHsnName()+"',hsn1.cgst='"+hsn.getCgst()+"',hsn1.igst='"+hsn.getIgst()+"',hsn1.sgst='"+hsn.getSgst()+"',hsn1.ugst='"+hsn.getUgst()+"'where hsn1.rowNo="+hsn.getRowNo();
			System.out.println("update Hsn"+hql);
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
	public boolean deleteHsn(int rowno,Hsn hsn) {
		boolean b1=false;
		System.out.println("hsn delte"+hsn);
		try {
			String hql="update Hsn hsn1 set hsn1.isDeleted='1' where hsn1.rowNo="+rowno;
			System.out.println("delete Hsn"+hql);
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
