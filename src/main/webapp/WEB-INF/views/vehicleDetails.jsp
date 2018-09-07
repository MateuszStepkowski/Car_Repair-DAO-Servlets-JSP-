<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>

<h2>Vehicle details | ID: ${vehicle.id}</h2>

<table class="table">
    <tbody>
    <tr>
        <th>customer</th>
        <td>
            <a href="/customer/details?customerID=${vehicle.customer.id}" class="btn btn-primary">${vehicle.customer.forename} ${vehicle.customer.surname}</a>
        </td>
    </tr>
    <tr>
        <th>brand</th>
        <td>${vehicle.brand}</td>
    </tr>
    <tr>
        <th>model</th>
        <td>${vehicle.model}</td>

    </tr>
    <tr>
        <th>production year</th>
        <td>${vehicle.productionYear}</td>
    </tr>
    <tr>
        <th>registration number</th>
        <td>${vehicle.registrationNumber}</td>
    </tr>
    <tr>
        <th>next inspection</th>
        <td>${vehicle.nextInspection}</td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="/vehicle/edit?vehicleID=${vehicle.id}" class="btn btn-primary">Edit</a>
        </td>
    </tr>

    </tbody>
</table>

<h3>Our History of this Car:</h3>

<table class="table">
    <tr>
        <th>order ID</th>
        <th>Receive Date</th>
        <th>planned start date</th>
        <th>Status</th>
        <th>employee</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${vehicleOrdersHistory}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.receiveDate}</td>
            <td>${order.plannedStartDate}</td>
            <td>${order.status}</td>
            <td>${order.employee.surname} ${order.employee.forename}</td>
            <td>
                <a href="/order/details?orderID=${order.id}" class="btn btn-primary">Details</a>
            </td>
            <td>
                <a href="/order/edit?orderID=${order.id}" class="btn btn-primary">Edit</a>
            </td>
            <td>
                <a href="/order/delete?orderID=${order.id}" class="btn btn-primary">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>



<%@include file="default/footer.jsp" %>
