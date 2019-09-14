showBagstableList
$(document).ready(function() 
{
    $("#HomeText").html("Bags List");
    getBagsList();
    DropDownForBrand();
    DropDownForType();
});
function getBagsList() {
    spinnerOn();

    $('#showBagstableList').DataTable().destroy();

    $('#showBagstableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showBagstableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showBagstableList').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Bags',
            action: function(e, dt, node, config) {
                addNewBags();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listBags",
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
            }, {
                "data": "brandName"
            }, {
                "data": "type"
            }

        ],

        "initComplete": function(settings, json) {
            spinnerOff();
        }

    });
    $('#showBagstableList tbody').off('click');

    $('#showBagstableList tbody').on('click', '.edit_me', function() {
        var data = table.row($(this).parents('tr')).data();

        //console.log(data);

        $("#showBagsDiv").addClass("HideThisElement");
        $("#saveBagsDiv").removeClass("HideThisElement");
        $("#UpdateButtonBags").removeClass("HideThisElement");
        $("#SubmitButtonBags").addClass("HideThisElement");

        $("#rowNo").val(data.rowNo);
        $("#brandName").val(data.brandName);
        $("#type").val(data.type);
    

        $("#action").val("updateBags");
        
        $("#headerName").html("Update Bgas");

    });

    $('#showBagstableList tbody').on('click', '.delete_me', function() {
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
            deleteBags(rowno);
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

function deleteBags(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteBags?rowNo=" + rowNo,
        data: {
            rowNo: rowNo
        }, // serializes the form's elements.
        success: function(data) {
            if (data == 91) {
                getBagsList();
            }
        },
        error: function() {

        }
    });
}

var bgId;

function addNewBags() {
	/* var generator = new IDGenerator();
 	  $("#rowId").val("BG"+generator.generate());*/
 	  
	var generator = new IDGenerator();
	
	bgId = ("BG"+generator.generate());
	
	$("#rowId").val(bgId);
	
	
	
    $("#showBagsDiv").addClass("HideThisElement");
    $("#saveBagsDiv").removeClass("HideThisElement");
    $("#UpdateButtonBags").addClass("HideThisElement");
    $("#SubmitButtonBags").removeClass("HideThisElement");
    $("#action").val("insertBags");
    $("#headerName").html("New Bgas");
}