$(document).ready(function()
{
	$("#HomeText").html("Vendor");
	
	getVendorList();
});


//load customer list
function getVendorList() 
{
	//spinnerOn();
	
		$('#showVendortableList').DataTable().destroy();
	
		$('#showVendortableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showVendortableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showVendortableList').DataTable({ 
    		 dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Vendor',
                     action: function ( e, dt, node, config ) {
                     	addNewVendor();
                     	
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
                  "url": "listVendor",
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
                  { "data": "vendorName" },
                  { "data": "contactNo" },
                  { "data": "email" },
                  { "data": "location" },
                  { "data": "companyName" }
          ],
          
	          "initComplete": function(settings, json)
	          {   
	          	//spinnerOff();
	          }
              
        });
    	 
    	 $('#showVendortableList tbody').off('click');
    	 
    	 $('#showVendortableList tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 //console.log(data);
    		 
    		 $("#venderTableDiv").addClass("HideThisElement");
    		 $("#vendorFormDiv").removeClass("HideThisElement");
    		 $("#UpdateButtonVendor").removeClass("HideThisElement");
    		 $("#SubmitButtonVendor").addClass("HideThisElement");
    		 
    		 $("#rowNo").val(data.rowNo);
    		 $("#vendorName").val(data.vendorName).trigger('change');
    		 $("#contactNo").val(data.contactNo).trigger('change');
    		 $("#alternateContactNo").val(data.alternateContactNo).trigger('change');
    		 $("#email").val(data.email).trigger('change');
    		 $("#location").val(data.location).trigger('change');
    		 $("#companyName").val(data.companyName).trigger('change');
    		 $("#source").val(data.source).trigger('change');
    		 $("#gstNo").val(data.gstNo).trigger('change');
    		 $("#state").val(data.state).trigger('change');
    		 
    		 $("#action").val("updateVendor");
    		 
    		 $("#headerName").html("Update Vendor");
    		 
    	 });
    	 
    	 $('#showVendortableList tbody').on( 'click', '.delete_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 var rowNo = data.rowNo;
    		 
    		 console.log(data);
    		 
    		 //deleteCustomer(rowNo);
    		 SwalDelete("It will permanently deleted !",  data.rowNo);
    	 });
}

function addNewVendor()
{
	$("#venderTableDiv").addClass("HideThisElement");
	$("#vendorFormDiv").removeClass("HideThisElement");
	$("#UpdateButtonVendor").addClass("HideThisElement");
	$("#SubmitButtonVendor").removeClass("HideThisElement");
	$("#action").val("insertVendor");
	$("#headerName").html("New Vendor");
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
		  deleteVendor(rowno);
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


function deleteVendor(rowNo)
{
	$.ajax
    ({
          type: "POST",
          url: "deleteVendor?rowNo="+rowNo,
          data: {rowNo:rowNo}, // serializes the form's elements.
          success: function(data)
          {
        	  if(data == 201)
        	  {
        		  getVendorList();
        	  }
          },
		  error : function ()
		  {
			  
		  }
      });
}