$(document).ready(function()
{
	 
  $("#SubmitButtonCases").click(function()
    {
	  if (validate())
    	saveCasesData();
    });
      

    $("#UpdateButtonCases").click(function()
    {
    	 if (validate())
            updateCasesData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertCasesData').reset();
        $("#saveCasesDiv").addClass("HideThisElement");
        $("#showCasesDiv").removeClass("HideThisElement");
    });
});
     function saveCasesData(){

    	 $.ajax
    	    ({  
    	    	type:"POST",
    	    	url:"casesRegister",
    	    	data:$("#insertCasesData").serialize(),
    	    	success:function(data)
    	    	{
    	    		 if(data==701){
    	    			 document.getElementById('insertCasesData').reset();
    	    			 SwalSuccess("Cases Registration Successfully");
    	                 getCasesList();
    	                 $("#showCasesDiv").removeClass("HideThisElement");
    	                 $("#saveCasesDiv").addClass("HideThisElement");
    	             } 
    	             else{
    	 	    		SwalError("No Cases Added");
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
     
     function updateCasesData(){
    		//  spinnerOn();
    		$.ajax
    		({
    			type:"POST",
    			url:"updateCases",
    			data:$("#insertCasesData").serialize(),
    			success:function(data)
    			{
    				if(data="7001")
    					{
    					spinnerOff();
    					SwalSuccess("Cases Update Sucessfully");
    					   document.getElementById('insertCasesData').reset();
    					   getCasesList();
    					   $("#showCasesDiv").removeClass("HideThisElement");
    		                $("#saveCasesDiv").addClass("HideThisElement");
    		            }
    				
    				else if(data=="7002"){
    					SwalError("No Tray Updated");
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
     	else if($("#quantity").val()=="")
     		SwalWarning("Select quantity!");
     	else 
     		return true;
     }
