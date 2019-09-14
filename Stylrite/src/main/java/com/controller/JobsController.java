package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Brand;
import com.pojo.Jobs;
import com.pojo.JobsItem;
import com.pojo.Order;
import com.pojo.OrderLensItem;
import com.pojo.Tray;
import com.service.JobsService;

@Controller
@WebListener
public class JobsController
{
	@Autowired
	private JobsService jobsService;

	/*** getting Frame And Sunglass List ***/
    @RequestMapping(value="/getFrameAndSunglassList", produces="application/json",method=RequestMethod.GET)
	public @ResponseBody HashMap getFrameAndSunglassListData(Model model,HttpSession session, @RequestParam ("orderId") String orderId) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List lsitGetFrameAndSunglassListData = jobsService.getFrameAndSunglassList(orderId);
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", lsitGetFrameAndSunglassListData);
	        System.out.println("list of customers"+lsitGetFrameAndSunglassListData);
	        
	        return hm ;
	}
    
    /*** Creating a add new Jobs ***/
    @PostMapping("/addNewOrderJobs")
    public @ResponseBody int addNewOrderJobsData(@ModelAttribute("jobs") Jobs jobs , BindingResult br) 
    {
    	System.out.println(jobs);
    	 
    	int status = 0;
    	
    	try
    	{
    		status = jobsService.addNewJobs(jobs);
    	}
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	
    	return status;
    }
    
    /*** Creating a add new Order Jobs Item ***/
	  @PostMapping("/addNewJobsItemForvendorFittingFrameAndSunglass") 
	  public @ResponseBody int addNewJobsItemForvendorFittingFrameAndSunglassData(@ModelAttribute("jobsItem") JobsItem jobsItem, BindingResult br, @RequestParam("vendorFittingFrameAndSunglassArray") JSONArray vendorFittingFrameAndSunglassArray)
	  {
		 // System.out.println(orderItem+"................i");
		  
		  int status = 0;

		  try 
		  {
			  for (int i = 0; i < vendorFittingFrameAndSunglassArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) vendorFittingFrameAndSunglassArray.get(i);
				  
				
				 JobsItem jItem = new JobsItem(jsonObject.getString("jobItemId"), jsonObject.getString("jobId"), jsonObject.getString("barcode"), jsonObject.getString("skuId"), jsonObject.getInt("qty"),jsonObject.getString("status"));
				 
				  System.out.println(jsonObject+"..................123");
				  
			   status = jobsService.addNewJobsItemForvendorFittingFrameAndSunglass(jItem);
				 
				  
			  }
		  }
		  catch (Exception e)
		  {
			e.printStackTrace();
		  }
		  
		  return status;
	  }
	  
	  	/*** getting Frame And Sunglass Jobs List ***/
	    @RequestMapping(value="/getOrderJobsList", produces="application/json",method=RequestMethod.GET)
		public @ResponseBody HashMap getOrderJobsListData(Model model,HttpSession session, @RequestParam ("orderId") String orderId) 
	    {
	    		HashMap<String, Object> hm = new HashMap();
			
			 	List lsitGetFrameAndSunglassListData = jobsService.getOrderJobsList(orderId);
		        
		        //mv.addAttribute("listCustomers", listCustomers);
		        
		        hm.put("data", lsitGetFrameAndSunglassListData);
		        
		        System.out.println("list of customers"+lsitGetFrameAndSunglassListData);
		        
		        return hm ;
		}
}

