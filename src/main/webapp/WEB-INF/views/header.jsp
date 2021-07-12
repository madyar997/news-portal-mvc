<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="../../../resources/css/header.css">
</head>
<body>
<div class="header">
    <%--    <h1>${isAdmin}</h1>--%>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal">Newsportal</h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/newsportal/"><spring:message code="label.news"/></a>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="p-2 text-dark" href="/login"><spring:message code="label.login"/></a>
                <a class="p-2 text-dark" href="/registration"><spring:message code="label.register"/></a>
            </c:if>
            <a class="p-2 text-dark" href="/newsportal/?lang=en">En</a>
            <a class="p-2 text-dark" href="/newsportal/?lang=ru">Ru</a>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a class="p-2 text-dark" href="/admin"><spring:message code="label.admin-menu"/></a>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a class="p-2 text-dark" href="/user"><spring:message code="label.user-menu"/></a>
                </sec:authorize>

                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <a class="p-2 text-dark" onclick="document.forms['logoutForm'].submit()"><spring:message
                        code="label.logout"/></a>
            </c:if>
        </nav>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
