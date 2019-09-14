<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Product Grn</title>
                <link href="<c:url value=" /resources/img/favicon.ico " />" rel="shortcut icon">
            </head>

            <body>
                <jsp:include page="/WEB-INF/jsp/Header.jsp" />
                <div class="container">
                    <div class="container-fluid">
                        <div class="card" id="StockInDiv">
                            <div class="card-body">
                                <%-- <form name="insertProductData" id="insertProductData" method="POST"> --%>
                                  
                                    <p style="font-size: 120%;margin-bottom: 1%;"> Vendor Details</p>
                                    <hr>
                                    <jsp:include page="/WEB-INF/jsp/productgrn/vendorDetails.jsp" />
                                    <br>
                                    <p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p>
                                    <hr>
                                    <form name="insertGRNProduct" id="insertGRNProduct">
                                      <input type="hidden" name="rowId" id="grnPId">
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label>GRN Number<span class="mandatory-element">*</span></label>
                                                <input type="text" id="grnNo" name="grnNo" class="form-control">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label>Purchase Date<span class="mandatory-element">*</span></label>
                                                <input type="text" id="purchaseDateText" name="purchaseDate" class="form-control datepicker">
                                            </div>
                                        </div>
                                        <br>

                                        <p style="font-size: 120%;margin-bottom: 1%;">Receipt Details</p>

                                        <hr>

                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label>Received By <span class="mandatory-element">*</span></label>
                                                <input type="text" id="receivedByText" name="receivedBy" class="form-control">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label>Receipt Date <span class="mandatory-element">*</span></label>
                                                <input type="text" id="receiptDateText" name="receiptDate" class="form-control datepicker">
                                            </div>
                                        </div>
                                         </form>
                                        <p style="font-size: 120%;margin-bottom: 1%;">Product Lists</p>

                                        <hr>

                                        <div class="col-md-12" id="boxInfoDiv">
                                            <div class="form-row">
                                                     <input type="hidden" name="rowId" id="PId">
                                                <br>
                                                <table id="showProducttableList"  class="table table-hover mb-0 nowrap">
                                                    <thead>
                                                        <tr id="headerrow">
                                                            <th>#</th>
                                                            <th>Brand</th>
                                                            <th>Type</th>
                                                            <th>Quantity</th>
                                                            <th>Capacity</th>
                                                              <th>Type of Product</th>
                                                        </tr>
                                                        <tr id="filterrow">
                                                            <th></th>
                                                            <th>Brand</th>
                                                            <th>Type</th>
                                                            <th>Quantity</th>
                                                            <th>Capacity</th>
                                                           <th>Type of Product</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>

                                        </div>
                                        <hr>
                                        <table id="ProductData" class="table table-hover mb-0 nowrap">
                                    <thead>
                                        <tr id="headerrow" class="">
                                                              <th></th>
                                                            <th>Brand</th>
                                                            <th>Type</th>
                                                            <th>Quantity</th>
                                                            <th>Capacity</th>
                                                           <th>Type of Product</th>
                                        </tr>
                                    </thead>
                                    <tbody id="ProductDataBody"></tbody>
                                 </table>
                                 <br>
                                 <div class="form-row">
                                <div class="text-center mt-1-half">
                                    <button type="button" class="btn btn-primary" id="SubmitButtonProductGrn">Submit</button>
                                    <button type="button" class="btn btn-primary HideThisElement" id="DeleteProduct">Delete</button>
                                    <!--   <button type="button" class="btn btn-primary" id="UpdateButtonProductGrn">Update</button> -->
                                    <button type="button" class="btn btn-outline-info waves-effect" id="closeBtn">Cancel</button>
                                </div>
                            </div>
                                   
                            </div>

                        </div>
                    </div>
                </div>

                <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
                <jsp:include page="/WEB-INF/jsp/grn/SelectVendorModal.jsp" />
                

            </body>
            <script src="<c:url value="/resources/js/vendors/vendorList.js "/>"></script>
            <script src="<c:url value="/resources/js/productgrn/productgrnList.js "/>"></script>
            <script src="<c:url value="/resources/js/productgrn/productgrnForm.js "/>"></script>
              <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
                     <script src="<c:url value="/resources/js/productgrn/viewgrnProductList.js"/>"></script>
            </html>