<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp"%>

<h2>Edit order | id: ${order.id} </h2>

 <form action="/order/edit" method="POST">
    <input type="hidden" value="${order.id}" name="orderID">
    <label>
        Receive date:
        <input type="date" name="receiveDate" required value="${order.receiveDate}">
    </label></br>
    <label>Planned start date:
    <input type="date" name="plannedStartDate" required value="${order.plannedStartDate}">
    </label></br>
    <label>
        Start date:
        <input type="date" name="startDate" value="${order.startDate}">
    </label></br>
    <label>End date:
    <input type="date" name="endDate" value="${order.endDate}">
    </label></br>
    <label>
        Employee:
        <select name="employee">
            <option>"=="</option>
            <c:forEach items="${employees}" var="employee">
                <option value="${employee.id}">${employee.surname} ${employee.forename}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Problem description:
        <input type="text" name="problemDescription">
    </label></br>
    <label>
        Repair description:
        <input type="text" name="repairDescription">
    </label></br>
    <label>
        Status:
        <select name="status">
            <c:forEach items="${statuses}" var="status">
                <option value="${status}">${status}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Vehicle:
        <select name="vehicle">
            <c:forEach items="${vehicles}" var="vehicle">
                <option value="${vehicle.id}">${vehicle.brand} ${vehicle.model} | ${vehicle.registrationNumber}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Client Costs:
        <input type="text" name="clientCosts" value="${order.clientCosts}">
    </label></br>
    <label>
        Parts price:
        <input type="text" name="partsCost" value="${order.partsCost}">
    </label></br>
    <label>
        service hours amount:
        <input type="text" name="hoursAmount" value="${order.hoursAmount}">
    </label></br>

    <input type="submit" value="save changes">
</form>

<%@include file="../default/footer.jsp" %>