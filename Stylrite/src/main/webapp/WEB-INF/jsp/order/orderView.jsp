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
                    
                    #vendorForButton {
                        margin-top: 25px;
                    }
                </style>

            </head>

            <body>
                <div class="card HideThisElement" id="viewOrderDiv">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <h5 class="card-title">Basic Order Details</h5></div>
                        </div>
                        <hr>
                        <dl class="row">
                            <dt class="col-sm-2">Order Id</dt>
                            <dd class="col-sm-2" id="OrderIDText">-</dd>
                            <dt class="col-sm-2">Order Date</dt>
                            <dd class="col-sm-2" id="OrderDateText">-</dd>
                            <dt class="col-sm-2">Due Date</dt>
                            <dd class="col-sm-2" id="DueDateText">-</dd>
                            <dt class="col-sm-2">Customer Name</dt>
                            <dd class="col-sm-2" id="CustomernameText">-</dd>
                            <dt class="col-sm-2">Contact Number</dt>
                            <dd class="col-sm-2" id="ContactNumberText">-</dd>
                            <dt class="col-sm-2"> Address</dt>
                            <dd class="col-sm-2" id="AddressText">-</dd>
                            <dt class="col-sm-2"> Old Lens</dt>
                            <dd class="col-sm-2" id="OldLensText">-</dd>
                            <dt class="col-sm-2"> Booked By</dt>
                            <dd class="col-sm-2" id="BookedByText">-</dd>
                            <dt class="col-sm-2"> Delivered By</dt>
                            <dd class="col-sm-2" id="DeliveredByText">-</dd>
                            <dt class="col-sm-2"> Old Lens Returned</dt>
                            <dd class="col-sm-2" id="OldLensReturnedText">-</dd>
                            <dt class="col-sm-2"> Rx By</dt>
                            <dd class="col-sm-2" id="RxByText">-</dd>
                            <dt class="col-sm-2">Prescription Returned</dt>
                            <dd class="col-sm-2" id="PrescriptionReturnedText">-</dd>
                            <dt class="col-sm-2">Amount Payable</dt>
                            <dd class="col-sm-2" id="AmountPayableText">-</dd>
                            <dt class="col-sm-2">Advance Rs</dt>
                            <dd class="col-sm-2" id="AdvanceRsText">-</dd>
                            <dt class="col-sm-2">Balance Rs</dt>
                            <dd class="col-sm-2" id="BalanceRsText">-</dd>
                             <dt class="col-sm-2">Status</dt>
                            <dd class="col-sm-2" id="StatusText">-</dd>
                            <dt class="col-sm-2">Remarks</dt>
                            <dd class="col-sm-6" id="RemarksText">-</dd>
                        </dl>
                    </div>
                    <div class="card-body">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="productDetails-tab" data-toggle="tab" href="#productDetails" role="tab" aria-controls="productDetails" aria-selected="true">Product Details</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="jobsDetails-tab" data-toggle="tab" href="#jobsDetails" role="tab" aria-controls="jobsDetails" aria-selected="true">Jobs Details</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" id="jobsList-tab" data-toggle="tab" href="#jobsList" role="tab" aria-controls="jobsList" aria-selected="true">Jobs List</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="productDetails" role="tabpanel" aria-labelledby="productDetails-tab">
                                <table id="ProductData1" class="table table-hover mb-0 nowrap">
                                    <thead>
                                        <tr id="headerrow" class="">
                                            <th>#</th>
                                            <th>Barcode</th>
                                            <th>Product</th>
                                            <th>Color</th>
                                            <th>Model No</th>
                                            <th>Size</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody id="ProductDataBody2"></tbody>
                                    <TFOOT>
	                                    <tr class='left'>
											<td colspan='7'> Total Amount</td>
											<td id='totalrs1'>0</td>
											</tr>
											<tr class='left'>
											<td colspan='7'> Discount</td>
											<td>0</td>
											</tr>
											<tr class='left'>
											<td colspan='7'> Net Amount</td>
											<td  id='totalAmountrs1'>0</td>
											</tr>
											<tr class='left'>
											<td colspan='7'> Tax Amount</td>
											<td   id='taxrs1'>0</td>
											</tr>
											<tr class='left'>
											<td colspan='7'> Amount Payable</td>
											<td id='totalPayableAmountrs1'>0</td>
										</tr>
                                    </tfoot>
                                </table>
                                <button type="button" id="receivePaymentOrder" class="btn btn-sm btn-primary">Receive Payment</button> &nbsp;
                            </div>
                            <div class="tab-pane fade" id="jobsDetails" role="tabpanel" aria-labelledby="jobsDetails-tab">
                                <div class="form-row">
                                    <div class=" form-group col-md-3">
                                        <p style="font-size: 120%;"> Job Types: </p> &nbsp; &nbsp;
                                        <input type="radio" class="radio" value="Job1" onchange="selectJob(this.value)"><b> Lens Purchase</b> &nbsp; &nbsp;
                                        <input type="radio" class="radio" value="Job2" onchange="selectJob(this.value)"><b> Fitting Job </b>
                                    </div>
								</div>
								 <div class="form-row HideThisElement" id = "showOrderJobsDiv">
                                   
                                    <jsp:include page="/WEB-INF/jsp/jobs/jobs.jsp" />
                                    
                                    <div class="col-md-3" id="expected">
                                    <label for="expectedDeliveryDate">Expected Delivery Date</label>
                                    <input type="text" id="expectedDeliveryDate" class="form-control datepicker">
                               	 </div>

                                <div class="col-md-12" >
                                    <div class="form-row" id="remarks11">
                                        <div class="form-group col-md-12">
                                            <label id="remarksLbl" for="remarks" class="">Remarks</label>
                                            <textarea class="form-control" rows="5" id="remarks" placeholder="Enter Remarks"></textarea>
                                        </div>
                                    </div>
                                </div>
								</div>
								<button type="button" id="SubmitButtonOrderJobs" class="btn btn-sm btn-primary">Submit</button> &nbsp;
                            </div>
                             <div class="tab-pane fade" id="jobsList" role="tabpanel" aria-labelledby="jobsList-tab">
                             	 <table id="showJobstableList" class="cell-border table table-hover mb-0 nowrap">
			                        <thead>
			                            <tr id="headerrow">
			                                <th>#</th>
			                                <th>Id</th>
			                                <th>ProductInfo</th>
			                                <th>Vendor Name</th>
			                                <th>Status</th>
			                                
			                              
			                            </tr>
			                            <tr id="filterrow">
			                             	<th>#</th>
			                                <th>Id</th>
			                                <th>ProductInfo</th>
			                                <th>Vendor Name</th>
			                                <th>Status</th>
			                            </tr>
			                        </thead>
			                    </table>
                             </div>
                        </div>
                        <!--                         <div class="left">
                            <button type="button" class="btn btn-primary" id="SubmitButtonEmployee">Submit</button>
                            <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonEmployee">Update</button>
                            <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Back</button>
                        </div>
 --></div>
                </div>
            </body>

            </html>