package com.dao;

import java.util.List;

import com.pojo.Cases;
import com.pojo.Jobs;
import com.pojo.JobsItem;

public interface JobsDao 
{
	List getFrameAndSunglassList(String orderId);

	boolean addNewJobs(Jobs jobs);

	boolean addNewJobsItemForvendorFittingFrameAndSunglass(JobsItem jItem);

	List getFrameAndSunglassJobsList();
}
