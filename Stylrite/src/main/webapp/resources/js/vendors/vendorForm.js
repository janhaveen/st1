$(document).ready(function()
{
    $("#SubmitButtonVendor").click(function()
    {
        if (validate())
            saveVendorData();
    });

    $("#UpdateButtonVendor").click(function()
    {
        if (validate())
            updateVendorData();
    });

    $("#closeBtn").click(function()
    {
        document.getElementById('insertVendorData').reset();
        $("#vendorFormDiv").addClass("HideThisElement");
        $("#venderTableDiv").removeClass("HideThisElement");
    });
});

function saveVendorData() 
{
    spinnerOn();

    $.ajax
    ({
        type: "POST",
        url: "vendorRegister",
        data: $("#insertVendorData").serialize(), // serializes the form's elements.
        success: function(data) 
        {
            if (data == 301)
            {
                spinnerOff();

                document.getElementById('insertVendorData').reset();

                SwalSuccess("Vendor Registration Successfully");
                getVendorList();

                $("#vendorFormDiv").addClass("HideThisElement");
                $("#venderTableDiv").removeClass("HideThisElement");
            } 
            else if (data == 304) 
            {
                spinnerOff();
                //$("#contactNo").val("");
                SwalWarning("Contact No is Already Present!");
            }
            else if (data == 303) 
            {
                spinnerOff();
                //$("#gstNo").val("");
                SwalWarning("GST No is Already Present!");
            }

            console.log(data);
        }
    });
}

function updateVendorData() 
{
    spinnerOn();

    $.ajax
    ({
        type: "POST",
        url: "updateVendor",
        data: $("#insertVendorData").serialize(), // serializes the form's elements.
        success: function(data)
        {
            if (data == 701 || data == 704 || data == 706 || data == 708) 
            {
                spinnerOff();

                SwalSuccess("Vendor Update Successfully");

                document.getElementById('insertVendorData').reset();

                //$('#showCustomertableList').ajax.reload();

                getVendorList();

                $("#vendorFormDiv").addClass("HideThisElement");
                $("#venderTableDiv").removeClass("HideThisElement");
            } 
            else if (data == 705)
            {
                spinnerOff();
                //$("#contactNo").val("");
                SwalWarning("Contact No is Already Present!");
            } 
            else if (data == 703 || data == 707) 
            {
                spinnerOff();
                SwalWarning("GST No is Already Present!");
            }
            console.log(data);
        }
    });
}

function validate() 
{
    if ($("#vendorName").val() == "")
        SwalWarning("Select Vendor Name!");
    else if ($("#contactNo").val() == "")
        SwalWarning("Select Contact No!");
    else if ($("#location").val() == "")
        SwalWarning("Select Location!");
    else if ($("#gstNo").val() == "")
        SwalWarning("Select GST No!");
    else
        return true;
}