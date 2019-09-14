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
            <form name="insertProduct" id="insertProduct">
                <input type="hidden" name="rowId" id="ProductId">
                <div class="form-row HideThisElement" id="insertGRN">
                    <div class="form-group col-md-3">
                        <label for="brand">Brand <span class="mandatory-element">*</span></label>
                        <select class="form-control" id="brandName" name="brand">
                            <option value="" selected>Select Brand</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label id="modelNoLbl" for="modelNo" class="">Model No <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control" id="modelNo" name="modelNo" placeholder="Model No">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Color <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control" id="color" name="color" placeholder="Color">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Size <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control" id="size" name="size" placeholder="Size">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="hsnId">HSN ID <span class="mandatory-element">*</span></label>
                        <select class="form-control" id="hsnId" name="hsnId">
                            <option value="" selected>Select HSN ID</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="type">Type <span class="mandatory-element">*</span></label>
                        <select class="form-control" id="type" name="type">
                            <option value="" selected>Select Product Type</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Quantity <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control" id="qty" name="qty" placeholder="Quantity">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Price <span class="mandatory-element">*</span></label>
                        <input type="number" class="form-control" id="price" name="price" placeholder="Price">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Selling Price <span class="mandatory-element">*</span></label>
                        <input type="number" class="form-control" id="cost" name="cost" placeholder="Selling Price">
                    </div>
                     <div class="form-group col-md-9" id = "tagProduct">
			                  <label>Tags</label>
			                  <input type="text" class="form-control" id="tags" name="tags"  placeholder="Tags">	
			          </div>

                    <button type="button" id="saveProduct" class="btn btn-sm btn-primary">Submit</button> &nbsp;
                    <button type="button" id="backProduct" class="btn btn-sm btn-outline-primary">Back</button>
                </div>
            </form>
        </body>

        </html>