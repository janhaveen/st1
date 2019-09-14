package com.pojo;

import java.io.Serializable;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="d_general_legend")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Legend")
@Proxy(lazy = false)
public class Legend implements Serializable
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
	
	@Column(name="legendGroup")
	private String legendGroup;
	
	@Column(name="category")
	private String category;
	
	@Column(name="subCategory")
	private String subCategory;
	
	@Column(name="description")
	private String description;
	
	@Column(name="otherInfo")
	private String otherInfo;
	
	/*
	 * @OneToMany(mappedBy="d_customer",cascade = CascadeType.ALL,fetch =
	 * FetchType.EAGER)
	 * 
	 * @JsonIgnore private Set<LogInLogOutlog> logInLogOutLog;
	 */
	
	public Legend() 
	{
		
	}

	public Legend(long rowNo, String rowId, String legendGroup, String category, String subCategory, String description,
			String otherInfo) 
	{
		this.rowNo = rowNo;
		this.rowId = rowId;
		this.legendGroup = legendGroup;
		this.category = category;
		this.subCategory = subCategory;
		this.description = description;
		this.otherInfo = otherInfo;
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

	public String getLegendGroup() {
		return legendGroup;
	}

	public void setLegendGroup(String legendGroup) {
		this.legendGroup = legendGroup;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
