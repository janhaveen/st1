<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Order</title>
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
        </head>

        <body>
       <div id="headerDiv">
            <jsp:include page="/WEB-INF/jsp/Header.jsp" />
           </div>
            <div class="container">
                <div class="container-fluid">
                <div id="orderListDiv">
                    <jsp:include page="/WEB-INF/jsp/order/orderList.jsp" />
                    </div>
                    <jsp:include page="/WEB-INF/jsp/order/orderForm.jsp" />
                    <jsp:include page="/WEB-INF/jsp/order/orderView.jsp" />
                </div>
            </div>
           <div id="footerDiv">
            <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
            </div>
             <jsp:include page="/WEB-INF/jsp/order/selectLensesModal.jsp" />
             <jsp:include page="/WEB-INF/jsp/order/selectPrescriptionModal.jsp" />
        </body>
	        <script src="<c:url value="/resources/js/order/orderList.js" />"></script>
	        <script src="<c:url value="/resources/js/vendors/vendorList.js"/>"></script>
	        
	        <script src="<c:url value="/resources/js/jobs/jobsList.js"/>"></script>
	        <script src="<c:url value="/resources/js/jobs/jobsForm.js"/>"></script>
	        <script src="<c:url value="/resources/js/lenses/lensesList.js"/>"></script>
	          <script src="<c:url value="/resources/js/order/prescriptionList.js"/>"></script>
	        <script src="<c:url value="/resources/js/order/orderForm.js" />"></script>
	        <script src="<c:url value="/resources/js/order/orderCalculation.js" />"></script>	      
	        <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
        </html>
        