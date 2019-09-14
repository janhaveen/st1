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
import com.pojo.Tray;
import com.service.TrayService;

@Controller
@WebListener
public class TrayController {
	@Autowired
private TrayService trayService;

@RequestMapping(value="/showTray",method=RequestMethod.GET)

public  ModelAndView showTray(ModelAndView model)
{
	System.out.println("Hello tray");
	model.addObject("tray",new Tray());
	model.setViewName("tray/tray");
	return model;
	
}
/*** Listing Tray List in Json Format ***/
@RequestMapping(value="/listTray",produces="application/json",method=RequestMethod.GET)
public @ResponseBody HashMap listTray(Model model,HttpSession session) {
	HashMap<String, Object>hm=new HashMap<>();
	List listTrays=trayService.getAllTrays();
	hm.put("data",listTrays);
	hm.put("status","200");
	return hm;
	
}
/*** Listing Type List in Json Format ***/
@RequestMapping(value="/listType",produces="application/json",method=RequestMethod.GET)
public @ResponseBody HashMap listType(Model model,HttpSession session) {
	HashMap<String, Object> hm=new HashMap<>();
	List listTypes=trayService.getAllTypes();
	hm.put("data",listTypes);
	return hm;
}

/*** adding new Tray ***/
@PostMapping("/trayRegister")
public @ResponseBody int register(@ModelAttribute("tray")Tray tray,BindingResult br,@RequestParam("action")String action)
{
	System.out.println(tray +"");
	System.out.println(action +"");
	System.out.println("tray data is"+tray);
	int status=0;
	status=trayService.addTray(tray,action);
	System.out.println("STATUS IS "+status);
	return status;
}
/*** Update new Tray ***/
@PostMapping("/updateTray")
public @ResponseBody int updateTray(@ModelAttribute("tray")Tray tray,@RequestParam("action")String action) {
	
	System.out.println("tray"+"");
	System.out.println("action is"+action);
	int status =0;
	try {
		status=trayService.updateTray(tray,action);
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return status;
}
/*** Delete new Tray ***/
@RequestMapping(value = "/deleteTray", method = RequestMethod.POST)
public @ResponseBody int deleteTray(@RequestParam("rowNo")int rowNo,Tray tray) {
	int status=0;
	try {
	System.out.println("deleteing tray");
	status=trayService.deleteTray(rowNo,tray);
	System.out.println("delete done");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return status;
	
}
}

