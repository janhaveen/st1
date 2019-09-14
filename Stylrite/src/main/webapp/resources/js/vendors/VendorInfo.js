$(document).ready(function()
{
    $('#showVendortableList tbody').on( 'click', '.select_me', function () 
    {
		var data = $('#showVendortableList').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		
		$("#VendorId").val(data.rowNo+data.vendorName);
		$('#vendorText').val(data.vendorName);
		
		$('#VendorNoId').val(data.rowNo+data.contactNo);
		$('#vendorNoText').val(data.contactNo);
		
		$('#VendorLocationId').val(data.rowNo+data.location);
		$('#vendorLocationText').val(data.location);
		//getAddress();
		
		//getCotactPerson();
		
		$('#SelectVendorModal').modal('hide');
    });
    
    getProductList();
});

function showAddressModal(type)
{
	$("#addressType").val(type);
	$('#SelectClientAddressModal').modal('show');
}

function getProductList()
{
	spinnerOn();
	
	$('#showProducttableList').DataTable().destroy();
	
	$('#showProducttableList thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
	$("#showProducttableList thead input").on('keyup change', function () {
	    table.column($(this).parent().index() + ':visible')
	        .search(this.value)
	        .draw();
	});
	
	 var table=$('#showProducttableList').DataTable({ 
		 dom: 'Bfrtip',
         buttons: [
             {
                 text: 'Add New Product',
                 action: function ( e, dt, node, config ) {
                 	addNewProduct();
                 	
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
              "url": "getProductDataList",
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
              { "data": "brandText" },
              { "data": "modelNo" },
              { "data": "color" },
              { "data": "size" },
              { "data": "typeText" },
              { "data": "qty" },
              { "data": "price" }
      ],
      
          "initComplete": function(settings, json)
          {   
          	spinnerOff();
          }
          
    });
}

function addNewProduct()
{
	$('#insertGRN').removeClass("HideThisElement");
	
	$('#saveProduct').removeClass("HideThisElement");
	
	$('#backProduct').removeClass("HideThisElement");
	
	DropDownForProductLegend();
	
	var generator = new IDGenerator();
	$("#productId").val("PD"+generator.generate());
}

$("#backProduct").click(function()
{
	$('#insertGRN').addClass("HideThisElement");
});

function validate() 
{
	if($("#brand").val()=="")
		SwalWarning("Select Brand!");
	else if($("#modelNo").val()=="")
		SwalWarning("Select Model No!");
	else if($("#color").val()=="")
		SwalWarning("Select Color!");
	else if($("#size").val()=="")
		SwalWarning("Select Size!");
	else if($("#type").val()=="")
		SwalWarning("Select Type!");
	else if($("#price").val()=="")
		SwalWarning("Select Price!");
	else 
		return true;
}

$("#saveProduct").click(function()
{
	spinnerOn();
	
	if(validate())
	{
		$.ajax
	    ({
	          type: "POST",
	          url: "addNewProduct",
	          data: $("#insertProduct").serialize(), // serializes the form's elements.
	          success: function(data)
	          {
			       	if(data == 3001)
		       		{
		       		   spinnerOff();
		       		   
		       		   document.getElementById('insertProduct').reset();
		       		   
		       		   $('#insertGRN').addClass("HideThisElement");
		       		
		       		   SwalSuccess("Product Save Successfully");
		       		   
		       		   getProductList();
		           	   
			       		$("#custFormDiv").addClass("HideThisElement");
			            $("#custTableDiv").removeClass("HideThisElement");
		       		}
			       	else if(data == 3002)
			       	{
			       		console.log(data);
			       	}
			       	else
			       	{
			       		console.log(data);
			       	}
			       	
			       	console.log(data);
	          }
	      });
	}
});

$("#saveGRNProduct").click(function() 
{
    $.ajax
    ({
        type: "POST",
        url: "addNewGRNProduct",
        data: $("#insertVendor").serialize()+$("#insertGRNProduct").serialize()+$("#insertProduct").serialize()+$("#insertGRNButtonProduct").serialize(), // serializes the form's elements.
        success: function(data) 
        {
            console.log(data);
        }
    });
});
