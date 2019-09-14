$(document).ready(function() {
	
	$("#HomeText").html("Brand List");
	
	getBrandList();
});
function getBrandList(){
	// $("#saveBrandDiv").addClass("HideThisElement");
	$('#showBrandList').DataTable().destroy();
	$('#showBrandList thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	$("#showBrandList thead input").on('keyup change', function () {
	    table.column($(this).parent().index() + ':visible')
	        .search(this.value)
	        .draw();
	});
	var table=$('#showBrandList').DataTable({
		dom:'Bfrtrip',
		buttons:[
			{
				text:'Add New Brand',
				action:function(e,dt,node,config){
					addNewBrand();
				}
			}
		],
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
		"sScrollXInner": "100%",
		"bScrollCollapse": true,
		"ajax":{
			"url":"listBrand",
		},
		'dataType':"json",
		'language':{
			'loadingRecords':'&nbsp;',
			processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
		},
		"columns":[
			{
				className:"center",
				defaultContent:'<center>'+
	             '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
	             '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;'+
	             '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'+
	            '</center>'
			},
			  { "data": "brandName" },
		      { "data": "remarks" }
		],
		  "initComplete": function(settings, json)
		     {   
		     	spinnerOff();
		     }
	});

	//$('#showBrandList tbody').off('click')
	 $('#showBrandList tbody').off('click');
	 
	 $('#showBrandList tbody').on( 'click', '.edit_me', function () 
	 {
		 var data = table.row( $(this).parents('tr') ).data();
		 
		 //console.log(data);
		 
		 $("#showBrandDiv").addClass("HideThisElement");
		 $("#saveBrandDiv").removeClass("HideThisElement");
		 $("#UpdateButtonBrand").removeClass("HideThisElement");
		 $("#SubmitButtonBrand").addClass("HideThisElement");
		 
		 $("#rowNo").val(data.rowNo);
		 $("#brandName").val(data.brandName).trigger('change');
		 $("#remarks").val(data.remarks).trigger('change');
		
		  $("#HomeText").html("Update Brand");
		    
		  $("#headerName").html("Update Brand");
		 
		 $("#action").val("updateBrand");
		 
	 });
	 
	 $('#showBrandList tbody').on( 'click', '.delete_me', function () 
	 {
		 var data = table.row( $(this).parents('tr') ).data();
		 
		 var rowNo = data.rowNo;
		 
		 console.log(data);
		 
		 //deleteCustomer(rowNo);
		 SwalDelete("It will permanently deleted !",  data.rowNo);
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
	  deleteBrand(rowno);
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


function deleteBrand(rowNo)
{
	$.ajax
	({
	      type: "POST",
	      url: "deleteBrand?rowNo="+rowNo,
	      data: {rowNo:rowNo}, // serializes the form's elements.
	      success: function(data)
	      {
	    	  if(data == 21)
	    	  {
	    		  getBrandList();
	    	  }
	      },
		  error : function ()
		  {
			  
		  }
	  });
}
var BId;

  function addNewBrand()
  {
	  $("#HomeText").html("New Brand");
	  
	  $("#headerName").html("New Brand");
	  
	  $("#rowNo").val("");
	  
	  var generator = new IDGenerator();
		
	   BId = ("BD"+generator.generate());
		
	  $("#rowId").val(BId);
	
		console.log(BId+" .............i344");
	  $("#showBrandDiv").addClass("HideThisElement");
	  $("#saveBrandDiv").removeClass("HideThisElement");
	  $("#SubmitButtonBrand").removeClass("HideThisElement");
	  $("#UpdateButtonBrand").addClass("HideThisElement"); 
	  $("#action").val("insertBrand");
  }