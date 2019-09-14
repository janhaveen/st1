<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>hsn</title>
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
        </head>

        <body>
          <jsp:include page="/WEB-INF/jsp/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
                    <jsp:include page="/WEB-INF/jsp/hsn/hsnForm.jsp" />
                    <jsp:include page="/WEB-INF/jsp/hsn/hsnList.jsp" />
                </div>
            </div>
              <jsp:include page="/WEB-INF/jsp/Footer.jsp" />
        </body>
        <script src="<c:url value="/resources/js/hsn/hsnList.js"/>"></script>
        <script src="<c:url value="/resources/js/hsn/hsnForm.js"/>"></script>
        <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>

        </html>