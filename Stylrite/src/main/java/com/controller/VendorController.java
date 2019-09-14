package com.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.pojo.Customer;
import com.pojo.Vendor;
import com.service.VendorService;

@Controller
@WebListener
public class VendorController 
{
    @Autowired
    private VendorService vendorService;
    
    /*** Page Redirect on vendor.jsp ***/
	@RequestMapping(value = "/showVendor", method = RequestMethod.GET)
    public ModelAndView showVendor(ModelAndView model) 
    {
        model.addObject("vendor", new Vendor());
        
        model.setViewName("vendor/vendor");
        
		return model;
    }
	
	/*** Creating a add new Vendor ***/
    @PostMapping("/vendorRegister")
    public @ResponseBody int register(@ModelAttribute("vendor") Vendor vendor, BindingResult br, @RequestParam ("action") String action) 
    {
    	System.out.println(vendor+" ");
    	
    	System.out.println(action+" ");
    	
    	int status = 0;
    	
        status = vendorService.addVendor(vendor, action);
        
        return status;
    }
    
    /*** Listing Customer List in Json Format ***/
    @RequestMapping(value = "/listVendor", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listVendor(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listVendors = vendorService.getAllVendors();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listVendors);
	        
			hm.put("status", "200");
			
	        return hm ;
		
	}
    
    /*** Update Customer ***/
    @RequestMapping(value = "/updateVendor", method = RequestMethod.POST)
    public @ResponseBody int updateVendor(@ModelAttribute("vendor") Vendor vendor, @RequestParam ("action") String action)
    {
        int status = 0;
    	
    	try
		{
    		System.out.println(vendor+" ");
        	
        	System.out.println(action+" ");
        	
    		status = vendorService.updateVendor(vendor, action);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
        return status;
    }
    
    @RequestMapping(value = "/deleteVendor", method = RequestMethod.POST)
    public @ResponseBody int deleteVendor(@RequestParam("rowNo") int  rowNo,  Vendor vendor) 
    {
    	int status = 0;
    	
    	try
		{
    		 System.out.println("In in delete");
        	
    		 status = vendorService.deleteVendor(rowNo, vendor);
    		 
    		 System.out.println("Delete Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
        return status;
    }

}
