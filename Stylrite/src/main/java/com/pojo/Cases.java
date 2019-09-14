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
@Table(name = "d_cases")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cases")
@Proxy(lazy = false)
public class Cases {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rowNo")
	private int rowNo;
	@Column(name = "rowId")
	private String rowId;
	@Column(name = "brandName")
	private String brandName;
	@Column(name = "type")
	private String type;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "isDeleted")
	private String isDeleted;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "createdOn")
	private String createdOn;
	@Column(name = "updatedOn")
	private String updatedOn;

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

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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

	@Override
	public String toString() {
		return "Cases [rowNo=" + rowNo + ", rowId=" + rowId + ", brandName=" + brandName + ", type=" + type
				+ ", quantity=" + quantity + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

}
