<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>

<h2>Customer details | ${customer.forename} ${customer.surname} |id: ${customer.id}</h2>

<table class="table">

    <tr>
        <th>phone number:</th>
        <td>${customer.phoneNumber}</td>
    </tr>
    <tr>
        <th>date of birth</th>
        <td>${customer.birthDate}</td>
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

<h3>Add new vehicle:</h3>

<jsp:include page="forms/vehicleAddForm.jsp"/>


<h3>Customer vehicles:</h3>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>brand</th>
        <th>model</th>
        <th>production year</th>
        <th>registration number</th>
        <th>next inspection</th>
        <th colspan="3">actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerVehicles}" var="vehicle">
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.model}</td>
            <td>${vehicle.productionYear}</td>
            <td>${vehicle.registrationNumber}</td>
            <td>${vehicle.nextInspection}</td>
            <td>
                <a href="/vehicle/details?vehicleID=${vehicle.id}" class="btn btn-primary">Details</a>
            </td>
            <td><a href="/vehicle/edit?vehicleID=${vehicle.id}" class="btn btn-primary">Edit</a>
            </td>
            <td>
                <a href="/vehicle/delete?vehicleID=${vehicle.id}" class="btn btn-primary">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>Customer orders history:</h3>

<table class="table">
    <tr>
        <th>order ID</th>
        <th>Receive Date</th>
        <th>employee</th>
        <th>Vehicle</th>
        <th>Status</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${customerOrders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.receiveDate}</td>
            <td>${order.employee.surname} ${order.employee.forename}</td>
            <td>${order.vehicle.model} ${order.vehicle.brand} ${order.vehicle.registrationNumber}</td>
            <td>${order.status}</td>
            <td>
                <a href="/order/details?orderID=${order.id}" class="btn btn-primary">Details</a>
            </td>
            <td><a href="/order/edit?orderID=${order.id}" class="btn btn-primary">Edit</a>
            </td>
            <td>
                <a href="/order/delete?orderID=${order.id}" class="btn btn-primary">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="default/footer.jsp" %>