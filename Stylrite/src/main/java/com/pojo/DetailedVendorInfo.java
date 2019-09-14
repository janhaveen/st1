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
@Table(name="detailedvendorinfo")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DetailedVendorInfo")
@Proxy(lazy = false)
public class DetailedVendorInfo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;

	@Column(name="rowId")
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
	
	
	@Column(name="createdBy")
	private String createdBy;
	
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="locationadd")
	private String locationadd;
	
	@Column(name="addressId")
	private String addressId;
	
	@Column(name="branchName")
	private String branchName;
	
	@Column(name="ledgerName")
	private String ledgerName;
	
	@Column(name="addressLine1")
	private String addressLine1;
	
	@Column(name="addressLine2")
	private String addressLine2;

	@Column(name="gstNo")
	private String gstNo;
	

	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;


	@Column(name="contactPerson")
	private String contactPerson;
	
	@Column(name="CPId")
	private String CPId;
	
	@Column(name="contactNoCP")
	private long contactNoCP;
	
	
	@Column(name="altContactNoCP")
	private long altContactNoCP;
	
	@Column(name="emailIdCP")
	private String emailIdCP;
	
	@Column(name="state_text")
	private String state_text;
	
	@Column(name="source_text")
	private String source_text;
	
	@Column(name="vendorType_txt")
	private String vendorType_txt;
	
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

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public String getLocationadd() {
		return locationadd;
	}

	public String getAddressId() {
		return addressId;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getLedgerName() {
		return ledgerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getGstNo() {
		return gstNo;
	}

	public String getState() {
		return state;
	}

	public int getPincode() {
		return pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public String getCPId() {
		return CPId;
	}

	public long getContactNoCP() {
		return contactNoCP;
	}

	public long getAltContactNoCP() {
		return altContactNoCP;
	}

	public String getEmailIdCP() {
		return emailIdCP;
	}

	public String getState_text() {
		return state_text;
	}

	public String getSource_text() {
		return source_text;
	}

	public String getVendorType_txt() {
		return vendorType_txt;
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

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setLocationadd(String locationadd) {
		this.locationadd = locationadd;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public void setCPId(String cPId) {
		CPId = cPId;
	}

	public void setContactNoCP(long contactNoCP) {
		this.contactNoCP = contactNoCP;
	}

	public void setAltContactNoCP(long altContactNoCP) {
		this.altContactNoCP = altContactNoCP;
	}

	public void setEmailIdCP(String emailIdCP) {
		this.emailIdCP = emailIdCP;
	}

	public void setState_text(String state_text) {
		this.state_text = state_text;
	}

	public void setSource_text(String source_text) {
		this.source_text = source_text;
	}

	public void setVendorType_txt(String vendorType_txt) {
		this.vendorType_txt = vendorType_txt;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "DetailedVendorInfo [rowNo=" + rowNo + ", rowId=" + rowId + ", companyName=" + companyName
				+ ", location=" + location + ", vendorType=" + vendorType + ", source=" + source + ", referenceBy="
				+ referenceBy + ", creditTime=" + creditTime + ", creditLimit=" + creditLimit + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", locationadd=" + locationadd + ", addressId=" + addressId + ", branchName=" + branchName
				+ ", ledgerName=" + ledgerName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", gstNo=" + gstNo + ", state=" + state + ", pincode=" + pincode + ", contactPerson=" + contactPerson
				+ ", CPId=" + CPId + ", contactNoCP=" + contactNoCP + ", altContactNoCP=" + altContactNoCP
				+ ", emailIdCP=" + emailIdCP + ", state_text=" + state_text + ", source_text=" + source_text
				+ ", vendorType_txt=" + vendorType_txt + ", isDeleted=" + isDeleted + "]";
	}

	
	
}
