<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>

<h2>Order details | id: ${order.id}</h2>

<table class="table">
    <tr>
        <th>Receive date:</th>
        <td>${order.receiveDate}</td>
    </tr>
    <tr>
        <th>planned start:</th>
        <td>${order.plannedStartDate}</td>
    </tr>
    <tr>
        <th>Start date:</th>
        <td>${order.startDate}</td>
    </tr>
    <tr>
        <th>End date:</th>
        <td>${order.endDate}</td>
    </tr>
    <tr>
        <th>employee:</th>
        <td>${order.employee.surname} ${order.employee.forename}</td>
    </tr>
    <tr>
        <th>Status:</th>
        <td>${order.status}</td>
    </tr>
    <tr>
        <th>Vehicle:</th>
        <td>${order.vehicle.brand} ${order.vehicle.model} ${order.vehicle.registrationNumber}</td>
    </tr>
    <tr>
        <th>Problem description:</th>
        <td>${order.problemDescription}</td>
    </tr>
    <tr>
        <th>Repair description:</th>
        <td>${order.repairDescription}</td>
    </tr>
    <tr>
        <th>Client costs:</th>
        <td>${order.clientCosts}</td>
    </tr>
    <tr>
        <th>parts cost:</th>
        <td>${order.partsCost}</td>
    </tr>
    <tr>
        <th>service cost per hour:</th>
        <td>${order.serviceCostPerHour}</td>
    </tr>
    <tr>
        <th>service hours amount:</th>
        <td>${order.hoursAmount}</td>
    </tr>
    <tr>
        <td><a href="/order/edit?orderID=${order.id}" class="btn btn-primary">Edit</a>
        </td>
        <td>
            <a href="/order/delete?orderID=${order.id}" class="btn btn-primary">Delete</a>
        </td>
    </tr>
</table>



<%@include file="default/footer.jsp" %>