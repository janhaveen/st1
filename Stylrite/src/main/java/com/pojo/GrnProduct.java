package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;



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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_product_grn")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GrnProduct")
@Proxy(lazy = false)
public class GrnProduct {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="VendorName")
	private String VendorName;
	
	@Column(name="vendorNo")
	private String VendorNo;
	
	@Column(name="vendorLocation")
	private String VendorLocation;
	
	@Column(name="grnNo")
	private String grnNo;
	
	@Column(name="purchaseDate")
	private Date purchaseDate;
	


	@Override
	public String toString() {
		return "GrnProduct [rowNo=" + rowNo + ", rowId=" + rowId + ", VendorName=" + VendorName + ", VendorNo="
				+ VendorNo + ", VendorLocation=" + VendorLocation + ", grnNo=" + grnNo + ", purchaseDate="
				+ purchaseDate + ", receivedBy=" + receivedBy + ", receiptDate=" + receiptDate + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Column(name="receivedBy")
	private String receivedBy;
	
	@Column(name="receiptDate")
	private Date receiptDate;
	
	@Column(name="createdBy")
	private String createdBy;
        
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	
	private String updatedBy;
     
	

	@Column(name="updatedOn")
	
	private Timestamp updatedOn;
	

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

	
	public String getVendorName() {
		return VendorName;
	}

	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}

	public String getVendorNo() {
		return VendorNo;
	}

	public void setVendorNo(String vendorNo) {
		VendorNo = vendorNo;
	}

	public String getVendorLocation() {
		return VendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		VendorLocation = vendorLocation;
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

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}



	
	
	
	
}
