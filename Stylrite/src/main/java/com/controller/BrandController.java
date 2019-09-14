package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
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
import com.pojo.Brand;
import com.pojo.Customer;
import com.service.BrandService;

@Controller
@WebListener
public class BrandController 
{
	@Autowired
	private BrandService brandService;

/*** Page Redirect on brand.jsp ***/
@RequestMapping(value="/showBrand",method=RequestMethod.GET)
public  ModelAndView showBrand(ModelAndView model) {
	System.out.println("hello brand");
	model.addObject("brand",new Brand());
	model.setViewName("brand/brand");
	return model;
}

/*** Adding a new Brand***/
@PostMapping("/brandRegister")
public @ResponseBody int register(@ModelAttribute("brand")Brand brand,BindingResult br,@RequestParam("action")String action) {
	System.out.println(brand+"");
	System.out.println(action +" ");
	int status=0;
	status= brandService.addBrand(brand,action);
	System.out.println(brand +" data");
	return status;
}




/*** Listing Customer List in Json Format ***/
@RequestMapping(value="/listBrand",produces="application/json",method=RequestMethod.GET)
public @ResponseBody HashMap listBrand(Model model,HttpSession session) {
	System.out.println("list brand");
	HashMap<String, Object> hm=new HashMap<>();
	List listbrands=brandService.getAllBrands();
	hm.put("data", listbrands);
	System.out.println("listbrand is"+listbrands);
	return hm;
}


/*** Update Brand ***/
@RequestMapping(value="/updateBrand",method=RequestMethod.POST)
public @ResponseBody int updateBrand(@ModelAttribute("brand")Brand brand,@RequestParam("action")String action)
{
	int status=0;
	try {
		System.out.println(brand +"");
		System.out.println(action +"");
		status=brandService.updateBrand(brand,action);
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	
    return status;
}
/*** Delete Brand ***/
@RequestMapping(value = "/deleteBrand", method = RequestMethod.POST)
public @ResponseBody int deleteBrand(@RequestParam("rowNo") int  rowNo,  Brand brand) 
{
	int status=0;
	try {
    System.out.println("In in delete");
    status= brandService.deleteBrand(rowNo, brand);
    System.out.println("Delete Done");
	}catch(Exception e) {
		e.printStackTrace();
	}
    return status;
}
}