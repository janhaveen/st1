package com.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.VendorDao;
import com.pojo.Customer;
import com.pojo.Vendor;
import com.pojo.VendorAddress;
import com.pojo.VendorContactPerson;
import com.service.VendorService;
@WebListener
@Controller
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	
	public VendorService getVendorService() {
		return vendorService;
	}

	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	/*** Page Redirect on Vendor1.jsp ***/
	@RequestMapping(value = "/showVendor1", method = RequestMethod.GET)
    public ModelAndView showVendor(ModelAndView model) 
    {
        model.addObject("customer", new Customer());
        
        model.setViewName("VendorNew/Vendor");
        
		return model;
    }
	
	 @PostMapping("/vendorRegister")
	    public @ResponseBody int registerClient(@ModelAttribute("vendor") Vendor  vendor, BindingResult br,
	            @RequestParam("action") String action) {
	        System.out.println(vendor + " ");
	        System.out.println(action + " ");
	        int status = 0;
	        status = vendorService.addVendor(vendor, action);
	        return status;
	    }
	  @PostMapping("/vendorAddressRegister")
	    public @ResponseBody int registerClientAddress(@ModelAttribute("vaddress") VendorAddress vaddress,
	            BindingResult br,@RequestParam("isDefault") boolean isDefault) {
	        System.out.println(vaddress + " ");
	        int status = 0;
	        status = vendorService.addVendorAddress(vaddress,isDefault);
	        return status;
	    }
	    @PostMapping("/VendorPersonRegister")
	    public @ResponseBody int registerVendorContactPerson(@ModelAttribute("vperson") VendorContactPerson vperson,
	            BindingResult br,@RequestParam("isDefault") boolean isDefault)
	    {
	        System.out.println(vperson + " ");
	        int status = 0;
	        status = vendorService.addVendorContactPerson(vperson,isDefault);
	        return status;
	    }
	    /*** Listing Vendor List in Json Format ***/
	    @RequestMapping(value = "/GetVendorList", produces = "application/json", method = RequestMethod.GET)
	    public @ResponseBody HashMap listClientList(Model model, HttpSession session) {
	        HashMap<String, Object> hm = new HashMap();
	        List listVendor = vendorService.getAllVendorList();
	        System.out.println("listClient" + listVendor);
	        // mv.addAttribute("listCustomers", listCustomers);
	        hm.put("data", listVendor);
	        hm.put("status", "200");
	        return hm;
	    }
	    
	    /*** Listing VendorAddress List in Json Format ***/
	    @RequestMapping(value = "/GetVendorAddressList", produces = "application/json", method = RequestMethod.GET)
	    public @ResponseBody HashMap listVendorAddressList(Model model, HttpSession session,@RequestParam("vendorId")String vendorId) {
	        HashMap<String, Object> hm = new HashMap();
	        List listVAddress = vendorService.getAllVendorAddressList(vendorId);
	        System.out.println("listAddressClient" + listVAddress);
	        // mv.addAttribute("listCustomers", listCustomers);
	        hm.put("data", listVAddress);
	        hm.put("status", "200");
	        return hm;
	    }
	    /*** Listing VendorContactPerson List in Json Format ***/
	    @RequestMapping(value = "/GetVendorContactPersonList", produces = "application/json", method = RequestMethod.GET)
	    public @ResponseBody HashMap listVendorContactPersonList(Model model, HttpSession session,@RequestParam("vendorId")String vendorId) {
	        HashMap<String, Object> hm = new HashMap();
	        List listVContactPerson = vendorService.getAllVendorContactPersonList(vendorId);
	        System.out.println("listContactPerson" + listVContactPerson);
	        // mv.addAttribute("listCustomers", listCustomers);
	        hm.put("data", listVContactPerson);
	        hm.put("status", "200");
	        return hm;
	    }
	    
	    /*** Updating Vendor ***/
	    @PostMapping("/updateVendor")
	    public @ResponseBody int updateVendor(@ModelAttribute("vendor") Vendor vendor, BindingResult br,
	            @RequestParam("action") String action) {
	        System.out.println(vendor + " ");
	        System.out.println(action + " ");
	        int status = 0;
	        status = vendorService.updateVendor(vendor, action);
	        return status;
	    }
	    
	    /*** Updating  Vendor  Address Details ***/
	    @PostMapping("/vendorUpdateAddressDetails")
	    public @ResponseBody int updateVendorAddressDetails(@ModelAttribute("vaddress") VendorAddress vaddress,
	            BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) {
	        System.out.println(vaddress + " ");
	        int status = 0;
	        status = vendorService.updateVendorAddressDetails(vaddress,action,isDefault);
	        return status;
	    }
	             
	    /*** Updating Vendor Contact Details ***/
	    @PostMapping("/vendorUpdateContactDetails")
	    public @ResponseBody int updateVendorContactDetails(@ModelAttribute("vperson") VendorContactPerson vperson,
	            BindingResult br, @RequestParam("action") String action,@RequestParam("isDefault") boolean isDefault) {
	        System.out.println(vperson + " ");
	        System.out.println(action + " ");
	        int status = 0;
	        status = vendorService.updateVendorContactDetail(vperson,action,isDefault);
	        return status;
	    }
	    
	    /*** Adding  New  VendorContact Details ***/
		@PostMapping("/newVendorContactDetails")
		public @ResponseBody int newClientContactPersonDetails(@ModelAttribute("vperson") VendorContactPerson vperson,
				BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) {
			System.out.println(vperson + " ");

			int status = 0;

			status = vendorService.addNewVendorContactPersonDetails(vperson,action,isDefault);

			return status;
		}
		/*** Adding  New Address ***/
		@PostMapping("/newVendorAddressDetails")
		public @ResponseBody int NewClientAddressDetails(@ModelAttribute("vaddress") VendorAddress vaddress,
				BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) {
			System.out.println(vaddress + " ");

			int status = 0;

			status = vendorService.addNewVendorAddressDetails(vaddress,action,isDefault);

			return status;
		}

}
