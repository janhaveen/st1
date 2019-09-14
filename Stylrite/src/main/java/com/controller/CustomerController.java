package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.pojo.Order;
import com.pojo.PrescriptionDetails;
import com.service.CustomerService;
import com.service.OrderService;

@Controller
@WebListener
public class CustomerController 
{
    @Autowired
    private CustomerService customerService;

    
    
    /*** Page Redirect on home.jsp ***/
	@RequestMapping("/Home")
	public String home(Model m, HttpSession session) 
	{
		if (session != null) 
		{
			return "dashboard";
		}
		else 
		{
			return "redirect:index.jsp";
		}

	}
	
	/*** Page Redirect on customer.jsp ***/
	@RequestMapping(value = "/showCustomer", method = RequestMethod.GET)
    public ModelAndView showCustomer(ModelAndView model) 
    {
        model.addObject("customer", new Customer());
        
        model.setViewName("customer/customer");
        
		return model;
    }
	
	@RequestMapping(value="/showOrderForm",method=RequestMethod.GET)
	     public ModelAndView showOrderForm(ModelAndView model) {
		model.addObject("order",new Order());
		model.setViewName("order/orderForm");
		return model;
	}

	/*** Creating a add new Customer ***/
    @PostMapping("/customerRegister")
    public @ResponseBody int register(@ModelAttribute("customer") Customer customer, BindingResult br, @RequestParam ("action") String action) 
    {
    	System.out.println(customer+" ");
    	
    	System.out.println(action+" ");
    	
    	int status = 0;
    	
        status = customerService.addCustomer(customer, action);
        
        return status;
    }
    
    @PostMapping("/PrescriptionDetailsRegister")
    public @ResponseBody int PrescriptionDetailsRegister(@ModelAttribute("prescriptiondetails") PrescriptionDetails prescriptiondetails, BindingResult br) 
    {
    	System.out.println(prescriptiondetails+" ");
    	

    	int status = 0;
    	
        status = customerService.addPrescriptionDetails(prescriptiondetails);
        
        return status;
    }

    /*** LogIn Customer ***/
   /* @PostMapping("/logInCustomer")
    public @ResponseBody String logIn(@ModelAttribute("customer") Customer customer, HttpSession session, Model model) 
    {
        try
        {
        	session.setAttribute("email", customer.getEmail());
            
            boolean bol = customerService.customerValidate(customer);

            if (bol) 
            {
            	//employeeService.getEmployeeByEmail(employeePojo.getEmail());
            	
            	return "1";
            } 
            else 
            {
            	model.addAttribute("messege", customer.getEmail().toString() + "Email And Password Invailed !!");
            	
    			return "2";
            }
		} 
        catch (Exception e) 
        {
        	e.printStackTrace();
		}
        
		return "500";
    }*/
    
   /* *//*** LogOut Customer ***//*
    @RequestMapping(value = "/logout1", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, ModelAndView model, HttpSession session) 
    {
        try 
        {
        			
            System.out.println(session.getAttribute("email"));
            
            String email = (String) session.getAttribute("email");
            
            if (session != null) 
            {
            	customerService.logOutCustomer(email);
            	
                session.removeAttribute("email");
                
                session.invalidate();
              
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

		model.addObject("customer", new Customer());
		
		model.setViewName("LogIn");
		
		return model;
    }
*/
    /*** Listing Customer List in Json Format ***/
    @RequestMapping(value = "/listCustomer", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listCustomer(Model model, HttpSession session) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listCustomers = customerService.getAllCustomers();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listCustomers);
	        
			hm.put("status", "200");
			
	        return hm ;
		
	}
    
    /*** Update Customer ***/
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public @ResponseBody int updateCustomer(@ModelAttribute("Customer") Customer customer, @RequestParam ("action") String action)
    {
    	int status = 0;
    	
    	try
		{
    		System.out.println(customer+" ");
        	
        	System.out.println(action+" ");
        	
    		status = customerService.updateCustomer(customer, action);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
        return status;
    }
    /*** Delete Customer ***/
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public @ResponseBody String deleteCustomer(@RequestParam("rowNo") int  rowNo,  Customer customer) 
    {
        System.out.println("In in delete");
        customerService.deleteCustomer(rowNo, customer);
        System.out.println("Delete Done");
        return "201";
    }
    
    /***Get Prescription Card of that Customer ***/
	@RequestMapping(value="/getPrescriptionData",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap getPrescriptionData(Model model,HttpSession session,@RequestParam("clientId")String clientId) {
		System.out.println("list prescription data");
		HashMap<String, Object> hm=new HashMap<>();
		List getPrescriptionData =customerService.getAllOrderPrescriptionData(clientId);
		hm.put("data",getPrescriptionData);
		System.out.println("Get Prescription"+getPrescriptionData);
		return hm;
		
	}
	 /***Get  Pending Order Card of that Customer ***/
	@RequestMapping(value="/getCustomerOrderData",produces="application/json",method=RequestMethod.GET)
	public @ResponseBody HashMap getCustomerOrderCard(Model model,HttpSession sesssion,@RequestParam("clientId")String ClientId) {
		System.out.println("list order data ");
		HashMap<String, Object> hm=new HashMap<>();
		List getOrderData=customerService.getAllCustomerOrderData(ClientId);
		hm.put("data",getOrderData);
		System.out.println("Get Order Data "+getOrderData);
		return hm;
	}
	 /*** Get All Order  of that Customer***/
	@RequestMapping(value ="/getCustomerOrderListData", produces ="application/json", method =RequestMethod.GET)
	public @ResponseBody HashMap listCustomerOrder(Model model, HttpSession session,@RequestParam("clientId")String ClientId) 
    {
    	System.out.println("hello list");
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listOrders = customerService.getCutomerOrderListData(ClientId);
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listOrders);
	        
	        return hm ;
		
	}
	
	 /***order Card view  ***/
	@RequestMapping(value="/CustomerOrderCardViewData",produces="application/json",method=RequestMethod.GET)
	public @ResponseBody HashMap getCustomerOrderCardView(Model model,HttpSession session,@RequestParam("orderId")String orderId)
	{
		System.out.println("ordercardviewlist");
		HashMap< String, Object>hm=new HashMap();
		List orderCardView=customerService.getCustomerOrderCardView(orderId);
		hm.put("data",orderCardView);
		return hm;
		
		
	}
	
	
}
