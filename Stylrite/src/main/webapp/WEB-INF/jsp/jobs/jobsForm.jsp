<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Jobs</title>
            <link href="<c:url value=" /resources/img/favicon.ico " />" rel="shortcut icon">
        </head>

        <body>
          <!--   <div class="card-body HideThisElement" id="vendorForLens">
                <p style="font-size: 120%;margin-bottom: 1%;"> Select Vendor For Lens Product</p>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Vendor <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="vendorName" id="vendorName">
                        <input type="text" id="vendorText" class="form-control" disabled="disabled" style="padding-left: 30px;">
                        <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorModal').modal('show');"></i>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contact No <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="vendorNo" id="vendorNo">
                        <input type="text" id="vendorNoText" class="form-control" disabled style="padding-left: 30px;">
                        <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Location <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="vendorLocation" id="vendorLocation">
                        <input type="text" id="vendorLocationText" class="form-control" disabled style="padding-left: 30px;">
                         <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Select Lens Product <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="vendorName" id="vendorName">
                        <input type="text" id="vendorText" class="form-control" disabled="disabled" style="padding-left: 30px;">
                        <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorModal').modal('show');"></i>
                    </div>
                    
                    <table id="lensProductData" class="table table-hover mb-0 nowrap">
                                    <thead>
                                        <tr id="headerrow" class="">
                                            <th>#</th>
                                            <th>Barcode</th>
                                            <th>Product</th>
                                            <th>Color</th>
                                            <th>Model No</th>
                                            <th>Size</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody id="lensProductDataBody"></tbody>
                                </table>

            </div>
           </div>  -->
            <div class="card-body HideThisElement" id="vendorForFitting">
            <form id="insertVendorFittingData" name="insertVendorFittingData">
                <p style="font-size: 120%;margin-bottom: 1%;"> Select Vendor For Fitting</p>
                 <input type="hidden" id="jobId">
                 <input type="hidden" name="vendorId" id="vendorId">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Vendor <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="vendorName" id="vendorName">
                        <input type="text" id="vendorText" class="form-control" disabled="disabled" style="padding-left: 30px;">
                        <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorModal').modal('show');"></i>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Contact No <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="contactNo" id="vendorNo">
                        <input type="text" id="vendorNoText" class="form-control" disabled style="padding-left: 30px;">
                        <!-- <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i> -->
                    </div>
                    <div class="form-group col-md-4">
                        <label>Location <span class="mandatory-element">*</span></label>
                        <input type="hidden" name="location" id="vendorLocation">
                        <input type="text" id="vendorLocationText" class="form-control" disabled style="padding-left: 30px;">
                        <!--  <i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i> -->
                    </div>
                </div>
             
              	 <div class="form-row">
                     <div class="form-group col-md-4">
                        <label>Select Frame & Sunglass Product <span class="mandatory-element">*</span></label>
                        <input type="text" id="frameAndSunglass" class="form-control" disabled="disabled" style="padding-left: 30px;">
                        <i class="fa fa-search prefix searchIcon" onclick="$('#SelectJobFrameAndSunglassModal').modal('show');"></i>
                    </div>
                    <table id="frameAndSunglassProductData" class="table table-hover mb-0 nowrap">
                                    <thead>
                                        <tr id="headerrow" class="">
                                            <th>Action</th>
				                            <th>BarCode</th>
				                            <th>Product Info</th>
				                            <th>Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody id="frameAndSunglassProductDataBody"></tbody>
                                </table>
                   </div>
                   
                 </form>

            </div>

        </body>

        </html>