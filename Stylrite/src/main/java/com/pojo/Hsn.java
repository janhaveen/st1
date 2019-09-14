package com.pojo;


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
@Table(name="d_hsn" )
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Hsn")
@Proxy(lazy = false)
public class Hsn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(unique = true,name="rowId")
	private String rowId;

	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="ugst")
	private float ugst;
	
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;

	@Column(name="isDeleted")
	private String isDeleted;
	
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

	

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getUgst() {
		return ugst;
	}

	public void setUgst(float ugst) {
		this.ugst = ugst;
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
    
	
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Hsn [rowNo=" + rowNo + ", rowId=" + rowId + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst
				+ ", ugst=" + ugst + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
				+ updatedBy + ", updatedOn=" + updatedOn + ", isDeleted=" + isDeleted + "]";
	}

	

	

	

}
