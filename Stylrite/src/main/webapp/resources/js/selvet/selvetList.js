
$(document).ready(function() {
    $("#HomeText").html("Selvet List");
    
    getSelvetList();
    DropDownForBrand();
    DropDownForType();
});
function getSelvetList() {
    spinnerOn();

    $('#showSelvettableList').DataTable().destroy();

    $('#showSelvettableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showSelvettableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showSelvettableList').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Selvet',
            action: function(e, dt, node, config) {
                addNewSelvet();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listSelvet",
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
    $('#showSelvettableList tbody').off('click');

    $('#showSelvettableList tbody').on('click', '.edit_me', function() {
        var data = table.row($(this).parents('tr')).data();

        //console.log(data);

        $("#showSelvetDiv").addClass("HideThisElement");
        $("#saveSelvetDiv").removeClass("HideThisElement");
        $("#UpdateButtonSelvet").removeClass("HideThisElement");
        $("#SubmitButtonSelvet").addClass("HideThisElement");

        $("#rowNo").val(data.rowNo);
        $("#brandName").val(data.brandName);
        $("#type").val(data.type);
    

        $("#action").val("updateSelvet");
        $("#headerName").html("Update Selvet");

    });

    $('#showSelvettableList tbody').on('click', '.delete_me', function() {
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
            deleteSelvet(rowno);
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

function deleteSelvet(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteSelvet?rowNo=" + rowNo,
        data: {
            rowNo: rowNo
        }, // serializes the form's elements.
        success: function(data) {
            if (data == 81) {
                getSelvetList();
            }
        },
        error: function() {

        }
    });
}

function addNewSelvet() {
	var generator = new IDGenerator();
	  $("#rowId").val("SV"+generator.generate());
    $("#showSelvetDiv").addClass("HideThisElement");
    $("#saveSelvetDiv").removeClass("HideThisElement");
    $("#UpdateButtonSelvet").addClass("HideThisElement");
    $("#SubmitButtonSelvet").removeClass("HideThisElement");
    $("#action").val("insertSelvet");
    $("#headerName").html("New Selvet");
}