<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">
         <head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		 .searchIcon {
		        float: left;
		        margin-left: 10px;
		        margin-top: -23px;
		        position: relative;
		/*         z-index: 2;
		 */    }
		</style>
		</head>
		<body>
		 <form name="insertVendor" id="insertVendor">
		<div class="form-row">
			<div class="col-md-4">
					<label>Vendor  <span class="mandatory-element">*</span></label>
					<input type="hidden" name="VendorName" id="VendorId">
					<input type="text" id="vendorText" class="form-control" disabled="disabled" style="padding-left: 30px;">
					<i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorModal').modal('show');"></i>
			</div>
			<div class="col-md-4">
					<label>Contact No  <span class="mandatory-element">*</span></label>
					<input type="hidden" name="VendorNo" id="VendorNoId">
					<input type="text" id="vendorNoText" class="form-control" disabled style="padding-left: 30px;">
					<!-- <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i> -->
			</div>
			<div class="col-md-4">
			    <label>Location <span class="mandatory-element">*</span></label>
			    <input type="hidden" name="VendorLocation" id="VendorLocationId">
			    <input type="text" id="vendorLocationText" class="form-control" disabled style="padding-left: 30px;">
			    <!-- <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i> -->
			</div>
		</div>
		</form>
		</body>
		</html>