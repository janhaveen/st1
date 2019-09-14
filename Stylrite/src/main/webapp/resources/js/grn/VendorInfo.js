var grnId;

$(document).ready(function()
{
    $('#showVendortableList tbody').on( 'click', '.select_me', function () 
    {
		var data = $('#showVendortableList').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		
		$("#vendorName").val(data.vendorName);
		$('#vendorText').val(data.vendorName);
		
		$('#vendorNo').val(data.contactNo);
		$('#vendorNoText').val(data.contactNo);
		
		$('#vendorLocation').val(data.location);
		$('#vendorLocationText').val(data.location);
		
		$('#SelectVendorModal').modal('hide');
    });
    
});
