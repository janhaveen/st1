<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<title>Address</title>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" id="selectPrescriptionModal" tabindex="-1" role="dialog" aria-labelledby="selectLensesModal" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">	      
	      <div class="modal-body">
	      		<jsp:include page="/WEB-INF/jsp/order/PrescriptionList.jsp" />
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>