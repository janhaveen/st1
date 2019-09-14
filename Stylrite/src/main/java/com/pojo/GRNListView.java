package com.pojo;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="grnListView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GRNListView")
@Proxy(lazy = false)
public class GRNListView implements Serializable
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

	@Column(name="grnId")
	private String grnId;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="price")
	private float  price;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Date updatedOn;
	
	@Column(name="receivedByText")
	private String receivedByText;
	
	@Column(name="receiptDateText")
	private Date receiptDateText;
	
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
	
	@Column(name="itemCount")
	private String itemCount;

	public GRNListView() 
	{
		
	}

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

	public String getGrnId() {
		return grnId;
	}

	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
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

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
}