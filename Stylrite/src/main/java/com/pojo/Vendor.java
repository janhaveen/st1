package com.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="d_vendor")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Vendor")
@Proxy(lazy = false)
public class Vendor implements Serializable
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
	
	@Column(name="vendorName")
	private String vendorName;
	
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
	
	/*
	 * @OneToMany(mappedBy="d_customer",cascade = CascadeType.ALL,fetch =
	 * FetchType.EAGER)
	 * 
	 * @JsonIgnore private Set<LogInLogOutlog> logInLogOutLog;
	 */
	
	public Vendor() 
	{
		
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
	
	/*
	 * public Set<LogInLogOutlog> getLogInLogOutLog() { return logInLogOutLog; }
	 * 
	 * 
	 * public void setLogInLogOutLog(Set<LogInLogOutlog> logInLogOutLog) {
	 * this.logInLogOutLog = logInLogOutLog; }
	 */


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
		return "Vendor [rowNo=" + rowNo + ", rowId=" + rowId + ", vendorName=" + vendorName + ", contactNo=" + contactNo
				+ ", alternateContactNo=" + alternateContactNo + ", email=" + email + ", password=" + password
				+ ", location=" + location + ", companyName=" + companyName + ", gstNo=" + gstNo + ", state=" + state
				+ ", isdeleted=" + isdeleted + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
				+ updatedBy + ", updatedOn=" + updatedOn + "]";
	}

}
