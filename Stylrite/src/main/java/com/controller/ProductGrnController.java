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

import com.dao.Impl.ProductGrnDaoImpl;

import com.pojo.GrnProduct;
import com.pojo.GrnProductItem;
import com.service.ProductGrnService;

@Controller
@WebListener
public class ProductGrnController {
	        @Autowired
          private   ProductGrnService productGrnService;
	        
	 public void setProductGrnService(ProductGrnService productGrnService) {
				this.productGrnService = productGrnService;
			}

	/*** Page Redirect on CreateProductGrn.jsp ***/
		@RequestMapping(value = "/showProductGrn", method = RequestMethod.GET)
	    public ModelAndView showEmployee(ModelAndView model) 
	    {
	        model.addObject("grnProduct", new GrnProduct());
	        
	        model.setViewName("productgrn/createProductGrn");
	        
			return model;
	    }
		/*** Page Redirect on GrnProductList.jsp ***/
		@RequestMapping(value = "/showGrnproductList", method = RequestMethod.GET)
	    public ModelAndView showGrnProductList(ModelAndView model) 
	    {
	        model.addObject("grnProduct", new GrnProduct());
	        
	        model.setViewName("productgrn/productGrn");
	        
			return model;
	    }
		
		/*** Listing Grn list ***/
		@RequestMapping(value="/listGrnList",produces="application/json",method=RequestMethod.GET)
		public  @ResponseBody HashMap listGrnProductList(Model model,HttpSession session) {
			System.out.println("list GrnProductList");
			HashMap<String, Object> hm=new HashMap<>();
			List listGrnProductList=productGrnService.getAllGrnProductList();
			hm.put("data",listGrnProductList);
			System.out.println("list ProductGrnlist "+listGrnProductList);
			return hm;
			
		}
		
		/*** Listing ViewProductGrnlist ***/
		@RequestMapping(value="/viewGrnProductList",produces="application/json",method=RequestMethod.GET)
		public  @ResponseBody HashMap viewGrnProductList(Model model,HttpSession session,@RequestParam("grnId")String grnId) {
			System.out.println("list ViewGrnProductList");
			HashMap<String, Object> hm=new HashMap<>();
			List listViewGrnProductList=productGrnService.getAllViewGrnProductList(grnId);
			hm.put("data",listViewGrnProductList);
			System.out.println("list ViewGrnProductList "+listViewGrnProductList);
			return hm;
			
		}
		 /*** Listing product list ***/
		/*** Listing Product list of Grn  ***/
		@RequestMapping(value="/listGrnProduct",produces="application/json",method=RequestMethod.GET)
		public  @ResponseBody HashMap listProductGrnList(Model model,HttpSession session) {
			System.out.println("list ProductList");
			HashMap<String, Object> hm=new HashMap<>();
			List listGrnProduct=productGrnService.getAllProductGrnList();
			hm.put("data",listGrnProduct);
			System.out.println("list ProductGrnlist "+listGrnProduct);
			return hm;
			
		}
		@PostMapping("/addGRNProduct") 
		  public @ResponseBody int addNewGrnProduct(@ModelAttribute("grnProduct") GrnProduct grnProduct, BindingResult br)
		  {
			  System.out.println(grnProduct+" ");
			  
			  int status = 0;
			  
			  status = productGrnService.addNewGRNProduct(grnProduct);
			  System.out.println("status is"+status);
			  return status; 
		  }
		@PostMapping("/addGrnProductItem") 
		  public @ResponseBody int addNewGrnProductItem(@ModelAttribute("grnProductItem") GrnProductItem grnProductItem, BindingResult br,@RequestParam ("grnProductItemArray") JSONArray grnProductItemArray)
		  {  int status = 0;

		  try 
		  {
			  for (int i = 0; i < grnProductItemArray.length(); i++)
			  {
				  //action.get(i).;
				  
				  JSONObject j=(JSONObject) grnProductItemArray.get(i);
				 
			  GrnProductItem grnItm = new GrnProductItem(j.getString("rowId"),j.getString("brandName"),j.getString("type"),j.getInt("quantity"),j.getString("typeOfProduct"),j.getString("grnId"),j.getString("PID"),j.getString("capacity"));
				  	
				System.out.println(j.getInt("quantity")+"..................p09");
				  
				  status =  productGrnService.addNewGrnProductItem(grnItm);
			  }
		  } 
		  catch (Exception e) 
		   {
			  e.printStackTrace();
		   }
		  
		  return status; 
	  }
}
