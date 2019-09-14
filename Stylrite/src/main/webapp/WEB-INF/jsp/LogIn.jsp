<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <meta http-equiv="x-ua-compatible" content="ie=edge">
                <link rel="shortcut icon" href="/resources/img/favicon.ico">
                <title>Stylrite</title>

                <!-- Font Awesome -->
                <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />" rel="stylesheet">

                <!-- Bootstrap core CSS -->
                <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

                <!-- Material Design Bootstrap -->
                <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet">

                <!-- data table css -->
                <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet">

                <link href="<c:url value="/resources/css/buttons.dataTables.min.css" />" rel="stylesheet">

                <!-- Your custom styles (optional) -->
                <link href="<c:url value="/resources/css/lms/lms.css" />" rel="stylesheet">

                <!-- Date time css -->
                <link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">

                <style>
                    #mydiv {
                        position: fixed;
                        top: 30%;
                        left: 50%;
                        width: 30em;
                        height: 35em;
                        margin-top: -9em;
                        /*set to a negative number 1/2 of your height*/
                        margin-left: -15em;
                        /*set to a negative number 1/2 of your width*/
                    }
                </style>

            </head>

            <body class="fixed-sn white-skin">
                <!-- Material form login -->
                <div id="mydiv" class="card">

                    <h5 class="card-header text-center py-4" style="background-color: bisque;">
					   <img style="width: 51%;margin-bottom:  -5%;margin-top: -5%;" src="resources/img/CompanyLogo.png" class="CompanyLogo">
					  </h5>

                    <!--Card content-->
                    <div class="card-body px-lg-5 pt-0">

                        <!-- Form -->
                        <form class="text-center col-md-12 " style="color: #757575;" id="logInEmployee" method="post">

                            <!-- Email -->
                            <div class="md-form">
                                <input type="text" id="emailId" class="form-control" name="emailId" required>
                                <label for="email">E-mail</label>
                            </div>

                            <!-- Password -->
                            <div class="md-form">
                                <input type="password" id="password" class="form-control" name="password" required>
                                <label for="password">Password</label>
                            </div>

                            <div class="d-flex justify-content-around">
                                <div>
                                    <!-- Remember me -->
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
                                        <label class="form-check-label" for="materialLoginFormRemember">Remember me</label>
                                    </div>
                                </div>
                                <div>
                                    <!-- Forgot password -->
                                    <a href="">Forgot password?</a>
                                </div>
                            </div>

                            <!-- Sign in button -->
                            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="button" onclick="login()">Sign in</button>

                            <!-- Register -->
                            <p>Not a member?
                                <a href="#">Register</a>
                            </p>

                        </form>
                        <!-- Form -->

                    </div>

                </div>
                <!-- Material form login -->

                <!-- SCRIPTS -->
                <!-- JQuery -->

                <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>

                <!-- Bootstrap tooltips -->
                <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>

                <!-- Bootstrap core JavaScript -->
                <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>

                <!-- MDB core JavaScript -->
                <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>

                <!-- data table cdns -->
                <script type="text/javascript" src="<c:url value="/resources/js/vendor/datatables/js/jquery.dataTables.min.js" />"></script>

                <script src="<c:url value="/resources/js/vendor/datatables/js/dataTables.bootstrap4.min.js" />"></script>

                <script src="<c:url value="/resources/js/vendor/datatables/js/dataTables.buttons.min.js" />"></script>

                <!-- Date time Js -->
                <script src="<c:url value="/resources/js/moment.min.js" />"></script>

                <script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>

                <script src="<c:url value="/resources/js/sweetalert.min.js" />"></script>

                <script src="<c:url value="/resources/js/fun_with_svg_arcs.js" />"></script>
                
                <script type="text/javascript">
                
                function login(){
          		  
          		    var a=document.forms["logInEmployee"]["emailId"].value;
          	        var b=document.forms["logInEmployee"]["password"].value;
          	        if (a==null || a=="",b==null || b=="")
          	        {
          	            alert("Please Fill All Required Field");
          	            return false;
          	        }
          	        else
          	        {
          	        	//on();
          	    	$.ajax
          	    	({
          	            type: "POST",
          	            url: 'logInEmployee',
          	            data: $("#logInEmployee").serialize(), // serializes the form's elements.
          	            success: function(data)
          	            {
                             // off();
          	                if (data == 1) 
          	                {
          	                	window.location = 'Home';
          					}
          	                else if (data == 2) 
          	                {
          						alert("Email Id Or Password Invalid !");
          					}
          	                else if (data == 500) 
        	                {
        						alert("Invalid !");
        					}
          				}
          	 	       });
          	        }
          	    }
                
                </script>
            </body>

            </html>