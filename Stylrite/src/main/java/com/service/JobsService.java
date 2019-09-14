package com.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Cases;
import com.pojo.Jobs;
import com.pojo.JobsItem;

public interface JobsService 
{
	List getFrameAndSunglassList(String orderId);

	int addNewJobs(Jobs jobs);

	int addNewJobsItemForvendorFittingFrameAndSunglass(JobsItem jItem);

	List getOrderJobsList(String orderId);

}
