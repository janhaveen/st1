$(document).ready(function()
{
	$("#HomeText").text("Create GRN");
	$('#ProductDatatables').addClass('display compact');
	$('#ProductDatatables tbody').on('click', '.select_me', function()
	{
		$('#productIdRowEmp').remove();
		var generator = new IDGenerator();
		var data = $('#ProductDatatables').DataTable().row($(this).parents('tr')).data();
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
    		SwalMsgWarning(" <strong>Error!</strong> Product Already Exists !");
		} else { 
			var newHtml = '<tr id="productIdRow">'+
						  '<td><input type="checkbox" value="'+data.rowId+'" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
						  '<td>'+data.productInfo+'</td>'+
						  '<td><input class="form-control qty" style="width: 40%;" type="text" id="qty'+data.rowId+'"></td>'+
						  '<td>'+data.price+'</td>'+
						  '<td class="HideThisElement">'+data.price+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+data.rowId+'"></label></td>'+
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
			$("#SelectProduct").modal('hide');
		}    	
	});
	
	$("#DeleteProduct").click(function() {
    	try {
        	var table = document.getElementById('ProductDataBody');
        	var rowCount = table.rows.length;
        	for(var i=0; i<rowCount; i++) {
        		var row = table.rows[i]; 
        		var chkbox = row.cells[0].childNodes[0]; 

        		if(null != chkbox && true == chkbox.checked) {
        			table.deleteRow(i); 
        			//calculateAmountPayable();
        			rowCount--;
        			i--;
        			//count--;
        		}
        	}
        	}catch(e) {
        		alert(e);
        	}
        return false; // avoid to execute the actual submit of the form.
    });
	
	$("#GenerateBarcode").click(function() {
		formSubmit();
	});
	
	$("#ExportasCSV").click(function() {
		exportasCSV();
	});
	
	$("#submitProductGRN").click(function() {
		formSubmitGRN();
	});
	
});

function formSubmitGRN() {
	var returnVal=false;
	var barcodeArr=[];
	if($("#GRNText").val()==""){
		/*$("#purchaseDetailsForm #alertMessage").removeClass("HideThisElement");
        $("#purchaseDetailsForm #alertMessage").html('');*/
		SwalMsgWarning(" <strong>Warning!</strong>  GRN Number is mandatory !");
	}else if($("#VendorId").val()==""){
		/*$("#purchaseDetailsForm #alertMessage").removeClass("HideThisElement");
        $("#purchaseDetailsForm #alertMessage").html(' <strong>Warning!</strong>  Select Vendor !');*/
		SwalMsgWarning(" <strong>Warning!</strong>  Select Vendor !");
	}else if($("#ReceivedText").val()==""){
		SwalMsgWarning(" <strong>Warning!</strong>  Enter Received by !");
	}else if($("#ReceiptDateText").val()==""){
		SwalMsgWarning(" <strong>Warning!</strong>  Select Received Date !");
	}else {
		var table1 = document.getElementById('ProductDataBody');
		var rowCount = table1.rows.length; 		
		for (var i = 0; i < rowCount; i++) {
			var generator = new IDGenerator();
		     var row = table1.rows[i]; 
		     var formData="PurchaseOrderId=PO"+generator.generate()+"&GRNItemId=GI"+generator.generate()+"&count="+i+"&"; 
			 for(var j=0; j<$(row.cells).length; j++){
				if(j==0){
					var ProductId=$($(row.cells[j]).html()).val();
					formData+="ProductId="+ProductId+"&qty="+$("#qty"+ProductId).val()+"&";
				}
			}
			formData+="GRNNumber="+$("#GRNText").val()+"&PurchaseDateText="+$("#PurchaseDateText").val()+"&";
			
			if($("#qty"+ProductId).val()==""){
				/*$("#boxInfoDiv .errorMsg").removeClass("HideThisElement");
		        $("#boxInfoDiv #errorMsg").html();*/
		        SwalMsgWarning(" <strong>Error!</strong> Product Quantity is mandatory !");
			}else{
				/*$("#boxInfoDiv .errorMsg").addClass("HideThisElement");		
				$("#purchaseDetailsForm #alertMessage").addClass("HideThisElement");*/
				$.ajax({
		            type: "POST",
		            url: "../../../SaveGRN",
		            data: formData+$("#purchaseDetailsForm").serialize(), 
		            async:false,
		            success: function(data)
			        {	
		            	if(data!="0"){
		            		barcodeArr.push($.trim(data));
		            		returnVal=true;
		            	}
			     	   else
			     		  returnVal=false
		            }
		    	});
			}
		}
		if(returnVal){
			/*$("#boxInfoDiv .successMsg").removeClass("HideThisElement");
	        $("#boxInfoDiv #successMsg").html(" <strong>Success !</strong> Product(s) Received successfully ! ");
	        */
			SwalMsgSuccess("<strong>Success !</strong> Product(s) Received successfully ! ");
	        window.location.href="ViewGRN.jsp?id="+$("#GRNText").val()+"&t=b";
	        /*setTimeout(function(){
	        	
	        }, 2000);*/
	        /*$(".qty").attr("readOnly", true);
			$("#submitProductGRN").addClass('HideThisElement');
			$("#GenerateBarcode").removeClass('HideThisElement');*/
		}
	}
}

function SwalMsgWarning(msg)
{
	swal({
		  html: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalMsgSuccess(msg)
{
	swal({
		  html: msg,
		  type: "success",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalMsgError(msg)
{
	swal({
		  html: msg,
		  type: "error",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
