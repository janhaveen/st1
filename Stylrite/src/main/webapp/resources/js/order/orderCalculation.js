/**
 * 
 */
var orderItemArray1=[];
var totalAmt1, totalTax1, discountAmt1, netAmt1, totalPayableAmt1;
var specialDiscount = 0;
var rowCounter = 0;
var orderItemArray=[];
$(document).ready(function()
{
// Scan the Bar code
$("#barcode").focusout(function() 
	    {
	    	var barcode = $("#barcode").val();
			
			if(orderItemArray1.length == 0 && barcode.length > 10)
			{
				//console.log(BarcodeArrScanned.length);
				
				scanBarcode($(this).val());  
			}
			else if(barcode.length > 10)
			{
				 var checkBarcode = checkBarcodeIfExists(orderItemArray1, $(this).val());
				 
				if(checkBarcode)
				{
					SwalError("Barcode Already Scanned!");
					
					console.log(checkBarcode+".........checkBarcode....true");
				}
				else
				{
					console.log(checkBarcode+".........checkBarcode....false");
					
					scanBarcode($(this).val());
				}
			}
	    });


$("#DeleteProduct").click(function()
		{
	
	
	
			try
			{
				var ch;
		    	var table = document.getElementById('ProductDataBody');
		    	var rowCount = table.rows.length;
		    	console.log("log--lenght-->",rowCount)
		    	var arrayrowid=[];
		    	for(var i=0; i<rowCount; i++)
		    	{
		    		var row = table.rows[i]; 
		    		console.log(row.id)
		    		var chkbox = row.cells[0].childNodes[0]; 

		    		console.log(chkbox.checked);
		    		if(null != chkbox && true == chkbox.checked)
		    		{
		    			//ch = $(chkbox).val();
		    			
		    			//$('#cbIdH'+$(chkbox).val()).remove();
		    			//console.log("ch", $(chkbox).val());
		    			
		    			//removeOrderItemArray($(chkbox).val());
		    			
		    			/*rowCount--;
	        			
						i--;*/
		    			

		    			arrayrowid.push(row.id);
		    			
		    			var a = removeOrderItemArray($(chkbox).val());
		    		
		    			if(a)
		    			{
		    				console.log("a true: ",a);
		    				
		    				//console.log("orderItemArray1length: ",orderItemArray1);
		    				
		    				ChangeFinalValues();
		    				
		    			}
		    			else
		    			{
		    				console.log("a false: ",a);
		    			}
		    			
	    				//table.deleteRow(i); 
		    		}
		    	}
		    	console.log(arrayrowid.length)
		    	for(var j=0;j<arrayrowid.length;j++)
		    	{
		    		console.log("orderItemArray1length: ",orderItemArray1.length);
		    		
		    		$('table#showProductOrderFormList tr#'+arrayrowid[j]).remove();
		    	}
		    	
		    	}catch(e)
		    	{
		    		alert(e);
		    	}
		    return false; 
		});

});


// Check if Item is already scanned

function checkBarcodeIfExists(barcodeArray, barcodeValue) 
{
	var returnBarcodeValue = false;
	
	for (var i = 0; i < barcodeArray.length; i++) 
	{
		if(barcodeArray[i].barcode == barcodeValue)
		{
			console.log("checkBarcodeIfExists");
		
			console.log(barcodeArray[i].barcode,  barcodeValue);
			
			returnBarcodeValue = true;
		}
	}
	
	return returnBarcodeValue;
}

// Scan the barcode

function scanBarcode(barcode) 
{
	var generator = new IDGenerator();
	
	var statusValue = "403";
	var qtyValue = 1;
	var tax = 18;
	var discountVal = 0;
	
	
	var html="";
	
	$.ajax
    ({
    	  type:"GET",
    	  url:"checkScanBarcode?barcode="+barcode,
    	  data:$(this).serialize(),  // serializes the form's elements.
          success: function(data2)
          {
        	  if(data2.data.length>0)
        	  {
					for (var i = 0; i < data2.data.length; i++) 
					{
						rowCounter++;
						console.log("count---->",rowCounter);
						if(data2.data[i].status == "Out")
						{
							SwalError("Barcode Stock Out Already!");
						}
						else
						{
							
							
							orderItemArray1.push({"rowCounter":rowCounter,"barcode": data2.data[i].rowId, "brand": data2.data[i].brand, "color": data2.data[i].color, "size": data2.data[i].size, "price":data2.data[i].price, "qtyValue":qtyValue, "tax":tax, "status":data2.data[i].status, "discount": discountVal});
							
							console.log("row count---->",orderItemArray1[0].rowCounter);
							
							var rate = parseFloat(data2.data[i].price);
							var qty = parseFloat(qtyValue);
							var disc = parseFloat(0);
							tax = parseFloat(tax);
							
							html = '<tr id="productBasedIdRow'+rowCounter+'">'+
							  '<td><input type="checkbox" value="'+data2.data[i].rowId+'" id="'+data2.data[i].rowId+'" name="' + data2.data[i].rowId + '"><label for="'+data2.data[i].rowId+'"></label></td>'+
							  '<td>'+data2.data[i].rowId+'</td>'+
							  '<td>'+data2.data[i].brand+" "+data2.data[i].color+" "+data2.data[i].modelNo+" "+data2.data[i].size+'</td>'+
							  '<td id="qty'+data2.data[i].rowId+'" value="'+qtyValue+'">'+qtyValue+'</td>'+
							  '<td id="price'+data2.data[i].rowId+'" value="'+data2.data[i].price+'">'+data2.data[i].price+'</td>'+
							  '<td id="tax'+data2.data[i].rowId+'" value="'+tax+'">'+tax+'</td>'+
							  /*'<td><input class="form-control disc" style="width: 60%;" value="'+0+'" type="number"  onfocusout="calculateDiscountAmount(\''+ data2.data[i].rowId +'\',this)" id="disc'+data2.data[i].rowId+'" name="disc'+data2.data[i].rowId+'" ></td>'+*/
							  /*'<td><input class="form-control disc" style="width: 60%;" value="'+0+'" type="number"   id="disc'+data2.data[i].rowId+'" name="disc'+data2.data[i].rowId+'" ></td>'+*/
							  '<td><input class="form-control disc" style="width: 60%;" value="'+0+'" type="number"  id="disc'+data2.data[i].rowId+'" name="disc'+data2.data[i].rowId+'"' + 
							  ' onfocusout=discountRevised('+rate+','+qty+',this,'+ tax+','+rowCounter+')></td>'+
							  '<td id="amt'+rowCounter+'" class="amtCls">'+CalculateItemAmount(rate, qty, disc)+'</td>'+
							  '<td><input class="taxCls" style="width: 60%;" type="hidden" id="tax1'+data2.data[i].rowId+'" value= "0"></td>'+
							  '</tr>';
							 
							 document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', html);
							 
							 orderItemArray.push({"orderItemId":"OItemId"+generator.generate(), "orderId":$("#orderId").val(), "barcode": data2.data[i].rowId, "brand": data2.data[i].brand, "color": data2.data[i].color, "size": data2.data[i].size, "price":data2.data[i].price, "barcodeStatus":statusValue, "modelNo":data2.data[i].modelNo, "qty": qtyValue, "tax":tax, "discount": $('#disc'+data2.data[i].rowId).val(), "amount":$('#amt'+rowCounter).html(), "status":"601"});
							 
							 ChangeFinalValues();
							 
							 
							 
							 $("#barcode").val("");
							 
							 
						}
					}
        	  }
        	  else
        	  {
        		  SwalError("Invalid Barcode!");
			  }
          }
    
    });
}


//Change Final Values

function ChangeFinalValues()
{
	var totalrs = CalculateOrderTotalAmount(orderItemArray1);
	var	taxrs =	CalculateOrderTaxAmount(orderItemArray1);
	var totalAmountrs = CalculateOrderTotalAmount(orderItemArray1)+CalculateOrderTaxAmount(orderItemArray1);
	var totalPayableAmountrs = CalculateOrderTotalAmount(orderItemArray1)+CalculateOrderTaxAmount(orderItemArray1)-specialDiscount;
	
	$("#totalrs").html(totalrs);
	$("#totalrs1").html(totalrs);
	
	$("#taxrs").html(taxrs);
	$("#taxrs1").html(taxrs);
	
	$("#totalAmountrs").html(totalAmountrs);
	$("#totalAmountrs1").html(totalAmountrs);
	
	$("#grantTotalrs").html(CalculateOrderTotalAmount(orderItemArray1)+CalculateOrderTaxAmount(orderItemArray1)-specialDiscount);
	
	$("#totalPayableAmountrs").html(totalPayableAmountrs);
	$("#totalPayableAmountrs1").html(totalPayableAmountrs);
}


// Change Special Discount

function ChangeSpecialDiscount()
{
	specialDiscount = parseFloat($('#specialDiscount').val());
	ChangeFinalValues();
}

// Revise Amounts when discount changes against the item

function discountRevised(rate,qty, disc, tax, arrayIndex){
	console.log("discount value: ",$(disc).val());
	console.log("Array Index value: ",arrayIndex);
	
	var discVal = $(disc).val();
	var rowPosInd = parseInt(arrayIndex);
	
	var amount1 =  parseFloat(CalculateItemAmount(rate, qty, parseFloat(discVal)));
	var taxAmount1= parseFloat(CalculateItemTaxAmount(rate, qty, parseFloat(discVal), tax));
	
	/*totalAmtWithDiscount = parseFloat(amount1);
	
	console.log("totalAmtWithDiscount........",totalAmtWithDiscount);*/
	 
	$('#amt'+rowPosInd).html(amount1);
	
	//orderItemArray1[rowPosInd-1].discount = discVal;
	
	console.log("Old discount value : ",orderItemArray1[rowPosInd-1].discount)
	
	
	ChangeFinalValues();
}


// Calculate Item Amount

function CalculateItemAmount(rate, qty, disc){
	var amount = 0;
	//console.log("ItemTotalAmount: ",amount);
	amount = parseFloat((rate * qty) - (rate * qty * disc * 0.01));
	//console.log("ItemTotalAmount: ",amount);
	return amount;
	
}

// Calculate Tax Amount

function CalculateItemTaxAmount(rate, qty, disc, tax)
{
	var itemTaxAmount = 0;
//	console.log("itemTaxAmount: ",itemTaxAmount);
	var totAmt = CalculateItemAmount(rate, qty, disc);
	console.log("itemTaxAmount: ",totAmt);
	itemTaxAmount += parseFloat(totAmt*tax*0.01);
//	console.log("itemTaxAmount: ",itemTaxAmount);
	
	return itemTaxAmount;
	
}


// Caclulate Total Order Tax Amount


function CalculateOrderTaxAmount(orderItemArray1){
	var orderTaxAmount=0;
	
	console.log("OrderTaxAmount:",orderTaxAmount);
	for (var i = 0; i < orderItemArray1.length; i++) 
	{
		//console.log("checkBarcodeIfExists");
		//console.log(orderItemArray1[i].barcode,  barcodeValue);
		
		var itemRate = parseFloat(orderItemArray1[i].price);
		var itemQty = parseFloat(orderItemArray1[i].qtyValue);
		var itemDisc = parseFloat(orderItemArray1[i].discount);
		var itemTax = parseFloat(orderItemArray1[i].tax);
		
		orderTaxAmount += parseFloat(CalculateItemTaxAmount(itemRate, itemQty, itemDisc, itemTax));
		//console.log("OrderTaxAmount:",orderTaxAmount);
		
	}
	return orderTaxAmount;
}

	// Caclulate Total Order Tax Amount
	function CalculateOrderTotalAmount(orderItemArray1){
		var orderTotalAmount = 0;
		console.log("orderTotalAmount: ",orderTotalAmount);
		for (var i = 0; i < orderItemArray1.length; i++) 
		{
			console.log("checkBarcodeIfExists");
			//console.log(orderItemArray1[i].barcode,  barcodeValue);
			
			var itemRate = parseFloat(orderItemArray1[i].price);
			var itemQty = parseFloat(orderItemArray1[i].qtyValue);
			var itemDisc = parseFloat(orderItemArray1[i].discount);
			var itemTax = parseFloat(orderItemArray1[i].tax);
			
			console.log("Check all values: ",itemRate, itemQty, itemDisc);
			
			orderTotalAmount += parseFloat(CalculateItemAmount(itemRate, itemQty, itemDisc));
			
		}
	
		console.log("orderTotalAmount: ",orderTotalAmount);
		
		console.log(orderTotalAmount);
	
	return orderTotalAmount;
	
}

	
function removeOrderItemArray(removeItem) 
{
	console.log("removeItem: ",removeItem);
	
	var removeItemValue = false;
	
	for (var i = 0; i < orderItemArray1.length; i++)
	{
	
		if (orderItemArray1[i].barcode === removeItem) 
	    { 
			orderItemArray1.splice(i, 1);
			
			removeItemValue = true;
			
	        break;
	    }
		
	}
	
	return removeItemValue;
}