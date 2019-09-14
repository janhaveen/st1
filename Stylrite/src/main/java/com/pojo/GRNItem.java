package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_grnItem")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="GRNItem")
@Proxy(lazy = false)
public class GRNItem 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId")
	private String rowId;

	@Column(name="grnId")
	private String grnId;
	
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
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;
	

	public GRNItem()
	{
		
	}
	
	public GRNItem(String rowId, String productId, String grnId, String brand, String modelNo, String color, String size, int qty, float cost, String type, float price, String hsnId) 
	{
		this.rowId = rowId;
		this.productId = productId;
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


	public String getGrnId() {
		return grnId;
	}


	public void setGrnId(String grnId) {
		this.grnId = grnId;
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

	@Override
	public String toString() {
		return "GRNItem [rowNo=" + rowNo + ", rowId=" + rowId + ", grnId=" + grnId + ", productId=" + productId
				+ ", brand=" + brand + ", modelNo=" + modelNo + ", color=" + color + ", size=" + size + ", qty=" + qty
				+ ", cost=" + cost + ", type=" + type + ", price=" + price + ", hsnId=" + hsnId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}
}
