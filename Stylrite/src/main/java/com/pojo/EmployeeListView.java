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
@Table(name="employeelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EmployeeListView")
@Proxy(lazy = false)

public class EmployeeListView implements Serializable
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
	
	@Column(name="firstName")
    private String firstName;
	
	@Column(name="lastName")
    private String lastName;
	
	@Column(name="empName")
    private String empName;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name="genderText")
    private String genderText;
	
	@Column(name="mobileNo")
    private Long mobileNo;
	
	@Column(name="altContactNo")
    private Long altContactNo;
	
	@Column(name="emailId")
    private String emailId;
	
	@Column(name="department")
    private String department;
	
	@Column(name="deptText")
    private String deptText;
	
	@Column(name="designation")
    private String designation;
	
	@Column(name="desigText")
    private String desigText;
	
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
	
	@Column(name="statusText")
    private String statusText;
	
	@Column(name="DOB")
    private Date DOB;
	
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
	
	@Column(name="joiningDate")
    private Date joiningDate;
	
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
	private String createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private String updatedOn;

	public EmployeeListView() 
	{
		
	}

	public EmployeeListView(long rowNo, String rowId, String firstName, String lastName, String empName, String gender,
			String genderText, Long mobileNo, Long altContactNo, String emailId, String department, String deptText,
			String designation, String desigText, String reportTo, String userId, String password, String location,
			String status, String statusText, Date DOB, String inputAddress, String inputAddress2,
			String inputCity, String inputState, String inputZip, Date joiningDate, Float basicSalary,
			Float travelAllowance, Float dearnessAllowance, Float houseRentAllowance, Float conveyanceAllowance,
			Float specialAllowance, Float variableSalary, Float ePF, Float eSIC, Float professionalTax, Float mediclaim,
			Float statutoryBonus, String accountNo, String bankName, String bankBranch, String iFSCCode,
			String isdeleted, String createdBy, String createdOn, String updatedBy, String updatedOn) {
		super();
		this.rowNo = rowNo;
		this.rowId = rowId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empName = empName;
		this.gender = gender;
		this.genderText = genderText;
		this.mobileNo = mobileNo;
		this.altContactNo = altContactNo;
		this.emailId = emailId;
		this.department = department;
		this.deptText = deptText;
		this.designation = designation;
		this.desigText = desigText;
		this.reportTo = reportTo;
		this.userId = userId;
		this.password = password;
		this.location = location;
		this.status = status;
		this.statusText = statusText;
		this.DOB = DOB;
		this.inputAddress = inputAddress;
		this.inputAddress2 = inputAddress2;
		this.inputCity = inputCity;
		this.inputState = inputState;
		this.inputZip = inputZip;
		this.joiningDate = joiningDate;
		this.basicSalary = basicSalary;
		this.travelAllowance = travelAllowance;
		this.dearnessAllowance = dearnessAllowance;
		this.houseRentAllowance = houseRentAllowance;
		this.conveyanceAllowance = conveyanceAllowance;
		this.specialAllowance = specialAllowance;
		this.variableSalary = variableSalary;
		this.ePF = ePF;
		this.eSIC = eSIC;
		this.professionalTax = professionalTax;
		this.mediclaim = mediclaim;
		this.statutoryBonus = statutoryBonus;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.iFSCCode = iFSCCode;
		this.isdeleted = isdeleted;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
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

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGenderText() {
		return genderText;
	}

	public void setGenderText(String genderText) {
		this.genderText = genderText;
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

	public String getDeptText() {
		return deptText;
	}

	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesigText() {
		return desigText;
	}

	public void setDesigText(String desigText) {
		this.desigText = desigText;
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
     
	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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
}