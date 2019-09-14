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
@Table(name="d_brand" )
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Brand")
@Proxy(lazy = false)
public class Brand implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	@Column(name="rowId")
	private String rowId;
	@Column(name="brandName")
	private String brandName;
	@Column(name="remarks")
	private String remarks;
	@Column(name="isDeleted")
	private String isDeleted;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="updatedBy")
	private String updatedBy;
	@Column(name="createdOn")
	private String  createdOn;
	@Override
	public String toString() {
		return "Brand [rowNo=" + rowNo + ", rowId=" + rowId + ", brandName=" + brandName + ", remarks=" + remarks
				+ ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", updateBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getUpdateBy() {
		return updatedBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updatedBy = updateBy;
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
	@Column(name="updatedOn")
	private String updatedOn;

}