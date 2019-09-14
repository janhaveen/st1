$(document).ready(function(){
    $("#source").change(function () {
        var val = this.value;
		$('#legendGroupLbl').addClass("active");
        if (val=="246") {
        	$('#reference').val("");
        	$("#referenceDiv").removeClass("HideThisElement");
		}
        else
        {
        	$("#referenceDiv").addClass("HideThisElement");
        }
    });
        $("#SubmitButtonRegister").click(function() {
        	 if (validate())
        	formSubmit(); 
        	
        });
        
        $("#SubmitButtonUpdate").click(function()
        	{
        	  if(validateVendorUpdate())
        	formUpdate();
        	
          });
        
        $("#SubmitButtonBack").click(function()
       	{
    	    $("#VendorTableDiv").removeClass("HideThisElement");
    		$("#VendorViewDiv").addClass("HideThisElement");
    		$("#VendorFormDiv").addClass("HideThisElement");
        });
        
        $("#SubmitButtonBackFromView").click(function()
        {
    	    $("#VendorTableDiv").removeClass("HideThisElement");
    		$("#VendorViewDiv").addClass("HideThisElement");
    		$("#VendorFormDiv").addClass("HideThisElement");
        });
        $("#SubmitButtonUpdateVContactPerson").click(function() {
        	if(validateContactPerson())
        	formUpdateVendorContactPerson();
                        
        });
        $("#SubmitButtonUpdateVAddress").click(function() {
        	if(ValidateAddressDetails())
        	formUpdateVendorAddress();
        
    });
        $("#SubmitButtonVendorContactPerson").click(function() {
            /*if (validate())*/
        	if(validateContactPerson())
           formSubmitContactDetils();

        });
        
        $("#SubmitButtonVendorAddressDetails").click(function() {
            /*if (validate())*/
        	if(ValidateAddressDetails())
                formSubmitAddressDetails();

        });
        $("#DeleteVendorConfirmed").click(function() {
            var DeleteVendorId = document.querySelector('#DeleteVendorId').value;
           /* alert(DeleteVendorId);*/
            $.ajax({
                type: "POST",
                url: 'DeletedVendor?rowId='+DeleteVendorId,
              
                success: function(data)
                {
                	if(data==801){
                		
                		 $('#centralModalDangerDemo').modal('hide');
                		  $('#datatables').DataTable().ajax.reload();
                		  SwalSuccess("vendor Deleted Sucessdfully")
                	}
                	else if(data==802)
                	{
                		SwalError("No Vendor Deleted")
                	}
                   /* if (data == 802) {
                        $('#centralModalDangerDemo').modal('hide');
                        SwalError("No Vendor Deleted")
                        $(".errorMsg").removeClass("HideThisElement");
                        $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Client!');
                    } else {
                        $('#centralModalDangerDemo').modal('hide');
                        $('#selectedEmployeeId').val('');
                        $('#datatables').DataTable().ajax.reload();
                        $(".successMsg").removeClass("HideThisElement");
                        $("#successMsg").html(' <strong>Success!</strong>  Client Deleted Successfully!');
                    }*/
                }
            })
            return false; // avoid to execute the actual submit of the form.
        });
});
function formSubmit()
{
	var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");
	var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");
    spinnerOn();

    $.ajax({
        type: "POST",
        url: "vendorRegister",
        data: $("#newVendorElementForm").serialize(), // serializes the form's elements.
        success: function(data) {
        	 console.log("VendorAd",data)
        	
            $.ajax({
                type: "POST",
                url: "vendorAddressRegister",
                data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val()+dataAdd, // serializes the form's elements.
                success: function(data) {
                    spinnerOff();

                    console.log("VendorAdddressDetails",data);

                    $.ajax({

                        type: "POST",
                        url: "VendorPersonRegister",
                        data: $("#insertVendorContactDetails").serialize() +'&vendorId='+ $("#selectedVendorId").val()+dataCP, // serializes the form's elements.
                        success: function(data)
                        {
                        	
                            console.log("vendor contactPersonRegister Details", data);
                            

                          
                        }
                    });

                    //window.location = 'showOrder';
                   
                    getVendorList();   
                    window.location = 'showVendor1';
                    SwalSuccess("Vendor  added Sucessfully");
                }
            });
            console.log(data);
        }
    });

}
       function formUpdate(){
    	   spinnerOn();

    	    $.ajax({
    	        type: "POST",
    	        url: "updateVendor",
    	        data: $("#newVendorElementForm").serialize(), // serializes the form's elements.
    	        success: function(data) {
    	        	spinnerOff();
    	        	    if(data==2501)
    	        	    {  	
    	        	    	 getVendorList();   
    	                     window.location = 'showVendor1';
    	                 	    SwalSuccess("Vendor Updated Sucessfully");
    	        	    	
    	        	    }
    	        	    
    	       	}
    	    });
       }
     function formUpdateVendorContactPerson()
     {
    		var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");
    	    $.ajax({
  
                type: "POST",
                url: "vendorUpdateContactDetails",
                data: $("#insertVendorContactDetails").serialize() +'&vendorId=' + $("#selectedVendorId").val()+dataCP, // serializes the form's elements.
                success: function(data)
                {
                    console.log("VendorPersonRegister Details", data);
                    if(data==2701){
                    
                    	$("#VendorFormDiv").addClass("HideThisElement");
                    	$("#VendorViewDiv").removeClass("HideThisElement");
                   	 	document.getElementById("insertVendorContactDetails").reset();
                   	 	getCotactPerson();
                   		SwalSuccess("Vendor Contact Person Data updated Sucessfully");
                    }
                    else if (data==2702){
                    	SwalSuccess("No updated Vendor Person");
                    }

                  
                }
            });
    	 
     }
     function formUpdateVendorAddress()
     {
    	 var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");	 
    	   $.ajax({
               type: "POST",
               url: "vendorUpdateAddressDetails",
               data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val()+dataAdd, // serializes the form's elements.
               success: function(data) {
                   spinnerOff();

                   console.log("vendorAdddressDetails",data);

                   if(data=2601)
                   {
                   	
                   	$("#VendorFormDiv").addClass("HideThisElement");
               	    $("#VendorViewDiv").removeClass("HideThisElement");
               	    document.getElementById("insertVendorAddressDetails").reset();
               	    getAddress();
                 	SwalSuccess("Vendor Address Detail data updated  Sucessfully");
                   }
                   else if(data==2602){
                   	SwalSuccess("No updated Vendor Details");
                   }

                 
               }
           });
       	
     }
       function  formSubmitContactDetils()
      {
    	   var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");

    	   $.ajax({
               type: "POST",
               url: "newVendorContactDetails",
               data: $("#insertVendorContactDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val()+dataCP, // serializes the form's elements.
               success: function(data) {
                   spinnerOff();

                   console.log("newVendorClientDetails",data);
                     if(data==1703){
                    	 $("#VendorFormDiv").addClass("HideThisElement");
                    	 $("#VendorViewDiv").removeClass("HideThisElement");
                    	 document.getElementById("insertVendorContactDetails").reset();
                    	 getCotactPerson();
                    	 SwalSuccess("Vendor ContactPerson Added  Sucessfully");
                     }
                     else if(data==1704){
                    	 SwalSuccess("No Vendor added Sucessfully");
                    	 
                     }
                    
               }
    	   });
    	   
    	   
            }   
       
     function formSubmitAddressDetails()
     {
    		var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");

    	 $.ajax({
             type: "POST",
             url: "newVendorAddressDetails",
             data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val()+dataAdd, // serializes the form's elements.
             success: function(data) {
                 spinnerOff();

                 console.log("newAddressDetails",data);
                   if(data==1603){
                	   $("#VendorFormDiv").addClass("HideThisElement");
                  	   $("#VendorViewDiv").removeClass("HideThisElement");
                  	   document.getElementById("insertVendorAddressDetails").reset();
                  	   getAddress();
                  	  	SwalSuccess("Vendor Address Details Added  Sucessfully");
                   }
                   else if(data==1604){  
                  	 SwalSuccess("No Vendor  Address added Sucessfully");
                   }
                  
             }
  	   });

     }

     function validateVendorUpdate(){ 
         	    if ($("#companyName").val() == "")
   	        SwalWarning("Company Name is mandatory !");
   	         else if ($("#location").val() == "")
   	        SwalWarning("Location is mandatory !");
   	        else if ($("#vendorType").val() == "")
   	        SwalWarning("vendor Type is mandatory !");
   	        else if ($("#creditTime").val() == "")
   	        SwalWarning("Credit Time is mandatory !");
   	        else if ($("#salesPerson").val() == "")
   	        SwalWarning("Sales Person is not selected !");
   	        else if ($("#source").val() == "")
   	        SwalWarning("Source is not selected !");
   	        else
   	    	return true;

   	  
     }
   function validateContactPerson() {
   	 if ($("#firstName").val() == "")
           SwalWarning("First Name is mandatory !");
       else if ($("#locationCP").val() == "")
           SwalWarning("Location is mandatory !");
       else if ($("#mobileno").val() == "")
           SwalWarning("Mobile Number is mandatory !");
       else if ($("#emailId").val() == "")
           SwalWarning("Email ID is mandatory !");
       else if ($("#designation").val() == "")
           SwalWarning("Designation is mandatory !");
       else if ($("#department").val() == "")
    		SwalWarning("Department is mandatory !");
    	else if ($("#birthDate").val() == "")
    		SwalWarning("birthDate is mandatory !");
       else
       	return true;
   }

function validate() {

if ($("#companyName").val() == "")
SwalWarning("Company Name is mandatory !");
else if ($("#location").val() == "")
SwalWarning("Location is mandatory !");
else if ($("#vendorType").val() == "")
SwalWarning("Vendor Type is mandatory !");
else if ($("#creditTime").val() == "")
SwalWarning("Credit Time is mandatory !");

else if ($("#salesPerson").val() == "")
SwalWarning("Sales Person is not selected !");

else if ($("#source").val() == "")
SwalWarning("Source is not selected !");

else if ($("#firstName").val() == "")
SwalWarning("First Name is mandatory !");
else if ($("#locationCP").val() == "")
SwalWarning("Location is mandatory !");
else if ($("#mobileno").val() == "")
SwalWarning("Mobile Number is mandatory !");
else if ($("#emailId").val() == "")
SwalWarning("Email ID is mandatory !");
else if ($("#designation").val() == "")
SwalWarning("Designation is mandatory !");

   else if ($("#department").val() == "")
	SwalWarning("Department is mandatory !");
else if ($("#birthDate").val() == "")
	SwalWarning("birthDate is mandatory !");
else if ($("#branchName").val() == "")
SwalWarning("Branch Name is mandatory !");
else if ($("#inputState").val() == "")
SwalWarning(" State is mandatory !");
else
return true;

}
function ValidateAddressDetails(){
if ($("#branchName").val() == "")
SwalWarning("Branch Name is mandatory !");
else if ($("#inputState").val() == "")
SwalWarning(" State is mandatory !");
else
return true;
}     

