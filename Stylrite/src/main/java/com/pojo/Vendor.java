
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
@Table(name="d_vendor")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Vendor")
@Proxy(lazy = false)
public class Vendor {
	  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(unique = true,name="rowId")
	private String rowId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="vendorType")
	private String vendorType;
	
	@Column(name="source")
	private String source;

	@Column(name="referenceBy")
	private String referenceBy;
	
	@Column(name="creditTime")
	private String creditTime;
	
	@Column(name="creditLimit")
	private String creditLimit;
	
	@Column(name="salesPerson")
	private String salesPerson;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;
	
	@Column(name="isDeleted")
	private String isDeleted;

	public int getRowNo() {
		return rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getLocation() {
		return location;
	}

	public String getVendorType() {
		return vendorType;
	}

	public String getSource() {
		return source;
	}

	public String getReferenceBy() {
		return referenceBy;
	}

	public String getCreditTime() {
		return creditTime;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}

	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Vendor [rowNo=" + rowNo + ", rowId=" + rowId + ", companyName=" + companyName + ", location=" + location
				+ ", vendorType=" + vendorType + ", source=" + source + ", referenceBy=" + referenceBy + ", creditTime="
				+ creditTime + ", creditLimit=" + creditLimit + ", salesPerson=" + salesPerson + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", isDeleted=" + isDeleted + "]";
	}
	

	
	
	

}
