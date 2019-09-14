<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

                <style>
                    .mandatory-element {
                        color: red;
                    }
                </style>

            </head>

            <body>
                <div class="card HideThisElement" id="custFormDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertCustomerData" name="insertCustomerData">
                            <input type="hidden" name="action" id="action">
                            <input type="hidden" name="rowId" id="CustomerId">
                            <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                            <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
                            <input type="hidden" name="rowNo" id="rowNo">
                            <!-- Grid row -->
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label id="customerNameLbl" for="customerName" class="">Customer Name <span class="mandatory-element">*</span> </label>
                                    <input type="text" class="form-control capitalizeText" id="customerName" name="customerName">
                                </div>
                                <div class="form-group col-md-4">
                                    <label id="contactNoLbl" for="contactNo" class="">Contact No <span class="mandatory-element">*</span> </label>
                                    <input type="number" maxlength="10" min="1000000000" max="9999999999" class="form-control validate" id="contactNo" name="contactNo">
                                </div>
                                <div class="form-group col-md-4">
                                    <label id="alternateContactNoLbl" for="alternateContactNo" class="">Alternate Contact No
                                    </label>
                                    <input type="number" maxlength="10" min="1000000000" max="9999999999" class="form-control" id="alternateContactNo" name="alternateContactNo">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label id="emailLbl" pattern=".+@.+..+" for="email" class="">Email <span class="mandatory-element">*</span> </label>
                                    <input type="email" class="form-control validate" id="email" name="email">
                                </div>
                                <div class="form-group col-md-4">
                                    <label id="locationLbl" for="location" class="">Location <span class="mandatory-element">*</span> </label>
                                    <input type="text" class="form-control" id="location" name="location">
                                </div>
                                <div class="form-group col-md-4">
                                    <label id="companyNameLbl" for="companyName" class="">Company Name</label>
                                    <input type="text" class="form-control" id="companyName" name="companyName">
                                </div>
                            </div>

                            <!-- Grid row -->
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label id="gstNoLbl" for="gstNo" class="">GST No <span class="mandatory-element">*</span> </label>
                                    <input type="text" class="form-control validate" id="gstNo" name="gstNo">
                                </div>
                                <div class="form-group col-md-4">
                                    <label id="stateLbl" for="state" class="">State</label>
                                    <input type="text" class="form-control" id="state" name="state">
                                </div>

                                <!-- <div class="col-md-4">
                            <div class="md-form">
                                <input type="text" class="form-control" id="source" name="source">
                                <label id="sourceLbl" for="source" class="">Source</label>
                            </div>
                        </div> -->

                                <div class="form-group col-md-4">
                                    <!-- Medium input -->
                                    <label for="source" class="active">Source <span class="mandatory-element">*</span> </label>
                                    <select id="source" name="source" class="form-control">
                                        <option value="" selected>Select Source</option>
                                        <option value="301">India Mart</option>
                                        <option value="302">Other</option>
                                    </select>
                                </div>

                            </div>
                            <div class="form-row">
                                <div class="text-center mt-1-half">
                                    <button type="button" id="SubmitButtonCustomer" class="btn btn-primary">
                                        Submit <i class="fa fa-chcek ml-1"></i>
                                    </button>
                                    <button type="button" id="UpdateButtonCustomer" class="btn btn-primary HideThisElement">Update</button>
                                    <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Close</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>