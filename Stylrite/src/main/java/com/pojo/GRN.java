package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_grn")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GRN")
@Proxy(lazy = false)
public class GRN implements Serializable
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
	
	@Column(name="vendorId")
	private String vendorId; 
	
	@Column(name="vendorCpId")
	private String vendorCpId;
	
	@Column(name="vendorAddrId")
	private String vendorAddrId;
	
	@Column(name="vendorName")
	private String vendorName;
	
	@Column(name="vendorNo")
	private String vendorNo;
	
	@Column(name="vendorLocation")
	private String vendorLocation;
	
	@Column(name="grnNo")
	private String grnNo;
	
	@Column(name="purchaseDateText")
	private Date purchaseDateText;
	
	@Column(name="receivedByText")
	private String receivedByText;
	
	@Column(name="receiptDateText")
	private Date receiptDateText;
	
	@Column(name="remarks")
	private String remarks;
	
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

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorCpId() {
		return vendorCpId;
	}

	public void setVendorCpId(String vendorCpId) {
		this.vendorCpId = vendorCpId;
	}

	public String getVendorAddrId() {
		return vendorAddrId;
	}

	public void setVendorAddrId(String vendorAddrId) {
		this.vendorAddrId = vendorAddrId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorNo() {
		return vendorNo;
	}

	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}

	public String getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public Date getPurchaseDateText() {
		return purchaseDateText;
	}

	public void setPurchaseDateText(Date purchaseDateText) {
		this.purchaseDateText = purchaseDateText;
	}

	public String getReceivedByText() {
		return receivedByText;
	}

	public void setReceivedByText(String receivedByText) {
		this.receivedByText = receivedByText;
	}

	public Date getReceiptDateText() {
		return receiptDateText;
	}

	public void setReceiptDateText(Date receiptDateText) {
		this.receiptDateText = receiptDateText;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		return "GRN [rowNo=" + rowNo + ", rowId=" + rowId + ", vendorId=" + vendorId + ", vendorCpId=" + vendorCpId
				+ ", vendorAddrId=" + vendorAddrId + ", vendorName=" + vendorName + ", vendorNo=" + vendorNo
				+ ", vendorLocation=" + vendorLocation + ", grnNo=" + grnNo + ", purchaseDateText=" + purchaseDateText
				+ ", receivedByText=" + receivedByText + ", receiptDateText=" + receiptDateText + ", remarks=" + remarks
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
}
