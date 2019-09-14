package com.pojo;

import java.io.Serializable;

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
@Table(name="productLists")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProductListView")
@Proxy(lazy = false)

public class ProductListView implements Serializable
{
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name="rowId")
	private String rowId;
	@Column(name="brandName")
	private String brandName;

	@Column(name="type")
	private String type;
	
	@Column(name="quantity")
	private String  quantity;
	
	@Column(name="capacity")
	private String  capacity; 

	@Column(name="createdBy")
	private String  createdBy;
	
	@Column(name="updatedBy")
	private String  updatedBy;
	
	@Column(name="isDeleted")
	private String  isDeleted;
	
	public String getIsDeleted() {
		return isDeleted;
	}
	@Column(name="createdOn")
	private String  createdOn;
	
	@Column(name="updatedOn")
	private String updatedOn;
	@Column(name="TypeOfProduct")
	private String TypeOfProduct;
	
	
	public String getTypeOfProduct() {
		return TypeOfProduct;
	}



	public void setTypeOfProduct(String typeOfProduct) {
		TypeOfProduct = typeOfProduct;
	}



	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "ProductListView [rowId=" + rowId + ", brandName=" + brandName + ", type=" + type + ", quantity="
				+ quantity + ", capacity=" + capacity + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", isDeleted=" + isDeleted + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", TypeOfProduct=" + TypeOfProduct + "]";
	}

	

	
	
	
}
