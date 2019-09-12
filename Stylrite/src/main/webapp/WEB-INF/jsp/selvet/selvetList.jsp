<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showSelvetDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Selvet List</h5>
                    <hr>
                    <table id="showSelvettableList" class="cell-border table table-hover mb-0 nowrap">
                        <thead>
                            <tr id="headerrow">
                                <th>#</th>
                                <th>Brand</th>
                                <th>Type</th>
                            </tr>
                            <tr id="filterrow">
                                <th>#</th>
                                <th>Brand</th>
                                <th>Type</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </body>

        </html>