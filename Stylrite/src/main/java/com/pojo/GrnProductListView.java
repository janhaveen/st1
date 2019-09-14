package com.pojo;

import java.sql.Date;
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
@Table(name="grnProductListView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "grnProductListView")
@Proxy(lazy = false)
public class GrnProductListView {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="type")
	private String type;
	
	@Column(name="typeOfProduct")
	private String typeOfProduct;
	
	@Column(name="PID")
	private String PID;
	
	@Column(name="grnId")
	private String grnId;
	
	@Column(name="vendorName")
	private String vendorName;
	
	@Column(name="VendorNo")
	private String VendorNo;
	
	@Column(name="receivedBy")
	private String receivedBy;
	
	@Column(name="vendorLocation")
	private String vendorLocation;
	
	@Column(name="receiptDate")
	private Date receiptDate;
	
	@Column(name="grnNo")
	private String grnNo;
	

	@Column(name="purchaseDate")
	private Date purchaseDate;

	@Column(name="createdBy")
	private String createdBy;

	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeOfProduct() {
		return typeOfProduct;
	}

	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	public String getGrnId() {
		return grnId;
	}

	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorNo() {
		return VendorNo;
	}

	public void setVendorNo(String vendorNo) {
		VendorNo = vendorNo;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "grnProductListView [rowNo=" + rowNo + ", rowId=" + rowId + ", brandName=" + brandName + ", quantity="
				+ quantity + ", type=" + type + ", typeOfProduct=" + typeOfProduct + ", PID=" + PID + ", grnId=" + grnId
				+ ", vendorName=" + vendorName + ", VendorNo=" + VendorNo + ", receivedBy=" + receivedBy
				+ ", vendorLocation=" + vendorLocation + ", receiptDate=" + receiptDate + ", grnNo=" + grnNo
				+ ", purchaseDate=" + purchaseDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
	
	
	

}
