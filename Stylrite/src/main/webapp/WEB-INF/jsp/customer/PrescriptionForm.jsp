<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <style type="text/css">
                .searchIcon {
                    float: left;
                    margin-left: 10px;
                    margin-top: -23px;
                    position: relative;
                    /*         z-index: 2;
		 */
                }
            </style>
        </head>

        <body>
            <form name="insertPrescriptionForm" id="insertPrescriptionForm">
                <input type="hidden" id="PrescriptionId">
                <input type="hidden" id="customerId">
                 <div class="checkbox form-row HideThisElement" id="prescriptionCheckboxDiv">
                  <label><input type="checkbox" id="prescriptionChecked" value=""><b>Show Previous Prescription</b></label>
                   </div>
                   
                   
                <div class="form-row">

                    <div class="form-group col-md-5">
                        <label id="machineTestlbl" for="machineTest" class="">Machine Test <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control capitalizeText" id="machineTest" name="machineTest" placeholder="machineTest">
                    </div>

                    <div class="form-group col-md-5">
                        <label id="operatorlbl" for="operator" class="">Operator <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control capitalizeText" id="operator" name="operator" placeholder="operator">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label id="referencelbl" for="reference" class="">Reference <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control capitalizeText" id="reference" name="reference" placeholder="reference">
                    </div>
                    <div class="form-group col-md-5">
                        <label id="otherInfolbl" for="reference" class="">Other Info <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control capitalizeText" id="otherInfo" name="otherInfo" placeholder="otherInfo">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-2">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="text-dark"> Rigth Eye</label>
                    </div>
                    <div class="form-group col-md-4">
                        <label class="text-dark"> Left Eye</label>
                    </div>
                    <div class="form-groupcol-md-2">
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-md-2">
                    </div>

                    <div class="form-group col-md-1">
                        <label class="text-dark">Sph</label>
                    </div>
                    <div class="form-group col-md-1">
                        <label class="text-dark">Cyl</label>
                    </div>
                    <div class="form-group col-md-1">
                        <label class="text-dark">Axis</label>
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-1">
                        <label class="text-dark">Sph</label>
                    </div>
                    <div class="form-group col-md-1">
                        <label class="text-dark">Cyl</label>
                    </div>
                    <div class="form-group col-md-1">
                        <label class="text-dark">Axis</label>
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-2">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-2">
                        <label class="text-dark">DIST.</label>
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="sphRightEyeDIST" name="sphRightEyeDIST">
                        <br>
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="cylRightEyeDIST" name="cylRightEyeDIST">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="axisRightEyeDIST" name="axisRightEyeDIST">
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="sphLeftEyeDIST" name="sphLeftEyeDIST">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="cylLeftEyeDIST" name="cylLeftEyeDIST">
                    </div>
                    <div class="form-group col-md-1">

                        <input type="text" class="form-control" id="axisLeftEyeDIST" name="axisLeftEyeDIST">
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-2">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-2">
                        <label class="text-dark">NEAR.</label>
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="sphRightEyeNEAR" name="sphRightEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="cylRightEyeNEAR" name="cylRightEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="axisRightEyeNEAR" name="axisRightEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="sphLeftEyeNEAR" name="sphLeftEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">
                        <input type="text" class="form-control" id="cylLeftEyeNEAR" name="cylLeftEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">

                        <input type="text" class="form-control" id="axisLeftEyeNEAR" name="axisLeftEyeNEAR">
                    </div>
                    <div class="form-group col-md-1">
                    </div>
                    <div class="form-group col-md-2">
                    </div>
                </div>

                <div class="custom-file" id = "attachFileForPrescription">
                    <div class="form-group col-md-5">
                        <input type="file" class="custom-file-input" id="customFile">
                        <label class="custom-file-label" for="customFile">Attach Your file</label>
                    </div>
                </div>

                <div class="text-center mt-1-half" id = "buttonForPrescription">
                    <button type="button" id="SubmitButtonPrescription" class="btn btn-primary">
                        Submit <i class="fa fa-chcek ml-1"></i>
                    </button>
                    <button type="button" id="UpdateButtonPrescription" class="btn btn-primary HideThisElement">Update</button>
                    <!-- <button type="button" class="btn btn-outline-info waves-effect" id="closeViewBtn">Close</button> -->
                       <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </form>

        </body>

        </html>