$(document).ready(function()
{

	
  $("#SubmitButtonTray").click(function()
    {
	  if (validate())
            saveTrayData();
    });

    $("#UpdateButtonTray").click(function()
    {
    	  if (validate())
            updateTrayData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertTrayData').reset();
        $("#saveTrayDiv").addClass("HideThisElement");
        $("#showTrayDiv").removeClass("HideThisElement");
    });
});

function saveTrayData() 
{
    //spinnerOn();

    $.ajax
    ({
        type: "POST",
        url: "trayRegister",
        data: $("#insertTrayData").serialize(), // serializes the form's elements.
        success: function(data) 
        {
            if (data == 601)
            {
                //spinnerOff();

                document.getElementById('insertTrayData').reset();

                SwalSuccess("Tray Registration Successfully");
                getTrayList();
                $("#showTrayDiv").removeClass("HideThisElement");
                $("#saveTrayDiv").addClass("HideThisElement");
            } 
            else{
	    		SwalError("No Tray Added");
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

function updateTrayData(){
	//  spinnerOn();
	$.ajax
	({
		type:"POST",
		url:"updateTray",
		data:$("#insertTrayData").serialize(),
		success:function(data)
		{
			if(data="6001")
				{
				spinnerOff();
				SwalSuccess("Tray Update Sucessfully");
				   document.getElementById('insertTrayData').reset();
				   getTrayList();
				   $("#showTrayDiv").removeClass("HideThisElement");
	                $("#saveTrayDiv").addClass("HideThisElement");
	            }
			
			else if(data=="6002"){
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
	else if($("#capacity").val()=="")
		SwalWarning("Select Capacity!");
	else 
		return true;
}



