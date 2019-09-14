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

import com.pojo.CreateBarCode;
import com.pojo.GRN;
import com.pojo.GRNItem;
import com.pojo.Product;
import com.service.GRNService;

@Controller
@WebListener
public class GRNController 
{
    @Autowired
    private GRNService grnService;
    
    /*** Page Redirect on GRN.jsp ***/
	@RequestMapping(value = "/showGRN", method = RequestMethod.GET)
    public ModelAndView showGRN(ModelAndView model) 
    {
        model.addObject("grn", new GRN());
        
        model.setViewName("grn/createGRN");
        
		return model;
    }
	
	/*** Page Redirect on GRN.jsp ***/
	@RequestMapping(value = "/viewGRN", method = RequestMethod.GET)
    public ModelAndView showGRNView(ModelAndView model) 
    {
        model.addObject("grn", new GRN());
        
        model.setViewName("grn/ViewGRN");
        
		return model;
    }
	
	/*** Page Redirect on GRN.jsp ***/
	@RequestMapping(value = "/listGRN", method = RequestMethod.GET)
    public ModelAndView showGRNList(ModelAndView model) 
    {
        model.addObject("grn", new GRN());
        
        model.setViewName("grn/GRNList");
        
		return model;
    }
	
    /*** Creating a add new Product ***/
	  @PostMapping("/addNewProduct") 
	  public @ResponseBody int addProduct(@ModelAttribute("product") Product product, BindingResult br)
	  {
		  System.out.println(product+" ");
		  
		  int status = 0;
		  
		  status = grnService.addNewProduct(product);
		  
		  return status; 
	  }
	 
	    /*** Creating a add new product ***/
		  @PostMapping("/addNewGRN") 
		  public @ResponseBody int addNewGRNData(@ModelAttribute("grn") GRN grn, BindingResult br)
		  {
			  System.out.println(grn+" ");
			  
			  int status = 0;
			  
			  status = grnService.addNewGRNProduct(grn);
			  
			  return status; 
		  }
		  
		  /*** Creating a add new GRN And GRNItem ***/
		  @PostMapping("/addNewGRNItem") 
		  public @ResponseBody int addNewGRNItemData(@ModelAttribute("grnItem") GRNItem grnItem, BindingResult br, @RequestParam ("grnItemArray") JSONArray grnItemArray)
		  {
			  //System.out.println(grnId+"................i");
			  
			  int status = 0;

			  try 
			  {
				  for (int i = 0; i < grnItemArray.length(); i++)
				  {
					  //action.get(i).;
					  
					  JSONObject j=(JSONObject) grnItemArray.get(i);
					 
					  GRNItem grnItm = new GRNItem(j.getString("rowId"), j.getString("productId"), j.getString("grnId"), j.getString("brand"), j.getString("modelNo"), j.getString("color"), j.getString("size"), j.getInt("qty"),j.getFloat("cost"), j.getString("type"), j.getFloat("price"), j.getString("hsnId"));
					  
					 // System.out.println(grnItm+"..................p09");
					  
					  status =  grnService.addNewGRNItem(grnItm);
				  }
			  } 
			  catch (Exception e) 
			  {
				  e.printStackTrace();
			  }
			  
			  return status; 
		  }
		  
		  /*** Creating a add new Barcode ***/
		  @PostMapping("/addNewBarcode") 
		  public @ResponseBody int addNewBarcodeData(@ModelAttribute("createBarCode") CreateBarCode createBarCode, BindingResult br, @RequestParam ("createBarcodeArray") JSONArray createBarcodeArray)
		  {
			  //System.out.println(grnId+"................i");
			  
			  int status = 0;

			  try 
			  {
				  for (int i = 0; i < createBarcodeArray.length(); i++)
				  {
					  JSONObject jsonObject = (JSONObject) createBarcodeArray.get(i);
					 
					 CreateBarCode cBarCode = new CreateBarCode(jsonObject.getString("barCodeRowId"), jsonObject.getString("productId"), jsonObject.getString("grnNo"), jsonObject.getString("grnId"), jsonObject.getString("brand"), jsonObject.getString("modelNo"), jsonObject.getString("color"), jsonObject.getString("size"), jsonObject.getInt("qty"), jsonObject.getFloat("cost"), jsonObject.getString("type"), jsonObject.getFloat("price"), jsonObject.getString("hsnId"));
					 
					 System.out.println(jsonObject+"..................jsonObject......"+i);
					  
					 status =  grnService.addNewBarcode(cBarCode);
				  }
			  } 
			  catch (Exception e) 
			  {
				  e.printStackTrace();
			  }
			  
			  return status; 
		  }
		  
		  /*** Listing GRN List in Json Format ***/
		    @RequestMapping(value = "/grnList", produces = "application/json", method = RequestMethod.GET)
			public @ResponseBody HashMap getAllGRNListData(Model model, HttpSession session) 
		    {
				
		    		HashMap<String, Object> hm = new HashMap();
				
				 	List listgrn = grnService.getAllGRNList();
			        
			        hm.put("data", listgrn);
			        
			        return hm ;
				
			}
		    
		    /*** Listing ProductBasedGRN List in Json Format ***/
		    @RequestMapping(value = "/getProductBasedGRNList", produces = "application/json", method = RequestMethod.GET)
			public @ResponseBody HashMap getProductBasedBarcodeListData(Model model, HttpSession session, @RequestParam("grnId")String grnId) 
		    {
				
		    		HashMap<String, Object> hm = new HashMap();
				
				 	List listProductBased = grnService.getProductBasedBarcodeList(grnId);
			        
			        hm.put("data", listProductBased);
			        
			        return hm ;
				
		   }
}
