$(document).ready(function()
{
	
	 DropDownForHSN();
	 
	var generator = new IDGenerator();
	
	grnId = ("GRN"+generator.generate());
	
	$("#grnId").val(grnId);
	
	var grnItemArray=[];
	
	var createBarcodeArray=[];

	$("#saveProduct").click(function()
	{
		//spinnerOn();
		
		if(validate())
		{
			
			var brand = $("#brandName").val();
			var modelNo = $("#modelNo").val();
			var color = $("#color").val();
			var size = $("#size").val();
			var type = $("#type").val();
			var price = $("#price").val();
			var hsnId = $("#hsnId").val();
			var type = $("#type").val();
			var cost = $("#cost").val();
			var qty = $("#qty").val();
			
			var grnNo = $("#grnNo").val();

			$.ajax
		    ({
		          type: "POST",
		          url: "addNewProduct",
		          data: $("#insertProduct").serialize(), // serializes the form's elements.
		          success: function(data)
		          {
		        	  
		      			var newHtml = '<tr id="productIdRow">'+
		      						  /*'<td><input type="checkbox" value="'+productId+'" id="'+productId+'" name="' + productId + '"><label for="'+productId+'"></label> &nbsp; <i class="fa fa-eye" ></i></td>'+*/
		      						  '<td>'+brand+'</td>'+
		      						  '<td>'+modelNo+'</td>'+
		      						  '<td>'+color+'</td>'+
		      						  '<td>'+size+'</td>'+
		      						  '<td>'+hsnId+'</td>'+
		      						  '<td>'+type+'</td>'+
		      						  '<td>'+qty+'</td>'+
		      						  '<td>'+price+'</td>'+
		      						  '<td>'+cost+'</td>'+
		      						  '</tr>';
		      			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
		      			
		      			 document.getElementById('insertProduct').reset();
		      			 
		      			$('#insertGRN').addClass("HideThisElement");
		      			
		      			$('#addProduct').removeClass("HideThisElement");
		      			
		      			grnItemArray.push({"rowId":"GRNI"+generator.generate(), "productId":productId, "grnId":$("#grnId").val(), "brand": brand, "modelNo": modelNo, "color": color, "size": size, "qty":qty, "cost":cost, "type":type, "price":price, "hsnId":hsnId});
		      			
		      			for (var i = 0; i < qty; i++) 
		      			{
		      				//createBarcodeArray.push({"brand":brand, "modelNo":modelNo, "color":color, "size":size, "productId":productId, "grnNo":grnNo, "grnId":$("#grnId").val(),"barCodeRowId":"barcode"+generator.generate()});
		      				
		      				createBarcodeArray.push({"barCodeRowId": "TTC"+generator.generate(), "productId": productId, "grnNo": grnNo, "grnId": $("#grnId").val(), "brand": brand, "modelNo": modelNo, "color": color, "size": size, "qty":1, "cost":cost, "type":type, "price":price, "hsnId":hsnId});
		      				//console.log(i+" ............g4f..........."+qtyArray);
		      			}
		      			
				       	/*if(data == 3001)
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
				       	}*/
				       	
				       //	console.log(data);
		          }
		      });
		}
	});

	$("#saveGRNProduct").click(function() 
	{	
	    $.ajax
	    ({
	        type: "POST",
	        url: "addNewGRN",
	        data: $("#insertGRNData").serialize()+"&remarks="+$("#remarks").val(), // serializes the form's elements.
	        success: function(data) 
	        {
	            $.ajax
	    	    ({
	    	        type: "POST",
	    	        url: "addNewGRNItem",
	    	        data: {"grnItemArray":JSON.stringify(grnItemArray)}, // serializes the form's elements.
	    	        success: function(data) 
	    	        {
	    	        	$.ajax
	    	    	    ({
	    	    	        type: "POST",
	    	    	        url: "addNewBarcode",
	    	    	        data: {"createBarcodeArray":JSON.stringify(createBarcodeArray)}, // serializes the form's elements.
	    	    	        success: function(data) 
	    	    	        {
	    	    	        	window.location = 'listGRN';
	    	    	        	
	    	    	           // console.log(data+" ............154");
	    	    	            
	    	    	        }
	    	    	    });
	    	            
	    	        }
	    	    });
	        }
	    });
	});
});

var productId;
$("#addProduct").click(function()
{
	$('#insertGRN').removeClass("HideThisElement");
	
	$('#saveProduct').removeClass("HideThisElement");
	
	$('#backProduct').removeClass("HideThisElement");
	
	$('#addProduct').addClass("HideThisElement");
	
	var generator = new IDGenerator();
	
	productId = ("PRD"+generator.generate());
	
	$("#ProductId").val(productId);
	
	console.log(productId);
});

$("#backProduct").click(function()
{
	$('#insertGRN').addClass("HideThisElement");
	$('#addProduct').removeClass("HideThisElement");
});

function validate() 
{
	if($("#brandName").val()=="")
		SwalWarning("Select Brand!");
	else if($("#modelNo").val()=="")
		SwalWarning("Select Model No!");
	else if($("#color").val()=="")
		SwalWarning("Select Color!");
	else if($("#size").val()=="")
		SwalWarning("Select Size!");
	else if($("#hsnId").val()=="")
		SwalWarning("Select HSN Id!");
	else if($("#type").val()=="")
		SwalWarning("Select Type!");
	else if($("#price").val()=="")
		SwalWarning("Select Price!");
	else if($("#cost").val()=="")
		SwalWarning("Select Cost!");
	else 
		return true;
}

function createBarcode(qty) 
{
	for (var i = 0; i < qty; i++) 
	{
		console.log(i+" ............g4f");
	}
}
