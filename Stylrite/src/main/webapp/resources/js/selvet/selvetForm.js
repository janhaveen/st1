$(document).ready(function()
{

  $("#SubmitButtonSelvet").click(function()
    {
	  if (validate())
            saveSelvetData();
    });

    $("#UpdateButtonSelvet").click(function()
    {
    	  if (validate())
            updateSelvetData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertSelvetData').reset();
        $("#saveSelvetDiv").addClass("HideThisElement");
        $("#showSelvetDiv").removeClass("HideThisElement");
    });
});
     function saveSelvetData(){
    	 $.ajax
    	    ({  
    	    	type:"POST",
    	    	url:"selvetRegister",
    	    	data:$("#insertSelvetData").serialize(),
    	    	success:function(data)
    	    	{
    	    		 if(data==801){
    	    			 document.getElementById('insertSelvetData').reset();
    	    			 SwalSuccess("Selvet Registration Successfully");
    	                 getSelvetList();
    	                 $("#showSelvetDiv").removeClass("HideThisElement");
    	                 $("#saveSelvetDiv").addClass("HideThisElement");
    	             } 
    	             else{
    	 	    		SwalError("No Selvet Added");
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
     
     function updateSelvetData(){
    		//  spinnerOn();
    		$.ajax
    		({
    			type:"POST",
    			url:"updateSelvet",
    			data:$("#insertSelvetData").serialize(),
    			success:function(data)
    			{
    				if(data="8001")
    					{
    					spinnerOff();
    					SwalSuccess("Selvet Update Sucessfully");
    					   document.getElementById('insertSelvetData').reset();
    					   getSelvetList();
    					   $("#showSelvetDiv").removeClass("HideThisElement");
    		                $("#saveSelvetDiv").addClass("HideThisElement");
    		            }
    				
    				else if(data=="8002"){
    					SwalError("No Selvet Updated");
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


