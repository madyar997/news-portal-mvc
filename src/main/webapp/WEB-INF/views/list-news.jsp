<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>javaguides.net</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link href="../../resources/css/list-news.css">
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>News Portal</h2>
        <hr/>

        <input type="button" value="Add News"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary"/>
        <br/><br/>

        <c:forEach var="theNews" items="${news}">
            <div class="container-my">
                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/newsportal/updateForm">
                    <c:param name="newsId" value="${theNews.id}" />
                </c:url>

                <!-- construct an "delete" link with customer id -->
                <c:url var="deleteLink" value="/newsportal/delete">
                    <c:param name="newsId" value="${theNews.id}" />
                </c:url>
                <div class="div-news">
                    <div class="div-title-data">
                        <h4>${theNews.id}</h4>
                        <h3>${theNews.title}</h3>
                        <span>${theNews.createdDate}</span>
                    </div>
                    <div>
                        <p>${theNews.text}</p>
                    </div>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                </div>
            </div>
        </c:forEach>


    </div>

</div>
</body>
</html>