<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp" %>


<form action="/report/employeesWorkingHours" method="post">


    <label>
        from date:
        <input type="date" name="fromDate" required value="${fromDate}">
    </label></br>
    <label>to date:
        <input type="date" name="toDate" required value="${toDate}">
    </label></br>

    <input type="submit" value="generate">

</form>

<h2> Employees Working Hours Report </h2>
<h3>from:${fromDate} | to:${toDate}</h3>

<table class="table">
    <tr>
        <th>employee</th>
        <th>hours Amount</th>
    </tr>
    <c:forEach items="${reportList}" var="report">
    <tr>
        <td>${report.employeeFullName}</td>
        <td>${report.hoursAmount}</td>
    </tr>
    </c:forEach>
</table>


<%@include file="../default/footer.jsp" %>