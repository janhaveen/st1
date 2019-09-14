package com.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.pojo.Customer;
import com.pojo.GRNItem;
import com.pojo.Jobs;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.OrderLensItem;
import com.pojo.PrescriptionDetails;

import com.service.OrderService;

@Controller
@WebListener
public class OrderController 
{
    @Autowired
    private OrderService orderService;
    
    /*** Page Redirect on employee.jsp ***/
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
    public ModelAndView showEmployee(ModelAndView model) 
    {
        model.addObject("order", new Order());
        
        model.setViewName("order/order");
        
		return model;
    }
	
	/*** Creating a add new Order ***/
    @PostMapping("/orderRegister")
    public @ResponseBody int orderRegister(@ModelAttribute("order") Order order, BindingResult br, @RequestParam ("action") String action, @RequestParam ("CID") String CID, @RequestParam ("remarks") String remarks) 
    {
    	System.out.println(order+" "+CID+" "+remarks);
    	
    	int status = 0;
    	
    	try 
    	{
			
			  order.setRemarks(remarks);
			  order.setCID(CID);
			  
    		status = orderService.addOrder(order, action);
		}
    	catch (Exception e)
    	{
    		e.printStackTrace();
		}
    	
        return status;
    }
    
    /*** Listing Order List in Json Format ***/
    @RequestMapping(value = "/listOrder", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listOrder(Model model, HttpSession session) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listOrders = orderService.getAllOrder();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listOrders);
	        
	        return hm ;
		
	}
    
    /*** Listing ViewProductGrnlist ***/
	@RequestMapping(value="/viewOrderProductList",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap viewGrnProductList(Model model,HttpSession session,@RequestParam("orderId")String orderId) 
	{
		System.out.println("list listorderProductView");
		
		HashMap<String, Object> hm=new HashMap<>();
		
		List listorderProductView=orderService.getAllOrderProductView(orderId);
		
		hm.put("data",listorderProductView);
		
		System.out.println("list orderProductView"+listorderProductView);
		
		return hm;
		
	}
	
    /*** getting Customer List ***/
    @RequestMapping(value="/listCustomerInfo", produces="application/json",method=RequestMethod.GET)
	public @ResponseBody HashMap listCustmerInfo(Model model,HttpSession session,@RequestParam("mobileno") long mobileno) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listCustomersInfo = orderService.getAllCustomerInfo(mobileno);
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listCustomersInfo);
	        System.out.println("list of customers"+listCustomersInfo);
	        
	        return hm ;
		
	}
    
    @PostMapping("/addNewCustomer")
    public @ResponseBody int addNewCustomer(@ModelAttribute("customer") Customer customer, BindingResult br) 
    {
    	
    	System.out.println(customer);
    
    	
    	int status = 0;
    	
        status = orderService.addNewCustomer(customer);
        
        return status;
    }
    
    /*** Check Scan Barcode in Json Format ***/
    @RequestMapping(value = "/checkScanBarcode", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap checkScanBarcodeData(Model model, HttpSession session, @RequestParam ("barcode") String barcode) 
    {
    	   System.out.println("sdffvbc................."+barcode);
    	
	        HashMap<String, Object> hm = new HashMap();
			
		 	List list34 = orderService.checkScanBarcode(barcode);
	        
	        hm.put("data", list34);
	        
			return hm;
	        
    }
    
    /*** Check Scan Barcode StockOut is Out in Json Format ***/
    @RequestMapping(value = "/checkIfBarcodeStockOut", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap checkIfBarcodeStockOut(Model model, HttpSession session, @RequestParam ("barcode") String barcode) 
    {
    	   System.out.println("..........."+barcode);
    	
	        HashMap<String, Object> hm = new HashMap();
			
		 	List list = orderService.checkScanBarcodeStockOut(barcode);
	        
	        hm.put("data", list);
	        
			return hm;
	        
    }
    
    /*** Creating a add new Order Item ***/
	  @PostMapping("/addNewOrderItem") 
	  public @ResponseBody int addNewOrderItemData(@ModelAttribute("orderItem") OrderItem orderItem, BindingResult br, @RequestParam ("orderItemArray") JSONArray orderItemArray)
	  {
		 // System.out.println(orderItem+"................i");
		  
		  int status = 0;

		  try 
		  {
			  for (int i = 0; i < orderItemArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) orderItemArray.get(i);
				  
				
				 OrderItem orderItemData = new OrderItem(jsonObject.getString("orderItemId"), jsonObject.getString("orderId"), jsonObject.getString("barcode"), jsonObject.getString("brand"), jsonObject.getString("color"), jsonObject.getString("size"), jsonObject.getFloat("price"), jsonObject.getInt("qty"), jsonObject.getString("modelNo"), jsonObject.getString("status"));
				 
				  System.out.println(jsonObject+"..................123");
				  
			      status = orderService.addNewGRNItem(orderItemData, jsonObject.getString("barcode"), jsonObject.getString("barcodeStatus"));
				 
				  
			  }
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return status; 
	  }
	  
	@PostMapping("/addNewOrderJobsVendor")
    public @ResponseBody int addNewOrderJobsVendor(@ModelAttribute("jobs") Jobs jobs, BindingResult br) 
    {
    	
    	System.out.println(jobs);
    
    	
    	int status = 0;
    	
        status = orderService.addNewOrderJobsVendor(jobs);
        
        return status;
    }
	
	 /***Adding prescription details ***/
	  @PostMapping("/addPrescriptionDetails")
	  public @ResponseBody int addPrescriptionDetails(@ModelAttribute("prescription") PrescriptionDetails prescription, BindingResult br) 
    {
    	
    	System.out.println(prescription);
    
    	
    	int status = 0;
    	
        status = orderService.addPrescriptionDetails(prescription);
        
        return status;
    }
	  
	  /*** Creating a add new Order Lens Item ***/
	  @PostMapping("/addNewOrderLenseItem") 
	  public @ResponseBody int addNewOrderLenseItem(@ModelAttribute("orderLensItem") OrderLensItem orderLensItem, BindingResult br, @RequestParam ("orderLensItemArray") JSONArray orderLensItemArray)
	  {
		 // System.out.println(orderItem+"................i");
		  
		  int status = 0;

		  try 
		  {
			  for (int i = 0; i < orderLensItemArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) orderLensItemArray.get(i);
				  
				
				  OrderLensItem oLensItem = new OrderLensItem(jsonObject.getString("orderLensItemId"), jsonObject.getString("orderId"), jsonObject.getString("brand"), jsonObject.getString("model"), jsonObject.getInt("qty"),jsonObject.getString("specification1"),jsonObject.getString("specification2"),jsonObject.getString("specification2"));
				 
				 // System.out.println(jsonObject+"..................123");
				  
			      status = orderService.addNewOrderLenseItemData(oLensItem);
				 
				  
			  }
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return status; 
	  }
	  
	  /*** Listing Prescription List in Json Format ***/
	    @RequestMapping(value = "/listPrescription", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap listPrescription(Model model, HttpSession session,@RequestParam("customerId")String customerId) 
	    {
	    		HashMap<String, Object> hm = new HashMap();
			
			 	List listOrders = orderService.getAllPrescriptionList(customerId);
		        
		        //mv.addAttribute("listCustomers", listCustomers);
		        
		        hm.put("data", listOrders);
		        
		        return hm ;
			
		}
}
