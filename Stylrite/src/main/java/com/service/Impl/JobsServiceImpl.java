package com.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CasesDao;
import com.dao.JobsDao;
import com.pojo.Cases;
import com.pojo.Jobs;
import com.pojo.JobsItem;
import com.service.CasesService;
import com.service.JobsService;

@Service
public class JobsServiceImpl implements JobsService 
{
	@Autowired
	private JobsDao jobsDao;
	
	public void setJobsDao(JobsDao jobsDao) 
	{
		this.jobsDao = jobsDao;
	}

	@Override
	public List getFrameAndSunglassList(String orderId) 
	{
		return jobsDao.getFrameAndSunglassList(orderId);
	}

	@Override
	public int addNewJobs(Jobs jobs)
	{
		boolean bol = false;
		
		int status = 0;
		
		jobs.setStatus("601");
		jobs.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
		bol = jobsDao.addNewJobs(jobs);
		
		if(bol)
		{
			status = 1501;
		}
		else
		{
			status = 1502;
		}
		
		return status;
	}

	@Override
	public int addNewJobsItemForvendorFittingFrameAndSunglass(JobsItem jItem)
	{
		boolean bol = false;
		
		int status = 0;
		
		jItem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
		bol = jobsDao.addNewJobsItemForvendorFittingFrameAndSunglass(jItem);
		
		if(bol)
		{
			status = 1601;
		}
		else
		{
			status = 1602;
		}
		
		return status;
	}

	@Override
	public List getFrameAndSunglassJobsList()
	{
		return jobsDao.getFrameAndSunglassJobsList();
	}

	
}

	
