function getPrescriptionList(CustomerId){
    $('#showPrescriptiontableList').DataTable().destroy();

    $('#showPrescriptiontableList thead #filterrow th').each(function() {
        var title = $(this).val();
        $(this).html('<input type="val" style="font-size: 80%;padding:1%;val-align:center" placeholder="' + title + '" />');
    });

    $("#showPrescriptiontableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showPrescriptiontableList').DataTable({
        //dom: 'Bfrtip',
        buttons: [{
            val: 'Add New Prescription',
            action: function(e, dt, node, config) {
                addNewOrder();

            }
        }],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "listPrescription?customerId="+CustomerId,
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
                '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> &nbsp;&nbsp; '+
                '</center>'
        }, {
            "data": "machineTest"
        }, {
            "data": "operator"
        }, {
            "data": "reference"
        }, {
            "data": "otherInfo"
        }, {
            "data": "sphRightEyeDIST"
        },{
            "data": "cylRightEyeDIST"
        }, {
            "data": "axisRightEyeDIST"
        }, {
            "data": "sphLeftEyeDIST"
        }, {
            "data": "cylLeftEyeDIST"
        }, {
            "data": "axisLeftEyeDIST"
        },
        {
            "data": "sphRightEyeNEAR"
        }, {
            "data": "cylRightEyeNEAR"
        }, {
            "data": "axisRightEyeNEAR"
        }, {
            "data": "sphLeftEyeNEAR"
        }, {
            "data": "cylLeftEyeNEAR"
        },
        {
            "data": "axisLeftEyeNEAR"
        },
        {
            "data": "createdOn"
        }],

        "initComplete": function(settings, json) {
            //spinnerOff();
        }

    })
    $('#showPrescriptiontableList tbody').off('click');
    
    $('#showPrescriptiontableList tbody').on('click', '.select_me', function() {
        var data = table.row($(this).parents('tr')).data();

        console.log(data);
        $('#selectPrescriptionModal').modal('hide');
        $("#machineTest").val(data.machineTest);
        console.log("hellleee",data.machineTest);
        $("#operator").val(data.operator);
        $("#reference").val(data.reference);
        $("#otherInfo").val(data.otherInfo);
        $("#sphRightEyeDIST").val(data.sphRightEyeDIST);
        $("#cylRightEyeDIST").val(data.cylRightEyeDIST);
        $("#axisRightEyeDIST").val(data.axisRightEyeDIST);
        $("#sphLeftEyeDIST").val(data.sphLeftEyeDIST);
        $("#cylLeftEyeDIST").val(data.cylLeftEyeDIST);
        $("#axisLeftEyeDIST").val(data.axisLeftEyeDIST);
        $("#sphRightEyeNEAR").val(data.sphRightEyeNEAR);
        $("#cylRightEyeNEAR").val(data.cylRightEyeNEAR);
        $("#axisRightEyeNEAR").val(data.axisRightEyeNEAR);
        $("#sphLeftEyeNEAR").val(data.sphLeftEyeNEAR);
        $("#cylLeftEyeNEAR").val(data.cylLeftEyeNEAR);
        $("#axisLeftEyeNEAR").val(data.axisLeftEyeNEAR);

    });
}