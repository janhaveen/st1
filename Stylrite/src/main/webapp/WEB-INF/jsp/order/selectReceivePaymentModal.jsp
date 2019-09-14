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
	<div class="modal fade bd-example-modal-lg" id="selectReceivePaymentModal" tabindex="-1" role="dialog" aria-labelledby="selectReceivePaymentModal" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">	      
	      <div class="modal-body">
	      	 <form id="insertReceivePaymentData" name="insertReceivePaymentData">
                <p style="font-size: 120%;margin-bottom: 1%;"> Receive Payment</p>
                <hr>
                 <input type="hidden" id="rpId">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Amount <span class="mandatory-element">*</span></label>
                        <input type="text" id="amountOrder" class="form-control" style="padding-left: 30px;">
                    </div>
                    <div class="form-group col-md-4">
                        <label>Mode Of Payment <span class="mandatory-element">*</span></label>
                        <input type="text" id="modeOfPayment" class="form-control" style="padding-left: 30px;">
                    </div>
                    <div class="form-group col-md-4">
                        <label>Reference No <span class="mandatory-element">*</span></label>
                        <input type="text" id="referenceNo" class="form-control" style="padding-left: 30px;">
                    </div>
                </div>
                
                 <div class="col-md-12" >
                   <div class="form-row" id="remarks11">
                       <div class="form-group col-md-12">
                           <label id="remarksLbl" for="remarks" class="">Remarks</label>
                           <textarea class="form-control" rows="5" id="remarks" placeholder="Enter Remarks"></textarea>
                       </div>
                   </div>
                </div>
                 <div class="form-row">
                    <div class="text-center mt-1-half">
                        <button type="button" id="saveProduct" class="btn btn-sm btn-primary">Submit</button> &nbsp;
                   		<button type="button" id="backProduct" class="btn btn-sm btn-outline-primary">Back</button>
                    </div>
                </div>
                 </form>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>