$(document).ready(function()
{
	/*$('#datetimepicker1').datetimepicker();*/
	$("#HomeText").html("Order List");
	
	 $('#showVendortableList tbody').on( 'click', '.select_me', function () 
     {
		var data = $('#showVendortableList').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		
		$("#vendorId").val(data.rowId);
		
		$("#vendorName").val(data.vendorName);
		$('#vendorText').val(data.vendorName);
		
		$('#vendorNo').val(data.contactNo);
		$('#vendorNoText').val(data.contactNo);
		
		$('#vendorLocation').val(data.location);
		$('#vendorLocationText').val(data.location);
		
		$('#SelectVendorModal').modal('hide');
     });
	 
 
	//getJobsList();
});


//load customer list
function getJobsList() 
{
		//spinnerOn();
	
		$('#showJobsTableList').DataTable().destroy();
	
		$('#showJobsTableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showJobsTableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showJobsTableList').DataTable({ 
    		 dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Jobs',
                     action: function ( e, dt, node, config ) {
                     	addNewOrderJobs();
                     	
                     }
                 }
             ],
             	"bLengthChange": false,
      			"searching": true,
      			"orderCellsTop": true ,
      			"sScrollX": "100%",
      			"sScrollXInner": "100%",
      			"bScrollCollapse": true,
              "ajax": {
                  "url": "listOrder",
                //  "dataSrc": "" 
              },
              //'processing': true,
              'dataType': "json",
              'language': {
                  'loadingRecords': '&nbsp;',
                  processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
              }, 
      		 "columns": [
      			{
                  	className: "center",
                      defaultContent:'<center>'+
                      '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
                      '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;'+
                      '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'+
                     '</center>'
                  },
                  { "data": "rowId" },
                  { "data": "date" },
                  { "data": "customerName" },
                  { "data": "mobileNo" },
                  { "data": "emailId" },
                  { "data": "totalrs" },
                  { "data": "remarks" }
               ],
               
               "initComplete": function(settings, json)
               {   
            	   //spinnerOff();
               }

             
    	 });
    	 
    	 $('#showJobsTableList tbody').off('click');
    	 
    	 $('#showJobsTableList tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    

    		 
    		 $("#showOrderDiv").addClass("HideThisElement");
    		 $("#saveOrderDiv").removeClass("HideThisElement");
    		 $("#UpdateButtonEmployee").removeClass("HideThisElement");
    		 $("#SubmitButtonEmployee").addClass("HideThisElement");
    		 $("#rowNo").val(data.rowNo);
    		 $("#firstName").val(data.firstName).trigger('change');
    		 $("#lastName").val(data.lastName).trigger('change');
    		 $("#Male").val(data.Male).trigger('change');
    		 $("#Female").val(data.Female).trigger('change');
    		 $("#lastName").val(data.lastName).trigger('change');
    		 $("#mobileNo").val(data.mobileNo).trigger('change');
    		 $("#altContactNo").val(data.altContactNo).trigger('change');
    		 $("#emailId").val(data.emailId).trigger('change');
    		 $("#department").val(data.department);
    		 $("#designation").val(data.designation);
    		 $("#reportTo").val(data.reportTo).trigger('change');
    		 $("#userId").val(data.userId).trigger('change');
    		 $("#location").val(data.location).trigger('change');
    		 $("#Active").val(data.Active).trigger('change');
    		 $("#Inactive").val(data.Inactive).trigger('change');
    		 $("#birthDate").val(data.DOB).trigger('change');
    		 
    		 $("#action").val("updateCustomer");
    		 
    	 });
    	 
    	 $('#showJobsTableList tbody').on( 'click', '.select_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    		    $("#showOrderDiv").addClass("HideThisElement");
    	        $("#viewOrderDiv").removeClass("HideThisElement");
    	        $("#OrderIDText").text(data.rowId);
    	        $("#OrderDateText").text(data.date);
    	        $("#DueDateText").text(data.dueDate);
    	        $("#CustomernameText").text(data.customerName);
    	        $("#ContactNumberText").text(data.mobileNo);
    	        $("#AddressText").text(data.address);
    	        $("#OldLensText").text(data.oldLens);
    	        $("#BookedByText").text(data.bookedBy);
    	        $("#DeliveredByText").text(data.deliveredBy);
    	        $("#OldLensReturnedText").text(data.oldLensReturn);
    	        $("#RxByText").text(data.rxBy);
    	        $("#PrescriptionReturnedText").text(data.prescriptionReturned);
    	        $("#RemarksText").text(data.remarks);
    	        viewOrderProductList(data.rowId);
    		
    		 
    	 });
    	    	 
	 function viewOrderProductList(orderId)
	 {   
            $.ajax
            ({
				url:"viewOrderProductList?orderId="+orderId,
				type:"GET",
				success:function(data2)
				{
					$("#ProductData1").removeClass("HideThisElement");
					
					var html="";
					
					if(data2.data.length>0)
					{
						for (var i = 0; i < data2.data.length; i++)
						{
							 //console.log("hello data 1",data2.data[i]);
							 
							html+='<tr id="productIdRow">'+
								  '<td>'+(i+1)+'</td>'+
								  '<td>'+data2.data[i].barcode+'</td>'+
								  '<td>'+data2.data[i].brand+'</td>'+
								  '<td >'+data2.data[i].color+'</td>'+
								  '<td>'+data2.data[i].size+'</td>'+
								  '<td>'+data2.data[i].price+'</td>'+
								  '</tr>';
						}
					}
					else
					{
						/*for (var i = 0; i < data2.data.length; i++)
						{
							html+='<tr id="productIdRow">'+
							 '<td>'+(i+1)+'</td>'+
							  '<td>'+data2.data[i].barcode+'</td>'+
							  '<td>'+data2.data[i].brand+'</td>'+
							  '<td >'+data2.data[i].color+'</td>'+
							  '<td>'+data2.data[i].size+'</td>'+
							  '<td>'+data2.data[i].price+'</td>'+
								  '</tr>';
						}*/
					}
					
					document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', html);
				}
			});		     
          }

    	 
    	 $('#showJobsTableList tbody').on( 'click', '.delete_me', function () 
    	 {
    		 //SwalWarning("Are You Sure Delete!"); 
    		 
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 var rowNo = data.rowNo;
    		 
    		 console.log(data);
    		 
    		 //deleteCustomer(rowNo);
    		 SwalDelete("It will permanently deleted !",  data.rowNo);
    	 });
}

var vendorFittingFrameAndSunglassArray = [];

function getFrameAndSunglassList(orderId) 
{
		//spinnerOn();
	
		$('#showFrameAndSunglassTableList').DataTable().destroy();
	
		$('#showFrameAndSunglassTableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showFrameAndSunglassTableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showFrameAndSunglassTableList').DataTable({ 
    		// dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Jobs',
                     action: function ( e, dt, node, config ) {
                     	//addNewOrderJobs();
                     	
                     }
                 }
             ],
             	"bLengthChange": false,
      			"searching": true,
      			"orderCellsTop": true ,
      			"sScrollX": "100%",
      			"sScrollXInner": "100%",
      			"bScrollCollapse": true,
              "ajax": {
                  "url": "getFrameAndSunglassList?orderId="+orderId,
                //  "dataSrc": "" 
              },
              //'processing': true,
              'dataType': "json",
              'language': {
                  'loadingRecords': '&nbsp;',
                  processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
              }, 
      		 "columns": [
      			{
                  	className: "center",
                      defaultContent:'<center>'+
                      '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
                      '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;'+
                      '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'+
                     '</center>'
                  },
                  { "data": "barcode" },
                  { "data": "brand" },
                  { "data": "price" }
               ],
               
               "initComplete": function(settings, json)
               {   
            	   //spinnerOff();
               }

             
    	 });
    	 
    	
    	 
    	 $('#showFrameAndSunglassTableList tbody').on( 'click', '.select_me', function () 
    	 {
    				var data = $('#showFrameAndSunglassTableList').DataTable().row($(this).parents('tr')).data();
    				
    				console.log(data);
    				
    				var table1 = document.getElementById('frameAndSunglassProductDataBody');
    		 		var rowCount = table1.rows.length;
    		 		var idExists = false;
    		 		for(var i=0; i<rowCount; i++)
    		 		{
    		 			var row = table1.rows[i];
    		 			var a = $(row.cells[0]).html();
    		 			var idToCheck= $(a).attr('id');
    		 			console.log(idToCheck);
    		 	    	if (idToCheck == data.orderItemId)
    		 	    	{
    		 				idExists = true;
    		 				break;
    		 			}
    		 		}
    		 		/*console.log(idExists);*/
    		 		if (idExists) 
    		 		{
    		 			swal({
    		 				  title: 'Frame & Sunglass Product Already Selected !',
    		 				  text: 'Product Already Selected ! You want to add it again ?',
    		 				  type: 'warning',
    		 				  showCancelButton: true,
    		 				  confirmButtonText: 'Yes, Add it!',
    		 				  cancelButtonText: 'No !'
    		 				}).then(function() {
    		 				  swal(
    		 				    'Ok',
    		 				    'Product Added !',
    		 				    'success'
    		 				  );
    		 				},
    		 				function(dismiss)
    		 				{
    		 				  if (dismiss === 'cancel') 
    		 				  {
    		 				    swal(
    		 				      'Ok',
    		 				      'Cancelled !)',
    		 				      'error'
    		 				    )
    		 				  }
    		 				});
    		 		} 
    		 		else 
    		 		{
    		 			var generator = new IDGenerator();
    		 			var productInfo = data.brand+"-"+data.modelNo+"-"+data.color+"-"+data.size;
	    				var newHtml = '<tr id="lensProductIdRow">'+
	    				  '<td><input type="checkbox" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
	    				  '<td>'+data.barcode+'</td>'+
	    				  '<td>'+data.brand+" "+data.modelNo+" "+data.color+" "+data.size+'</td>'+
	    				  '<td>'+data.qty+'</td>'+
	    				  '</tr>';
	    				
	    				document.querySelector('#frameAndSunglassProductDataBody').insertAdjacentHTML('beforeend', newHtml);
	    				
	    				vendorFittingFrameAndSunglassArray.push({"jobItemId":"JobItemId"+generator.generate(), "jobId":$("#jobId").val(), "barcode": data.barcode, "skuId":productInfo, "qty": 1, "status":"601"});
	    				
	    				$('#SelectJobFrameAndSunglassModal').modal('hide');
    		 		}
    	  });
 		
}



function addNewOrderJobs()
{
	var generator = new IDGenerator();
	
	$("#orderJobsId").val("ORJId"+generator.generate());
	$("#showOrderJobsDiv").addClass("HideThisElement");
	$("#saveOrderJobsDiv").removeClass("HideThisElement");
	$("#UpdateButtonOrderJobs").addClass("HideThisElement");
	$("#SubmitButtonOrderJobs").removeClass("HideThisElement");
	$("#action").val("insertOrderJobs");
	$("#headerName").html("New Order Jobs");
}

function SwalDelete(msg, rowno) 
{
	swal
	({
		  title: 'Are you sure?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, delete it!',
		  cancelButtonText: 'No !'
		}).then(function() {
		  swal(
			'Deleted!',
			'Your file has been deleted.',
			'success'
		  );
		  deleteCustomer(rowno);
		}, function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
		    swal(
		      'Ok',
		      'Cancelled !',
		      'error'
		    )
		  }
	});
}

function deleteCustomer(rowNo)
{
	$.ajax
    ({
          type: "POST",
          url: "deleteVendor?rowNo="+rowNo,
          data: $(this).serialize(), // serializes the form's elements.
          success: function(data)
          {
        	  if(data == 201)
        	  {
        		  getCustomerList();
        	  }
          },
		  error : function ()
		  {
			  
		  }
    
      });
}


function selectJob(val) 
{
	if(val == "Job1")
	{
		$("#showOrderJobsDiv").addClass("HideThisElement");
		$("#vendorForLens").addClass("HideThisElement");
		$("#vendorForFitting").addClass("HideThisElement");
		$("#vendorForBoth").removeClass("HideThisElement");
		$("#vendorForButton").removeClass("HideThisElement");
		$("#showJobsListDiv").addClass("HideThisElement");
	}
	else if(val == "Job2")
	{
		var generator = new IDGenerator();
		
		$("#jobId").val("JId"+generator.generate());
		
		$("#showOrderJobsDiv").removeClass("HideThisElement");
		$("#vendorForLens").removeClass("HideThisElement");
		$("#vendorForFitting").removeClass("HideThisElement");
		$("#vendorForBoth").addClass("HideThisElement");
		$("#vendorForButton").removeClass("HideThisElement");
		$("#showJobsListDiv").addClass("HideThisElement");
	}
}

function getFrameAndSunglassJobsList() 
{
		//spinnerOn();
	
		$('#showJobstableList').DataTable().destroy();
	
		$('#showJobstableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showJobstableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showJobstableList').DataTable({ 
    		// dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Jobs',
                     action: function ( e, dt, node, config ) {
                     	//addNewOrderJobs();
                     	
                     }
                 }
             ],
             	"bLengthChange": false,
      			"searching": true,
      			"orderCellsTop": true ,
      			"sScrollX": "100%",
      			"sScrollXInner": "100%",
      			"bScrollCollapse": true,
              "ajax": {
                  "url": "getFrameAndSunglassJobsList",
                //  "dataSrc": "" 
              },
              //'processing': true,
              'dataType': "json",
              'language': {
                  'loadingRecords': '&nbsp;',
                  processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
              }, 
      		 "columns": [
      			{
                  	className: "center",
                      defaultContent:'<center>'+
                      '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
                      '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;'+
                      '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'+
                     '</center>'
                  },
                  {
                      "data": "rowId"
                  }, 
                  {
                      "data": "productInfo"
                  },
                  {
                      "data": "jobsItemStatus"
                  },
                  {
                      "data": "vendorName"
                  }	  
               ],
               
               "initComplete": function(settings, json)
               {   
            	   //spinnerOff();
               }

             
    	 });
    
}

/*function getJobsViewdata() 
{

    $.ajax({
        url: "getJobsViewdata",
        type: "GET",
        success: function(data2)
        {
            $("#PrescriptionIdCard").empty();
            
            for (i = 0; i < data2.data.length; i++) 
            {
            	newdiv.innerHTML = '<div class="card border-info"> <div class="card-header">Order No:' + (i + 1) + ",&nbsp;" + data2.data[i].createdOn + '<div class=" right"><u><a id="viewOrderClick" onclick=viewOrder("' + data2.data[i].orderId + '") href="#">View Order</a></u></div><div class="card-body"><dl class="row" id="orderCard">' +
                '<dt class="col-sm-2">Order Id</dt><dd class="col-sm-2" id="OrderIDText">' + data2.data[i].orderId + '</dd><dt class="col-sm-2">Order Date-</dt>' +
                ' <dd class="col-sm-2" id="OrderDateText">' + data2.data[i].date + '<dt class="col-sm-2">Status-</dt><dd class="col-sm-2" id="StatusText">' + data2.data[i].orderStatus + '</dd>' +
                '<dt class="col-sm-2">Quantity-</dt> <dd class="col-sm-2" id="QuantityText">' + data2.data[i].qty + '</dd> <dt class="col-sm-2">Amount Payable-</dt>' +
                ' <dd class="col-sm-2" id="AmountText">15000</dd><dt class="col-sm-2">Advance Rs-</dt><dd class="col-sm-2" id="AdvanceText">5000</dd>' +
                ' <dt class="col-sm-2">balance Rs-</dt> <dd class="col-sm-2" id="BalanceText">10000</dd><dt class="col-sm-2">Expected Delivery Date-</dt>' +
                ' <dd class="col-sm-2" id="ExpectedDeliveryDateText">' + data2.data[i].dueDate + '</dd></dl></div></div></div><br>'
            var element = document.getElementById("OrderId");
            element.appendChild(newdiv);
            
            }
            if (data2.data.length == 0)
            {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = '<center><p tyle="color:blue"><b>No Prescription Card Found !</b></p></center>';
                var element = document.getElementById("PrescriptionIdCard");
                element.appendChild(newdiv);
            }
        }
    });
}*/