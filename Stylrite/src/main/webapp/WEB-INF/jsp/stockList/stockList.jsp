<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Barcode List</title>
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
        </head>

        <body>
          <jsp:include page="/WEB-INF/jsp/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
                    <jsp:include page="/WEB-INF/jsp/stockList/BarcodeList.jsp" />
                   <%--  <jsp:include page="/WEB-INF/jsp/stockList/brandwiseStockList.jsp" /> --%>
                    
                </div>
            </div>
              <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
        </body>
        <script src="<c:url value="/resources/js/stockList/barcodeList.js"/>"></script>
       <%--    <script src="<c:url value="/resources/js/stockList/brandwiseStockList.js"/>"></script> --%>
        <%-- <script src="<c:url value="/resources/js/hsn/hsnForm.js"/>"></script>
        <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script> --%>

        </html>