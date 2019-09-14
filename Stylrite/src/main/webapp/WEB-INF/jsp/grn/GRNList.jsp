<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
            <title>GRN List</title>
        </head>

        <body>
            <jsp:include page="/WEB-INF/jsp/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
                    <div class="card" id="GRNDataTableDiv">
                        <div class="card-body table-responsive-md">
                            <input type="hidden" id="grnId">
                            <table id="showGRNtableList" class="cell-border table table-hover mb-0 nowrap">
                                <thead>
                                    <tr id="headerrow">
                                        <th>#</th>
                                        <th>GRN No</th>
                                        <th>Vendor Name</th>
                                        <th>Vendor No</th>
                                        <th>Vendor Location</th>
                                        <th>Purchase Date</th>
                                        <th>Received By</th>
                                        <th>Receipt Date</th>
                                        <th>Total Quantity</th>
                                        <th>Total Price</th>
                                        <th>Total Item</th>
                                    </tr>
                                    <tr id="filterrow">
                                        <th></th>
                                        <th>GRN No</th>
                                        <th>Vendor Name</th>
                                        <th>Vendor No</th>
                                        <th>Vendor Location</th>
                                        <th>Purchase Date</th>
                                        <th>Received By</th>
                                        <th>Receipt Date</th>
                                        <th>Total Quantity</th>
                                        <th>Total Price</th>
                                        <th>Total Item</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <div class="card HideThisElement" id="viewGRNFormDiv">
                        <div class="card-body">
                            <p style="font-size: 120%;margin-bottom: 1%;"> GRN Details</p>
                            <hr>
                            <dl class="row">
                                <dl class="col-sm-12 ">
                                    <dl class="row">
                                        <dt class="col-sm-2">GRN Number</dt>
                                        <dd class="col-sm-2" id="GRNNumberTextView">-</dd>
                                        <dt class="col-sm-2">Vendor Name</dt>
                                        <dd class="col-sm-2" id="VendorNameView">-</dd>
                                        <dt class="col-sm-2">Vendor Location</dt>
                                        <dd class="col-sm-2" id="VendorLocationView">-</dd>
                                    </dl>
                                    <dl class="row">
                                        <dt class="col-sm-2">Purchase Date</dt>
                                        <dd class="col-sm-2" id="PurchaseDateTextView">-</dd>
                                        <dt class="col-sm-2">Received By</dt>
                                        <dd class="col-sm-2" id="ReceivedByTextView">-</dd>
                                        <dt class="col-sm-2">Receipt Date</dt>
                                        <dd class="col-sm-2" id="ReceiptDateTextView">-</dd>
                                    </dl>
                                </dl>
                            </dl>
                               <hr>
                            <p style="font-size: 120%;margin-bottom: 1%;"> Product Details</p>
                          <!--   <hr> -->
                            <div class="col-md-12" style="text-align: right;margin-top: -3%;">
								<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						 	</div> <br>
                            <table id="showProductBarcodeList" class="cell-border table table-hover mb-0 nowrap">
                                <thead>
                                    <tr id="headerrow">
                                        <th>#</th>
                                        <th>Brand</th>
                                        <th>Model No</th>
                                        <th>Color</th>
                                        <th>Size</th>
                                        <th>Type</th>
                                        <th>Barcode</th>
                                       <!--  <th>Price</th> -->
                                    </tr>
                                </thead>
                                <tbody id="GRNListDataBody"></tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
        </body>
        <script src="<c:url value="/resources/js/grn/GRNList.js" />"></script>

        </html>