<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showJobsListDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Jobs List</h5>
                    <hr>
                    <table id="showJobstableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow">
                                <th>#</th>
                                <th>JobItem  Id</th>
                                <th>ProductInfo</th>
                                <th>JobitemStatus</th>
                                <th>vendorName</th>
                                
                              
                            </tr>
                            <tr id="filterrow">
                                <th>#</th>
                                <th>JobItem  Id</th>
                                <th>ProductInfo</th>
                                <th>JobitemStatus</th>
                                <th>vendorName</th>
                               
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>