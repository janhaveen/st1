$(document).ready(function() {
	$("#SubmitButtonCustomer").click(function() {
		if (validate()) {
			console.log("hello.........");
			saveCustomerData();
		}
	});

	$("#UpdateButtonCustomer").click(function() {
		if (validate()) {
			console.log("hii.........");
			updateCustomerData();
		}
	});

	$("#closeBtn").click(function() {
		document.getElementById('insertCustomerData').reset();
		$("#custFormDiv").addClass("HideThisElement");
		$("#custTableDiv").removeClass("HideThisElement");
	});

	// var contactNo = null;

	/*
	 * $("#contactNo").keyup(function() { contactNo_check(); });
	 * 
	 * $("#gstNo").keyup(function() { gstNo_check(); });
	 */
});

function saveCustomerData() {
	spinnerOn();

	$.ajax({
		type : "POST",
		url : "customerRegister",
		data : $("#insertCustomerData").serialize(), // serializes the form's
														// elements.
		success : function(data) {
			if (data == 501) {
				spinnerOff();

				document.getElementById('insertCustomerData').reset();

				SwalSuccess("Customer Registration Successfully");

				getCustomerList();

				$("#custFormDiv").addClass("HideThisElement");
				$("#custTableDiv").removeClass("HideThisElement");
			} else if (data == 504) {
				spinnerOff();
				// $("#contactNo").val("");
				SwalWarning("Contact No is Already Present!");
			} else if (data == 503) {
				spinnerOff();
				// $("#gstNo").val("");
				SwalWarning("GST No is Already Present!");
			}

			console.log(data);
		}
	});
}

function updateCustomerData() {
	spinnerOn();

	$.ajax({
		type : "POST",
		url : "updateCustomer",
		data : $("#insertCustomerData").serialize(), // serializes the form's
														// elements.
		success : function(data) {

			if (data == 601 || data == 604 || data == 606 || data == 608) {
				spinnerOff();

				SwalSuccess("Customer Update Successfully");

				document.getElementById('insertCustomerData').reset();

				// $('#showCustomertableList').ajax.reload();

				getCustomerList();

				$("#custFormDiv").addClass("HideThisElement");
				$("#custTableDiv").removeClass("HideThisElement");
			} else if (data == 605) {
				spinnerOff();
				// $("#contactNo").val("");
				SwalWarning("Contact No is Already Present!");
			} else if (data == 603 || data == 607) {
				spinnerOff();
				SwalWarning("GST No is Already Present!");
			}
			console.log(data);
		}
	});
}

function validate() {
	if ($("#customerName").val() == "")
		SwalWarning("Enter Customer Name!");
	else if ($("#contactNo").val() == "")
		SwalWarning("Enter Contact No!");
	else if ($("#location").val() == "")
		SwalWarning("Enter the Location!");
	else if ($("#gstNo").val() == "")
		SwalWarning("Select GST No!");

	else
		return true;
}