<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address</title>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" id="SelectVendorAddrModal" tabindex="-1" role="dialog" aria-labelledby="SelectProductLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">	      
	      <div class="modal-body">
	      <input type="hidden" id="addressType">
	      		<%@include file="AddressList.jsp" %>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>