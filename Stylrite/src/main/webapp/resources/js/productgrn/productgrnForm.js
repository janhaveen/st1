$(document).ready(function()
{
  $("#SubmitButtonProductGrn").click(function()
    {
	 
         saveProductGrn();
    });

   /* $("#UpdateButtonBrand").click(function()
    {
         updateBrandData();
    });
*/
    $("#closeBtn").click(function()
    {
        document.getElementById('insertBrandData').reset();
        $("#saveBrandDiv").addClass("HideThisElement");
        $("#showBrandDiv").removeClass("HideThisElement");
    });
    
});

    
    function saveProductGrn() {
   //spinnerOn();
       /*var generator =new IDGenerator();
   	   $("#grnPId").val("Gp"+generator.generate());*/
   	
   
    	
    			{
    			    $.ajax
    			    ({
    			        type: "POST",
    			        url: "addGRNProduct",
    			    	data:$("#insertVendor").serialize()+"&"+$("#insertGRNProduct").serialize(),
    			        success: function(data) 
    			        {
    			            console.log(data);

    			          
    			            $.ajax
    			    	    ({
    			    	        type: "POST",
    			    	        url: "addGrnProductItem",
    			    	        data: {"grnProductItemArray":JSON.stringify(grnProductItemArray)}, // serializes the form's elements.
    			    	        success: function(data) 
    			    	        {
    			    	            console.log(grnProductItemArray);
    			    	            
    			    	            if(data="10001")
    		    					{
	    		    					spinnerOff();
	    		    					SwalSuccess("Grn  Product Received  Sucessfully");
	    		    					/*getGrnProductList();
    		    					    $("#StockInDiv").addClass("HideThisElement");
    		    					    window.location="productGrn.jsp";*/
    		    		            }else if(data=="10001"){
	    		    					SwalError("No Product Received");
	    		    				}
    			    	        }
    			    	    });
    			        }
    			    });
    			

    }
 
    }  
