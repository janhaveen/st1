 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<main class="center">
	<a href="" style="padding:  0px;margin-left: -5%;"><img style="width: 35%; margin-top: 4%;" src="resources/img/CompanyLogo.png" class="CompanyLogo"></a>
</main>
<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
</body>
</html>