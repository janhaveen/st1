$(document).ready(function()
{
	$("#HomeText").html("Employee");
	
	getEmployeeList();
	
	DropDownForLegend();
	
	DropDownForEmployee();
	
});


//load customer list
function getEmployeeList() 
{
		//spinnerOn();
	
		$('#showEmployeetableList').DataTable().destroy();
	
		$('#showEmployeetableList thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#showEmployeetableList thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#showEmployeetableList').DataTable({ 
    		 dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Employee',
                     action: function ( e, dt, node, config ) {
                     	addNewEmployee();
                     	
                     }
                 }
             ],
             	"bLengthChange": true,
      			"searching": true,
      			"orderCellsTop": true ,
      			"sScrollX": "100%",
      			"sScrollXInner": "100%",
      			"bScrollCollapse": true,
              "ajax": {
                  "url": "listEmployee",
                //  "dataSrc": "" 
              },
              //'processing': true,
              'dataType': "json",
              'language': {
                  'loadingRecords': '&nbsp;',
                  processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
              }, 
      		 "columns": [
      			{
                  	className: "center",
                      defaultContent:'<center>'+
                      '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
                      '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;'+
                      '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'+
                     '</center>'
                  },
                  { "data": "empName" },
                  { "data": "deptText" },
                  { "data": "desigText" },
                  { "data": "userId" },
                  { "data": "mobileNo" },
                  { "data": "emailId" },
                  { "data": "reportTo" },
                  { "data": "statusText" }
               ],
               
               "initComplete": function(settings, json)
               {   
               	spinnerOff();
               }

             
    	 });
    	 
    	 
    	 $('#showEmployeetableList tbody').off('click');
    	 
    	 $('#showEmployeetableList tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    

    		 
    		 $("#empTableDiv").addClass("HideThisElement");
    		 $("#empFormDiv").removeClass("HideThisElement");
    		 $("#UpdateButtonEmployee").removeClass("HideThisElement");
    		 $("#SubmitButtonEmployee").addClass("HideThisElement");
    		 
    		 $("#rowId").val(data.rowId);
    		 $("#firstName").val(data.firstName).trigger('change');
    		 $("#lastName").val(data.lastName).trigger('change');
    		 $("#Male").val(data.Male).trigger('change');
    		 $("#Female").val(data.Female).trigger('change');
    		 $("#lastName").val(data.lastName).trigger('change');
    		 $("#mobileNo").val(data.mobileNo).trigger('change');
    		 $("#altContactNo").val(data.altContactNo).trigger('change');
    		 $("#emailId").val(data.emailId).trigger('change');
    		 $("#department").val(data.department);
    		 $("#designation").val(data.designation);
    		 $("#reportTo").val(data.reportTo).trigger('change');
    		 $("#userId").val(data.userId).trigger('change');
    		 $("#location").val(data.location).trigger('change');
    		 $("#Active").val(data.Active).trigger('change');
    		 $("#Inactive").val(data.Inactive).trigger('change');
    		 $("#birthDate").val(data.DOB).trigger('change');
    		 
    		 $("#action").val("updateCustomer");
    		 
    	 });
    	 
    	 $('#showEmployeetableList tbody').on( 'click', '.delete_me', function () 
    	 {
    		 //SwalWarning("Are You Sure Delete!"); 
    		 
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 var rowNo = data.rowNo;
    		 
    		 console.log(data);
    		 
    		 //deleteCustomer(rowNo);
    		 SwalDelete("It will permanently deleted !",  data.rowNo);
    	 });
}

function addNewEmployee()
{
	 var generator = new IDGenerator();
 	 $("#rowId").val("EId"+generator.generate());
 	 
	$("#empTableDiv").addClass("HideThisElement");
	$("#empFormDiv").removeClass("HideThisElement");
	$("#UpdateButtonEmployee").addClass("HideThisElement");
	$("#SubmitButtonEmployee").removeClass("HideThisElement");
	$("#action").val("insertEmployee");
	
	DropDownForLegend();
	
	DropDownForEmployee();
}

function SwalDelete(msg, rowno) 
{
	swal
	({
		  title: 'Are you sure?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, delete it!',
		  cancelButtonText: 'No !'
		}).then(function() {
		  swal(
			'Deleted!',
			'Your file has been deleted.',
			'success'
		  );
		  deleteCustomer(rowno);
		}, function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
		    swal(
		      'Ok',
		      'Cancelled !',
		      'error'
		    )
		  }
	});
}

function deleteCustomer(rowNo)
{
	$.ajax
    ({
          type: "POST",
          //url: "deleteVendor?rowNo="+rowNo,
          data: $(this).serialize(), // serializes the form's elements.
          success: function(data)
          {
        	  if(data == 201)
        	  {
        		  getCustomerList();
        	  }
          },
		  error : function ()
		  {
			  
		  }
    
      });
}