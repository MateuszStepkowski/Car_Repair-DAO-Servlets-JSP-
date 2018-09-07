<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp"%>

<h4>Add new employee:</h4>

<form action="/employee/add" method="POST">

    <label>
        forename:
        <input type="text" name="forename">
    </label></br>
    <label>
        surname:
        <input type="text" name="surname">
    </label></br>
    <label>
        address:
        <input type="text" name="address">
    </label></br>
    <label>
        phone number:
        <input type="text" name="phoneNumber">
    </label></br>
    <label>
        note:
        <textarea name="note" cols="12" rows="4"></textarea>
    </label></br>
    <label>
        hour salary:
        <input type="text" name="hourSalary">
    </label></br>
    <input type="submit" value="Add new Employee">

</form>


<table id="table_template">
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
