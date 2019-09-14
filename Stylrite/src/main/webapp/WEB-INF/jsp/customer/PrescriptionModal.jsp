<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<title>Prescription Form</title>
 <style type="text/css">
       .modal-lg {
    width: 1500px;
    margin: 30px auto;
}

}
                </style>
                <!--style="width:1250px;"  -->
</head>

<body>
	<div class="modal fade bd-example-modal-lg"  id="selectPrescriptionFormModal" tabindex="-1" role="dialog" aria-labelledby="selectPrescriptionFormModal" aria-hidden="true">
	  <div class="modal-dialog modal-lg" style="width: 1500px;" role="document">
	    <div class="modal-content">	      
	      <div class="modal-body">
	        <jsp:include page="/WEB-INF/jsp/customer/PrescriptionForm.jsp"/>	
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>