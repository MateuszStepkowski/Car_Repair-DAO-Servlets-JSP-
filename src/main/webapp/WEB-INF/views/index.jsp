<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp"%>

<h2>Not Ready Yet</h2>

<table class="table">
    <tr>
        <th>order ID</th>
        <th>status</th>
        <th>receive date</th>
        <th>Start date</th>
        <th>employee</th>
        <th>vehicle</th>
        <th>problem description</th>
        <th>details</th>
    </tr>
    <c:forEach items="${ordersNotReady}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.status}</td>
            <td>${order.receiveDate}</td>
            <td>${order.startDate}</td>
            <td>${order.employee.surname} ${order.employee.forename}</td>
            <td>${order.vehicle.model} ${order.vehicle.brand}</td>
            <td>${order.problemDescription}</td>


            <td>
                <a href="/order/details?orderID=${order.id}" class="btn btn-primary">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="default/footer.jsp"%>

