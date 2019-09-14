$(document).ready(function()
{
	
  $("#SubmitButtonBags").click(function()
    {
	  if (validate())
            saveBagsData();
    });

    $("#UpdateButtonBags").click(function()
    {
    	 if (validate())
            updateBagsData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertBagsData').reset();
        $("#saveBagsDiv").addClass("HideThisElement");
        $("#showBagsDiv").removeClass("HideThisElement");
    });
});

     function saveBagsData()
     {
    	
    	 $.ajax
    	    ({  
    	    	type:"POST",
    	    	url:"bagsRegister",
    	    	data:$("#insertBagsData").serialize(),
    	    	success:function(data)
    	    	{
    	    		 if(data==901){
    	    			 document.getElementById('insertBagsData').reset();
    	    			 SwalSuccess("Bags Registration Successfully");
    	                 getBagsList();
    	                 $("#showBagsDiv").removeClass("HideThisElement");
    	                 $("#saveBagsDiv").addClass("HideThisElement");
    	             } 
    	             else{
    	 	    		SwalError("No Bags Added");
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
     
     function updateBagsData(){
    		//  spinnerOn();
    		$.ajax
    		({
    			type:"POST",
    			url:"updateBags",
    			data:$("#insertBagsData").serialize(),
    			success:function(data)
    			{
    				if(data="9001")
    					{
    					spinnerOff();
    					SwalSuccess("Bags Update Sucessfully");
    					   document.getElementById('insertBagsData').reset();
    					   getBagsList();
    					   $("#showBagsDiv").removeClass("HideThisElement");
    		                $("#saveBagsDiv").addClass("HideThisElement");
    		            }
    				
    				else if(data=="9002"){
    					SwalError("No Bags Updated");
    				}
    				 console.log(data);
    			}
    		})
    	}
     function validate() 
     {
     	if($("#brandName").val()=="")
     		SwalWarning("Select Brand Name!");
     	else if($("#type").val()=="")
     		SwalWarning("Select Type No!");
     	
     	else 
     		return true;
     }

