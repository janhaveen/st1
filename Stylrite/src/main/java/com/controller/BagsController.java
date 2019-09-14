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

import com.pojo.Bags;
import com.pojo.Selvet;
import com.service.BagsService;

@Controller
@WebListener
public class BagsController {
	
	@Autowired
	private BagsService bagsService;

	public void setBagsService(BagsService bagsService) {
		this.bagsService = bagsService;
	}
	 @RequestMapping(value="/showBags",method=RequestMethod.GET)
	  public  ModelAndView showTray(ModelAndView model)
	  {
	  	System.out.println("Hello Bags");
	  	model.addObject("bags",new Bags());
	  	model.setViewName("bags/bags");
	  	return model;
	  	
	  }
	 /*** Listing Bags List in Json Format ***/
	  @RequestMapping(value="/listBags",method=RequestMethod.GET)
	  public @ResponseBody HashMap listSelvet(Model model,HttpSession session) {
		  System.out.println("listing Bags");
		  HashMap<String, Object> hm=new HashMap<>();
		  List listBags=bagsService.getAllBags();
		  hm.put("data", listBags);
		  return hm;
		  
	  }
	  /*** Add Bags  ***/
	  @PostMapping("/bagsRegister")
	  public  @ResponseBody int register(@ModelAttribute("bags") Bags bags,BindingResult br,@RequestParam("action")String action) {
		  System.out.println(bags +"");
			System.out.println(action +"");
			System.out.println("Bags data is"+bags);
			int status=0;
			try {
				status=bagsService.addBags(bags,action);
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return status;
	  }
	  /*** Update Bags  ***/
	  @PostMapping("/updateBags")
	  public @ResponseBody int updateSelvet(@ModelAttribute("bags")Bags bags,@RequestParam("action")String action)
	  {
		  System.out.println(action +"");
		  int status=0;
		  try {
			  status=bagsService.updateBags(bags,action);
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return status;
		  
		  
	  }
	  /*** Delete Bags  ***/
	  @RequestMapping(value="/deleteBags",method=RequestMethod.POST)
	  public @ResponseBody int deleteSelvet(Bags bags,@RequestParam("rowNo")int rowNo) {
		  int status=0;
		  System.out.println("in delete selvet");
		  try {
			  status=bagsService.deleteBags(bags,rowNo);System.out.println("delete done");
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return status;
		  
	  }
	  
}
