
$(document).ready(function() {
  
	 
    $("#HomeText").html("Grn List");
    
    getGrnProductList();
    
    $("#backButton").click(function()
		    {
    	 
		 $("#productDiv").addClass("HideThisElement");
		 $("#viewProductGrn").addClass("HideThisElement");
		 
		 $("#showGrnProductDiv").removeClass("HideThisElement");
    
		    });
});
function getGrnProductList(){
    spinnerOn();

    $('#showGrnProducttableList').DataTable().destroy();

    $('#showGrnProducttableList thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

   /* $("#showGrnProducttableList thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
*/
    var table = $('#showGrnProducttableList').DataTable({
        // dom: 'Bfrtip',
        buttons: [{
            text: 'Add New Grn Product',
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
            "url": "listGrnList",
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
                    
                    '</center>'
            }, {
                "data": "grnNo"
            },
            {
                "data": "vendorName"
            },
            {
                "data": "vendorNo"
            },
            {
                "data": "createdOn"
            },
            {
                "data": "purchaseDate"
            },
            {
                "data": "receiptDate"
            },
            {
                "data": "receivedBy"
            }

        ],

        "initComplete": function(settings, json) {
            spinnerOff();
        }

    });

    $('#showGrnProducttableList tbody').on('click', '.select_me', function() {
        var data = table.row($(this).parents('tr')).data();
          console.log(data.vendorNo);
        $("#showGrnProductDiv").addClass("HideThisElement");
        $("#viewProductGrn").removeClass("HideThisElement");
        $("#GRNNumberTextView").text(data.grnNo);
        $("#VendorTextView").text(data.vendorName);
        $("#contactNoTextView").text(data.vendorNo);
        $("#PurchaseDateTextView").text(data.purchaseDate);
        $("#ReceiptDateTextView").text(data.receiptDate);
        $("#ReceivedByTextView").text(data.receivedBy);
        $("#headerName").html("View Grn");
        viewProductGrnList(data.rowId);

    });
    function viewProductGrnList(grnId){   
		            $.ajax({
						url:"viewGrnProductList?grnId="+grnId,
						type:"GET",
						success:function(data2){
							$("#productDiv").removeClass("HideThisElement");
							var html="";
							if(data2.data.length>0){
								for (var i = 0; i < data2.data.length; i++) {
									html+='<tr id="productIdRow">'+
										  '<td>'+(i+1)+'</td>'+
										  '<td>'+data2.data[i].brandName+'</td>'+
										  '<td>'+data2.data[i].type+'</td>'+
										  '<td >'+data2.data[i].quantity+'</td>'+
										  '<td>'+data2.data[i].capacity+'</td>'+
										  '<td>'+data2.data[i].typeOfProduct+'</td>'+
										  '</tr>';
								}
							}else{
								for (var i = 0; i < data1.data.length; i++) {
									html+='<tr id="productIdRow">'+
									 '<td>'+(i+1)+'</td>'+
									  '<td>'+data2.data[i].brandName+'</td>'+
									  '<td>'+data2.data[i].type+'</td>'+
									  '<td >'+data2.data[i].quantity+'</td>'+
									  '<td>'+data2.data[i].capacity+'</td>'+
									  '<td>'+data2.data[i].typeOfProduct+'</td>'+
										  '</tr>';
								}
							}
							document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', html);
						}
					});		        }
		    
		




}