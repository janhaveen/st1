var orderItemArray=[];
var orderLensItemArray=[];
var BarcodeArrScanned=[];
var price2 = 0;
$(document).ready(function() 
 {
    $("#SubmitButtonOrder").click(function() 
    {
    		console.log("hello.........");
    		saveOrderData();
    });
    
    $("#UpdateButtonOrder").click(function() 
    {
    	if(validate())
    	{
    		console.log("hii.........");
    		updateEmployeeData();
    	}
    });
    
   
    
    $("#closeBtn").click(function() 
    {
    	document.getElementById('insertOrderData').reset();
        $("#saveOrderDiv").addClass("HideThisElement");
        $("#showOrderDiv").removeClass("HideThisElement");
	});
    
    $("#SubmitNewCustomer").click(function() 
    {
  	  if (validateNewCustomer())
         addNewCustomer();
    });
    
    
    
    $("#advancers").focusout(function() 
    {
    	if ($("#advancers").val() != "") 
    	{
        	$("#balancers").html((parseFloat($("#grantTotalrs").html()) - parseFloat($("#advancers").val())));
        	
        	$("#totalPayableAmountrs").html($("#balancers").html());
    	}
    	else
    	{
    		
    	}
    });
    
    $('#showLensestableList tbody').on( 'click', '.select_me', function () 
     {
    	var data = $('#showLensestableList').DataTable().row($(this).parents('tr')).data();
    			
    	var qty = 1;
    			
    		var table1 = document.getElementById('LensDataBody');
    		var rowCount = table1.rows.length;
    		var idExists = false;
    		for(var i=0; i<rowCount; i++)
    		{
    			var row = table1.rows[i];
    			var a = $(row.cells[0]).html();
    			var idToCheck= $(a).attr('id');
    	    	if (idToCheck == data.rowId)
    	    	{
    				idExists = true;
    				break;
    			}
    		}
    		/*console.log(idExists);*/
    		if (idExists) 
    		{
    			swal({
    				  title: 'Lens Product Already Selected !',
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
    			console.log("dsd");
    			  var generator = new IDGenerator();
    			  
    			var newHtml = '<tr id="lensProductIdRow">'+
    			  '<td><input type="checkbox" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
    			  '<td>'+data.brandName+'</td>'+
    			  '<td>'+data.model+'</td>'+
    			  '<td>'+data.specification1+'</td>'+
    			  '<td>'+data.specification2+'</td>'+
    			  '<td>'+data.specification3+'</td>'+
    			  '<td>'+data.price+'</td>'+
    			  '<td>'+data.cost+'</td>'+
    			  '</tr>';
    			
    			document.querySelector('#LensDataBody').insertAdjacentHTML('beforeend', newHtml);
    			
    			orderLensItemArray.push({"orderLensItemId":"OLId"+generator.generate(), "orderId":$("#orderId").val(), "brand": data.brandName, "model":data.model, "qty": qty, "specification1":data.specification1, "specification2":data.specification2, "specification3":data.specification3});
    			
    			console.log(orderLensItemArray);
    			
    			$('#selectLensesModal').modal('hide');
    		}
    		
   });
    
    $("#DeleteProduct").click(function()
    		{
    			try
    			{
    				var ch;
    		    	var table = document.getElementById('ProductDataBody');
    		    	var rowCount = table.rows.length;
    		    	for(var i=0; i<rowCount; i++) {
    		    		var row = table.rows[i]; 
    		    		var chkbox = row.cells[0].childNodes[0]; 

    		    		if(null != chkbox && true == chkbox.checked)
    		    		{
    		    			ch = $(chkbox).val();
    		    			
    		    			$("#totalrs").val(parseInt($("#totalrs").val())-parseInt($("#amt"+$(chkbox).val()).html()));
    		    			
    		    			$('#cbIdH'+$(chkbox).val()).remove();
    		    			
    		    			removeOrderItemArray($(chkbox).val());
    		    			
    		    			rowCount--;
    	        			
    						//i--;
    						
		    				table.deleteRow(i); 
    		    			
    		    			/*for(var j=0; j<$(row.cells).length; j++)
    		    			 {    		    
    		    				 
    		    				 if(j==0)
 		    					{
 		    						
 		    					
 		    						//ch = $($(row.cells[j]).html()).val();
 		    						
 		    						console.log(ch+"..............1pkm");
 		    						
 		    						$('#cbIdH'+$($(row.cells[j]).html()).val()).remove();
 		    						
 		    						$("#advancers").val("");
 									
 									$("#balancers").val("");
 		    						
 		    						removeOrderItemArray($($(row.cells[j]).html()).val());
 		    						
 		    						rowCount--;
 		    	        			
 		    						i--;
 		    						
 				    				table.deleteRow(i); 
 		    						
 		    					}
    		    			   else if(j==9)
    		    				{
    		    				   		var price3 = 0;
    		    				   		
    		    				   		price3 = parseFloat($($(row.cells[j]).html()).val());
    		    						
    		    				   		console.log($("#amt"+ch));
    		    				   		
    		    						price2 = parseFloat(price2) - parseFloat($("#amt"+ch));
    		    						 
    		    						$("#totalrs").val(price2);
    		    						
    		    						rowCount--;
     		    	        			
     		    						i--;
     		    						
     				    			table.deleteRow(i); 
    		    				}
	    		    			
    		    			}*/
    		    		}
    		    	}
    		    	}catch(e)
    		    	{
    		    		alert(e);
    		    	}
    		    return false; 
    		});
    
    $("#mobileNo").focusout(function() 
    {
    	var phoneno = /^\d{10}$/;
  	  
        var mobileno = $("#mobileNo").val();
        if (mobileno != "") 
        {
            /*if (mobileno.length > 9)*/
        	if((mobileno.match(phoneno)))
                getCustomerInfo(mobileno);
        	else
        	{
        		SwalWarning("mobile number should of 10 digits");
        	}
        }
    });
    
    $("#addLense").click(function() 
    {
    	$('#selectLensesModal').modal('show');
    });
    
    $("#prescriptionChecked").change(function() 
    {
        if(this.checked) {
        	
        	$('#selectPrescriptionModal').modal('show');
        	getPrescriptionList( $("#customerId").val());
        	
        }
    });
});

function getCustomerInfo(mobileno) 
{
    console.log(mobileno);
    $.ajax({
        type: "GET",
        url: "listCustomerInfo?mobileno=" + mobileno,
        data: $(this).serialize(), // serializes the form's elements.
        success: function(data) {
            if (data.data.length > 0) {
                for (var i = 0; i < data.data.length; i++) {
                    if (mobileno == data.data[i].contactNo) {
                    	$("#customernameDiv").removeClass("HideThisElement");
                        $("#emailidDiv").removeClass("HideThisElement");          
                        console.log("...cust..", data.data[i].customerName)
                        $("#customerName").val(data.data[i].customerName);
                        $("#emailId").val(data.data[i].email);
                        $("#customerId").val(data.data[i].rowId);
                        $("#SubmitNewCustomer").addClass("HideThisElement");
                        $("#prescriptionCheckboxDiv").removeClass("HideThisElement")
                        getPrescriptionList(data.data[i].rowId);
                    }

                }
            } else {
            	$("#customernameDiv").removeClass("HideThisElement");
                $("#emailidDiv").removeClass("HideThisElement");     
                document.getElementById('customerName').value = "";
                document.getElementById('emailId').value = "";
                $("#SubmitNewCustomer").removeClass("HideThisElement");
               
            }
        }

    });
}

function addNewCustomer() 
{
    var generator = new IDGenerator();
     $("#customerId").val("CID" + generator.generate())
     $("#mobileNo").val();
     $("#customerName").val();
    var emailid = $("#emailId").val();
    $.ajax({
        type: "POST",
        url: "addNewCustomer",
        data: 'contactNo='+$("#mobileNo").val() + '&customerName='+$("#customerName").val()+'&email='+$("#emailId").val()+'&rowId='+$("#customerId").val(),
        success: function(data) {
            if (data == 12001) {

                SwalSuccess("New Customer added ");
                $("#SubmitNewCustomer").addClass("HideThisElement");

            }

            console.log(data);
        }

    });
}



function updateEmployeeData()
{
	spinnerOn();
	
	/*$.ajax
	 ({
	     type: "POST",
	     url: "updateCustomer",
	     data: $("#insertEmployeeData").serialize(), // serializes the form's elements.
	     success: function(data)
	      {
	    	 
	    	    if(data == 601 || data == 604 || data == 606 || data == 608)
        		{
	    	    	spinnerOff();
	    	    	
	    	    	SwalSuccess("Employee Update Successfully");
	    	    	
	    	    	document.getElementById('insertEmployeeData').reset();
	    	    	
	    	    	//$('#showCustomertableList').ajax.reload();
	    	    	 
	    	    	getEmployeeList();
	    	            	   
	    	        $("#showEmployeeDiv").removeClass("HideThisElement");
	    	        
		           	$("#saveEmployeeDiv").addClass("HideThisElement");
        		}
	    	    else if(data == 605)
        		{
	    	    	spinnerOff();
	       	    	//$("#contactNo").val("");
	       	    	SwalWarning("Contact No is Already Present!");
        		}
	    	    else if(data == 603 || data == 607)
        		{
	    	    	spinnerOff();
	       	    	SwalWarning("GST No is Already Present!");
        		}
	    	 console.log(data);
	       }
	 });*/
}

function validate() 
{
	if($("#customerName").val()=="")
		SwalWarning("Select Customer Name!");
	else if($("#contactNo").val()=="")
		SwalWarning("Select Contact No!");
	else if($("#location").val()=="")
		SwalWarning("Select Location!");
	else if($("#gstNo").val()=="")
		SwalWarning("Select GST No!");
	else if($("#source").val()=="")
		SwalWarning("Select Source!");
	else 
		return true;
}

function validateNewCustomer()
{
	if($("#mobileNo").val()=="")
		SwalWarning("Enter Mobile Number!");
	else if($("#customerName").val()=="")
		SwalWarning("Enter Customer Name!");
	else if($("#emailId").val()=="")
		SwalWarning("Enter email id!");
	else 
		return true;
}

function saveOrderData()
{
    //spinnerOn();

    $.ajax({
        type: "POST",
        url: "orderRegister",
        data: $("#insertOrderData,#insertOrderInfo,#insertPrescriptionForm").serialize()+'&mobileNo='+$("#mobileNo").val()+'&customerName='+$("#customerName").val()+'&emailId='+$("#emailId").val()+'&CID='+$("#customerId").val()+'&remarks='+$("#remarks").val(), // serializes the
        success: function(data)
        {
        	$.ajax
    	    ({
    	        type: "POST",
    	        url: "addNewOrderItem",
    	        data: {"orderItemArray":JSON.stringify(orderItemArray)}, // serializes the form's elements.
    	        success: function(data) 
    	        {
    	        	spinnerOff();
    	        	
    	        	console.log(data);
    	        	
    	        	var generator = new IDGenerator();
    	        	
    	        	$("#PrescriptionId").val("PSCId"+generator.generate());
    	        	
    	        	 $.ajax
			    	    ({
			    	    	
			    	        type: "POST",
			    	        url: "addPrescriptionDetails",
			    	        data:$("#insertPrescriptionForm").serialize()+'&orderId='+$("#orderId").val()+'&clientId='+$("#customerId").val()+'&rowId='+$("#PrescriptionId").val(), // serializes the form's elements.
			    	        success: function(data) 
			    	        {
			    	            console.log("Prescription Details",data);
			    	            
			    	            $.ajax
					    	    ({
					    	    	
					    	        type: "POST",
					    	        url: "addNewOrderLenseItem",
					    	        data:{"orderLensItemArray":JSON.stringify(orderLensItemArray)}, // serializes the form's elements.
					    	        success: function(data) 
					    	        {
					    	        	window.location = 'showOrder';
					    	        }
					    	    });
			    	        }
			    	    });
    	        	
    	        	//window.location = 'showOrder';
    	        }
    	    });
        	
           /* if (data == 901) 
            {
            	$.ajax
        	    ({
        	        type: "POST",
        	        url: "addNewOrderItem",
        	        data: {"orderItemArray":JSON.stringify(orderItemArray)}, // serializes the form's elements.
        	        success: function(data) 
        	        {
        	        	spinnerOff();
        	        	
        	        	if (data == 12001) 
        	            {
        	        		document.getElementById('insertOrderData').reset();

                            SwalSuccess("Order Placed Successfully");
                            
                            getOrderList();
                            
            	           	$("#saveOrderDiv").removeClass("HideThisElement");
            	           	$("#showOrderDiv").addClass("HideThisElement");
        	            }
        	        }
        	    });

             }*/
        }
    });
}

