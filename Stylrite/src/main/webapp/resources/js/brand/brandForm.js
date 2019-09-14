$(document).ready(function()
{

  $("#SubmitButtonBrand").click(function()
    {
	  if (validate())
         saveBrandData();
    });

    $("#UpdateButtonBrand").click(function()
    { 
    	 if (validate())
         updateBrandData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertBrandData').reset();
        $("#saveBrandDiv").addClass("HideThisElement");
        $("#showBrandDiv").removeClass("HideThisElement");
        
        $("#HomeText").html("Brand List");
    });
});
function saveBrandData() 
{
    //spinnerOn();

    $.ajax
    ({
        type: "POST",
        url: "brandRegister",
        data: $("#insertBrandData").serialize(), // serializes the form's elements.
        success: function(data) 
        {
          if (data == 501)
            {
                //spinnerOff();

                document.getElementById('insertBrandData').reset();

                SwalSuccess("Brand Registration Successfully");
                getBrandList();
                $("#showBrandDiv").removeClass("HideThisElement");
                $("#saveBrandDiv").addClass("HideThisElement");
            } 
           else if (data == 502) 
            {
               spinnerOff();
                //$("#contactNo").val("");
               
                SwalWarning("No Brand Register!");
            }
            else if (data == 503) 
            {
               // spinnerOff();
                //$("#gstNo").val("");
                SwalWarning("Brand  is Already Present!");
            }

            console.log(data);
        }
    });
}
function updateBrandData() 
{
    spinnerOn();
    
    $.ajax
    ({
        type: "POST",
        url: "updateBrand",
        data: $("#insertBrandData").serialize(), // serializes the form's elements.
        success: function(data)
        {
            if (data == 5001) 
            {
                spinnerOff();

                SwalSuccess("Brand Update Successfully");

                document.getElementById('insertBrandData').reset();

                //$('#showCustomertableList').ajax.reload();

                getBrandList();

                $("#showBrandDiv").removeClass("HideThisElement");
                $("#saveBrandDiv").addClass("HideThisElement");
            }
           else if (data == 5003)
            {
                spinnerOff();
                //$("#contactNo").val("");
                SwalWarning("Brand  is Already Present!");
            } 
            else if (data==5004) 
            {
                spinnerOff();
                SwalWarning("No Brand Updated!");
            }
            console.log(data);
        }
    });
}
function validate() 
{
	if($("#brandName").val()=="")
		SwalWarning("Select Brand Name!");
	
	else
		return true;
}