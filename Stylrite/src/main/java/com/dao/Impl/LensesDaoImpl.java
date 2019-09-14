package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.dao.LensesDao;
import com.pojo.Lenses;
@Repository("lensesDaoImpl")
@Transactional
public class LensesDaoImpl implements LensesDao {
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
	public List<Lenses> getAllLenses()
	{
		return entityManager.createQuery("select lens from Lenses lens where lens.isDeleted='0'",Lenses.class).getResultList();
	}

	@Override
	public boolean addLenses(Lenses lenses) 
	{
		boolean b=false;
	
		System.out.println(lenses+"......................pjn");
		
		try 
		{
			entityManager.persist(lenses);
			
			b=true;
			
		}
		catch(Exception e) 
		{
			b=false;
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean updateLenses(Lenses lenses) {
		boolean b1=false;
		try {
		String hql="update Lenses lens set lens.brandName='"+lenses.getBrandName()+"',lens.model='" + lenses.getModel() + "',"
				+ "lens.specification1='"+lenses.getSpecification1()+"',lens.specification2='"+lenses.getSpecification2()+"',lens.specification3='"+lenses.getSpecification3()+"' where lens.rowNo=" + lenses.getRowNo();
		
		 System.out.println("update Lenses" + lenses);
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         System.out.println("affected row" + i);
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }

     return b1;

         }

	@Override
	public boolean deleteLenses(int rowNo, Lenses lenses) {
		boolean b1=false;
		  try {
			  String hql="update Lenses lens set lens.isDeleted='1' where lens.rowNo="+rowNo;
			  System.out.println("delete Lenses"+lenses);
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
