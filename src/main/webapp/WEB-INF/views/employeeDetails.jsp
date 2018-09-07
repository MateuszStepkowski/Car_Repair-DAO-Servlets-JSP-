<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>

<h2>Employee details | ${employee.forename} ${employee.surname} |id: ${employee.id}</h2>

<table class="table">

    <tr>
        <th>address:</th>
        <td>${employee.address}</td>
    </tr>
    <tr>
        <th>phone number:</th>
        <td>${employee.phoneNumber}</td>
    </tr>
    <tr>
        <th>note</th>
        <td>${employee.note}</td>
    </tr>
    <tr>
        <th>hour salary:</th>
        <td>${employee.hourSalary}</td>
    </tr>
    <tr>
        <td>
            <a href="/employee/edit?employeeID=${employee.id}" class="btn btn-primary">Edit</a>
        </td>
        <td>
            <a href="/employee/delete?employeeID=${employee.id}" class="btn btn-primary">Delete</a>
        </td>
    </tr>

</table>

<h3>orders with 'IN_REPAIR' status:</h3>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Receive date:</th>
        <th>Start date:</th>
        <th>Vehicle</th>
        <td>actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${inRepairOrders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.receiveDate}</td>
            <td>${order.startDate}</td>
            <td>${order.vehicle.brand} ${order.vehicle.model} | ${order.vehicle.registrationNumber}</td>
            <td>
                <a href="/order/details?orderID=${order.id}" class="btn btn-primary">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>rest of orders:</h3>

<table class="table">
<thead>
<tr>
    <th>ID</th>
    <th>Receive date:</th>
    <th>Planned start date:</th>
    <th>status:</th>
    <th>Vehicle</th>
    <th>actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${restOfOrders}" var="order">
    <tr>
        <td>${order.id}</td>
        <td>${order.receiveDate}</td>
        <td>${order.plannedStartDate}</td>
        <td>${order.status}</td>
        <td>${order.vehicle.brand} ${order.vehicle.model} | ${order.vehicle.registrationNumber}</td>
        <td>
            <a href="/order/details?orderID=${order.id}" class="btn btn-primary">Details</a>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>


<%@include file="default/footer.jsp" %>