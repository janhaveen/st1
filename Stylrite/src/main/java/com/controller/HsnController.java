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
import com.pojo.Hsn;
import com.pojo.Lenses;
import com.service.HsnService;

@Controller
@WebListener
public class HsnController {
      
	@Autowired
	private HsnService hsnService;

	public void setHsnService(HsnService hsnService)
	{
		this.hsnService = hsnService;
	}
	
	/*** Page Redirect on Hsn.jsp ***/
	 @RequestMapping(value="/showHsn",method=RequestMethod.GET)
	 public ModelAndView showLenses(ModelAndView model)
	 {
		System.out.println("show Hsn");
		model.addObject("hsn",new Hsn());
		model.setViewName("hsn/hsn");
		return model;
		
	  }
	 /*** Listing Lenses in JSon Format ***/
		@RequestMapping(value="/listHsn",produces="application/json",method=RequestMethod.GET)
		public  @ResponseBody HashMap listHsn(Model model,HttpSession session) {
			System.out.println("list Hsn");
			HashMap<String, Object> hm=new HashMap<>();
			List listHsn=hsnService.getAllHsn();
			hm.put("data",listHsn);
			System.out.println("list hsn "+listHsn);
			return hm;

		}
		/*** Adding a new Hsn***/
		@PostMapping("/hsnRegister")
		public @ResponseBody int register(@ModelAttribute("hsn")Hsn hsn,BindingResult br,@RequestParam("action")String action)
		{
	            
			System.out.println(hsn+"");
			System.out.println(action+"");
			int status=0;
			status=hsnService.addHsn(hsn,action);
			System.out.println(hsn+"data");
			return status;
		}
		/*** Updating Hsn   ***/
		@RequestMapping(value="/updateHsn",method=RequestMethod.POST)
	    public @ResponseBody int updateHsn(@ModelAttribute("hsn") Hsn hsn,@RequestParam("action")String action)
		{
			int status=0;
			try {
				System.out.println(hsn+"");
				System.out.println(action +"");
				status=hsnService.updateHsn(hsn,action);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		/*** Deleting Hsn   ***/
		@RequestMapping(value="/deleteHsn",method=RequestMethod.POST)
		public @ResponseBody int deleteHsn(@RequestParam("rowNo") int rowno,Hsn hsn) {
			int status=0;
			System.out.println("in delete hsn");
			try {
				status=hsnService.deleteHsn(rowno,hsn);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("hsn status delete "+status);
			return status;
		}
		
}
