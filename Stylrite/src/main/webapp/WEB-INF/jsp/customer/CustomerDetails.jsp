<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

                <style type="text/css">
                    dl {
                        margin-bottom: 0rem !important;
                    }
                </style>
            </head>

            <body>
                <div class="card">
                    <div class="card-body HideThisElement" id="viewCustomerDiv">

                        <div class="row">
                            <div class="col-md-6">
                                <h5 class="card-title">Basic Customer Details</h5></div>
                            <!-- <div class="col-md-6 "><a style="margin-left: 5px;" class="btn btn-sm btn-primary pull-right" id="printOrderDetails">Order PDF</a>
    	    <a class="btn btn-sm btn-primary pull-right" id="printLocationDetails">Location PDF</a>
    	    </div> -->
                        </div>
                        <hr>
                        <dl class="row">
                            <dt class="col-sm-2">Customer Name</dt>
                            <dd class="col-sm-2" id="CustomerNameText">-</dd>
                            <dt class="col-sm-2">Contact Number</dt>
                            <dd class="col-sm-2" id="ContactNumberText">-</dd>
                            <dt class="col-sm-2">Alternate Contact No</dt>
                            <dd class="col-sm-2" id="AlternateContactNumberText">-</dd>
                            <dt class="col-sm-2">Email</dt>
                            <dd class="col-sm-2" id="EmailText">-</dd>
                            <dt class="col-sm-2">Location</dt>
                            <dd class="col-sm-2" id="LocationText">-</dd>
                            <dt class="col-sm-2"> Company Name</dt>
                            <dd class="col-sm-2" id="CompanyNameText">-</dd>
                            <dt class="col-sm-2"> Gst No</dt>
                            <dd class="col-sm-2" id="GstNoText">-</dd>
                            <dt class="col-sm-2">State</dt>
                            <dd class="col-sm-2" id="StateText">-</dd>
                            <dt class="col-sm-2"> Source</dt>
                            <dd class="col-sm-2" id="SourceText">-</dd>

                        </dl>
                    </div>
                </div>
            </body>

            </html>