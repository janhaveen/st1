<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>GRN</title>
                 <link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
            </head>

            <body>
                <jsp:include page="/WEB-INF/jsp/Header.jsp" />
                <div class="container">
                    <div class="container-fluid">
                        <div class="card" id="StockInDiv">
                            <div class="card-body">
                             <form name="insertGRNData" id="insertGRNData">
							 <input type="hidden" name="rowNo" id="rowNo">
							 <input type="hidden" name="rowId" id="grnId">
                                    <p style="font-size: 120%;margin-bottom: 1%;"> Vendor Details</p>
                                    <hr> 
                                    <jsp:include page="/WEB-INF/jsp/grn/vendorDetails.jsp" />
                                    <br>
                                        <p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p>
                                        <hr>
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label>GRN Number <span class="mandatory-element">*</span></label>
                                                <input type="text" id="grnNo" name = "grnNo" class="form-control">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label>Purchase Date <span class="mandatory-element">*</span></label>
                                                <input type="text" id="purchaseDateText" name="purchaseDateText" class="form-control datepicker">
                                            </div>
                                        </div>
                                        <br>

                                        <p style="font-size: 120%;margin-bottom: 1%;">Receipt Details</p>

                                        <hr>

                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label>Received By <span class="mandatory-element">*</span></label>
                                                <input type="text" id="receivedByText" name="receivedByText" class="form-control">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label>Receipt Date <span class="mandatory-element">*</span></label>
                                                <input type="text" id="receiptDateText" name="receiptDateText" class="form-control datepicker">
                                            </div>
                                        </div>
                                        
                                        </form>
                                        
                                        <p style="font-size: 120%;margin-bottom: 1%;">Product Details</p>

                                        <hr>
                                        <div class="col-md-12" id="boxInfoDiv">
                                            <div class="form-row">
                                                <div class="form-group col-md-12">
                                                     <jsp:include page="/WEB-INF/jsp/grn/productDetails.jsp" />
                                                    <div class="form-group col-md-4">
                                                    	<button type="button" id="addProduct" class="btn btn-sm btn-primary">Add New Product</button>
                                                    </div>
                                                    <table id="showProducttableList" class="cell-border table table-hover mb-0 nowrap">
                                                        <thead>
                                                            <tr id="headerrow">
                                                                <th>#</th>
                                                                <th>Brand</th>
                                                                <th>Model No</th>
                                                                <th>Color</th>
                                                                <th>Size</th>
                                                                <th>HSN ID</th>
                                                                <th>Type</th>
                                                                <th>Quantity</th>
                                                                <th>Price</th>
                                                                <th>Cost</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="ProductDataBody"></tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        
                                        <div class="col-md-12">
                                            <div class="form-row">
                                                <div class="form-group col-md-12">
                                                <label id="remarksLbl" for="remarks" class="">Remarks</label>
	                							<textarea class="form-control" rows="5" id="remarks" name="remarks" placeholder="Enter Remarks"></textarea>
                                                </div>
                                            </div>
                                         </div>
                                            <br>
                                            <button type="button" id="saveGRNProduct" class="btn btn-primary">Submit</button>
                                            <button type="button" id="submitProductGRN" class="btn btn-sm btn-primary HideThisElement">Receive</button>
                                            <button type="button" id="GenerateBarcode" class="btn btn-sm btn-primary HideThisElement">Generate Barcode</button>
                                            
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
                <jsp:include page="/WEB-INF/jsp/grn/SelectVendorModal.jsp" />
            </body>
             <script src="<c:url value="/resources/js/tray/trayList.js" />"></script>
            <script src="<c:url value="/resources/js/vendors/vendorList.js"/>"></script>
            <script src="<c:url value="/resources/js/grn/VendorInfo.js"/>"></script>
           <%--  <script src="<c:url value="/resources/js/general/DropDownForProductLegend.js"/>"></script> --%>
            <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
            </html>