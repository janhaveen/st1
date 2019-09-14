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
                <div class="card HideThisElement" id="saveLensesDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertLensesData" name="insertLensesData">
                            <input type="hidden" name="action" id="action">
                            <input type="hidden" name="rowId" id="LensesId">
                              <input type="hidden" name="rowNo" id="rowNo">
                            <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                            <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
                           
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="brandName">Brand <span class="mandatory-element">*</span></label>
                                    <select class="form-control" id="brandName" name="brandName">
                                        <option value="" selected>Select Brand</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                  <label id="quantitylbl" for="quantity" class="">Model <span class="mandatory-element">*</span></label>
                                    <input type="text" class="form-control capitalizeText" id="model" name="model" placeholder="model">
                                </div>
                                 <div class="form-group col-md-3">
                                    <label id="specification1lbl" for="specification1" class="">Specification 1 <span class="mandatory-element">*</span></label>
                                    <input type="text" class="form-control capitalizeText" id="specification1" name="specification1" placeholder="specification1">
                                </div>
                                 <div class="form-group col-md-3">
                                    <label id="specification2lbl" for="specification2" class="">Specification 2 <span class="mandatory-element">*</span></label>
                                    <input type="text" class="form-control capitalizeText" id="specification2" name="specification2" placeholder="specification2">
                                </div>
                            </div>
                               <div class="form-row">
                              
                               <div class="form-group col-md-3">
                                    <label id="specification3lbl" for="specification3" class="">Specification 3 <span class="mandatory-element">*</span></label>
                                    <input type="text" class="form-control capitalizeText" id="specification3" name="specification3" placeholder="specification3">
                                </div>
                                
                                 <div class="form-group col-md-3">
			                        <label>Price <span class="mandatory-element">*</span></label>
			                        <input type="number" class="form-control" id="price" name="price" placeholder="Price">
			                    </div>
			                    <div class="form-group col-md-3">
			                        <label>Cost <span class="mandatory-element">*</span></label>
			                        <input type="number" class="form-control" id="cost" name="cost" placeholder="Cost">
			                    </div>
                                
                               </div>
                            <div class="left">
                                <button type="button" class="btn btn-primary" id="SubmitButtonLenses">Submit</button>
                                <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonLenses">Update</button>
                                <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Back</button>
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>