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
@Table(name="joblist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="JobListView")
@Proxy(lazy = false)
public class JobListView
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="rowId")
	private String rowId;
	
	@Column(name="productInfo")
	private String productInfo;
	
	@Column(name="jobsItemStatus")
	private String jobsItemStatus;
	
	@Column(name="vendorName")
	private String vendorName;

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

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getJobsItemStatus() {
		return jobsItemStatus;
	}

	public void setJobsItemStatus(String jobsItemStatus) {
		this.jobsItemStatus = jobsItemStatus;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "JobListView [rowNo=" + rowNo + ", rowId=" + rowId + ", productInfo=" + productInfo + ", jobsItemStatus="
				+ jobsItemStatus + ", vendorName=" + vendorName + "]";
	}
}