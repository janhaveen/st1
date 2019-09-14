$(document).ready(function()
{

  $("#SubmitButtonOrderJobs").click(function()
    {
        saveOrderJobsData();
    });

    $("#UpdateButtonSelvet").click(function()
    {
    	  if (validate())
            updateSelvetData();
    });

    $("#closeBtn").click(function() 
    {
    	//document.getElementById('insertOrderJobsData').reset();
        $("#saveOrderJobsDiv").addClass("HideThisElement");
        $("#showOrderJobsDiv").removeClass("HideThisElement");
	});
});
     function saveOrderJobsData()
     {
    	 $.ajax
    	    ({  
    	    	type:"POST",
    	    	url:"addNewOrderJobs",
    	    	data:$("#insertVendorFittingData").serialize()+"&rowId="+$("#jobId").val()+"&expectedDeliveryDate="+$("#expectedDeliveryDate").val()+"&remarks="+$("#remarks").val(),
    	    	success:function(data)
    	    	{
    	             $.ajax
    	     	    ({  
    	     	    	type:"POST",
    	     	    	url:"addNewJobsItemForvendorFittingFrameAndSunglass",
    	     	    	data:{"vendorFittingFrameAndSunglassArray":JSON.stringify(vendorFittingFrameAndSunglassArray)},
    	     	    	success:function(data)
    	     	    	{
    	     	             //console.log(data);
    	     	    		
    	     	    		$("#vendorForFitting").addClass("HideThisElement");
    	     	    		$("#expected").addClass("HideThisElement");
    	     	    		$("#remarks11").addClass("HideThisElement");
    	     	    		$("#SubmitButtonOrderJobs").addClass("HideThisElement");
    	     	    		$("#showJobsListDiv").removeClass("HideThisElement");
    	     	    		getFrameAndSunglassJobsList();
    	     	    		
    	     	        }
    	     	     });
    	        }
    	     });
    	 }
     
   /*  function updateSelvetData()
     {
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
    	}*/
     
     function validate() 
     {
     	if($("#brandName").val()=="")
     		SwalWarning("Select Brand Name!");
     	else if($("#type").val()=="")
     		SwalWarning("Select Type No!");
     	
     	else 
     		return true;
     }


