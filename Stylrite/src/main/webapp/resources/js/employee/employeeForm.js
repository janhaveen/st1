$(document).ready(function() 
 {
    $("#SubmitButtonEmployee").click(function() 
    {
    	if(validate())
    	{
    		console.log("hello.........");
    		saveEmployeeData();
    	}
    });
    
    $("#UpdateButtonEmployee").click(function() 
    {
    	if(validate())
    	{
    		console.log("hii.........");
    		updateEmployeeData();
    	}
    });
    
    
    $("#closeBtn").click(function() 
    {
    	document.getElementById('insertEmployeeData').reset();
        $("#empFormDiv").addClass("HideThisElement");
        $("#empTableDiv").removeClass("HideThisElement");
	});
    
    //var contactNo = null;
    
	
	/*$("#contactNo").keyup(function()
	{
		contactNo_check();
	});
	
	$("#gstNo").keyup(function()
	{
		gstNo_check();
	});*/
});

function saveEmployeeData() 
{
	spinnerOn();
	
    $.ajax
    ({
          type: "POST",
          url: "employeeRegister",
          data: $("#insertEmployeeData").serialize(), // serializes the form's elements.
          success: function(data)
          {
	       	   if(data == 301)
	       		{
	       		   spinnerOff();
	       		   
	       		  document.getElementById('insertEmployeeData').reset();
	       		
	       		   SwalSuccess("Employee Registration Successfully");
	       		  
	       		   getEmployeeList();
	           	   
	           	   $("#showEmployeeDiv").removeClass("HideThisElement");
	           	   $("#saveEmployeeDiv").addClass("HideThisElement");
	       		}
	       	   /* else if(data == 504)
	       		{
	       	    	spinnerOff();
	       	    	//$("#contactNo").val("");
	       	    	SwalWarning("Contact No is Already Present!");
	       		}
	       	    else if(data == 503)
	       		{
	       	    	spinnerOff();
	       	    	//$("#gstNo").val("");
	       	    	SwalWarning("GST No is Already Present!");
	       		}*/
	       	   
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