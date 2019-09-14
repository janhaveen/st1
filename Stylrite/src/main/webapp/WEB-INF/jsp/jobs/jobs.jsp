<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Jobs</title>
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
        </head>

    <body>
    <div class="container">
		<div class="container-fluid">
         <jsp:include page="/WEB-INF/jsp/jobs/jobsForm.jsp"/>
          <jsp:include page="/WEB-INF/jsp/jobs/jobsList.jsp"/>
        </div>
     </div>
    </body>
      <jsp:include page="/WEB-INF/jsp/jobs/SelectJobVendorModal.jsp" />
      <jsp:include page="/WEB-INF/jsp/jobs/SelectJobFrameAndSunglassModal.jsp" />
    </html>