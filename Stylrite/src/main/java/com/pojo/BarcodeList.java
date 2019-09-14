package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="barcodelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BarcodeList")
@Proxy(lazy = false)
public class BarcodeList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="barcode")
	private String barcode;
	
	@Column(name="status_txt")
	private String status_txt;
	
	@Column(name="stockIndate")
	private String stockIndate;
	
	@Column(name="stockOutDate")
	private String stockOutDate;
	

	@Column(name="productInfo")
	private String productInfo;


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public String getStatus_txt() {
		return status_txt;
	}


	public void setStatus_txt(String status_txt) {
		this.status_txt = status_txt;
	}


	public String getStockIndate() {
		return stockIndate;
	}


	public void setStockIndate(String stockIndate) {
		this.stockIndate = stockIndate;
	}


	public String getStockOutDate() {
		return stockOutDate;
	}


	public void setStockOutDate(String stockOutDate) {
		this.stockOutDate = stockOutDate;
	}


	public String getProductInfo() {
		return productInfo;
	}


	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	
	

}
