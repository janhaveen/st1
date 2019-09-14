<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
           <div class="card" id="empTableDiv">
			    <div class="card-body table-responsive-md">
			    	<h5 class="card-title">Employee List</h5><hr>		
			    	<table id="showEmployeetableList" class="cell-border table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
					            <th>Employee Name</th>
					            <th>Department</th>
					            <th>Designation</th>
					            <th>User ID</th>
					            <th>Mobile No</th>
					            <th>Email ID</th>
					            <th>Report To</th>
					            <th>Status</th>
					        </tr>
					         <tr id="filterrow">
					            <td></td>
					            <th>Employee Name</th>
					            <th>Department</th>
					            <th>Designation</th>
					            <th>User ID</th>
					            <th>Mobile No</th>
					            <th>Email ID</th>
					            <th>Report To</th>
					            <th>Status</th>
					        </tr>
					    </thead>
					</table>
			    </div>
			</div>
        </body>

        </html>