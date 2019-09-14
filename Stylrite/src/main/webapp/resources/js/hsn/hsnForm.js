$(document).ready(function()
{
	 $("#SubmitButtonHsn").click(function()
			    {
				  if (validate())
			    	saveHsnData();
			    });
	 $("#closeBtn").click(function()
			    {
			        document.getElementById('insertHsnData').reset();
			        $("#saveHsnDiv").addClass("HideThisElement");
			        $("#showHsnDiv").removeClass("HideThisElement");
			    });
	      $("#UpdateButtonHsn").click(function()
			    {
			    	 if (validate())
			            updateHsn();
			    });
});
   function saveHsnData(){
	   
	   $.ajax
	    ({  
	    	type:"POST",
	    	url:"hsnRegister",
	    	data:$("#insertHsnData").serialize(),
	    	success:function(data)
	    	{
	    		 if(data==21001){
	    			 document.getElementById('insertHsnData').reset();
	    			 SwalSuccess("HSN Added Successfully");
	                 getHsnList();
	                 $("#showHsnDiv").removeClass("HideThisElement");
	                 $("#saveHsnDiv").addClass("HideThisElement");
	             } 
	             else{
	 	    		SwalError("No Hsn Added");
	 	    	}
	             /*else if (data == 304) 
	             {
	                 //spinnerOff();
	                 //$("#contactNo").val("");
	                 SwalWarning("Contact No is Already Present!");
	             }
	             else if (data == 303) 
	             {
	                // spinnerOff();
	                 //$("#gstNo").val("");
	                 SwalWarning("GST No is Already Present!");
	             }*/

	             console.log(data);
	         }
	     });
   }
   function updateHsn(){
		//   spinnerOn();
		$.ajax
		({
			type:"POST",
			url:"updateHsn",
			data:$("#insertHsnData").serialize(),
			success:function(data)
			{
				if(data="2111")
					{
					spinnerOff();
					SwalSuccess("HSN Update Sucessfully");
					   document.getElementById('insertHsnData').reset();
					   getHsnList();
					   $("#showHsnDiv").removeClass("HideThisElement");
		                $("#saveHsnDiv").addClass("HideThisElement");
		            }
				
				else if(data=="2112"){
					SwalError("No Hsn Updated");
				}
				 console.log(data);
			}
		})
	}

function validate()
{
	if($("#hsnName").val()==""){
		SwalWarning("Enter HSN Name !");
	}
	else if($("#cgst").val()==""){
		SwalWarning("Enter Cgst Value!");
	}
	else if($("#sgst").val()==""){
		SwalWarning("Enter Sgst Value!");
	}
	else if($("#igst").val()==""){
		SwalWarning("Enter Igst Value!");
	}
	else if($("#ugst").val()=="")
		SwalWarning("Enter ugst Value!");
	
	else 
		return true;
		
}