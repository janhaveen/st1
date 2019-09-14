<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
           <div class="card" id="frameAndSunglassDiv">
			    <div class="card-body table-responsive-md">
			    	<h5 class="card-title">Frame & Sunglass List</h5><hr>		
			    	<table id="showFrameAndSunglassTableList" class="cell-border table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
					            <th>BarCode</th>
					            <th>Brand</th>
					            <th>Price</th>
					        </tr>
					         <tr id="filterrow">
					            <td></td>
					            <th>BarCode</th>
					            <th>Brand</th>
					            <th>Price</th>
					        </tr>
					    </thead>
					</table>
			    </div>
			</div>
        </body>

        </html>