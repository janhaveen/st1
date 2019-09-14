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
@Table(name="orderListView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OrderListView")
@Proxy(lazy = false)
public class OrderListView {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(unique = true, name="rowId")
	private String rowId;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="brand")
	private String  brand;

	@Column(name="color")
	private String  color;
	
	@Column(name="size")
	private String  size;
	
	@Column(name="price")
	private float  price;
	
	@Column(name="qty")
	private int  qty;
	
	@Column(name="modelNo")
	private String modelNo;
	
	@Column(name="barcodeStatus")
	private String barcodeStatus;

	@Column(name="orderItemStatus")
	private String orderItemStatus;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="customerName")
    private String customerName;
	
	@Column(name="emailId")
    private String emailId;
	
	@Column(name="mobileNo")
    private long mobileNo;
	
	@Column(name="date")
    private Date date;
	
	@Column(name="dueDate")
    private Date dueDate;
	
	@Column(name="address")
    private String address;
	
	@Column(name="oldLens")
    private String oldLens;
	
	@Column(name="oldLensReturn")
    private String oldLensReturn;
	
	@Column(name="bookedBy")
    private String bookedBy;
	
	@Column(name="deliveredBy")
    private String deliveredBy;
	
	@Column(name="prescriptionReturned")
    private String prescriptionReturned;
	
	@Column(name="rxBy")
    private String rxBy;
	
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
	
	@Column(name="tax")
	private String tax;
	@Column( name="discount")
	private String discount;


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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getBarcodeStatus() {
		return barcodeStatus;
	}

	public void setBarcodeStatus(String barcodeStatus) {
		this.barcodeStatus = barcodeStatus;
	}

	public String getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOldLens() {
		return oldLens;
	}

	public void setOldLens(String oldLens) {
		this.oldLens = oldLens;
	}

	public String getOldLensReturn() {
		return oldLensReturn;
	}

	public void setOldLensReturn(String oldLensReturn) {
		this.oldLensReturn = oldLensReturn;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getDeliveredBy() {
		return deliveredBy;
	}

	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	public String getPrescriptionReturned() {
		return prescriptionReturned;
	}

	public void setPrescriptionReturned(String prescriptionReturned) {
		this.prescriptionReturned = prescriptionReturned;
	}

	public String getRxBy() {
		return rxBy;
	}

	public void setRxBy(String rxBy) {
		this.rxBy = rxBy;
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

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
}
