$(document).ready(function()
{
	$("#HomeText").html("GRN List");
	
	getGRNList();
	
	$("#ExportasCSV").click(function() 
	{
		exportasCSV();
	});
});

var grnId;
//load grn list
function getGRNList() 
{
		//spinnerOn();
	
		$('#showGRNtableList').DataTable().destroy();
	
		$('#showGRNtableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showGRNtableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showGRNtableList').DataTable({ 
    		// dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Customer',
                     action: function ( e, dt, node, config ) {
                     	addNewCustomer();
                     	
                     }
                 }
             ],
             	//"bLengthChange": false,
      			"searching": true,
      			"orderCellsTop": true ,
      			"sScrollX": "100%",
      			"sScrollXInner": "100%",
      			//"bScrollCollapse": true,
              "ajax": {
                  "url": "grnList",
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
                     '</center>'
                  },
                  { "data": "grnNo" },
                  { "data": "vendorName" },
                  { "data": "vendorNo" },
                  { "data": "vendorLocation" },
                  { "data": "purchaseDateText" },
                  { "data": "receivedByText" },
                  { "data": "receiptDateText" },
                  { "data": "qty" },
                  { "data": "price" },
                  { "data": "itemCount" }
               ],
               
               columnDefs: [
                   { width: '25pc', targets: 1 },
                   { width: '30pc', targets: 2 }
               ],
               
               fixedColumns: true,
               "initComplete": function(settings, json) 
               {   
               	spinnerOff();
               }

             
    	 });
    	 
    	 $('#showGRNtableList tbody').off('click');
    	 
    	 $('#showGRNtableList tbody').on( 'click', '.select_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    		 
    		 $("#GRNDataTableDiv").addClass("HideThisElement");
    		 $("#viewGRNFormDiv").removeClass("HideThisElement");
    		 
    		$("#grnId").val(data.grnId);
    		$("#GRNNumberTextView").text(data.grnNo); 
 			$("#VendorNameView").text(data.vendorName);
 			$("#VendorLocationView").text(data.vendorLocation);
 			$("#PurchaseDateTextView").text(data.purchaseDateText);
 			$("#ReceivedByTextView").text(data.receivedByText);  
 			$("#ReceiptDateTextView").text(data.receiptDateText); 
 			
 			productBaesdDetailsList(data.grnId);
 			
    	 });
    	 
    	 $('#showGRNtableList tbody').on( 'click', '.delete_me', function () 
    	 {
    		 //SwalWarning("Are You Sure Delete!"); 
    		 
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 var rowNo = data.rowNo;
    		 
    		 console.log(data);
    		 
    		 //deleteCustomer(rowNo);
    		 SwalDelete("It will permanently deleted !",  data.rowNo);
    	 });
}

function productBaesdDetailsList(grnId) 
{
	$('#showProductBarcodeList').DataTable().destroy();
	
	$('#showProductBarcodeList thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
	$("#showProductBarcodeList thead input").on('keyup change', function () {
	    table.column($(this).parent().index() + ':visible')
	        .search(this.value)
	        .draw();
	});
	
	//var table=$('#showProductBarcodeList').DataTable();
	
		var html="";
		
		$.ajax
	    ({
	          type: "GET",
	          url: "getProductBasedGRNList?grnId="+grnId,
	          data: $(this).serialize(), // serializes the form's elements.
	          success: function(data2)
	          {
	        	  console.log(data2);
	        	  
	        	  if(data2.data.length>0)
	        	  {
						for (var i = 0; i < data2.data.length; i++) 
						{
							// console.log(data2.data[i]);
							 
							html = '<tr id="productBasedIdRow">'+
							  '<td>'+(i+1)+'</td>'+
							  '<td>'+data2.data[i].brand+'</td>'+
							  '<td>'+data2.data[i].modelNo+'</td>'+
							  '<td>'+data2.data[i].color+'</td>'+
							  '<td>'+data2.data[i].size+'</td>'+
							  '<td>'+data2.data[i].type+'</td>'+
							  '<td class="barcodeCls">'+data2.data[i].barcode+'</td>'+
							  /*'<td>'+data2.data[i].price+'</td>'+*/
							  '</tr>';
			        	  
			        	 document.querySelector('#GRNListDataBody').insertAdjacentHTML('beforeend', html);
						}
					}
	        	  else
	        	  {
						
				  }
	        	  
	          },
			  error : function ()
			  {
				  
			  }
	    
	      });
}

function addNewCustomer()
{
	$("#custTableDiv").addClass("HideThisElement");
	$("#custFormDiv").removeClass("HideThisElement");
	$("#UpdateButtonCustomer").addClass("HideThisElement");
	$("#SubmitButtonCustomer").removeClass("HideThisElement");
	$("#action").val("insertCustomer");
	$("#headerName").html("New Customer");
}

function exportasCSV() 
{
	//spinnerOn();
	
	var str="";
	$('.barcodeCls').each(function (i) {
		str+=",'"+$($('.barcodeCls')[i]).html()+"'";
	});
	
	console.log(str);
	
	$.ajax
	({
    	url:"exportBarcodeAsCSV?barcodes="+str.substr(1,str.length),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data)
    	{
    		spinnerOff();
    		//console.log(JSON.parse(JSON.stringify(data.data, null, 2)), data.data);
    		JSONToCSVConvertor(data.data, $("#grnId").val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
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
          url: "deleteCustomer?rowNo="+rowNo,
          data: $(this).serialize(), // serializes the form's elements.
          success: function(data)
          {
        	  if(data == 201)
        	  {
        		  getGRNList();
        	  }
          },
		  error : function ()
		  {
			  
		  }
    
      });
}