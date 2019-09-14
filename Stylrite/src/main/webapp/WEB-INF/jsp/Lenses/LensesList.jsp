<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showLensesDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Lenses List</h5>
                    <hr>
                    <table id="showLensestableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow">
                                <th>#</th>
                                <th>Brand</th>
                                <th>Model</th>
                                <th>Specification1</th>
                                <th>Specification2</th>
                                <th>Specification3</th>
                                <th>Price</th>
                                <th>Cost</th>
                              
                            </tr>
                            <tr id="filterrow">
                                <th>#</th>
                                 <th>Brand</th>
                                <th>Model</th>
                                <th>Specification1</th>
                                <th>Specification2</th>
                                <th>Specification3</th>
                               <th>Price</th>
                               <th>Cost</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>