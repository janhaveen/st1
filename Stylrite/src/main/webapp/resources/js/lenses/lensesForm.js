$(document).ready(function()
{
	 
  $("#SubmitButtonLenses").click(function()
    {
	  if (validate())
    	saveLensesData();
    });
      

    $("#UpdateButtonLenses").click(function()
    {
    	 if (validate())
            updateLenses();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertLensesData').reset();
        $("#saveLensesDiv").addClass("HideThisElement");
        $("#showLensesDiv").removeClass("HideThisElement");
    });
});
function saveLensesData(){
      console.log("action value",$("#action").val());
	 $.ajax
	    ({  
	    	type:"POST",
	    	url:"lensesRegister",
	    	data:$("#insertLensesData").serialize(),
	    	success:function(data)
	    	{
	    		 if(data==180001){
	    			 document.getElementById('insertLensesData').reset();
	    			 SwalSuccess("Lenses Registration Successfully");
	                 getLensesList();
	                 $("#showLensesDiv").removeClass("HideThisElement");
	                 $("#saveLensesDiv").addClass("HideThisElement");
	             } 
	             else{
	 	    		SwalError("No Lenses Added");
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
function updateLenses(){
	//  spinnerOn();
	$.ajax
	({
		type:"POST",
		url:"updateLenses",
		data:$("#insertLensesData").serialize(),
		success:function(data)
		{
			if(data="19001")
				{
				spinnerOff();
				SwalSuccess("Lens Update Sucessfully");
				   document.getElementById('insertLensesData').reset();
				   getLensesList();
				   $("#showLensesDiv").removeClass("HideThisElement");
	                $("#saveLensesDiv").addClass("HideThisElement");
	            }
			
			else if(data=="19002"){
				SwalError("No Lenses Updated");
			}
			 console.log(data);
		}
	})
}
function validate() 
{
	if($("#brandName").val()=="")
		SwalWarning("Select Brand Name!");
	else if($("#model").val()=="")
		SwalWarning("Enter Model No!");
	else if($("#specification1").val()=="")
		SwalWarning("Enter Specification 1!");
	else 
		return true;
}