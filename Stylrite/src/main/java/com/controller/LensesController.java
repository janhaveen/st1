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

import com.pojo.Cases;
import com.pojo.Customer;
import com.pojo.Lenses;
import com.service.LensesService;

@Controller
@WebListener
public class LensesController {
	@Autowired
	private LensesService lensesService;

	public void setLensesService(LensesService lensesService) {
		this.lensesService = lensesService;
	}
	
	/*** Page Redirect on Lenses.jsp ***/
	@RequestMapping(value="/showLenses",method=RequestMethod.GET)
	public ModelAndView showLenses(ModelAndView model) {
		System.out.println("show Lenses");
		model.addObject("lenses",new Lenses());
		model.setViewName("Lenses/Lenses");
		return model;
		
	}
	/*** Listing Lenses in JSon Format ***/
	@RequestMapping(value="/listLenses",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap listLenses(Model model,HttpSession session) {
		System.out.println("list Lenses");
		HashMap<String, Object> hm=new HashMap<>();
		List listLenses=lensesService.getAllLenses();
		hm.put("data",listLenses);
		System.out.println("list Lenses "+listLenses);
		return hm;
		
		
	}
	/*** Adding New  Lenses   ***/
	@PostMapping("/lensesRegister")
	  public  @ResponseBody int register(@ModelAttribute("lenses") Lenses lenses,BindingResult br,@RequestParam("action")String action) {
		System.out.println("lenses"+lenses);
		System.out.println("action"+action);
		int status=0;
		try {
			status=lensesService.addLenses(lenses,action);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("status is" +status);
		return status;
	}
	
	/*** Updating Lenses   ***/
	@RequestMapping(value ="/updateLenses", method = RequestMethod.POST)
    public @ResponseBody int updateLenses(@ModelAttribute("lenses") Lenses lenses, @RequestParam ("action") String action)
    {
    	int status = 0;
    	
    	try
		{
    		System.out.println(lenses+" ");
        	
        	System.out.println(action+" ");
        	
    		status = lensesService.updateLenses(lenses, action);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
        return status;
    }
	/*** Deleting the cases ***/
	@RequestMapping(value="/deleteLenses",method=RequestMethod.POST)
	public @ResponseBody int deleteCases(@RequestParam("rowNo")int rowNo,Lenses lenses) {
		int status=0;
		System.out.println("( in deleteLenses ");
		try {
			status=lensesService.deleteLenses(rowNo,lenses);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Lenses status delete "+status);
		return status;
	}
}
