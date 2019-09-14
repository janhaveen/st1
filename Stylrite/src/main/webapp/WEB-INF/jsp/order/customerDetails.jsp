<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <form name="insertCustomerDetails" id="insertCustomerDetails">
              <input type="hidden" id="customerId">
               <div class="form-group col-md-3 ">
                   <label id="mobileNoLbl" for="mobileNo" class="">Mobile No</label>
                   <input type="number" class="form-control" id="mobileNo" name="mobileNo">
               </div>
               <div class="form-group col-md-5 HideThisElement" id="customernameDiv">
                   <label id="customerNameLbl" for="firstName" class="">Customer name</label>
                   <input type="text" class="form-control capitalizeText" id="customerName" name="customerName">

               </div>

               <div class="form-group col-md-4 HideThisElement" id="emailidDiv">
                   <label id="emailIdLbl" for="emailId" pattern=".+@.+..+" class="">Email ID</label>
                   <input type="text" class="form-control validate" id="emailId" name="emailId">
               </div>
            </form>
        </body>

        </html>