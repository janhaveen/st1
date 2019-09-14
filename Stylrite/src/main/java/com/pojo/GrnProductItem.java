package com.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_product_grn_item")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GrnProductItem")
@Proxy(lazy = false)
public class GrnProductItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="rowId")
	private String rowId;
	@Column(name="PID")
	private String PID;
	@Column(name="brandName")
	private String brandName;
	@Column(name="type")
	private String type;
	@Column(name="quantity")
	private int quantity;
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTypeOfProduct() {
		return typeOfProduct;
	}
	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}
	public String getGrnId() {
		return grnId;
	}
	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}
	@Column(name="typeOfProduct")
	private String typeOfProduct;
	@Column(name="grnId")
	private String grnId;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="capacity")
	private String capacity;
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
	public void setCreatedOn(Timestamp timestamp) {
		this.createdOn = timestamp;
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
		return "GrnProductItem [rowNo=" + rowNo + ", PID=" + PID + ", brandName=" + brandName + ", type=" + type
				+ ", quantity=" + quantity + ", typeOfProduct=" + typeOfProduct + ", grnId=" + grnId + "]";
	}
	public GrnProductItem() {
		
	}
	public GrnProductItem(String rowId,String brandName,String type,int quantity,String typeOfProduct,String grnId,String PID,String capacity) 
	{
		this.rowId=rowId;
		this.PID = PID;
		this.brandName = brandName;
		this.type = type;
		this.quantity=quantity;
		this.typeOfProduct=typeOfProduct;
		this.grnId=grnId;
		this.capacity=capacity;
	}

	
}
