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

import com.pojo.Selvet;
import com.pojo.Tray;
import com.service.SelvetService;

@Controller
@WebListener
public class SelvetController {
	@Autowired
	private SelvetService selvetService;

	public void setSelvetService(SelvetService selvetService) {
		this.selvetService = selvetService;
	}
	
  
  @RequestMapping(value="/showSelvet",method=RequestMethod.GET)
  public  ModelAndView showTray(ModelAndView model)
  {
  	System.out.println("Hello Selvet");
  	model.addObject("selvet",new Selvet());
  	model.setViewName("selvet/selvet");
  	return model;
  	
  }
  /*** Listing Selvet List in Json Format ***/
  @RequestMapping(value="/listSelvet",method=RequestMethod.GET)
  public @ResponseBody HashMap listSelvet(Model model,HttpSession session) {
	  System.out.println("listing Selvet");
	  HashMap<String, Object> hm=new HashMap<>();
	  List listSelvet=selvetService.getAllSelvets();
	  hm.put("data", listSelvet);
	  return hm;
	  
  }
  /*** Add Selvet  ***/
  @PostMapping("/selvetRegister")
  public  @ResponseBody int register(@ModelAttribute("selvet")Selvet selvet,BindingResult br,@RequestParam("action")String action) {
	  System.out.println(selvet +"");
		System.out.println(action +"");
		System.out.println("Selvet data is"+selvet);
		int status=0;
		try {
			status=selvetService.addSelvet(selvet,action);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
  }
  
  /*** Update Selvet  ***/
  @PostMapping("/updateSelvet")
  public @ResponseBody int updateSelvet(@ModelAttribute("selvet")Selvet selvet,@RequestParam("action")String action)
  {
	  System.out.println(action +"");
	  int status=0;
	  try {
		  status=selvetService.updateSelvet(selvet,action);
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return status;
	  
	  
  }
  /*** Delete Selvet  ***/
  @RequestMapping(value="/deleteSelvet",method=RequestMethod.POST)
  public @ResponseBody int deleteSelvet(Selvet selvet,@RequestParam("rowNo")int rowNo) {
	  int status=0;
	  System.out.println("in delete selvet");
	  try {
		  status=selvetService.deleteSelvet(selvet,rowNo);System.out.println("delete done");
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return status;
	  
  }
}
