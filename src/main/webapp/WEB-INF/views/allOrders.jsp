<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp"%>

<h4>Add new order:</h4>

<jsp:include page="forms/orderAddForm.jsp"/>


<h3>all Orders: </h3>

<table class="table">
    <tr>
        <th>order ID</th>
        <th>Receive Date</th>
        <th>employee</th>
        <th>Vehicle</th>
        <th>Status</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${orders}" var="order">
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

<%@include file="default/footer.jsp"%>