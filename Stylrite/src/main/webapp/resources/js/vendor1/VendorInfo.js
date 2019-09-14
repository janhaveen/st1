$(document).ready(function(){
    $('#datatables tbody').on( 'click', '.select_me_client', function () {
		var data = $('#datatables').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		$("#VendorId").val(data.rowId);
		$('#VendorText').val(data.companyName);
		
		$('#VendorAddrId').val(data.addressId);
		$('#VendorAddrText').text(data.branchName+", "+data.locationadd+", "+data.state_text+", "+data.pincode);
		getAddress();
		
		/*$('#VendorAddrId').val(data.addressId);
		$('#clientDeliveryAddress').val(data.branchName+", "+data.locationadd+", "+data.state_text+", "+data.pincode);
		*/
		$('#VendorCPId').val(data.CPId);
		$('#VendorCPText').val(data.contactPerson);
		getCotactPerson();
		
		$('#SelectVendorModal').modal('hide');
    });
	
    /*$('#addressModal').on('shown.bs.modal', function (e) {
    	$('#addressTable').DataTable().destroy();
    	addressList();
	})
	
    $('#contactPersonModal').on('shown.bs.modal', function (e) {
    	$('#contactPTable').DataTable().destroy();
    	contactPList();
	})*/
});

function showAddressModal(type)
{
	$("#addressType").val(type);
	$('#SelectClientAddressModal').modal('show');
}