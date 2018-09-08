<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp" %>


<form action="/report/profitsReport" method="post">


    <label>
        from date:
        <input type="date" name="fromDate" required value="${fromDate}">
    </label></br>
    <label>to date:
        <input type="date" name="toDate" required value="${toDate}">
    </label></br>

    <input type="submit" value="generate">

</form>

<h2> Profits Report </h2>
<h3>from:${fromDate} | to:${toDate}</h3>

<table class="table">
    <thead>
    <tr>
        <th>clients Costs</th>
        <th>parts Cost</th>
        <th>service Cost</th>
        <th>hours Amount</th>
        <th>avg service cost per hour</th>
        <th>profit</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${profitsReport.clientCosts}</td>
            <td>${profitsReport.partsCost}</td>
            <td>${profitsReport.serviceCost}</td>
            <td>${profitsReport.hoursAmount}</td>
            <td>${profitsReport.avgCostPerHour}</td>
            <td>${profitsReport.profit}</td>
        </tr>
    </tbody>
</table>


<%@include file="../default/footer.jsp" %>