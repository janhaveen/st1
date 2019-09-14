 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<title>Customer</title>
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/Header.jsp" />
   <div class="container">
		<div class="container-fluid">            		
                   	<jsp:include page="/WEB-INF/jsp/customer/customerList.jsp"/>
                   	<jsp:include page="/WEB-INF/jsp/customer/customerForm.jsp"/>
                    <jsp:include page="/WEB-INF/jsp/customer/viewCustomer.jsp"/>
                   
                    <div id="customerOrderForm" class="HideThisElement">
                     <jsp:include page="/WEB-INF/jsp/order/order.jsp" />
                    </div>
                   
                   
                </div>
            </div>
<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
<jsp:include page="/WEB-INF/jsp/customer/PrescriptionModal.jsp"/>
</body>
	 <script src="<c:url value="/resources/js/customer/customerList.js"/>"></script>
	 <script src="<c:url value="/resources/js/customer/customerForm.js"/>"></script>
	 <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
     <script src="<c:url value="/resources/js/customer/viewCustomer.js" />"></script>
<%--   <script src="<c:url value="/resources/js/order/orderList.js" />"></script> --%>
</html>
 