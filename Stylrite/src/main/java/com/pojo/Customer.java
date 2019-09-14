package com.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="d_customer")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer")
@Proxy(lazy = false)
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="customerName")
	private String customerName;
	
	@NotNull
	@Column(name="contactNo")
	private long contactNo;
	
	@Column(name="alternateContactNo")
	private long alternateContactNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="location")
	private String location;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="gstNo")
	private String gstNo;
	
	@Column(name="state")
	private String state;
	
	 @Column(name="isdeleted")
	 private String isdeleted;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private String updatedOn;
	
	public Customer() 
	{
		
	}
	
	public Customer(int rowNo, String rowId, String customerName, long contactNo, long alternateContactNo, String email,
			String password, String location, String companyName, String source, String gstNo, String state,
			String isdeleted, String createdBy, String createdOn, String updatedBy, String updatedOn) 
	{
		this.rowNo = rowNo;
		this.rowId = rowId;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.alternateContactNo = alternateContactNo;
		this.email = email;
		this.password = password;
		this.location = location;
		this.companyName = companyName;
		this.source = source;
		this.gstNo = gstNo;
		this.state = state;
		this.isdeleted = isdeleted;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public long getAlternateContactNo() {
		return alternateContactNo;
	}

	public void setAlternateContactNo(long alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	@Override
	public String toString() {
		return "Customer [rowNo=" + rowNo + ", rowId=" + rowId + ", customerName=" + customerName + ", contactNo="
				+ contactNo + ", alternateContactNo=" + alternateContactNo + ", email=" + email + ", password="
				+ password + ", location=" + location + ", companyName=" + companyName + ", source=" + source
				+ ", gstNo=" + gstNo + ", state=" + state + ", isdeleted=" + isdeleted + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
	
	
}
