<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showHsnDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Hsn List</h5>
                    <hr>
                    <table id="showHsntableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow">
                                <th>#</th>
                                <th>HSN Name</th>
                                <th>CGST</th>
                                <th>SGST</th>
                                <th>IGST</th>
                                <th>UGST</th>
                                
                              
                            </tr>
                            <tr id="filterrow">
                               <th>#</th>
                               <th>HSN Name</th>
                               <th>CGST</th>
                               <th>SGST</th>
                               <th>IGST</th>
                               <th>UGST</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>