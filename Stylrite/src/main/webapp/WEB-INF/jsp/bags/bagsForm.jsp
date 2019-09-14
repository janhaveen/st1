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
                <div class="card HideThisElement" id="saveBagsDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertBagsData" name="insertBagsData">
                            <input type="hidden" name="action" id="action">
                            <input type="hidden" name="rowNo" id="rowNo">
                            <input type="hidden" name="rowId" id="rowId">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="brandName">Brand <span class="mandatory-element">*</span></label>
                                    <select class="form-control" id="brandName" name="brandName">
                                        <option value="" selected>Select Brand</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="type">Type <span class="mandatory-element">*</span></label>
                                    <select class="form-control" id="type" name="type">
                                        <option value="" selected>Select Type</option>
                                    </select>
                                </div>

                            </div>
                            <div class="form-row">
                                <div class="text-center mt-1-half">
                                    <button type="button" class="btn btn-primary" id="SubmitButtonBags">Submit</button>
                                    <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonBags">Update</button>
                                    <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Back</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>