<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <meta http-equiv="x-ua-compatible" content="ie=edge">
                <link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
                <title>Stylrite</title>

                <!-- Font Awesome -->
                <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />" rel="stylesheet">

                <!-- Bootstrap core CSS -->
                <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

                <!-- custom Design Bootstrap -->
                <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

                <!-- data table css -->
                <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet">

                <link href="<c:url value="/resources/css/buttons.dataTables.min.css " />" rel="stylesheet">

                <!-- Date time css -->
                <link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
                
                <!-- Swal css -->
                <link href="<c:url value="/resources/css/sweetalert2.css" />" rel="stylesheet">

                <style type="text/css">
				#overlay {
		  position: fixed;
		  display: none;
		  width: 100%;
		  height: 100%;
		 /*  top: 63px;
		  left: 322px;
		  right: 0;
		  bottom: 100px; 
		  background-color: rgba(0,0,0,0.5);*/
		  z-index: 2;
		  cursor: pointer;
		}
		#casio{
			margin-left: 40%;
			margin-top: 13%;
		}
		  
      	  .classForPageLengthMenu{
			padding: 8px;
		    background: white;
		    border-radius: 5px;      
	      }
	       body, .form-control {
			    font-size: 90% !important;
			    height: auto !important; 
			}
			.alert p, .navbar p{
				margin-bottom: 0rem	!important; 
			}
			.collapse{
				margin-left: 13%;	
			}
</style>

            </head>
            
            <body class="fixed-sn white-skin">
		<div  class="main" id="overlay" >
			<div id="casio"></div>
		</div>
 	<header>
    <div id="mySidenav" class="sidenav">
			<div class="collapsible"  id="accordion">
			  <li id="100001">
			  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Admin"><i class="fa fa-cogs"></i> Admin <i class="fa fa-angle-down pull-right"  ></i></a>
               	 <div class="collapse" id="Admin"  data-parent="#accordion">
               		<ul>
               			<li id="100002"><a href="showEmployee" class="waves-effect">Employee</a>
                         </li>
                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/EmployeeTask/JSPs/Task.jsp?t=A" class="waves-effect HideThisElement">All Task</a>
                         </li>
                         <li id="100004"><a href="http://localhost:8084/Stylrite/View/EmployeeTask/JSPs/Task.jsp?t=M" class="waves-effect sp HideThisElement">Task Management</a>
                         </li><!-- http://localhost:8084/Stylrite/View/EmployeeTask/JSPs/Task.jsp -->
               		</ul>
              	  </div>
               </li>
               <li id="200001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#CRM"><i class="fa fa-users"></i> CRM <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="CRM"  data-parent="#accordion">
	               		<ul>
	               			<li id="200002"><a href="showCustomer" class="waves-effect">Customer</a>
	                         </li>
	                         <li id="200003"><a href="showVendor" class="waves-effect">Vendor</a>
	                         </li>
	                         <li id="200004"><a href="showVendor1" class="waves-effect">Vendor1</a>
	                         </li>
	               		</ul>
	              	  </div>
	               </li>
	             <!-- <li id="100001">
				  	<a class="collapsible-header waves-effect arrow-r"  data-toggle="collapse" data-target="#Product"><i class="fab fa-product-hunt"></i> Product <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Product" data-parent="#accordion">
	               		<ul>
	               			<li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/Product.jsp" class="waves-effect">Product</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockSKU.jsp?t=1" class="waves-effect">Available Stock SKU with location</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockSKU.jsp?t=2" class="waves-effect">Available Stock SKU</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockLocation.jsp" class="waves-effect">Available Stock Location</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockBrand.jsp" class="waves-effect">Available Stock Brand</a>
	                         </li>	
	                          <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/StockSalesPerson.jsp" class="waves-effect">Stock Sales Person</a>
	                         </li>	
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrWiAvStckCrd.jsp" class="waves-effect">Sample Details</a>
	                         </li>	
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrandwiseSampleList.jsp?t=1" class="waves-effect">Brandwise Sample</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrandwiseSampleList.jsp?t=2" class="waves-effect">Sales Person wise Sample</a>
	                         </li>		
	                          <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/StockView.jsp" class="waves-effect">Stock Views</a>
	                         </li>  
	                          <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/CriticalStockSKU.jsp" class="waves-effect">Critical Stock</a>
	                         </li>  
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AllSample.jsp" class="sp waves-effect">All Sample</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AllSample.jsp" class="mg waves-effect">My Sample</a>
	                         </li>   
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrandwiseAllSample.jsp" class="waves-effect">Brandwise Sample</a>
	                         </li>                                         
	               		</ul>
	              	  </div>
	             </li> -->  	  
	            <li id="300001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement" data-toggle="collapse" data-target="#Inventory"><i class="fa fa-calendar-alt"></i> Inventory <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Inventory"  data-parent="#accordion">
	               		<ul>   
	               			<li id="300002"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/Product.jsp" class="waves-effect">Product</a>
	                         </li>                     
	                         <li id="300003"><a href="http://localhost:8084/Stylrite/View/StockIn/JSPs/StockIn.jsp" class="waves-effect">Stock In</a>
	                         </li>
	                         <li id="300004"><a href="http://localhost:8084/Stylrite/View/StockOut/JSPs/OrdersForStockOut.jsp" class="waves-effect">Stock Out (Order)</a>
	                         </li>
	                         <li id="300005"><a href="http://localhost:8084/Stylrite/View/StockOut/JSPs/SampleForStockOut.jsp" class="waves-effect">Stock Out (Sample)</a>
	                         </li>
	                         <li id="300006"><a href="http://localhost:8084/Stylrite/View/StockTransfer/JSPs/StockTransfer.jsp" class="waves-effect">Stock Transfer</a>
	                         </li>
	               		</ul>
	              	  </div>
	             </li>
	              <li id="400001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement"  data-toggle="collapse" data-target="#Stock"><i class="fa fa-list-alt"></i>  Stock List <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Stock" data-parent="#accordion">
	               		<ul>
	               			<li id="400002"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockSKU.jsp?t=2" class="waves-effect">Available Stock</a>
	                        </li>
	                        <li id="400003"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockBrand.jsp" class="waves-effect">Brand wise Stock</a>
	                        </li>
	                        <li id="400004"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AvailableStockSKU.jsp?t=1" class="waves-effect">Location wise Stock</a>
	                        </li>
	                        <li id="400005"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/StockSalesPerson.jsp" class="waves-effect">Sales Person wise Samples</a>
	                        </li>
	                        <li id="400006"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AllSample.jsp" class="sp waves-effect">All Sample</a>
	                         </li>
	                         <li id="400010"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrandwiseAllSample.jsp?t=2" class="sp waves-effect">Brandwise My Sample</a>
	                         </li>
	                         <li id="400007"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/AllSample.jsp" class="mg waves-effect">My Sample</a>
	                         </li>	                          
	                         <li id="400008"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/BrandWiseStockMovement.jsp" class="waves-effect">Brand wise Stock Movement</a>
	                         </li>
	                         <li id="400009"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/CriticalStockSKU.jsp" class="waves-effect">Critical Stock</a>
	                         </li>
	                    </ul>
	                  </div>
	              </li>     
	             <li id="500001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#GRN"><i class="fa fa-print"></i> GRN  <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="GRN"  data-parent="#accordion">
	               		<ul>
	               			<li id="500002"><a href="showGRN" class="waves-effect">Create GRN</a>
	                         </li>
	                         <li id="500003"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/GRNList.jsp?t=g" class="waves-effect HideThisElement">Generate Barcode</a>
	                         </li>
	                         <li id="500004"><a href="viewGRN" class="waves-effect HideThisElement">GRN View</a>
	                         </li>
	                         <li id="500005"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/AssignLocation.jsp" class="waves-effect HideThisElement">Assign Location</a>
	                         </li>
	                         <li id="500004"><a href="listGRN" class="waves-effect">GRN List</a>
	                         </li>	                         
	               		</ul>
	              	  </div>
	             </li>
	                 <li id="550001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#stockList"><i class="fa fa-print"></i>Stock List<i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="stockList"  data-parent="#accordion">
	               		<ul>
	               			<li id="550002"><a href="showBarcodeList" class="waves-effect">Barcode List</a>
	                         </li>
	                      <li id="550003"><a href="showBarcodeInList" class="waves-effect">Barcode In List</a>
	                         </li>
	                         <li id="550004"><a href="showBrandWiseStockList1" class="waves-effect ">BrandWiseStockList</a>
	                         </li>
	               		</ul>
	              	  </div>
	             </li>
	             <li id="600001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Barcode"><i class="fa fa-wpforms"></i> Inventory <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Barcode"  data-parent="#accordion">
	               		<ul>
	               			<li id="600002"><a href="showBrand" class="waves-effect"> Brand </a>
	               			<li id="600003"><a href="showTray" class="waves-effect"> Tray </a>
	               			<li id="600004"><a href="showBags" class="waves-effect">Bags</a>
	               			<li id="600005"><a href="showCases" class="waves-effect">Cases</a>
	               			<li id="600006"><a href="showSelvet" class="waves-effect">Selvet</a>
	                         </li>
	                         <!-- <li id="100003"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/GRNList.jsp?t=b" class="waves-effect">GRN List</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/AssignLocation.jsp" class="waves-effect">Assign Location</a>
	                         </li>	    -->                      
	               		</ul>
	              	  </div>
	             </li>
	               <li id="10100001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#productGRN"><i class="fa fa-print"></i> Product GRN  <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="productGRN"  data-parent="#accordion">
	               		<ul>
	               			<li id="10100002"><a href="showProductGrn" class="waves-effect">Create Product GRN</a>
	                         </li>
	                         <li id="10100003"><a href="showGrnproductList" class="waves-effect">Product GRN List</a>
	                         </li>
	                         <li id="10100004"><a href="viewGRN" class="waves-effect HideThisElement">GRN View</a>
	                         </li>
	               		</ul>
	              	  </div>
	             </li>
	             <li id="700001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement" data-toggle="collapse" data-target="#Sample"><i class="fa fa-wpforms"></i> Sample <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Sample"  data-parent="#accordion">
	               		<ul>
	               			<li id="700002"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/SampleListView.jsp" class="waves-effect">Sample List</a>
	                         </li>
	               			<li id="700003"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=newSample" class="waves-effect">New Requisition</a>
	                         </li>
	                          <li id="700010"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=newRequisition" class="waves-effect">New Requisition SalesPerson Wise</a>
	                         </li>
	                         <!--  <li id="700011"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=newSampleRequisition" class="waves-effect">New Requisition SalesPerson Wise List</a>
	                         </li>  --> 
	                         <li id="700004"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListDispatched" class="waves-effect">Ready To Dispatch</a>
	                         </li>
	                         <li id="700005"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListRdyToRcv" class="waves-effect">Dispatched</a>
	                         </li>
	                         <li id="700006"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListRdyToRcv" class="waves-effect">Dispatched/ Confirm Receipt</a>
	                         </li>
	                         <li id="700007"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListView" class="waves-effect">Requisition List</a>
	                         </li>
	                         <li id="700008"><a href="http://localhost:8084/Stylrite/View/SampleTransfer/JSPs/SampleTransfer.jsp" class="waves-effect">Sample Transfer</a>
	                         </li>
	                         <li id="700009"><a href="http://localhost:8084/Stylrite/View/SampleReturn/JSPs/SampleReturn.jsp" class="waves-effect">Sample Return</a>
	                         </li>
	                         <!-- <li id="100003"><a href="http://localhost:8084/Stylrite/View/Samples/JSPs/SampleTransfer.jsp?for=sampleListView" class="waves-effect">Sample Transfer</a>
	                         </li> -->
	               		</ul>
	              	  </div>
	             </li>
	             <li id="800001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Order"><i class="fa fa-shopping-cart"></i> Order <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Order"  data-parent="#accordion">
	               		<ul>
	               			<!-- <li id="800002"><a href="showOrder" class="waves-effect">New Order</a>
	                         </li> -->
	                         <li id="800002"><a href="showOrder" class="waves-effect">Order List</a>
	                         </li>
	                         <li id="800003"><a href="http://localhost:8084/Stylrite/View/ListOrders/JSPs/InProcessOrders.jsp" class="waves-effect HideThisElement">In Process Order</a>
	                         </li>
	                         <li id="800004"><a href="http://localhost:8084/Stylrite/View/ListOrders/JSPs/PendingOrders.jsp" class="waves-effect HideThisElement">Pending Order</a>
	                         </li>
	                         <li id="800005"><a href="http://localhost:8084/Stylrite/View/ListOrders/JSPs/OrderStatus.jsp" class="waves-effect HideThisElement">Completed Orders</a>
	                         </li>
	                         <!-- <li id="800006"><a href="http://localhost:8084/Stylrite/View/InvoiceDispatch/JSPs/RequisitionList.jsp" class="waves-effect">Order Requisition</a>
	                         </li> -->
	                        <!--  <li id="100003"><a href="http://localhost:8084/Stylrite/View/Order/JSPs/OrderView.jsp?t=c" class="waves-effect">Completed Order List</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8084/Stylrite/View/Order/JSPs/OrderView.jsp?t=p" class="waves-effect">Pending Order List</a>
	                         </li> -->
	               		</ul>
	              	  </div>
	             </li>
	             <li id="110001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement" data-toggle="collapse" data-target="#Invoice"><i class="fa fa-file-invoice"></i> Invoice and Dispatch <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Invoice"  data-parent="#accordion">
	               		<ul>
	               			<li id="110002"><a href="http://localhost:8084/Stylrite/View/InvoiceDispatch/JSPs/RequisitionList.jsp?t=ni" class="waves-effect">Update Invoice</a>
	                        </li>
	                        <li id="110003"><a href="http://localhost:8084/Stylrite/View/InvoiceDispatch/JSPs/RequisitionList.jsp?t=di" class="waves-effect">Update Dispatch</a>
	                        </li>
	                        <li id="110004"><a href="http://localhost:8084/Stylrite/View/InvoiceDispatch/JSPs/RequisitionList.jsp?t=nd" class="waves-effect">Completed Requisition</a>
	                        </li>
	                        <li id="110005"><a href="http://localhost:8084/Stylrite/View/InvoiceDispatch/JSPs/RequisitionList.jsp" class="waves-effect">All Requisition</a>
	                        </li>
	               		</ul>
	              	  </div>
	             </li>
	             <li id="900001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement" data-toggle="collapse" data-target="#Downloads"><i class="fa fa-download"></i> Downloads <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Downloads"  data-parent="#accordion">
	               		<ul>
	               			<li id="900002"><a href="http://localhost:8084/Stylrite/View/Product/JSPs/MonthlyBrandWiseStockMovement.jsp" class="waves-effect">Monthly Stock Movement</a>
	                        </li>
	                        <li id="900003"><a onclick="DownloadLocationwiseStock('101')" class="waves-effect">Download In Stock</a>
	                        </li>
	                        <li id="900004"><a onclick="DownloadLocationwiseStock('102')" class="waves-effect">Download Sample Stock</a>
	                        </li>
	               		</ul>
	              	  </div>
	             </li>
	             <li id="130001">
				  	<a class="collapsible-header waves-effect arrow-r HideThisElement" data-toggle="collapse" data-target="#Return"><i class="fa fa-undo"></i> Brand <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Return"  data-parent="#accordion">
	               		<ul>
	               			<li id="130002"><a href="showBrand" class="waves-effect"> Brand </a>
	               			<li id="130003"><a href="showTray" class="waves-effect"> Tray </a>
	                        </li>
	                        <!-- <li id="130003"><a href="http://localhost:8084/Stylrite/View/Return/JSPs/ReturnItem.jsp" class="waves-effect"> Return Item </a>
	                        </li> -->
	                        <!-- <li id="130003"><a onclick="DownloadLocationwiseStock('101')" class="waves-effect">Download In Stock</a>
	                        </li>
	                        <li id="130004"><a onclick="DownloadLocationwiseStock('102')" class="waves-effect">Download Sample Stock</a>
	                        </li> -->
	               		</ul>
	              	  </div>
	             </li>
	              <li id="1200001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Product"><i class="fa fa-users"></i> Product <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Product"  data-parent="#accordion">
	               		<ul>
	               			<li id="1200002"><a href="showLenses" class="waves-effect">Lens Product</a>
	                         </li>
	                         <li id="1200003"><a href="showVendor" class="waves-effect HideThisElement">Vendor</a>
	                         </li>
	               		</ul>
	              	  </div>
	               </li>
			</div>
    </div>
    <nav class="navbar navbar-expand-sm navbar-dark sticky-top">
        <div class="float-left">
            <p style="cursor:pointer" onclick="openNav()"><i class="fa fa-bars" style="margin-right: 10px;font-size: 120%;color:white;"></i> </p>
        </div>
        <!-- Breadcrumb-->
        <div class="breadcrumb-dn mr-auto">
        	<div class="row" style="margin-left:0px">
	        	<div class="breadcrumb-dn mr-auto">
	            	<p id="HomeText" style="font-size: 120%;font-weight: 500; color:white;"> Home</p>
	            </div>
	            <!-- <div class="center">
		            <h5 style="padding-left:50px"><i class="fas fa-caret-square-right"></i> Home</h5>
		        </div> -->
	         </div>
        </div>	
        <ul class="navbar-nav">
            <li class="nav-item" id="15000000">
                <a style="font-size: 120% !important; color:  white;" class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user" style="color:white;"></i> <span class="clearfix d-none d-sm-inline-block" style="font-size:15px;color:white;"><%=session.getAttribute("email") %></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" style="margin-right: 1%; color:white;">
                    <a class="dropdown-item" href="http://localhost:8084/Stylrite/LogOut">Log Out</a>
                    <a class="dropdown-item" href="http://localhost:8084/Stylrite/View/Employee/JSPs/ChangePassword.jsp">Change Password</a>
                </div>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </nav>
    <br>
    </header>
</body>