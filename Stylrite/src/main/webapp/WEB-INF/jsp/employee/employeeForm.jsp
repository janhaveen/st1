<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

                <style>
                    .mandatory-element 
                    {
                        color: red;
                    }
                </style>

            </head>

            <body>
             <div class="card HideThisElement" id="empFormDiv">
  				  <div class="card-body">
            		<h4>New Employee</h4>
                        <hr>
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="EmployeeDetails-tab" data-toggle="tab" href="#EmployeeDetails" role="tab" aria-controls="EmployeeDetails" aria-selected="true">Employee Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="Address-tab" data-toggle="tab" href="#AddressDetails" role="tab" aria-controls="AddressDetails" aria-selected="true">Address Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="SalaryDetails-tab" data-toggle="tab" href="#SalaryDetails" role="tab" aria-controls="SalaryDetails" aria-selected="false">Salary Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="Account-tab" data-toggle="tab" href="#AccountDetails" role="tab" aria-controls="AccountDetails" aria-selected="false">Account Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="AccessControl-tab" data-toggle="tab" href="#AccessControl" role="tab" aria-controls="AccessControl" aria-selected="false">Access Control</a>
                            </li>
                        </ul>
                        <form id="insertEmployeeData" name="insertEmployeeData">
                            <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                            <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
                            <div class="alert alert-success HideThisElement" id="successMessage"></div>
                             <input type="hidden" name="rowId" id="rowId">
                             <input type="hidden" name="action" id="action">
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="EmployeeDetails" role="tabpanel" aria-labelledby="EmployeeDetails-tab">
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label id="firstNameLbl" for="firstName" class="">First Name <span class="mandatory-element">*</span></label>
                                            <input type="text" class="form-control capitalizeText" id="firstName" name="firstName" placeholder="First Name">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label id="lastNameLbl" for="lastName" class="">Last Name <span class="mandatory-element">*</span></label>
                                            <input type="text" class="form-control capitalizeText" id="lastName" name="lastName" placeholder="Last Name">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Gender</label>
                                            <br>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="Male" value="801" checked="checked">
                                                <label class="form-check-label" for="Male">Male</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="Female" value="802">
                                                <label class="form-check-label" for="Female">Female</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label id="mobilenoLbl" for="mobileno" class="">Contact No <span class="mandatory-element">*</span></label>
                                            <input type="number" maxlength="10" min="1000000000" max="9999999999" class="form-control validate" id="mobileNo" name="mobileNo" placeholder="Contact No">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label id="altContactNoLbl" for="altContactNo" class="">Alt Contact No</label>
                                            <input type="number" class="form-control validate" id="altContactNo" name="altContactNo" placeholder="Alt Contact No">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label id="emailIdLbl" for="emailId" class="">Email ID <span class="mandatory-element">*</span></label>
                                            <input type="email" class="form-control validate" id="emailId" pattern=".+@.+..+" name="emailId" placeholder="name@example.com">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="department">Department <span class="mandatory-element">*</span></label>
                                            <select class="form-control" id="department" name="department">
                                                <option value="" selected>Select Department</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label  for="designation">Designation <span class="mandatory-element">*</span></label>
                                            <select class="form-control" id="designation" name="designation">
                                                <option value="" selected>Select Designation</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="reportTo" class="active">Supervisor </label>
                                            <select class="form-control" id="reportTo" name="reportTo">
                                                <option value="" selected>Select Supervisor</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label id="UserIdLbl" for="userId" class="">User ID <span class="mandatory-element">*</span></label>
                                            <input type="text" class="form-control" id="userId" name="userId" placeholder="User ID">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label id="locationLbl" for="location" class="">Location <span class="mandatory-element">*</span></label>
                                            <input type="text" class="form-control capitalizeText" id="location" name="location" placeholder="Location">
                                        </div>
                                        <!-- <div class="form-group col-md-4">
                    	<label>Branch <span class="mandatory-element">*</span></label>
                     	<select class="form-control" id="branch" name="branch">
                            <option value="" selected>Select Branch</option>
                        </select>                        
                    </div> -->
                                        <div class="form-group col-md-4">
                                            <label>Status</label>
                                            <br>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="status" id="Active" value="501" checked="checked">
                                                <label class="form-check-label" for="Active">Active</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="status" id="Inactive" value="502">
                                                <label class="form-check-label" for="Inactive">Inactive</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label id="birthDateLbl" for="birthDate">Select Birth Date <span class="mandatory-element">*</span></label>
                                            <input placeholder="Birth Date" type="text" id="birthDate" data-value="27 November, 2017" name="birthDate" class="form-control datepicker">
                                        </div>
                                        <!-- <div class="form-group col-md-4">
                        <label id="joinDateLbl" for="joinDate">Select Join Date <span class="mandatory-element">*</span></label>
                        <input placeholder="JoinDate" type="text" id="joinhDate" data-value="27 November, 2017" name="joinDate" class="form-control datepicker">
                    </div> -->
                                    </div>
                                    <!-- <button type="submit" class="btn btn-primary">Employee Details</button> -->
                                </div>
                                <div class="tab-pane fade" id="AddressDetails" role="tabpanel" aria-labelledby="AddressDetails-tab">
                                    <div class="form-group">
                                        <label for="inputAddress">Address Line 1</label>
                                        <input type="text" class="form-control" name="inputAddress" id="inputAddress" placeholder="Address Line 1">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAddress2">Address Line 2</label>
                                        <input type="text" class="form-control" name="inputAddress2" id="inputAddress2" placeholder="Address Line 2">
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputCity">City</label>
                                            <input type="text" class="form-control" name="inputCity" id="inputCity" placeholder="City">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="inputState">State</label>
                                            <select id="inputState" name="inputState" class="form-control">
                                                <option selected>Choose...</option>
                                                <option>...</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="inputZip">Pin</label>
                                            <input type="number" class="form-control" name="inputZip" id="inputZip" placeholder="Pin">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="SalaryDetails" role="tabpanel" aria-labelledby="SalaryDetails-tab">
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="joinDate">Joining Date</label>
                                            <input placeholder="Joining Date" type="text" id="joinDate" data-value="27 November, 2017" name="joinDate" class="form-control datepicker">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-3">
                                            <label for="basicSalary">Basic Salary</label>
                                            <input type="text" class="form-control" id="basicSalary" placeholder="Basic Salary" name="basicSalary">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="travelAllowance">Travel Allowance (TA)</label>
                                            <input type="text" class="form-control" id="travelAllowance" placeholder="Travel Allowance (TA)" name="travelAllowance">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dearnessAllowance">Dearness Allowance (DA)</label>
                                            <input type="text" class="form-control" id="dearnessAllowance" placeholder="Dearness Allowance (DA)" name="dearnessAllowance">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="houseRentAllowance">House Rent Allowance (HRA)</label>
                                            <input type="text" class="form-control" id="houseRentAllowance" placeholder="House Rent Allowance (HRA)" name="houseRentAllowance">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="conveyanceAllowance">Conveyance Allowance</label>
                                            <input type="text" class="form-control" id="conveyanceAllowance" placeholder="Conveyance Allowance" name="conveyanceAllowance">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="specialAllowance">Special Allowance</label>
                                            <input type="text" class="form-control" id="specialAllowance" placeholder="Special Allowance" name="specialAllowance">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="variableSalary">Variable Salary</label>
                                            <input type="text" class="form-control" id="variableSalary" placeholder="Variable Salary" name="variableSalary">
                                        </div>
                                    </div>
                                    <hr>
                                    <h5><li>Deduction</li></h5>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="ePF">Employee's Provident Fund (EPF)</label>
                                            <input type="text" class="form-control" name="ePF" id="ePF" placeholder="Employee's Provident Fund (EPF)">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="eSIC">ESIC (Employee Contribution)</label>
                                            <input type="text" class="form-control" name="eSIC" id="eSIC" placeholder="ESIC (Employee Contribution)">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="professionalTax">Professional Tax (PT)</label>
                                            <input type="text" class="form-control" id="professionalTax" name="professionalTax" placeholder="Professional Tax (PT)">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="mediclaim">Mediclaim</label>
                                            <input type="text" class="form-control" name="mediclaim" id="mediclaim" placeholder="Mediclaim">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="statutoryBonus">Statutory Bonus</label>
                                            <input type="text" class="form-control" id="statutoryBonus" name="statutoryBonus" placeholder="Statutory Bonus">
                                        </div>
                                    </div>
                                    <!-- <button type="submit" class="btn btn-primary">Salary Details</button> -->
                                </div>
                                <div class="tab-pane fade" id="AccountDetails" role="tabpanel" aria-labelledby="AccountDetails-tab">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="accountNo">Account No</label>
                                            <input type="text" class="form-control" id="accountNo" placeholder="Account No" name="accountNo">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="bankName">Bank Name</label>
                                            <input type="text" class="form-control" name="bankName" id="bankName" placeholder="Bank Name">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="bankBranch">Branch</label>
                                            <input type="text" class="form-control" name="bankBranch" id="bankBranch" placeholder="Branch">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="iFSCCode">IFSC Code</label>
                                            <input type="text" class="form-control" name="iFSCCode" id="iFSCCode" placeholder="IFSC Code">
                                        </div>
                                    </div>
                                    <!-- <button type="submit" class="btn btn-primary">Account Details</button> -->
                                </div>
                                <div class="tab-pane fade" id="AccessControl" role="tabpanel" aria-labelledby="AccessControl-tab">
                                  <%--   <%@include file="AccessControlOld.jsp" %> --%>
                                </div>
                            </div>
                            <div class="left">
                                <button type="button" class="btn btn-primary" id="SubmitButtonEmployee">Submit</button>
                                <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonEmployee">Update</button>
                                <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Back</button>
                            </div>
                        </form>
                        
                        </div>
                        
                        </div>
            </body>

            </html>