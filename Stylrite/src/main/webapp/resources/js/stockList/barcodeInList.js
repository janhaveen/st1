$(document).ready(function()
{
	
  $("#HomeText").html("Barcode In List");
      getInBarcodeList();
});
function getInBarcodeList(){
	
	
	  //  spinnerOn();
    $('#showBarcodetableList').DataTable().destroy();

    $('#showBarcodetableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#showBarcodetableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showBarcodetableList').DataTable({
       // dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Lenses',
            action: function(e, dt, node, config) {
                addNewBarcode();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listInBarcode",
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
                "data": "barcode"
            }, {
                "data": "status_txt"
            },{
                "data": "stockIndate"
            },{
                "data": "stockOutDate"
            },{
                "data": "productInfo"
            }	           

        ],

        "initComplete": function(settings, json) {
            spinnerOff();
        }

    });
  
}