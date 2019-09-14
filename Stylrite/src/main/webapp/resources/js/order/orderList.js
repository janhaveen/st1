var orderItemArray1=[];
/*var totalAmt1, totalTax1, discountAmt1, netAmt1, totalPayableAmt1;
var totalAmtWithDiscount = 0;
var discountChangeValue = 0;
var specialDiscount = 0;*/
var rowCounter = 0;
$(document).ready(function()
{
	/*$('#datetimepicker1').datetimepicker();*/
	$("#HomeText").html("Order List");
	
	getOrderList();
	
	$("#attachFileForPrescription").addClass("HideThisElement");
	
	$("#buttonForPrescription").addClass("HideThisElement");
	
	/*$("input:checkbox").click(function() 
   	 {
   	    if ($(this).is(":checked")) 
   	    {
   	        var group = "input:checkbox[name='" + $(this).attr("name") + "']";
   	        $(group).prop("checked", false);
   	        $(this).prop("checked", true);
   	    }
   	    else 
   	    {
   	        $(this).prop("checked", false);
   	    }
   	});*/
	
	$(function () 
	{
		  $("input:radio").click(function(e) 
		  {
			 if ($(this).is(":radio")) 
	   	    {
				 $("input:radio").not(this).prop('checked', false);
	   	    }
	   	    else 
	   	    {
	   	    	$("input:radio").prop("checked", false);
	   	    }
			  
		  });
	});
});


//load customer list
function getOrderList() 
{
		//spinnerOn();
	
		$('#showOrdertableList').DataTable().destroy();
	
		$('#showOrdertableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showOrdertableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showOrdertableList').DataTable({ 
    		 dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Order',
                     action: function ( e, dt, node, config ) {
                     	addNewOrder();
                     	
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
                  { "data": "remarks" }
               ],
               
               "initComplete": function(settings, json)
               {   
            	   //spinnerOff();
               }

             
    	 });
    	 
    	 $('#showOrdertableList tbody').off('click');
    	 
    	 $('#showOrdertableList tbody').on( 'click', '.edit_me', function () 
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
    	 
    	 $('#showOrdertableList tbody').on( 'click', '.select_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		  console.log(data);
    		    $("#showOrderDiv").addClass("HideThisElement");
    	        $("#viewOrderDiv").removeClass("HideThisElement");
    	        $("#OrderIDText").text(data.rowId);
    	        $("#OrderIDText").val(data.rowId);
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
    	        getFrameAndSunglassList(data.rowId);
    	        getOrderJobsList(data.rowId);
    		 
    	 });
    	    	 
	 function viewOrderProductList(orderId)
	 {   
            $.ajax
            ({
				url:"viewOrderProductList?orderId="+orderId,
				type:"GET",
				success:function(data2)
				{
					//$("#ProductData1").removeClass("HideThisElement");
					console.log("df");
					var html="";
					var rowCounter = 0;
					if(data2.data.length>0)
					{
						for (var i = 0; i < data2.data.length; i++)
						{
							 //console.log("hello data 1",data2.data[i]);
							 $("#StatusText").text(data2.data[i].orderStatus);
							 
							 orderItemArray1.push({"rowCounter":rowCounter,"barcode":data2.data[i].barcode, 
								 "brand": data2.data[i].brand, "color": data2.data[i].color,
								 "size": data2.data[i].size, "price":data2.data[i].price, 
								 "qtyValue":data2.data[i].qty, "tax":data2.data[i].tax, "status":data2.data[i].status, "discount": data2.data[i].discount});
							html+='<tr id="productIdRow">'+
								  '<td>'+(i+1)+'</td>'+
								  '<td>'+data2.data[i].barcode+'</td>'+
								  '<td>'+data2.data[i].brand+'</td>'+
								  '<td >'+data2.data[i].color+'</td>'+
								  '<td>'+data2.data[i].modelNo+'</td>'+
								  '<td>'+data2.data[i].size+'</td>'+
								  '<td>'+data2.data[i].price+'</td>'+
								  '<td>'+data2.data[i].qty+'</td>'+
								  '</tr>';
							 
							ChangeFinalValues();
						}
						console.log(html);
						document.querySelector('#ProductDataBody2').insertAdjacentHTML('beforeend', html);
						
						/*var str="<tr class='left'>" +
						"<td colspan='7'> Total Amount</td>"+
	                    "<td id='totalrs1'>"+0+"</td>"+
						"</tr>"+
						"<tr class='left'>" +
						"<td colspan='7'> Discount</td>"+
	                    "<td  id='totalrs'>"+0+"</td>"+
						"</tr>"+
	                    "<tr class='left'>" +
						"<td colspan='7'> Net Amount</td>"+
	                    "<td  id='totalrs'>"+0+"</td>"+
						"</tr>"+
						"<tr class='left'>" +
						"<td colspan='7'> Tax Amount</td>"+
	                    "<td   id='taxrs'>"+0+"</td>"+
						"</tr>"+
						"<tr class='left'>" +
						"<td colspan='7'> Amount Payable</td>"+
	                    "<td id='totalPayableAmountrs'>"+0+"</td>"+
						"</tr>";*/
						//document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', str);
					}
					else
					{
						
					}
					
				}
			});		     
          }

    	 
    	 $('#showOrdertableList tbody').on( 'click', '.delete_me', function () 
    	 {
    		 //SwalWarning("Are You Sure Delete!"); 
    		 
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 var rowNo = data.rowNo;
    		 
    		 console.log(data);
    		 
    		 //deleteCustomer(rowNo);
    		 SwalDelete("It will permanently deleted !",  data.rowNo);
    	 });
}

function addNewOrder()
{
	var generator = new IDGenerator();
	
	$("#orderId").val("OId"+generator.generate());
	$("#showOrderDiv").addClass("HideThisElement");
	$("#saveOrderDiv").removeClass("HideThisElement");
	$("#UpdateButtonOrder").addClass("HideThisElement");
	$("#SubmitButtonOrder").removeClass("HideThisElement");
	$("#action").val("insertOrder");
	$("#headerName").html("New Order");
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

