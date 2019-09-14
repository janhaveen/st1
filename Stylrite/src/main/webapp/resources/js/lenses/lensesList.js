$(document).ready(function() {
 
    $("#HomeText").html("Lenses List");
    
    getLensesList();
    DropDownForBrand();
    
});
function getLensesList(){   
	  //  spinnerOn();
	    $('#showLensestableList').DataTable().destroy();

	    $('#showLensestableList thead #filterrow th').each(function() {
	        var title = $(this).text();
	        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
	    });

	    $("#showLensestableList thead input").on('keyup change', function() {
	        table.column($(this).parent().index() + ':visible')
	            .search(this.value)
	            .draw();
	    });

	    var table = $('#showLensestableList').DataTable({
	        dom: 'Bfrtip',
	        buttons: [{
	            text: 'Add New Lenses',
	            action: function(e, dt, node, config) {
	                addNewLenses();

	            }
	        }],
	        "bLengthChange": false,
	        "searching": true,
	        "orderCellsTop": true,
	        "sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "bScrollCollapse": true,
	        "ajax": {
	            "url": "listLenses",
	            //  "dataSrc": "" 
	        },
	        //'processing': true,
	        'dataType': "json",
	        'language': {
	            'loadingRecords': '&nbsp;',
	            processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
	        },
	        "columns": [{
	                className: "center",
	                defaultContent: '<center>' +
	                    '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
	                    '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;' +
	                    '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>' +
	                    '</center>'
	            },
	            {
	                "data": "brandName"
	            },
	            {
	                "data": "model"
	            },
	            {
	                "data": "specification1"
	            },
	            {
	                "data": "specification2"
	            },
	            {
	                "data": "specification3"
	            },
	            {
	                "data": "price"
	            },
	            {
	                "data": "cost"
	            }	           

	        ],

	        "initComplete": function(settings, json) {
	            spinnerOff();
	        }
	
	    });
	    $('#showLensestableList tbody').off('click');

	    $('#showLensestableList tbody').on('click', '.edit_me', function() {
	        var data = table.row($(this).parents('tr')).data();

	        //console.log(data);

	        $("#showLensesDiv").addClass("HideThisElement");
	        $("#saveLensesDiv").removeClass("HideThisElement");
	        $("#UpdateButtonLenses").removeClass("HideThisElement");
	        $("#SubmitButtonLenses").addClass("HideThisElement");
	        $("#rowNo").val(data.rowNo);
	        $("#brandName").val(data.brandName);
	        $("#model").val(data.model);
	        $("#specification1").val(data.specification1);
	        $("#specification2").val(data.specification2);
	        $("#specification3").val(data.specification3);
	        $("#action").val("updateLenses");
	        $("#headerName").html("Update Lenses");

	    });

	    $('#showLensestableList tbody').on('click', '.delete_me', function() {
	        var data = table.row($(this).parents('tr')).data();

	        var rowNo = data.rowNo;

	        console.log(data);

	        //deleteCustomer(rowNo);
	        SwalDelete("It will permanently deleted !", data.rowNo);
	    });
	}

	function SwalDelete(msg, rowno) {
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
	            deleteLenses(rowno);
	        }, function(dismiss) {
	            if (dismiss === 'cancel') {
	                swal(
	                    'Ok',
	                    'Cancelled !',
	                    'error'
	                )
	            }
	        });
	}

	function deleteLenses(rowNo) {
	    $.ajax({
	        type: "POST",
	        url: "deleteLenses?rowNo=" + rowNo,
	        data: {
	            rowNo: rowNo
	        }, // serializes the form's elements.
	        success: function(data) {
	            if (data == 1901) {
	                getLensesList();
	            }
	        },
	        error: function() {

	        }
	    });
	}

	    function addNewLenses(){
	    	var generator = new IDGenerator();
	  	  $("#LensesId").val("LS"+generator.generate());
	      $("#action").val("insertLenses");
	      $("#showLensesDiv").addClass("HideThisElement");
	      $("#saveLensesDiv").removeClass("HideThisElement");
	      $("#UpdateButtonLenses").addClass("HideThisElement");
	      $("#SubmitButtonLenses").removeClass("HideThisElement");
	      $("#headerName").html("New Lenses");
	    }
	    
