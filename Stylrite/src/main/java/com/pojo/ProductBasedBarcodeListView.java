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
@Table(name="childbarcodelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProductBasedBarcodeListView")
@Proxy(lazy = false)
public class ProductBasedBarcodeListView implements Serializable
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
	
	@Column(name="productId")
	private String productId;

	@Column(name="brand")
	private String  brand;
	
	@Column(name="modelNo")
	private String  modelNo; 

	@Column(name="color")
	private String  color;
	
	@Column(name="size")
	private String  size;
	
	@Column(name="type")
	private String type;
	
	@Column(name="price")
	private float  price;
	
	@Column(name="qty")
	private int  qty;
	
	@Column(name="location")
	private String location;
	
	@Column(name="status")
	private String status;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Date updatedOn;
	

	public ProductBasedBarcodeListView() 
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


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModelNo() {
		return modelNo;
	}


	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
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


	@Override
	public String toString() {
		return "ProductBasedBarcodeListView [rowNo=" + rowNo + ", rowId=" + rowId + ", grnId=" + grnId
				+ ", receivedByText=" + receivedByText + ", receiptDateText=" + receiptDateText + ", vendorName="
				+ vendorName + ", vendorNo=" + vendorNo + ", vendorLocation=" + vendorLocation + ", grnNo=" + grnNo
				+ ", purchaseDateText=" + purchaseDateText + ", productId=" + productId + ", brand=" + brand
				+ ", modelNo=" + modelNo + ", color=" + color + ", size=" + size + ", type=" + type + ", price=" + price
				+ ", qty=" + qty + ", location=" + location + ", status=" + status + ", barcode=" + barcode
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
}