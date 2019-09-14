$(document).ready(function() {
    //getCustomerList();

    $("#SubmitButtonNewOrder").click(function() {

        addCustomerNewOrder();
    });

    $('#showCustomertableList tbody').on('click', '.select_me', function() {
        table = $('#showCustomertableList').DataTable();
        var data = table.row($(this).parents('tr')).data();
        //console.log(data);
        var data = table.row($(this).parents('tr')).data();
        console.log("CUSTOMER rOWID", data.rowId);
        console.log("CUSTOMER DATA", data);
        $("#customerId").val(data.rowId);
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
        $("#insertPrescriptionDetails").removeClass("HideThisElement");
        getAllOrderList(data.rowId);
        getCustomerOrderData(data.rowId);
        getPresscriptiondata(data.rowId);

    });
    $("#SubmitButtonPrescription").click(function() {
        
            /*if(validate())
			    	{
			    		console.log("hello.........");
			        	saveCustomerData();
			    	}*/
        addNewPrescription();
    });

    $("#SubmitButtonNewPrescription").click(function() {
        $("#selectPrescriptionFormModal").modal('show');
    });

    $("#closeViewBtn").click(function() {

        $("#custTableDiv").removeClass("HideThisElement");
        $("#viewCustomerDiv").addClass("HideThisElement");
        $("#viewCustomerPageDiv").addClass("HideThisElement");
    });

});

function getAllOrderList(customerID) {
    console.log("hello", customerID);

    //spinnerOn();

    $('#showOrdertableList').DataTable().destroy();

    $('#showOrdertableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '"/>');
    });

    $("#showOrdertableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var table = $('#showOrdertableList').DataTable({
        // dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Order',
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
            "url": "getCustomerOrderListData?clientId=" + customerID,
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
            "data": "orderId"
        }, {
            "data": "date"
        }, {
            "data": "customerName"
        }, {
            "data": "mobileNo"
        }, {
            "data": "emailId"
        }, {
            "data": "remarks"
        }],
        "initComplete": function(settings, json) {
            //spinnerOff();
        }

    });
}

function getPresscriptiondata(customerID) {

    $.ajax({
        url: "getPrescriptionData?clientId=" + customerID,
        type: "GET",
        success: function(data2) {
            $("#PrescriptionIdCard").empty();
            console.log("prescription data is", data2);
            console.log("prescription data", data2.data.length);
            for (i = 0; i < data2.data.length; i++) {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = ' <div class="card  border-primary"> <div class="card-header">Prescription' + (i + 1) + ",&nbsp;" + data2.data[i].createdOn + '</div><div class="card-body"><dl class="row" id="prescriptionCard">' +
                    '<dt class="col-sm-6">Right Eye</dt><dt class="col-sm-6">Left Eye</dt><dt class="col-sm-2"></dt> <dt class="col-sm-1">Sph</dt><dt class="col-sm-1">Cyl</dt>' +
                    '<dt class="col-sm-1">Axis</dt><dt class="col-sm-2"></dt><dt class="col-sm-1">Sph</dt> <dt class="col-sm-1">Cyl</dt> <dt class="col-sm-1">Axis</dt>' +
                    '<dt class="col-sm-2"></dt><dt class="col-sm-2">DIST.</dt> <dd class="col-sm-1" id="sphRightEyeDISTText">' + data2.data[i].sphRightEyeDIST + '</dd>' +
                    '<dd class="col-sm-1" id="cylRightEyeDISTText">' + data2.data[i].cylRightEyeDIST + '</dd><dd class="col-sm-1" id="axisRightEyeDISTText">' + data2.data[i].axisRightEyeDIST + '</dd><dt class="col-sm-2"></dt>' +
                    '<dd class="col-sm-1" id="sphLeftEyeDISTText">' + data2.data[i].sphLeftEyeDIST + '</dd> <dd class="col-sm-1" id="cylLeftEyeDISTText">' + data2.data[i].cylLeftEyeDIST + '</dd><dd class="col-sm-1" id="axisLeftEyeDISTText">' + data2.data[i].axisLeftEyeDIST + '</dd>' +
                    '<dt class="col-sm-2"></dt> <dt class="col-sm-2">NEAR.</dt><dd class="col-sm-1" id="sphRightEyeNEARText">' + data2.data[i].sphRightEyeNEAR + '</dd><dd class="col-sm-1" id="cylRightEyeNEARText">' + data2.data[i].cylRightEyeNEAR + '</dd>' +
                    ' <dd class="col-sm-1" id="axisRightEyeNEARText">' + data2.data[i].axisRightEyeNEAR + '</dd> <dt class="col-sm-2"></dt> <dd class="col-sm-1" id="sphLeftEyeNEARText">' + data2.data[i].sphLeftEyeNEAR + '</dd>' +
                    '<dd class="col-sm-1" id="cylLeftEyeNEARText">' + data2.data[i].cylLeftEyeNEAR + '</dd><dd class="col-sm-1" id="axisLeftEyeNEARText">' + data2.data[i].axisLeftEyeNEAR + '</dd><dt class="col-sm-2"></dt> </dd><dt class="col-sm-2"> Machine Test</dt>' +
                    '<dd class="col-sm-2" id="machineText">' + data2.data[i].machineTest + '<dt class="col-sm-2"> Operator</dt></dd><dd class="col-sm-2" id="operatorText">' + data2.data[i].operator + '</dd><dt class="col-sm-4"></dt>' +
                    '<dt class="col-sm-2">Reference </dt><dd class="col-sm-2" id="referenceText">' + data2.data[i].reference + '</dd><dt class="col-sm-2">Other </dt><dd class="col-sm-2" id="otherInfoText">' + data2.data[i].otherInfo + '</dd><dt class="col-sm-2"></dt>' +
                    '</dl></div></div><br>';

                var element = document.getElementById("PrescriptionIdCard");
                element.appendChild(newdiv);
            }
            if (data2.data.length == 0) {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = '<center><p tyle="color:blue"><b>No Prescription Card Found !</b></p></center>';
                var element = document.getElementById("PrescriptionIdCard");
                element.appendChild(newdiv);
            }
        }
    });

}

function addNewPrescription() {
    var clientid = $("#customerId").val();
    console.log("client id", $("#customerId").val())
    var generator = new IDGenerator();
    $("#PrescriptionId").val("PID" + generator.generate());

    spinnerOn();

    $.ajax({
        type: "POST",
        url: "PrescriptionDetailsRegister",
        data: $("#insertPrescriptionForm").serialize() + '&clientId=' + $("#customerId").val(), // serializes the form's elements.
        success: function(data) {
            if (data == 170001) {
                spinnerOff();

                document.getElementById('insertPrescriptionForm').reset();
                SwalSuccess("New Prescription Details Added");
                getPresscriptiondata(clientid);

                /*$("#custFormDiv").addClass("HideThisElement");
		            $("#custTableDiv").removeClass("HideThisElement");*/
            } else if (data == 170002) {
                spinnerOff();
                //$("#contactNo").val("");
                SwalWarning("No Prescription Added!");
            }

            console.log(data);
        }
    });

}

function getCustomerOrderData(customerId) {
    $.ajax({
        url: "getCustomerOrderData?clientId=" +customerId,
        type: "GET",
        success: function(data2) {
            $("#OrderId").empty();
            console.log("Order data is", data2);
            console.log("Order data", data2.data.length);
            for (i = 0; i < data2.data.length; i++) {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = '<div class="card border-info"> <div class="card-header">Order No:' + (i + 1) + ",&nbsp;" + data2.data[i].createdOn + '<div class=" right"><u><a id="viewOrderClick" onclick=viewOrder("' + data2.data[i].orderId + '") href="#">View Order</a></u></div><div class="card-body"><dl class="row" id="orderCard">' +
                    '<dt class="col-sm-2">Order Id</dt><dd class="col-sm-2" id="OrderIDText">' + data2.data[i].orderId + '</dd><dt class="col-sm-2">Order Date-</dt>' +
                    ' <dd class="col-sm-2" id="OrderDateText">' + data2.data[i].date + '<dt class="col-sm-2">Status-</dt><dd class="col-sm-2" id="StatusText">' + data2.data[i].orderStatus + '</dd>' +
                    '<dt class="col-sm-2">Quantity-</dt> <dd class="col-sm-2" id="QuantityText">' + data2.data[i].qty + '</dd> <dt class="col-sm-2">Amount Payable-</dt>' +
                    ' <dd class="col-sm-2" id="AmountText">15000</dd><dt class="col-sm-2">Advance Rs-</dt><dd class="col-sm-2" id="AdvanceText">5000</dd>' +
                    ' <dt class="col-sm-2">balance Rs-</dt> <dd class="col-sm-2" id="BalanceText">10000</dd><dt class="col-sm-2">Expected Delivery Date-</dt>' +
                    ' <dd class="col-sm-2" id="ExpectedDeliveryDateText">' + data2.data[i].dueDate + '</dd></dl></div></div></div><br>'
                var element = document.getElementById("OrderId");
                element.appendChild(newdiv);
            }
            if (data2.data.length == 0) {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = '<center><p><b>No Order Card Found !</b></p></center>';
                var element = document.getElementById("OrderId");
                element.appendChild(newdiv);
            }
        }
    });

}

function viewOrder(orderId) {
    // var orderId= $("#OrderIDText").text();
    
    $.ajax({
        url: "CustomerOrderCardViewData?orderId=" +orderId,
        type: "GET",
        success: function(data) {

           
            console.log(data.data[0].orderId);
            console.log("ordercardview", data);
            $("#viewCustomerDiv").addClass("HideThisElement");
            $("#viewCustomerPageDiv").addClass("HideThisElement");
            $("#headerDiv").addClass("HideThisElement");
            $("#footerDiv").addClass("HideThisElement");
            $("#orderListDiv").addClass("HideThisElement");
            $("#customerOrderForm").removeClass("HideThisElement");
            $("#viewOrderDiv").removeClass("HideThisElement");
            $("#viewOrderDiv #OrderIDText").text(data.data[0].orderId);
            $("#viewOrderDiv #OrderDateText").text(data.data[0].date);
            $("#DueDateText").text(data.data[0].dueDate);
            $("#CustomernameText").text(data.data[0].customerName);
            $("#viewOrderDiv #ContactNumberText").text(data.data[0].mobileNo);
            $("#AddressText").text(data.data[0].address);
            $("#OldLensText").text(data.data[0].oldLens);
            $("#BookedByText").text(data.data[0].bookedBy);
            $("#DeliveredByText").text(data.data[0].deliveredBy);
            $("#OldLensReturnedText").text(data.data[0].oldLensReturn);
            $("#RxByText").text(data.data[0].rxBy);
            $("#PrescriptionReturnedText").text(data.data[0].prescriptionReturned);
            $("#RemarksText").text(data.data[0].remarks);
            /*$("#RemarksText").text(data2.data.remarks);
            $("#RemarksText").text(data2.data.remarks);*/
            $("#viewOrderDiv #StatusText").text(data.data[0].orderStatus);
            

              /*    $("#RemarksText").text(data2.data.remarks);
		   	     AmountPayableText

		   	  AdvanceRsText
		   	BalanceRsText

		   	RemarksText*/
            viewOrderProductListData(orderId);
        }
    });
}
     function viewOrderProductListData(orderId){

         $.ajax({
             url: "viewOrderProductList?orderId=" + orderId,
             type: "GET",
             success: function(data2) {
                 //$("#ProductData1").removeClass("HideThisElement");

                 var html = "";

                 if (data2.data.length > 0) {
                     for (var i = 0; i < data2.data.length; i++) {
                         //console.log("hello data 1",data2.data[i]);

                         html += '<tr id="productIdRow">' +
                             '<td>' + (i + 1) + '</td>' +
                             '<td>' + data2.data[i].barcode + '</td>' +
                             '<td>' + data2.data[i].brand + '</td>' +
                             '<td >' + data2.data[i].color + '</td>' +
                             '<td>' + data2.data[i].modelNo + '</td>' +
                             '<td>' + data2.data[i].size + '</td>' +
                             '<td>' + data2.data[i].price + '</td>' +
                             '<td>' + data2.data[i].qty + '</td>' +
                             '<td>' + data2.data[i].status + '</td>' +
                             '</tr>';
                     }
                 } else {

                 }

                 document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', html);
             }
         });
     
     }

     
function addCustomerNewOrder() {
    /*$.ajax
        ({
              type: "GET",
              url: "showOrderForm",
              data:$(this).serialize()+'&clientId='+$("#customerId").val(), // serializes the form's elements.
              success: function(data)*/

    /* console.log(";;;;;;",data)*/
    /* $("#suresh").addClass("HideThisElement");*/

    $("#viewCustomerDiv").addClass("HideThisElement");
    $("#viewAllCustomerDiv").addClass("HideThisElement");
    $("#customerOrderForm").removeClass("HideThisElement");
    $("#headerDiv").addClass("HideThisElement");
    $("#footerDiv").addClass("HideThisElement");
    var generator = new IDGenerator();
    $("#orderId").val("OId" + generator.generate());
    $("#orderListDiv").addClass("HideThisElement");
    $("#saveOrderDiv").removeClass("HideThisElement");
    $("#mobileNo").val($('#ContactNumberText').text());
    $("#customerOrderForm #customerName").val($('#CustomerNameText').text());
    $("#emailId").val($('#EmailText').text());

    /*    }
	   });*/

}