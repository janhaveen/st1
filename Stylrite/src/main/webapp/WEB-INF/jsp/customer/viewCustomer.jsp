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

                <%--  <jsp:include page="/WEB-INF/jsp/Header.jsp" /> --%>
                    <div class="container" id="viewAllCustomerDiv">
                        <div class="container-fluid">

                            <jsp:include page="/WEB-INF/jsp/customer/CustomerDetails.jsp" />
                            <br>
                            <div class="card HideThisElement" id="viewCustomerPageDiv">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h6 class="card-title">Open Orders</h6></div>
                                        <!-- <div class="col-md-6 "><a style="margin-left: 5px;" class="btn btn-sm btn-primary pull-right" id="printOrderDetails">Order PDF</a>
    	    <a class="btn btn-sm btn-primary pull-right" id="printLocationDetails">Location PDF</a>
    	    </div> -->
                                    </div>
                                    <hr>
                                    <!--  <div class="row"> -->
                                    <div id="OrderId">
                                        <!--  <div class="card">
                                            <div class="card-header">
                                                Order1
                                            </div>
                                            <div class="card-body">
                                                <dl class="row">

                                                    <dt class="col-sm-2">Order Id-</dt>
                                                    <dd class="col-sm-2" id="OrderIDText">12121010</dd>
                                                    <dt class="col-sm-2">Order Date-</dt>
                                                    <dd class="col-sm-2" id="OrderDateText">24/07/2019</dd>
                                                    <dt class="col-sm-2">Status-</dt>
                                                    <dd class="col-sm-2" id="StatusText">Open</dd>
                                                    <dt class="col-sm-2">Quantity-</dt>
                                                    <dd class="col-sm-2" id="QuantityText">5</dd>
                                                    <dt class="col-sm-2">Amount Payable-</dt>
                                                    <dd class="col-sm-2" id="AmountText">15000</dd>
                                                    <dt class="col-sm-2">Advance Rs-</dt>
                                                    <dd class="col-sm-2" id="AdvanceText">5000</dd>
                                                    <dt class="col-sm-2">balance Rs-</dt>
                                                    <dd class="col-sm-2" id="BalanceText">10000</dd>
                                                    <dt class="col-sm-2">Expected Delivery Date-</dt>
                                                    <dd class="col-sm-2" id="ExpectedDeliveryDateText">24052019</dd>
                                                </dl>
                                            </div>
                                        </div> -->
                                    </div>
                                  
                                    <!--      <div class="card">
                                            <div class="card-header">
                                                Order2
                                            </div>
                                            <div class="card-body">
                                                <dl class="row">

                                                    <dt class="col-sm-2">Order Id-</dt>
                                                    <dd class="col-sm-2" id="OrderIDText">12121010</dd>
                                                    <dt class="col-sm-2">Order Date-</dt>
                                                    <dd class="col-sm-2" id="OrderDateText">24/07/2019</dd>
                                                    <dt class="col-sm-2">Status-</dt>
                                                    <dd class="col-sm-2" id="StatusText">Open</dd>
                                                    <dt class="col-sm-2">Quantity-</dt>
                                                    <dd class="col-sm-2" id="QuantityText">5</dd>
                                                    <dt class="col-sm-2">Amount Payable-</dt>
                                                    <dd class="col-sm-2" id="AmountText">15000</dd>
                                                    <dt class="col-sm-2">Advance Rs-</dt>
                                                    <dd class="col-sm-2" id="AdvanceText">5000</dd>
                                                    <dt class="col-sm-2">balance Rs-</dt>
                                                    <dd class="col-sm-2" id="BalanceText">10000</dd>
                                                    <dt class="col-sm-2">Expected Delivery Date-</dt>
                                                    <dd class="col-sm-2" id="ExpectedDeliveryDateText">24052019</dd>
                                                </dl>
                                            </div>
                                        </div> -->

                                    <br>
                                    <div class="form-row">
                                        <div class="text-center mt-1-half">
                                            <button type="button" id="SubmitButtonNewOrder" class="btn btn-sm btn-primary">
                                                New Order <i class="fa fa-chcek ml-1"></i>
                                            </button>
                                            <button type="button" id="SubmitButtonNewPrescription" class="btn btn-sm btn-primary">
                                                New Prescription <i class="fa fa-chcek ml-1"></i>
                                            </button>

                                        </div>
                                    </div>
                                </div>

                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="OrderHistory-tab" data-toggle="tab" href="#OrderHistory" role="tab" aria-controls="OrderHistory" aria-selected="true">Order history</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="PaymentHistory-tab" data-toggle="tab" href="#PaymentHistory" role="tab" aria-controls="PaymentHistory" aria-selected="false">Payment History</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="Prescriptions-tab" data-toggle="tab" href="#Prescriptions" role="tab" aria-controls="Prescriptions" aria-selected="false">Prescriptions</a>
                                    </li>

                                </ul>

                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade show active" id="OrderHistory" role="tabpanel" aria-labelledby="OrderHistory-tab">

                                        <jsp:include page="/WEB-INF/jsp/order/orderList.jsp" />
                                    </div>
                                    <div class="tab-pane fade" id="PaymentHistory" role="tabpanel" aria-labelledby="PaymentHistory-tab">
                                        <p style="color: red">work in progresss ..... </p>

                                    </div>
                                    <div class="tab-pane fade" id="Prescriptions" role="tabpanel" aria-labelledby="Prescriptions-tab">
                                        <div id="PrescriptionIdCard">

                                        </div>
                                        <br>

                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>

            </body>
            <%--   <script src="<c:url value="/resources/js/customer/viewCustomer.js" />"></script>
           <script src="<c:url value="/resources/js/order/orderList.js" />"></script> --%>
                <%--  <script src="<c:url value="/resources/js/order/orderList.js" />"></script> --%>

            </html>