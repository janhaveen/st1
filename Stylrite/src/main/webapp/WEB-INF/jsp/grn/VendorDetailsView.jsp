<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
dl{
	margin-bottom: 0rem	!important;	
}
</style>
</head>
<body>
<p style="font-size: 120%;margin-bottom: 1%;"> Vendor Details</p>
<dl class="row">
	<dl class="col-sm-12 ">
		<dl class="row">
		 <dt class="col-sm-2">Vendor Name</dt>
		  <dd class="col-sm-2" id="VendorNameTextView">-</dd>
		  <dt class="col-sm-2">Contact Number</dt>
		  <dd class="col-sm-2" id="ContactNumberTextView">-</dd>
		  <dt class="col-sm-2">Location</dt>
		  <dd class="col-sm-2" id="LocationTextView">-</dd>
		</dl>
	</dl>
</dl>
<p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p>
<dl class="row">
	<dl class="col-sm-12">
		<dl class="row">
		  <dt class="col-sm-2">Received By</dt>
		  <dd class="col-sm-2" id="ReceivedByTextView">-</dd>
		  <dt class="col-sm-2">Receipt Date</dt>
		  <dd class="col-sm-2" id="ReceiptDateTextView">-</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-2">Courier Name</dt>
		  	<dd class="col-sm-2" id="CourierNameTextView">-</dd>
			<dt class="col-sm-2">LR/Tracking Details</dt>
			<dd class="col-sm-2" id="LRTextView">-</dd>
			<dt class="col-sm-2">Courier Charges</dt>
			<dd class="col-sm-2" id="OtherTextView">-</dd>
		</dl>
	</dl>
</dl>
</body>
</html>