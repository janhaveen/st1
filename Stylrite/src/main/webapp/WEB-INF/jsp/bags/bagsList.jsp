<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en">

        <head>

        </head>

        <body>
            <div class="card" id="showBagsDiv">
                <div class="card-body table-responsive-md">
                    <h5 class="card-title">Bags List</h5>
                    <hr>
                    <table id="showBagstableList" class="cell-border table table-hover mb-0 nowrap">
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