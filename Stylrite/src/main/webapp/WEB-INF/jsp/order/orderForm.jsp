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
                <div class="card HideThisElement" id="saveOrderDiv">
                    <div class="card-body">
                        <h4 id="headerName"></h4>
                        <hr>
                        <form id="insertOrderData" name="insertOrderData">
                            <input type="hidden" name="rowId" id="orderId">
                            <input type="hidden" name="action" id="action">
                            <div class="card-body">
                                <p style="font-size: 120%;margin-bottom: 1%;"> Order Details</p>
                                <hr>
                                <!-- Grid row -->
                                <div class="row">
                                    <div class="form-group col-md-3">
                                        <label for="date">Date</label>
                                        <input type="text" id="date" class="form-control datepicker" name="date">
                                    </div>
                                    <div class=" form-group col-md-3">
                                        <label for="dueDate">Due Date</label>
                                        <input type="text" id="dueDate" class="form-control datepicker" name="dueDate">

                                    </div>
                                    <div class="form-group col-md-3">
                                        <label id="time" for="time" class="">Time</label>
                                        <div class="input-group bootstrap-timepicker timepicker">
                                            <input id="timepicker1" type="time" class="form-control input-small" id="time" name="time">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                                        </div>

                                    </div>
                                    <div class="form-group col-md-3">
                                    </div>

                                </div>
                            </div>
                        </form>
                        <div class="row">
                          <div class="card-body">
                            <jsp:include page="/WEB-INF/jsp/order/customerDetails.jsp" />
                           </div>
                        </div>
                        <form id="insertOrderInfo" name="insertOrderInfo">
                            <div class="row">
                                <div class=" form-group col-md-3">
                                    <label id="officeNoLbl" for="officeNo" class="">Office No</label>
                                    <input type="text" class="form-control" id="officeNo" name="officeNo">
                                </div>
                                <div class="form-group col-md-3">
                                    <label id="resiNoLbl" for="resiNo" class="">Resi No</label>
                                    <input type="text" class="form-control" id="resiNo" name="resiNo">

                                </div>
                                <div class="form-group col-md-3">
                                    <button type="button" id="SubmitNewCustomer" class="btn btn-sm btn-primary HideThisElement" style="margin-top: 30px;">
                                        Add Customer <i class="fa fa-chcek ml-1"></i>
                                    </button>
                                </div>
                                <div class="form-group col-md-3">
                                </div>

                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label id="addressLbl" for="address" class="">Address</label>
                                    <input type="text" class="form-control capitalizeText" id="address" name="address">

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-3">

                                    <label id="oldLensLbl" for="oldLens" class="">Old Lens</label>
                                    <input type="text" class="form-control" id="oldLens" name="oldLens">

                                </div>

                                <div class="form-group col-md-3">
                                    <label id="bookedByLbl" for="bookedBy" class="">Booked by</label>
                                    <input type="text" class="form-control" id="bookedBy" name="bookedBy">

                                </div>

                                <div class=" form-group col-md-3">
                                    <label id="deliveredByLbl" for="deliveredBy" class="">Delivered By</label>
                                    <input type="text" class="form-control" id="deliveredBy" name="deliveredBy">

                                </div>
                                <div class="form-group col-md-3">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-3">
                                    <label id="oldLensReturnLbl" for="oldLensReturn" class="">Old Lens Return</label>
                                    <input type="text" class="form-control" id="oldLensReturn" name="oldLensReturn">

                                </div>
                                <div class="form-group col-md-3">
                                    <label id="rxByLbl" for="rxBy" class="">Rx By</label>
                                    <input type="text" class="form-control" id="rxBy" name="rxBy">

                                </div>
                                <div class="form-group col-md-3">
                                    <label id="prescriptionReturnedLbl" for="prescriptionReturned" class="">Prescription Returned</label>
                                    <input type="text" class="form-control" id="prescriptionReturned" name="prescriptionReturned">

                                </div>
                                <div class="form-group col-md-3">
                                </div>
                            </div>
                        </form>
                        <div class="card-body">
                            <p style="font-size: 120%;margin-bottom: 1%;"> Prescription Details</p>
                            <hr>
                            <jsp:include page="/WEB-INF/jsp/customer/PrescriptionForm.jsp" />
                        </div>
                        <br>
                        <div class="card-body" id="productDetalisOrderDiv">
                            <p style="font-size: 120%;margin-bottom: 1%;">Product Details</p>
                            <hr>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label>Scan Barcode <span class="mandatory-element">*</span></label>
                                    <input type="text" id="barcode" name="barcode" class="form-control">
                                </div>

                                <div class="form-group col-md-4">

                                    <div class="form-row" style="margin-top: 10%; margin-left: 7%;">

                                        <div class="form-group col-md-4 HideThisElement">
                                            <button type="button" id="addProduct" class="btn btn-sm btn-primary">Add Product</button>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <button type="button" id="addLense" class="btn btn-sm btn-primary">Add Lense</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <jsp:include page="/WEB-INF/jsp/order/scanBarcodeProductDetails.jsp" />
                                </div>

                            </div>
                            <div class="col-md-12">
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label id="remarksLbl" for="remarks" class="">Remarks</label>
                                        <textarea class="form-control" rows="5" id="remarks" name="remarks" placeholder="Enter Remarks"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>

                        <div class="text-center mt-1-half">
                            <button type="button" id="SubmitButtonOrder" class="btn btn-primary">
                                Submit <i class="fa fa-chcek ml-1"></i>
                            </button>
                            <button type="button" id="UpdateButtonOrder" class="btn btn-primary HideThisElement">Update</button>
                            <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Close</button>
                        </div>
                    </div>
                </div>
            </body>

            </html>