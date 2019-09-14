package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.TrayDao;
import com.pojo.Legend;
import com.pojo.ProductLegend;
import com.pojo.Tray;
@Repository("TrayDaoImpl")
@Transactional
public class TrayDaoImpl implements TrayDao{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Tray> getAllTrays() {
	
		return entityManager.createQuery("select tray from Tray tray where tray.isDeleted='0' ",Tray.class).getResultList();
	}
	@Override
	public boolean addTray(Tray tray) {
    boolean b1=false;
    System.out.println("tray data"+tray);
    try {
    	entityManager.persist(tray);
    	b1=true;
    	
    }catch(Exception e) {
    	e.printStackTrace();
    	b1=false;
    }
		return b1;
	}

	
	@Override
	public boolean updateTray(Tray tray) {
		boolean b1=false;
		System.out.println("tray"+tray);
		try {
		String hql="update Tray tr set tr.brandName='"+tray.getBrandName()+"',tr.type='"+tray.getType()+"',tr.capacity='"+tray.getCapacity()+"' where tr.rowNo="+tray.getRowNo();
		System.out.println("update query"+hql);
		Query q=entityManager.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		}
		catch (Exception e) {
			b1=false;
			e.printStackTrace();
			// TODO: handle exception
		}
		return b1;
	}
	@Override
	public List<ProductLegend> getAllTypes()
	{
		return entityManager.createQuery("select pl from ProductLegend pl",ProductLegend.class).getResultList();
	}
	@Override
	public boolean deleteTray(int rowNo, Tray tray) {
		boolean b1=false;
		System.out.println("tray" +tray);
		try {
			String hql="update Tray tr set tr.isDeleted='1' where tr.rowNo="+rowNo;
			System.out.println("delete tray"+tray);
			Query q=entityManager.createQuery(hql);
			int i=q.executeUpdate();
			System.out.println("infected deleted row"+i);
			b1=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			b1=false;
		e.printStackTrace();
		}
		return b1;
	}
	
	
}
