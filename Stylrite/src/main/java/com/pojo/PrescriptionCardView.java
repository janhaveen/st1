package com.pojo;

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
@Table(name="prescriptionCardView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PrescriptionDetails")
@Proxy(lazy = false)
public class PrescriptionCardView {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="rowId")
	private String rowId;
	
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
	
	@Column(name="orderId")
    private String orderId;
	
	@Column(name="clientId")
    private String clientId;
	
	@Column(name="machineTest")
    private String machineTest;
	
	@Column(name="operator")
    private String operator;
	
	@Column(name="reference")
    private String reference;
	
	@Column(name="otherInfo")
    private String otherInfo;
	
	@Column(name="cylLeftEyeNEAR")
    private String cylLeftEyeNEAR;
	
	@Column(name="axisLeftEyeNEAR")
    private String axisLeftEyeNEAR;
	

	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="updatedOn")
	private String updatedOn;

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getMachineTest() {
		return machineTest;
	}

	public void setMachineTest(String machineTest) {
		this.machineTest = machineTest;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
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
		return "PrescriptionCardView [rowNo=" + rowNo + ", rowId=" + rowId + ", sphRightEyeDIST=" + sphRightEyeDIST
				+ ", cylRightEyeDIST=" + cylRightEyeDIST + ", axisRightEyeDIST=" + axisRightEyeDIST
				+ ", sphRightEyeNEAR=" + sphRightEyeNEAR + ", cylRightEyeNEAR=" + cylRightEyeNEAR
				+ ", axisRightEyeNEAR=" + axisRightEyeNEAR + ", sphLeftEyeDIST=" + sphLeftEyeDIST + ", cylLeftEyeDIST="
				+ cylLeftEyeDIST + ", axisLeftEyeDIST=" + axisLeftEyeDIST + ", sphLeftEyeNEAR=" + sphLeftEyeNEAR
				+ ", orderId=" + orderId + ", clientId=" + clientId + ", machineTest=" + machineTest + ", operator="
				+ operator + ", reference=" + reference + ", otherInfo=" + otherInfo + ", cylLeftEyeNEAR="
				+ cylLeftEyeNEAR + ", axisLeftEyeNEAR=" + axisLeftEyeNEAR + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
	

}
