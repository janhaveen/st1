<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

              <style type="text/css">
dl{
	margin-bottom: 0rem	!important;	
}
</style>

            </head>
<body >
<div class="card-body">
<div class="HideThisElement" id="viewProductGrn">
<dl class="row" >
	<dl class="col-sm-12">
		<dl class="row">
		  <dt class="col-sm-2">GRN Number</dt>
		  <dd class="col-sm-2" id="GRNNumberTextView">-</dd>
		  <dt class="col-sm-2">Vendor</dt>
		  <dd class="col-sm-2" id="VendorTextView">-</dd>
		  <dt class="col-sm-2">Contact No</dt>
			<dd class="col-sm-2" id="contactNoTextView">-</dd>
		</dl>
		</dl>
		<!-- <dl class="row">
			
			
			
		</dl> -->
	

</dl>
<dl class="row">
	<dl class="col-sm-12">
		<dl class="row">
		 <dt class="col-sm-2">Purchase Date</dt>
		  	<dd class="col-sm-2" id="PurchaseDateTextView">-</dd>
		  <dt class="col-sm-2">Receipt Date</dt>
		  <dd class="col-sm-2" id="ReceiptDateTextView">-</dd>
		  <dt class="col-sm-2">Received By</dt>
		  <dd class="col-sm-2" id="ReceivedByTextView">-</dd>
		</dl>
	
	</dl>
</dl>
 
</div>
</div>
</body>
</body>
</html>