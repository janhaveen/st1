package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

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
@Table(name="d_order")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order")
@Proxy(lazy = false)
public class Order implements Serializable
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
	
	@Column(name="date")
    private Date date;
	
	@Column(name="mobileNo")
    private long mobileNo;
	
	@Column(name="oldLens")
    private String oldLens;
	
	@Column(name="bookedBy")
    private String bookedBy;
	
	@Column(name="deliveredBy")
    private String deliveredBy;
	
	@Column(name="dueDate")
    private Date dueDate;
	
	@Column(name="officeNo")
    private String officeNo;
	
	@Column(name="oldLensReturn")
    private String oldLensReturn;
	
	@Column(name="rxBy")
    private String rxBy;
	
	@Column(name="time")
    private String time;
	
	@Column(name="resiNo")
    private String resiNo;
	
	@Column(name="prescriptionReturned")
    private String prescriptionReturned;
	
	@Column(name="customerName")
    private String customerName;
	
	@Column(name="emailId")
    private String emailId;	
	
	@Column(name="address")
    private String address;
	
	@Column(name="sphRightEyeDIST")
    private String sphRightEyeDIST;
	
	@Column(name="cylRightEyeDIST")
    private String cylRightEyeDIST;
	
	@Column(name="axisRightEyeDIST")
    private String axisRightEyeDIST;
	
	@Column(name="sphRightEyeNEAR")
    private String sphRightEyeNEAR;
	
	@Column(name="cylRightEyeNEAR")
    private String cylRightEyeNEAR;
	
	@Column(name="axisRightEyeNEAR")
    private String axisRightEyeNEAR;
	
	@Column(name="sphLeftEyeDIST")
    private String sphLeftEyeDIST;
	
	@Column(name="cylLeftEyeDIST")
    private String cylLeftEyeDIST;
	
	@Column(name="axisLeftEyeDIST")
    private String axisLeftEyeDIST;
	
	@Column(name="sphLeftEyeNEAR")
    private String sphLeftEyeNEAR;
	
	@Column(name="cylLeftEyeNEAR")
    private String cylLeftEyeNEAR;
	
	@Column(name="axisLeftEyeNEAR")
    private String axisLeftEyeNEAR;
	
	@Column(name="remarks")
    private String remarks;
	
	@Column(name="dateFeild")
    private Date dateFeild;
	
	@Column(name="labfeild")
    private String labfeild;
	
	@Column(name="fittingfeild")
    private String fittingfeild;
	
	@Column(name="instructionfeild")
    private String instructionfeild;
	
	@Column(name="isdeleted")
	private String isdeleted;
	
	@Column(name="CID")
    private String CID;
	
	@Column(name="status")
    private String status;
    
    @Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;
	
	public Order() 
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOldLens() {
		return oldLens;
	}

	public void setOldLens(String oldLens) {
		this.oldLens = oldLens;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getOldLensReturn() {
		return oldLensReturn;
	}

	public void setOldLensReturn(String oldLensReturn) {
		this.oldLensReturn = oldLensReturn;
	}

	public String getRxBy() {
		return rxBy;
	}

	public void setRxBy(String rxBy) {
		this.rxBy = rxBy;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResiNo() {
		return resiNo;
	}

	public void setResiNo(String resiNo) {
		this.resiNo = resiNo;
	}

	public String getPrescriptionReturned() {
		return prescriptionReturned;
	}

	public void setPrescriptionReturned(String prescriptionReturned) {
		this.prescriptionReturned = prescriptionReturned;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSphRightEyeDIST() {
		return sphRightEyeDIST;
	}

	public void setSphRightEyeDIST(String sphRightEyeDIST) {
		this.sphRightEyeDIST = sphRightEyeDIST;
	}

	public String getCylRightEyeDIST() {
		return cylRightEyeDIST;
	}

	public void setCylRightEyeDIST(String cylRightEyeDIST) {
		this.cylRightEyeDIST = cylRightEyeDIST;
	}

	public String getAxisRightEyeDIST() {
		return axisRightEyeDIST;
	}

	public void setAxisRightEyeDIST(String axisRightEyeDIST) {
		this.axisRightEyeDIST = axisRightEyeDIST;
	}

	public String getSphRightEyeNEAR() {
		return sphRightEyeNEAR;
	}

	public void setSphRightEyeNEAR(String sphRightEyeNEAR) {
		this.sphRightEyeNEAR = sphRightEyeNEAR;
	}

	public String getCylRightEyeNEAR() {
		return cylRightEyeNEAR;
	}

	public void setCylRightEyeNEAR(String cylRightEyeNEAR) {
		this.cylRightEyeNEAR = cylRightEyeNEAR;
	}

	public String getAxisRightEyeNEAR() {
		return axisRightEyeNEAR;
	}

	public void setAxisRightEyeNEAR(String axisRightEyeNEAR) {
		this.axisRightEyeNEAR = axisRightEyeNEAR;
	}

	public String getSphLeftEyeDIST() {
		return sphLeftEyeDIST;
	}

	public void setSphLeftEyeDIST(String sphLeftEyeDIST) {
		this.sphLeftEyeDIST = sphLeftEyeDIST;
	}

	public String getCylLeftEyeDIST() {
		return cylLeftEyeDIST;
	}

	public void setCylLeftEyeDIST(String cylLeftEyeDIST) {
		this.cylLeftEyeDIST = cylLeftEyeDIST;
	}

	public String getAxisLeftEyeDIST() {
		return axisLeftEyeDIST;
	}

	public void setAxisLeftEyeDIST(String axisLeftEyeDIST) {
		this.axisLeftEyeDIST = axisLeftEyeDIST;
	}

	public String getSphLeftEyeNEAR() {
		return sphLeftEyeNEAR;
	}

	public void setSphLeftEyeNEAR(String sphLeftEyeNEAR) {
		this.sphLeftEyeNEAR = sphLeftEyeNEAR;
	}

	public String getCylLeftEyeNEAR() {
		return cylLeftEyeNEAR;
	}

	public void setCylLeftEyeNEAR(String cylLeftEyeNEAR) {
		this.cylLeftEyeNEAR = cylLeftEyeNEAR;
	}

	public String getAxisLeftEyeNEAR() {
		return axisLeftEyeNEAR;
	}

	public void setAxisLeftEyeNEAR(String axisLeftEyeNEAR) {
		this.axisLeftEyeNEAR = axisLeftEyeNEAR;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDateFeild() {
		return dateFeild;
	}

	public void setDateFeild(Date dateFeild) {
		this.dateFeild = dateFeild;
	}

	public String getLabfeild() {
		return labfeild;
	}

	public void setLabfeild(String labfeild) {
		this.labfeild = labfeild;
	}

	public String getFittingfeild() {
		return fittingfeild;
	}

	public void setFittingfeild(String fittingfeild) {
		this.fittingfeild = fittingfeild;
	}

	public String getInstructionfeild() {
		return instructionfeild;
	}

	public void setInstructionfeild(String instructionfeild) {
		this.instructionfeild = instructionfeild;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Order [rowNo=" + rowNo + ", rowId=" + rowId + ", date=" + date + ", mobileNo=" + mobileNo + ", oldLens="
				+ oldLens + ", bookedBy=" + bookedBy + ", deliveredBy=" + deliveredBy + ", dueDate=" + dueDate
				+ ", officeNo=" + officeNo + ", oldLensReturn=" + oldLensReturn + ", rxBy=" + rxBy + ", time=" + time
				+ ", resiNo=" + resiNo + ", prescriptionReturned=" + prescriptionReturned + ", customerName="
				+ customerName + ", emailId=" + emailId + ", address=" + address + ", sphRightEyeDIST="
				+ sphRightEyeDIST + ", cylRightEyeDIST=" + cylRightEyeDIST + ", axisRightEyeDIST=" + axisRightEyeDIST
				+ ", sphRightEyeNEAR=" + sphRightEyeNEAR + ", cylRightEyeNEAR=" + cylRightEyeNEAR
				+ ", axisRightEyeNEAR=" + axisRightEyeNEAR + ", sphLeftEyeDIST=" + sphLeftEyeDIST + ", cylLeftEyeDIST="
				+ cylLeftEyeDIST + ", axisLeftEyeDIST=" + axisLeftEyeDIST + ", sphLeftEyeNEAR=" + sphLeftEyeNEAR
				+ ", cylLeftEyeNEAR=" + cylLeftEyeNEAR + ", axisLeftEyeNEAR=" + axisLeftEyeNEAR + ", remarks=" + remarks
				+ ", dateFeild=" + dateFeild + ", labfeild=" + labfeild + ", fittingfeild=" + fittingfeild
				+ ", instructionfeild=" + instructionfeild + ", isdeleted=" + isdeleted + ", CID=" + CID
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
}