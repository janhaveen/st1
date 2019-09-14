<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Selvet</title>
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
        </head>

        <body>
            <jsp:include page="/WEB-INF/jsp/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
                    <jsp:include page="/WEB-INF/jsp/productgrn/grnProductList.jsp" />
                    
                     <jsp:include page="/WEB-INF/jsp/productgrn/viewVendorsDetais.jsp" />
                     
                     <div id="productDiv" class="HideThisElement">
						 <p style="font-size: 120%;margin-bottom: 1%;"> Product Data</p>
						 <div class="col-md-12" style="text-align: right;margin-top: -3%;">
							<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						 </div>
						<div class="col-md-12">
						    <div class="alert alert-success alert-dismissible fade show  successMsg HideThisElement" role="alert">
								 <p id="successMsg"></p>
								  <!-- <button type="button" class="close" data-dismiss="alert" aria-label="Close"> -->
								    <span aria-hidden="true">×</span>
								  </button>
							</div>
					    </div>
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
						<!--  <button type="button" id="GenerateBarcode" class="btn btn-sm btn-primary HideThisElement">Generate Barcode</button> -->
						 <a type="button" class="btn btn-sm btn-primary" id="backButton">Back</a>
					 </div>
                </div>
            </div>
            <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
        </body>
        <script src="<c:url value="/resources/js/productgrn/viewgrnProductList.js"/>"></script>
        <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
        </html>