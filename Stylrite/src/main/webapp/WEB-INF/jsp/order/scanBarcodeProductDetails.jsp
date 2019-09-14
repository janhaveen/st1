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
            <form name="insertOrderItem" id="insertOrderItem">
                <input type="hidden" name="rowId" id="orderItemId">
                <br>
                <p style="font-size: 120%;margin-bottom: 1%;"> Frame & Sunglass Product</p>
                <table id="showProductOrderFormList" class="cell-border table table-hover mb-0 nowrap">
                    <thead>
                        <tr id="headerrow">
                            <th>Action</th>
                            <th>BarCode</th>
                            <th>Product Info</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Tax (%)</th>
                            <th>Disc (%)</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody id="ProductDataBody"></tbody>
                    <!--  <tfoot>
                        <tr>
                            <td class="right" colspan="9"><b>Total</b></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalrs" name="totalrs"></span></i>
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><b>Tax Amount (18%)</b></td>
                            <td style="width:10%;">
                               <i><span class="label label-primary" value="0" id="taxrs" name="taxrs"></span></i>
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Total Amount</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalAmountrs" name="totalAmountrs"></span></i>
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Special Discount</b></td>
                            <td>
                                <input type="text"  value="0" class="form-control" id="specialDiscount" name="specialDiscount">
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Grant Total</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="grantTotalrs" name="grantTotalrs"></span></i>
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Advance</b></td>
                            <td>
                                <input type="text"  value="0" class="form-control" id="advancers" name="advancers">
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Balance</b></td>
                            <td>
                                <i><span class="label label-primary" value="0" id="balancers" name="balancers"></span></i>

                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Total Payable Amount</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalPayableAmountrs" name="totalPayableAmountrs"></span></i>
                            </td>
                        </tr>
                    </tfoot> -->
                </table>
                <br>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <button type="button" id="DeleteProduct" class="btn btn-sm btn-primary">Delete Product</button>
                    </div>
                </div>
                <br>
                <p style="font-size: 120%;margin-bottom: 1%;"> Lens Product</p>
                <table id="showLensOrderFormList" class="cell-border table table-hover mb-0 nowrap">
                    <thead>
                        <tr id="headerrow">
                            <th>Action</th>
                            <th>Brand</th>
                            <th>Model No</th>
                            <th>Specification 1</th>
                            <th>Specification 2</th>
                            <th>Specification 3</th>
                            <th>Price</th>
                            <th>Cost</th>
                        </tr>
                    </thead>
                    <tbody id="LensDataBody"></tbody>
                     <tfoot>
                        <tr>
                            <td class="right" colspan="9"><b>Total</b></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalrs" name="totalrs"></span></i>
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><b>Tax Amount (18%)</b></td>
                            <td style="width:10%;">
                               <i><span class="label label-primary" value="0" id="taxrs" name="taxrs"></span></i>
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Total Amount</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalAmountrs" name="totalAmountrs"></span></i>
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Special Discount</b></td>
                            <td>
                                <input type="text"  value="0" class="form-control" id="specialDiscount" onfocusout="ChangeSpecialDiscount()" name="specialDiscount">
                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Grant Total</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="grantTotalrs" name="grantTotalrs"></span></i>
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Advance</b></td>
                            <td>
                                <input type="text"  value="0" class="form-control" id="advancers" name="advancers">
                            </td>
                        </tr>
                        <tr>
                            <td class="right" colspan="9"><b>Balance</b></td>
                            <td>
                                <i><span class="label label-primary" value="0" id="balancers" name="balancers"></span></i>

                            </td>
                        </tr>
                         <tr>
                            <td class="right" colspan="9"><h6><b>Total Payable Amount</b></h6></td>
                            <td style="width:10%;">
                                <i><span class="label label-primary" value="0" id="totalPayableAmountrs" name="totalPayableAmountrs"></span></i>
                            </td>
                        </tr>
                    </tfoot>
                </table>
                <br>
               <!--  <div class="form-row">
                    <div class="form-group col-md-4">
                        <button type="button" id="DeleteProduct" class="btn btn-sm btn-primary">Delete Lens Product</button>
                    </div>
                </div> -->

            </form>
        </body>

        </html>