package com.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_employee", uniqueConstraints={@UniqueConstraint(columnNames = {"rowId", "mobileNo", "emailId","userId", "accountNo"}) })
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@Proxy(lazy = false)

public class Employee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;

	@Column(name="rowId")
	private String rowId;
	
	@Column(name="firstName")
    private String firstName;
	
	@Column(name="lastName")
    private String lastName;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name="mobileNo")
    private Long mobileNo;
	
	@Column(name="altContactNo")
    private Long altContactNo;
	
	@Column(name="emailId")
    private String emailId;
	
	@Column(name="department")
    private String department;
	
	@Column(name="designation")
    private String designation;
	
	@Column(name="reportTo")
    private String reportTo;
	
	@Column(name="userId")
    private String userId;
	
	@Column(name="password")
    private String password;
	
	@Column(name="location")
    private String location;
	
	@Column(name="status")
    private String status;
	
	@Column(name="birthDate")
    private Date birthDate;
	
	/*
	 * @Column(name="branch") private String branch;
	 */
	
	@Column(name="inputAddress")
    private String inputAddress;
	
	@Column(name="inputAddress2")
    private String inputAddress2;
	
	@Column(name="inputCity")
    private String inputCity;
	
	@Column(name="inputState")
    private String inputState;
	
	@Column(name="inputZip")
    private String inputZip;
	
	@Column(name="joinDate")
    private Date joinDate;
	
	@Column(name="basicSalary")
    private Float basicSalary;
	
	@Column(name="travelAllowance")
    private Float travelAllowance;
	
	@Column(name="dearnessAllowance")
    private Float dearnessAllowance;
	
	@Column(name="houseRentAllowance")
    private Float houseRentAllowance;
	
	@Column(name="conveyanceAllowance")
    private Float conveyanceAllowance;
	
	@Column(name="specialAllowance")
    private Float specialAllowance;
	
	@Column(name="variableSalary")
    private Float variableSalary;
	
	@Column(name="ePF")
    private Float ePF;
	
	@Column(name="eSIC")
    private Float eSIC;
	
	@Column(name="professionalTax")
    private Float professionalTax;
	
	@Column(name="mediclaim")
    private Float mediclaim;
	
	@Column(name="statutoryBonus")
    private Float statutoryBonus;
	
	@Column(name="accountNo")
    private String accountNo;
	
	@Column(name="bankName")
    private String bankName;
	
	@Column(name="bankBranch")
    private String bankBranch;
	
	@Column(name="iFSCCode")
    private String iFSCCode;
	
	@Column(name="isdeleted")
	private String isdeleted;
    
	 
    @Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;

	public Employee() 
	{
		
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(Long altContactNo) {
		this.altContactNo = altContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getInputAddress() {
		return inputAddress;
	}

	public void setInputAddress(String inputAddress) {
		this.inputAddress = inputAddress;
	}

	public String getInputAddress2() {
		return inputAddress2;
	}

	public void setInputAddress2(String inputAddress2) {
		this.inputAddress2 = inputAddress2;
	}

	public String getInputCity() {
		return inputCity;
	}

	public void setInputCity(String inputCity) {
		this.inputCity = inputCity;
	}

	public String getInputState() {
		return inputState;
	}

	public void setInputState(String inputState) {
		this.inputState = inputState;
	}

	public String getInputZip() {
		return inputZip;
	}

	public void setInputZip(String inputZip) {
		this.inputZip = inputZip;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Float getTravelAllowance() {
		return travelAllowance;
	}

	public void setTravelAllowance(Float travelAllowance) {
		this.travelAllowance = travelAllowance;
	}

	public Float getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(Float dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public Float getHouseRentAllowance() {
		return houseRentAllowance;
	}

	public void setHouseRentAllowance(Float houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}

	public Float getConveyanceAllowance() {
		return conveyanceAllowance;
	}

	public void setConveyanceAllowance(Float conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public Float getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(Float specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public Float getVariableSalary() {
		return variableSalary;
	}

	public void setVariableSalary(Float variableSalary) {
		this.variableSalary = variableSalary;
	}

	public Float getePF() {
		return ePF;
	}

	public void setePF(Float ePF) {
		this.ePF = ePF;
	}

	public Float geteSIC() {
		return eSIC;
	}

	public void seteSIC(Float eSIC) {
		this.eSIC = eSIC;
	}

	public Float getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(Float professionalTax) {
		this.professionalTax = professionalTax;
	}

	public Float getMediclaim() {
		return mediclaim;
	}

	public void setMediclaim(Float mediclaim) {
		this.mediclaim = mediclaim;
	}

	public Float getStatutoryBonus() {
		return statutoryBonus;
	}

	public void setStatutoryBonus(Float statutoryBonus) {
		this.statutoryBonus = statutoryBonus;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getiFSCCode() {
		return iFSCCode;
	}

	public void setiFSCCode(String iFSCCode) {
		this.iFSCCode = iFSCCode;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
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
}