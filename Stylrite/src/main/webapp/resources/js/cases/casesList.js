
$(document).ready(function() {
    $("#HomeText").html("Cases List");
   
    getCasesList();
    DropDownForBrand();
    DropDownForType();
});
function getCasesList() {
    spinnerOn();

    $('#showCasestableList').DataTable().destroy();

    $('#showCasestableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showCasestableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showCasestableList').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Cases',
            action: function(e, dt, node, config) {
            	addNewCases();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listCases",
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
            }, {
                "data": "quantity"
            }

        ],

        "initComplete": function(settings, json) {
            spinnerOff();
        }

    });
    $('#showCasestableList tbody').off('click');

    $('#showCasestableList tbody').on('click', '.edit_me', function() {
        var data = table.row($(this).parents('tr')).data();

        //console.log(data);

        $("#showCasesDiv").addClass("HideThisElement");
        $("#saveCasesDiv").removeClass("HideThisElement");
        $("#UpdateButtonCases").removeClass("HideThisElement");
        $("#SubmitButtonCases").addClass("HideThisElement");

        $("#rowNo").val(data.rowNo);
        $("#brandName").val(data.brandName);
        $("#type").val(data.type);
        $("#quantity").val(data.quantity).trigger('change');

        $("#action").val("updateCases");
        $("#headerName").html("Update Cases");

    });

    $('#showCasestableList tbody').on('click', '.delete_me', function() {
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
            deleteCases(rowno);
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

function deleteCases(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteCases?rowNo=" + rowNo,
        data: {
            rowNo: rowNo
        }, // serializes the form's elements.
        success: function(data) {
            if (data == 71) {
                getCasesList();
            }
        },
        error: function() {

        }
    });

}
function addNewCases() {
	 var generator = new IDGenerator();
 	 $("#rowId").val("CS"+generator.generate());
    $("#showCasesDiv").addClass("HideThisElement");
    $("#saveCasesDiv").removeClass("HideThisElement");
    $("#UpdateButtonCases").addClass("HideThisElement");
    $("#SubmitButtonCases").removeClass("HideThisElement");
    $("#action").val("insertCases");
    $("#headerName").html("New Cases");
}