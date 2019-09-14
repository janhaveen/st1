$("#document").ready(function(){
	$("#HomeText").html("Hsn List");
	getHsnList();
	
	
});
function getHsnList(){
	  $('#showHsntableList').DataTable().destroy();

	    $('#showHsntableList thead #filterrow th').each(function() {
	        var title = $(this).text();
	        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
	    });

	    $("#showHsntableList thead input").on('keyup change', function() {
	        table.column($(this).parent().index() + ':visible')
	            .search(this.value)
	            .draw();
	    });

	    var table = $('#showHsntableList').DataTable({
	        dom: 'Bfrtip',
	        buttons: [{
	            text: 'Add New Hsn',
	            action: function(e, dt, node, config) {
	                addNewHsn();

	            }
	        }],
	        "bLengthChange": false,
	        "searching": true,
	        "orderCellsTop": true,
	        "sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "bScrollCollapse": true,
	        "ajax": {
	            "url": "listHsn",
	            //  "dataSrc": "" 
	        },
	        //'processing': true,
	        'dataType': "json",
	        'language': {
	            'loadingRecords': '&nbsp;',
	            processing:'<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
	        },
	        "columns": [{
	                className: "center",
	                defaultContent: '<center>'+
	                    '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +
	                    '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;' +
	                    '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>' +
	                    '</center>'
	            }, {
	                "data": "cgst"
	            }, {
	                "data": "sgst"
	            },{
	                "data": "igst"
	            },{
	                "data": "ugst"
	            }
	        ],

	        "initComplete": function(settings, json) {
	            spinnerOff();
	        }
	
	    });
	    $('#showHsntableList tbody').off('click');
		 
		 $('#showHsntableList tbody').on( 'click', '.edit_me', function () 
		 {
			 var data = table.row( $(this).parents('tr') ).data();
			 
			 //console.log(data);
			 
			 $("#showHsnDiv").addClass("HideThisElement");
			 $("#saveHsnDiv").removeClass("HideThisElement");
			 $("#UpdateButtonHsn").removeClass("HideThisElement");
			 $("#SubmitButtonHsn").addClass("HideThisElement");
			 
			 $("#rowNo").val(data.rowNo);
			 $("#cgst").val(data.cgst).trigger('change');
			 $("#sgst").val(data.sgst).trigger('change');
			 $("#igst").val(data.igst).trigger('change');
			 $("#ugst").val(data.ugst).trigger('change');
			 $("#action").val("updateHsn");
			 
		 });
		 
		 $('#showHsntableList tbody').on( 'click', '.delete_me', function () 
		 {
			 var data = table.row( $(this).parents('tr') ).data();
			 
			 var rowNo = data.rowNo;
			 
			 console.log(data);
			 
			 //deleteCustomer(rowNo);
			 SwalDelete("It will permanently deleted !",  data.rowNo);
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
            deleteHsn(rowno);
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

function deleteHsn(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteHsn?rowNo=" +rowNo,
        data: {
            rowNo: rowNo
        }, // serializes the form's elements.
        success: function(data) {
            if (data == 1911) {
                getHsnList();
            }
        },
        error: function() {

        }
    });
}
function addNewHsn(){
	var generator = new IDGenerator();
	  $("#hsnId").val("HID"+generator.generate());
      $("#action").val("insertHsn");
      $("#showHsnDiv").addClass("HideThisElement");
      $("#saveHsnDiv").removeClass("HideThisElement");
      $("#UpdateButtonHsn").addClass("HideThisElement");
      $("#SubmitButtonHsn").removeClass("HideThisElement");
      $("#headerName").html("New Hsn");
}
