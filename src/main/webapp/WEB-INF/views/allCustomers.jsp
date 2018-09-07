<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp"%>

<h4>Add new customer:</h4>

<jsp:include page="forms/customerAddForm.jsp"/>

<h3>all Customers: </h3>


<table class="table">
    <tr>
        <th>ID</th>
        <th>forename</th>
        <th>surname</th>
        <th>phone number</th>
        <th>date of birth</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.forename}</td>
            <td>${customer.surname}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.birthDate}</td>
            <td>
                <a href="/customer/details?customerID=${customer.id}" class="btn btn-primary">Details</a>
            </td>
            <td><a href="/customer/edit?customerID=${customer.id}" class="btn btn-primary">Edit</a>
            </td>
            <td>
                <a href="/customer/delete?customerID=${customer.id}" class="btn btn-primary">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>


<%@include file="default/footer.jsp"%>