package com.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dao.JobsDao;
import com.pojo.JobListView;
import com.pojo.Jobs;
import com.pojo.JobsItem;
import com.pojo.OrderListView;

@Repository("jobsDaoImpl")
@Transactional
public class JobsDaoImpl implements JobsDao
{
	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;

	@PersistenceContext(unitName="demoRestPersistenceLegacy")
	private EntityManager entityManagerLegacy;
	
	/*@PersistenceContext
	private EntityManager entityManager;*/
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	public List getFrameAndSunglassList(String orderId)
	{
		return entityManager.createQuery("select orderList from OrderListView orderList where orderList.orderId='"+orderId+"'",OrderListView.class).getResultList();
	}

	@Override
	public boolean addNewJobs(Jobs jobs) 
	{
		boolean bol = false;
		
		System.out.println("jobs.... "+jobs);
		
		try
		{
			entityManager.persist(jobs);
			
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
	public boolean addNewJobsItemForvendorFittingFrameAndSunglass(JobsItem jItem) 
	{
		boolean bol = false;
		
		System.out.println("jItem.... "+jItem);
		
		try
		{
			entityManager.persist(jItem);
			
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
	public List getFrameAndSunglassJobsList() 
	{
		return entityManager.createQuery("select jobsList from JobListView jobsList",JobListView.class).getResultList();
	}
}

	
