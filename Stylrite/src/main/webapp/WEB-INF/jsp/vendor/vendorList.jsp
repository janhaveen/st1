<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
        
        </head>

        <body>
		    <div class="card" id="venderTableDiv">
		        <div class="card-body table-responsive-md">
		            <h5 class="card-title">Vendor List</h5>
		            <hr>
		            <table id="showVendortableList" class="cell-border table table-hover mb-0 nowrap">
		                <thead>
		                    <tr id="headerrow">
		                        <th>#</th>
		                        <th>VendorName</th>
		                        <th>ContactNo</th>
		                        <th>Email</th>
		                        <th>Location</th>
		                        <th>CompanyName</th>
		                    </tr>
		                    <tr id="filterrow">
		                        <th></th>
		                        <th>VendorName</th>
		                        <th>ContactNo</th>
		                        <th>Email</th>
		                        <th>Location</th>
		                        <th>CompanyName</th>
		                    </tr>
		                </thead>
		            </table>
		        </div>
		    </div>
	  </body>

        </html>