$(document).ready(function() {
    $("#HomeText").html("Customer");

    getCustomerList();
});

//load customer list
function getCustomerList() {
    //	spinnerOn();

    $('#showCustomertableList').DataTable().destroy();

    $('#showCustomertableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showCustomertableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showCustomertableList').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Customer',
            action: function(e, dt, node, config) {
                addNewCustomer();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listCustomer",
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
            "data": "customerName"
        }, {
            "data": "contactNo"
        }, {
            "data": "email"
        }, {
            "data": "location"
        }, {
            "data": "companyName"
        }],

        "initComplete": function(settings, json) {
            spinnerOff();
        }

    });

    $('#showCustomertableList tbody').off('click');

    $('#showCustomertableList tbody').on('click', '.edit_me', function() {
        var data = table.row($(this).parents('tr')).data();

        //console.log(data);

        $("#custTableDiv").addClass("HideThisElement");
        $("#viewCustomerDiv").removeClass("HideThisElement");
        $("#UpdateButtonCustomer").removeClass("HideThisElement");
        $("#SubmitButtonCustomer").addClass("HideThisElement");

        $("#rowNo").val(data.rowNo);
        $("#customerName").val(data.customerName).trigger('change');
        $("#contactNo").val(data.contactNo).trigger('change');
        $("#alternateContactNo").val(data.alternateContactNo).trigger('change');
        $("#email").val(data.email).trigger('change');
        $("#location").val(data.location).trigger('change');
        $("#companyName").val(data.companyName).trigger('change');
        $("#source").val(data.source).trigger('change');
        $("#gstNo").val(data.gstNo).trigger('change');
        $("#state").val(data.state).trigger('change');

        $("#action").val("updateCustomer");

        $("#headerName").html("Update Customer");

    });

    $('#showCustomertableList tbody').on('click', '.delete_me', function() {
        //SwalWarning("Are You Sure Delete!"); 

        var data = table.row($(this).parents('tr')).data();

        var rowNo = data.rowNo;

        console.log(data);

        //deleteCustomer(rowNo);
        SwalDelete("It will permanently deleted !", data.rowNo);
    });
    /*$('#showCustomertableList tbody').on('click', '.select_me', function() {
        var data = table.row($(this).parents('tr')).data();
        //console.log(data);
        var data = table.row($(this).parents('tr')).data();
        console.log("CUSTOMER rOWID", data.rowId);
        console.log("CUSTOMER DATA", data);
        $("#custTableDiv").addClass("HideThisElement");
        $("#viewCustomerDiv").removeClass("HideThisElement");
        $("#viewCustomerPageDiv").removeClass("HideThisElement");
        $("#CustomerNameText").text(data.customerName);
        $("#ContactNumberText").text(data.contactNo);
        $("#AlternateContactNumberText").text(data.alternateContactNo);
        $("#EmailText").text(data.email);
        $("#LocationText").text(data.location);
        $("#CompanyNameText").text(data.companyName);
        $("#GstNoText").text(data.gstNo);
        $("#StateText").text(data.state);
        $("#SourceText").text(data.source);
        getPresscriptiondata(data.rowId);

    });*/
}

function addNewCustomer() {
	 var generator = new IDGenerator();
 	 $("#CustomerId").val("CID"+generator.generate());
    $("#custTableDiv").addClass("HideThisElement");
    $("#custFormDiv").removeClass("HideThisElement");
    $("#UpdateButtonCustomer").addClass("HideThisElement");
    $("#SubmitButtonCustomer").removeClass("HideThisElement");
    $("#action").val("insertCustomer");
    $("#headerName").html("New Customer");
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
            deleteCustomer(rowno);
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

function deleteCustomer(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteCustomer?rowNo=" + rowNo,
        data: $(this).serialize(), // serializes the form's elements.
        success: function(data) {
            if (data == 201) {
                getCustomerList();
            }
        },
        error: function() {

        }

    });
}

