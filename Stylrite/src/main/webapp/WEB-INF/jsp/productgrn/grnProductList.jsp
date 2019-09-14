<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showGrnProductDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Grn List</h5>
                    <hr>
                    <table id="showGrnProducttableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow">
                                <th>#</th>
                                <th>Grn No</th>
                                <th>Vendor Name</th>
                                <th>Vendor No</th>
                                <th>Grn Date</th>
                                <th>Purchase Date</th>
                                <th>Receipt Date</th>   
                                <th>Received By</th>   
                            </tr>
                            <tr id="filterrow">
                                <th>#</th>
                                <th>Grn No</th>
                                <th>Vendor Name</th>
                                <th>Vendor No</th>
                                <th>Grn Date</th>
                                <th>Purchase Date</th>
                                <th>Receipt Date</th>   
                                <th>Received By</th>  
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>