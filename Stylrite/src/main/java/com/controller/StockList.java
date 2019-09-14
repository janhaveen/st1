package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.BarcodeList;
import com.pojo.BrandWiseStock;
//import com.pojo.BarcodeList;
//import com.pojo.BrandWiseStock;
import com.service.StockListService;

@Controller
@WebListener
public class StockList {
     
	@Autowired
	private StockListService stockListService;

	
	public void setStockListService(StockListService stockListService) {
		this.stockListService = stockListService;
	}
	/*** Page Redirect on brandWiseStockList.jsp ***/
	@RequestMapping(value="/showBrandWiseStockList1",method=RequestMethod.GET)
	public ModelAndView showBrandWiseStockList(ModelAndView model) {
		System.out.println("brand wise stock list");
		model.addObject("brandwiseStock",new BrandWiseStock());
		model.setViewName("stockList/stockBrandWise");
		return model;
		
		
	}
	
	/*** Page Redirect on barcodeIn.jsp ***/
	@RequestMapping(value="/showBarcodeInList",method=RequestMethod.GET)
	public ModelAndView showBarcodeInList1(ModelAndView model)
	{
		System.out.println("brand In stock list");
		model.addObject("barcodeList",new BarcodeList());
		model.setViewName("stockList/BarcodeIn");
		return model;
		
		
	}
	
	/*** Page Redirect on barcodeList.jsp ***/
	@RequestMapping(value="/showBarcodeList",method=RequestMethod.GET)
	public ModelAndView showshowBarcodeList1(ModelAndView model) {
		System.out.println("brand wise stock list");
		model.addObject("barcodeList",new BarcodeList());
		model.setViewName("stockList/stockList");
		return model;
		
		
	}
	/*** Listing Barcode List in JSon Format ***/
	@RequestMapping(value="/listBarcode",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap listBarcode(Model model,HttpSession session) {
		System.out.println(" listBarcode");
		HashMap<String, Object> hm=new HashMap<>();
		List listBarcode=stockListService.getAllBarcodeList();
		hm.put("data",listBarcode);
		System.out.println("list Barcode"+listBarcode);
		return hm;
		
	}
	/*** Listing BarcodeiN List in JSon Format ***/
	@RequestMapping(value="/listInBarcode",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap listiNBarcode(Model model,HttpSession session) {
		System.out.println(" listiNBarcode");
		HashMap<String, Object> hm=new HashMap<>();
		List listBarcode=stockListService.getAlliNBarcodeList();
		hm.put("data",listBarcode);
		System.out.println("listiN Barcode"+listBarcode);
		return hm;
		
	}
	
	/*** Listing BrandWiseStockList List in JSon Format ***/
	@RequestMapping(value="/listBrandWiseStock",produces="application/json",method=RequestMethod.GET)
	public  @ResponseBody HashMap showBrandWiseStockList(Model model,HttpSession session) {
		System.out.println(" listBarcode");
		HashMap<String, Object> hm=new HashMap<>();
		List listBrandWiseStock=stockListService.getAllBrandWiseStockList();
		hm.put("data",listBrandWiseStock);
		System.out.println("list BrandWiseStock "+listBrandWiseStock);
		return hm;
		
	}
	
}
