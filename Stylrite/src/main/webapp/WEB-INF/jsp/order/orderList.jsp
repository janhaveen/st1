<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showOrderDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Order List</h5>
                    <hr>
                    <table id="showOrdertableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow" class="">
                                <th>#</th>
                                <th>OrderId</th>
                                <th>OrderDate</th>
                                <th>Customer Name</th>
                                <th>Mobile No</th>
                                <th>Email ID</th>
                                <th>Remarks</th>
                            </tr>
                            <tr id="filterrow">
                                <td>#</td>
                                <th>OrderId</th>
                                <th>OrderDate</th>
                                <th>Customer Name</th>
                                <th>Mobile No</th>
                                <th>Email ID</th>
                                <th>Remarks</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>