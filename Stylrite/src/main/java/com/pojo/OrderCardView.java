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
@Table(name="orderCardView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OrderListView")
@Proxy(lazy = false)

public class OrderCardView {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="OrderItemId")
	private String OrderItemId;
	
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
	
	@Column(name="CustomerId")
    private String CustomerId;
	
	@Column(name="orderStatus")
    private String orderStatus;
	
	@Column(name="remarks")
    private String remarks;
	
	@Column(name="createdBy")
    private String createdBy;
	
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private String  createdOn;
	@Column(name="updatedOn")
	private String  updatedOn;

	public long getRowNo() {
		return rowNo;
	}

	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}

	public String getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		OrderItemId = orderItemId;
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

	

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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


	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
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

	@Override
	public String toString() {
		return "OrderCardView [rowNo=" + rowNo + ", OrderItemId=" + OrderItemId + ", barcode=" + barcode + ", brand="
				+ brand + ", color=" + color + ", size=" + size + ", price=" + price + ", qty=" + qty + ", modelNo="
				+ modelNo + ", orderId=" + orderId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", date=" + date + ", dueDate=" + dueDate + ", address=" + address
				+ ", oldLens=" + oldLens + ", oldLensReturn=" + oldLensReturn + ", bookedBy=" + bookedBy
				+ ", deliveredBy=" + deliveredBy + ", prescriptionReturned=" + prescriptionReturned + ", rxBy=" + rxBy
				+ ", CustomerId=" + CustomerId + ", orderStatus=" + orderStatus + ", remarks=" + remarks
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}

	

}
