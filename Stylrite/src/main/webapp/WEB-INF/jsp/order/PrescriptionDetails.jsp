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
            <form name="insertPrescriptionDetails" id="insertPrescriptionDetails">
             <input type="hidden" name="rowId" id="PrescriptionId">
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
            </form>

        </body>

        </html>