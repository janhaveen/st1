package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.dao.CasesDao;
import com.pojo.Cases;
import com.pojo.Tray;
import com.service.CasesService;

@Controller
@WebListener
public class CasesController {
	@Autowired
	private CasesService casesService;

	public void setCasesService(CasesService casesService) {
		this.casesService = casesService;
	}

	/*** Page Redirect on Cases.jsp ***/
	@RequestMapping(value="/showCases",method=RequestMethod.GET)
	public ModelAndView showCases(ModelAndView model) {
		System.out.println("show Cases");
		model.addObject("cases",new Cases());
		model.setViewName("cases/cases");
		return model;
		
	}
	/*** Listing Cases in JSon Format ***/
	@RequestMapping(value="/listCases",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap listCases(Model model,HttpSession session) {
		System.out.println("list Cases");
		HashMap<String, Object> hm=new HashMap<>();
		List listCases=casesService.getAllCases();
		hm.put("data",listCases);
		System.out.println("list Cases "+listCases);
		return hm;
		
	}
	
	/*** Adding New  Cases  ***/
	@PostMapping("/casesRegister")
	public @ResponseBody int register(@ModelAttribute("cases")Cases cases,BindingResult br,@RequestParam("action")String action) {
		System.out.println("cases"+cases);
		System.out.println("action"+action);
		int status=0;
		try {
			status=casesService.addCases(cases,action);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("status is" +status);
		return status;
	}
	/*** Updating New  Cases  ***/
	@RequestMapping(value="/updateCases",method=RequestMethod.POST)
	public @ResponseBody int updateCases(@ModelAttribute("cases")Cases cases,@RequestParam("action")String action) {
	
	 int status=0;
	try {
		System.out.println("In update Cases");
		status=casesService.updateCases(cases,action);
		System.out.println("in update done ");
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return status;
	}

	/*** Deleting the cases ***/
	@RequestMapping(value="/deleteCases",method=RequestMethod.POST)
	public @ResponseBody int deleteCases(@RequestParam("rowNo")int rowNo,Cases cases) {
		int status=0;
		System.out.println("( in deletecases ");
		try {
			status=casesService.deleteCases(rowNo,cases);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("cases status delete "+status);
		return status;
	}
}
