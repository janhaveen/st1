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
                <div class="card HideThisElement" id="saveBrandDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertBrandData" name="insertBrandData">
                            <input type="hidden" name="action" id="action">
                            <input type="hidden" name="rowNo" id="rowNo">
                            <input type="hidden" name="rowId" id="rowId">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label id="brandNameLbl" for="brandName" class="">Brand Name <span class="mandatory-element">*</span></label>
                                    <input type="text" class="form-control capitalizeText" id="brandName" name="brandName" placeholder="Brand Name">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="remarks">Brand Description</label>
                                    <input type="text" class="form-control capitalizeText" id="remarks" name="remarks" placeholder="Brand Description">
                                </div>
                            </div>
                            <div class="left">
                                <button type="button" class="btn btn-sm btn-primary" id="SubmitButtonBrand">Submit</button>
                                <button type="button" class="btn btn-sm btn-primary HideThisElement" id="UpdateButtonBrand">Update</button>
                                <button type="button" class="btn btn-sm btn-outline-info waves-effect" id="closeBtn">Back</button>

                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>