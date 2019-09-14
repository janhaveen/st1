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
                <div class="card HideThisElement" id="saveHsnDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertHsnData" name="insertHsnData">
                            <input type="hidden" name="action" id="action">
                            <input type="hidden" name="rowId" id="hsnId">
                              <input type="hidden" name="rowNo" id="rowNo">
                            <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                            <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
                           
                            <div class="form-row">
                                <div class="form-group col-md-5">
                               <label id="cgstlbl" for="cgst" class="">CGST <span class="mandatory-element">*</span></label>
                               <input type="number" class="form-control capitalizeText" id="cgst" name="cgst" placeholder="CGST">
                                </div>
                                <div class="form-group col-md-5">
                                  <label id="sgstlbl" for="sgst" class="">SGST <span class="mandatory-element">*</span></label>
                               <input type="number" class="form-control capitalizeText" id="sgst" name="sgst" placeholder="SGST">
                                </div>
                                 <div class="form-group col-md-2">
                                   
                                </div>
                                
                            </div>
                                <div class="form-row">
                                <div class="form-group col-md-5">
                               <label id="igstlbl" for="igst" class="">IGST <span class="mandatory-element">*</span></label>
                               <input type="number" class="form-control capitalizeText" id="igst" name="igst" placeholder="IGST">
                                </div>
                                <div class="form-group col-md-5">
                                  <label id="ugstlbl" for="ugst" class="">UGST <span class="mandatory-element">*</span></label>
                               <input type="number" class="form-control capitalizeText" id="ugst" name="ugst" placeholder="UGST">
                                </div>
                                 <div class="form-group col-md-2">
                                   
                                </div>
                                
                            </div>
                            <div class="left">
                                <button type="button" class="btn btn-primary" id="SubmitButtonHsn">Submit</button>
                                <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonHsn">Update</button>
                                <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Back</button>
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>