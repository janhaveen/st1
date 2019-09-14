<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">
<head>
<meta charset="UTF-8">
<title>View GRN</title>
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
</head>
<body>
 <jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="StockInDiv">
    			<div class="card-body">
    				<input type="hidden" id="grn">
    				<input type="hidden" id="type">
    			 	<!-- <p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p> -->
    			 	<jsp:include page="VendorDetailsView.jsp"/>		 		
    			 	<%-- <%@include file="ReceiptDetails.jsp" %> --%>
          			 <hr>
          			 <div id="productDiv" class="HideThisElement">
						 <p style="font-size: 120%;margin-bottom: 1%;"> Product Data</p>
						 <div class="col-md-12" style="text-align: right;margin-top: -3%;">
							<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						 </div>
						 <table id="ProductData" class="table table-hover mb-0 nowrap">
						    <thead>
						        <tr id="headerrow" class="">
						            <th>#</th>
						            <th>Sku ID</th>
						            <th>Product Info</th>
						            <th>Barcode</th>
						            <th>Quantity</th>
						            <th>Cost/Unit</th>
						        </tr>
						    </thead>
						    <tbody id="ProductDataBody"></tbody>
						 </table>
						 <button type="button" id="GenerateBarcode" class="btn btn-sm btn-primary HideThisElement">Generate Barcode</button>
						<%--  <a type="button" class="btn btn-sm btn-primary" href="GRNList.jsp?t=<%=request.getParameter("t") %>">Back</a> --%>
					 </div>
    			</div>
    		</div>
    	</div>
    </div>
    <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
</body>
<script type="text/javascript" src="../JavaScripts/ViewGRN.js"></script>

</html>