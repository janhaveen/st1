package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.LegendService;

@WebListener
@Controller
public class LegendController {

	   @Autowired
	   public LegendService legendService;
	   
	   /*** Listing DepartmentAndDesignation List in Json Format ***/
	    @RequestMapping(value = "/getLegendList", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap getLegendList(Model model, HttpSession session) 
	    {
			
	    		HashMap<String, Object> hm = new HashMap();
			
			 	List listEmployees = legendService.getLegendList();
		        
		        //mv.addAttribute("listCustomers", listCustomers);
		        
		        hm.put("data", listEmployees);
		        
		        return hm ;
			
		}
	    /*** Listing State List in Json Format ***/
	    @RequestMapping(value = "/GetState", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap listState(Model model, HttpSession session) 
	    {
			
	    		HashMap<String, Object> hm = new HashMap();
			
			 	List listStateData = legendService.getAllState();
		        
		        //mv.addAttribute("listCustomers", listCustomers);
		        
		        hm.put("data", listStateData);
		        
		        return hm ;
			
		}
	    
	   
}
