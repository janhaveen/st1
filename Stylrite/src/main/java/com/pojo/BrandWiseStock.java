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
@Table(name="brandwiseStock")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="BrandWiseStock")
@Proxy(lazy = false)
public class BrandWiseStock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="brand")
	private String brand;
	
	@Column(name="SunGlassesQuantity")
	private String SunGlassesQuantity;
	
	@Column(name="FramesQuantity")
	private String FramesQuantity;

	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSunGlassesQuantity() {
		return SunGlassesQuantity;
	}

	public void setSunGlassesQuantity(String sunGlassesQuantity) {
		SunGlassesQuantity = sunGlassesQuantity;
	}

	public String getFramesQuantity() {
		return FramesQuantity;
	}

	public void setFramesQuantity(String framesQuantity) {
		FramesQuantity = framesQuantity;
	}

	@Override
	public String toString() {
		return "BrandWiseStock [brand=" + brand + ", SunGlassesQuantity=" + SunGlassesQuantity + ", FramesQuantity="
				+ FramesQuantity + "]";
	}

	
	
	

}