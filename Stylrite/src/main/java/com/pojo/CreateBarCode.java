package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_child_barcode")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreateBarCode")
@Proxy(lazy = false)
public class CreateBarCode implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="location")
	private String location;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="modelNo")
	private String  modelNo; 

	@Column(name="color")
	private String  color;
	
	@Column(name="size")
	private String  size;

	@Column(name="qty")
	private int qty;
	
	@Column(name="cost")
	private float cost;
	
	@Column(name="type")
	private String type;
	
	@Column(name="price")
	private float  price;
	
	@Column(name="hsnId")
	private String hsnId; 
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="stockInDate")
	private Timestamp stockInDate;
	
	@Column(name="stockOutDate")
	private Timestamp stockOutDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="grnNo")
	private String grnNo;
	
	@Column(name="grnId")
	private String grnId;
	
	@Column(name="printStatus")
	private String printStatus;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;
	

	public CreateBarCode()
	{
		
	}
	
	public CreateBarCode(String rowId, String productId, String grnNo, String grnId, String brand, String modelNo, String color, String size, int qty, float cost, String type, float price, String hsnId)
	{
		this.rowId = rowId;
		this.productId = productId;
		this.grnNo = grnNo;
		this.grnId = grnId;
		this.brand = brand;
		this.modelNo = modelNo;
		this.color = color;
		this.size = size;
		this.qty = qty;
		this.cost = cost;
		this.type = type;
		this.price = price;
		this.hsnId = hsnId;
	}

	public long getRowNo() {
		return rowNo;
	}

	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getHsnId() {
		return hsnId;
	}

	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Timestamp getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Timestamp stockInDate) {
		this.stockInDate = stockInDate;
	}

	public Timestamp getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Timestamp stockOutDate) {
		this.stockOutDate = stockOutDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getGrnId() {
		return grnId;
	}

	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
}
