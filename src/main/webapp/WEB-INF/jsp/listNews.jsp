<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>News List</title>

  </head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>News List</h2>
        <hr />

        <input type="button" value="Add Customer"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">News List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>title</th>
                        <th>createdDate</th>
                        <th>text</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempCustomer" items="${news}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <tr>
                            <td>${tempCustomer.title}</td>
                            <td>${tempCustomer.text}</td>
                            <td>${tempCustomer.createdDate}</td>

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>