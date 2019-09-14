package com.pojo;

import java.sql.Timestamp;

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
@Table(name="d_lenses" )
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lenses")
@Proxy(lazy = false)
public class Lenses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="model")
	private String model;
	
	@Column(name="specification1")
	private String specification1;
	
	@Column(name="specification2")
	private String specification2;

	@Column(name="price")
	private float  price;
	
	@Column(name="cost")
	private float cost;
	
	@Column(name="qty")
	private int  qty;
	
	@Column(name="isDeleted")
	private String isDeleted;
	
	@Column(name="specification3")
	private String specification3;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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
		return "Lenses [rowNo=" + rowNo + ", rowId=" + rowId + ", brandName=" + brandName + ", model=" + model
				+ ", specification1=" + specification1 + ", specification2=" + specification2 + ", price=" + price
				+ ", cost=" + cost + ", qty=" + qty + ", isDeleted=" + isDeleted + ", specification3=" + specification3
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
}
	
	
	
	
	
	
	


