<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp"%>

<h4>Add new employee:</h4>

<jsp:include page="forms/employeeAddForm.jsp"/>

<h3>all Employees: </h3>


<table class="table">
    <tr>
        <th>ID</th>
        <th>forename</th>
        <th>surname</th>
        <th>Address</th>
        <th>phone number</th>
        <th>note</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.forename}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.note}</td>
            <td>
                <a href="/employee/details?employeeID=${employee.id}" class="btn btn-primary">|orders & details|</a>
            </td>
            <td><a href="/employee/edit?employeeID=${employee.id}" class="btn btn-primary">Edit</a>
            </td>
            <td>
                <a href="/employee/delete?employeeID=${employee.id}" class="btn btn-primary">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>


<%@include file="default/footer.jsp"%>
