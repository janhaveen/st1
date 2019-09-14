$(document).ready(function()
{
	 var generator = new IDGenerator();
	 $("#grnPId").val("Gp"+generator.generate());
	$("#HomeText").html("Product Grn");
	
	getVendorList();
	
	
	$('#showVendortableList tbody').on( 'click', '.select_me', function () 
		    {
				var data = $('#showVendortableList').DataTable().row($(this).parents('tr')).data();
				console.log(data);
				
				$("#VendorId").val(data.vendorName);
				$('#vendorText').val(data.vendorName);
				
				$('#VendorNoId').val(data.contactNo);
				$('#vendorNoText').val(data.contactNo);
				
				$('#VendorLocationId').val(data.location);
				$('#vendorLocationText').val(data.location);
				//getAddress();
				
				//getCotactPerson();
				
				$('#SelectVendorModal').modal('hide');
		    });

	
	getProductList();
	 $("#DeleteProduct").click(function() {
		//deleteProduct();
		 try {
		    	var table = document.getElementById('ProductDataBody');
		    	var rowCount = table.rows.length;
		    	for(var i=0; i<rowCount; i++) {
		    		var row = table.rows[i]; 
		    		var chkbox = row.cells[0].childNodes[0]; 

		    		if(null != chkbox && true == chkbox.checked) {
		    			table.deleteRow(i); 
		    			//calculateAmountPayable();
		    			 // grnProductItemArray.remove(i);
		    			rowCount--;
		    			i--;
		    			//count--;
		    		}
		    	}
		    	}catch(e) {
		    		alert(e);
		    	}
		    return false; 
	 });
	    	
	    });



var grnProductItemArray=[];
function getProductList(){
	$('#showProducttableList').DataTable().destroy();
	$('#showProducttableList thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	/*$("#showProducttableList thead input").on('keyup change', function () {
	    table.column($(this).parent().index() + ':visible')
	        .search(this.value)
	        .draw();
	});*/
	var table=$('#showProducttableList').DataTable({
	//	dom:'Bfrtrip',
		 buttons: [
             {
                 text: 'Add New Employee',
                 action: function ( e, dt, node, config ) {
                 	addNewEmployee();
                 	
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
			"url":"listGrnProduct",
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
	            '</center>'
			},
			  { "data": "brandName" },
			  { "data": "type" },
			  { "data": "quantity" },
			  { "data": "capacity" },
			  { "data": "typeOfProduct"}
		],
		  "initComplete": function(settings, json)
		     {   
		     	spinnerOff();
		     }
	});
	  $('#showProducttableList tbody').off('click');
	  
	 $('#showProducttableList tbody').on('click', '.select_me', function() {
			$("#DeleteProduct").removeClass("HideThisElement");
		 
	        var data = table.row($(this).parents('tr')).data();
	         console.log("list data ",data);
	         console.log(data.rowId);
	         

	         var generator = new IDGenerator();
	        $("#PId").val("GPId"+generator.generate());
	         var data = $('#showProducttableList').DataTable().row($(this).parents('tr')).data();
	        var table1 = document.getElementById('ProductData');
	        var rowCount = table1.rows.length;
	        var idExists = false;
	        for(var i=1; i<=rowCount-1; i++) {    
	            var row = table1.rows[i];
	            var a = $(row.cells[0]).html();
	            var idToCheck= $(a).attr('id');
	            if (idToCheck == data.rowId) {
	                idExists = true;
	                break;
	            }
	        }
	        if (idExists) {
	             /*//toastr.error('Product Already Exists!');
	             $("#ProductTableDiv .errorMsg").removeClass("HideThisElement");
	             $("#ProductTableDiv #errorMsg").html('');*/
	            SwalWarning(" Product Already Exists !");
	         } else {
	             var newHtml = '<tr id="productIdRow">'+
	                           '<td><input type="checkbox" value="'+data.rowId+'" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
	                           '<td>'+data.brandName+'</td>'+
	                           '<td>'+data.type+'</td>'+
	                           '<td><input class="form-control quantity" style="width: 40%;" id="quantity" value="'+data.quantity+'" type="text"></td>'+
	                           '<td>'+data.capacity+'</td>'+
	                            '<td>'+data.typeOfProduct+'</td>'+
	                           '</tr>';
	             document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
				 grnProductItemArray.push({"rowId":$("#PId").val(), "brandName":data.brandName, "type":data.type,"quantity":data.quantity,
					 "typeOfProduct":data.typeOfProduct,"grnId":$("#grnPId").val(),"PID" : data.rowId,"capacity":data.capacity});
	             console.log("data is of rowid"+data.rowId)
	             console.log("json data ",grnProductItemArray)
	         }        
	     });  
	
	        /*$("#showBagsDiv").addClass("HideThisElement");
	        $("#saveBagsDiv").removeClass("HideThisElement");
	        $("#UpdateButtonBags").removeClass("HideThisElement");
	        $("#SubmitButtonBags").addClass("HideThisElement");

	        $("#rowNo").val(data.rowNo);
	        $("#brandName").val(data.brandName);
	        $("#type").val(data.type);
	    

	        $("#action").val("updateBags");
	        
	        $("#headerName").html("Update Bgas");
*/
	  

}
function deleteProduct(){
	try {
    	var table = document.getElementById('ProductDataBody');
    	var rowCount = table.rows.length;
    	for(var i=0; i<rowCount; i++) {
    		var row = table.rows[i]; 
    		var chkbox = row.cells[0].childNodes[0]; 

    		if(null != chkbox && true == chkbox.checked) {
    			table.deleteRow(i); 
    			//calculateAmountPayable();
    			  //grnProductItemArray.remove(i);
    			rowCount--;
    			i--;
    			//count--;
    		}
    	}
    	}catch(e) {
    		alert(e);
    	}
    return false; // avoid to execute the actual submit of the form.
}