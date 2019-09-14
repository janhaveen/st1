$(document).ready(function() 
{
    $("#HomeText").html("Tray List");
    getTrayList();
    
    DropDownForBrand();
    DropDownForType();
});

/**/

function DropDownForBrand() {
    var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', 'listBrand');
    ourRequest1.onload = function() {
        if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
            data1 = JSON.parse(ourRequest1.responseText);
            //alert(data1);
            console.log("data is" + data1);
            createHTML1(data1);
        } else {
            console.log("We connected to the server, but it returned an error.");
        }
    };
    ourRequest1.onerror = function() {
        console.log("Connection error");
    };
    ourRequest1.send();

    function createHTML1(Data) {
        var options1;
        $('#brandName').empty();
        options1 = '<option value="" selected>Select Brand</option>'
        for (i = 0; i < Data.data.length; i++) {
            options1 += "<option value='" + Data.data[i].brandName + "'>" + Data.data[i].brandName + "</option>";
        }
        $('#brandName').html(options1);
    }

    /*getEmployeeList();
     * $("#designation").material_select("refresh");
    $("#reportTo").material_select("refresh");

     	DropDownForLegend();*/

}

function DropDownForType() {
    var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', 'listType');
    ourRequest2.onload = function() {
        if (ourRequest2.status >= 200 && ourRequest2.status < 400) {
            data2 = JSON.parse(ourRequest2.responseText);
            getype(data2);

            console.log("Connection....." + data2);

        } else {
            console.log("We connected to the server, but it returned an error.");
        }
    };
    ourRequest2.onerror = function() {
        console.log("Connection error");
    };
    ourRequest2.send();

    function getype(Data) {
        var options1;
        $('#type').empty();
        options1 = '<option value="">Select Type</option>'
        for (i = 0; i < Data.data.length; i++) 
        {
            if (Data.data[i].subCategory == "Product Type") 
            {
                options1 += "<option value='" + Data.data[i].description + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#type').html(options1);
        // $('#department').material_select('refresh');  
    }
}
function getTrayList() {
   // spinnerOn();

    $('#showTraytableList').DataTable().destroy();

    $('#showTraytableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showTraytableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showTraytableList').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Tray',
            action: function(e, dt, node, config) {
                addNewTray();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listTray",
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
                   /* '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; ' +*/
                    '<i class="edit_me fa fa-eye fa-2x" aria-hidden="true"></i> &nbsp;&nbsp;' +
                    '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>' +
                    '</center>'
            }, {
                "data": "brandName"
            }, {
                "data": "type"
            }, {
                "data": "capacity"
            }

        ],

        "initComplete": function(settings, json) {
           // spinnerOff();
        }

    });
    $('#showTraytableList tbody').off('click');

    $('#showTraytableList tbody').on('click', '.edit_me', function() {
        var data = table.row($(this).parents('tr')).data();

        //console.log(data);

        $("#showTrayDiv").addClass("HideThisElement");
        $("#saveTrayDiv").removeClass("HideThisElement");
        $("#UpdateButtonTray").removeClass("HideThisElement");
        $("#SubmitButtonTray").addClass("HideThisElement");
        $("#rowNo").val(data.rowNo);
        $("#brandName").val(data.brandName);
        $("#type").val(data.type);
        $("#capacity").val(data.capacity).trigger('change');

        $("#action").val("updateTray");

    });

    $('#showTraytableList tbody').on('click', '.delete_me', function() {
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
            deleteTray(rowno);
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

function deleteTray(rowNo) {
    $.ajax({
        type: "POST",
        url: "deleteTray?rowNo=" + rowNo,
        data: {
            rowNo: rowNo
        }, // serializes the form's elements.
        success: function(data) {
            if (data == 61) {
                getTrayList();
            }
        },
        error: function() {

        }
    });
}

function addNewTray() {
	  $("#rowNo").val("");
	 var generator = new IDGenerator();
	  $("#rowId").val("TR"+generator.generate());
    $("#showTrayDiv").addClass("HideThisElement");
    $("#saveTrayDiv").removeClass("HideThisElement");
    $("#UpdateButtonTray").addClass("HideThisElement");
    $("#SubmitButtonTray").removeClass("HideThisElement");
    $("#action").val("insertTray");
    $("#HomeText").html("Add Tray");
    var generator = new IDGenerator();
	$("#rowId").val("TRY"+generator.generate());
    
    //DropDownForBrand();
  //  DropDownForType();
}