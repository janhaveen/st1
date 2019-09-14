package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

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
@Table(name="d_order_lens_item")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OrderLensItem")
@Proxy(lazy = false)
public class OrderLensItem implements Serializable
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
		
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="brand")
	private String  brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="specification1")
	private String specification1;
	
	@Column(name="specification2")
	private String specification2;
	
	@Column(name="isDeleted")
	private String isDeleted;
	
	@Column(name="specification3")
	private String specification3;

	@Column(name="qty")
	private int  qty;
	
    @Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;
	
	public OrderLensItem() 
	{
		
	}

	

	public OrderLensItem(String rowId, String orderId, String brand, String model, int qty, String specification1,String specification2, String specification3) 
	{
		this.rowId = rowId;
		this.orderId = orderId;
		this.brand = brand;
		this.model = model;
		this.qty = qty;
		this.specification1 = specification1;
		this.specification2 = specification2;
		this.specification3 = specification3;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSpecification1() {
		return specification1;
	}

	public void setSpecification1(String specification1) {
		this.specification1 = specification1;
	}

	public String getSpecification2() {
		return specification2;
	}

	public void setSpecification2(String specification2) {
		this.specification2 = specification2;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getSpecification3() {
		return specification3;
	}

	public void setSpecification3(String specification3) {
		this.specification3 = specification3;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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