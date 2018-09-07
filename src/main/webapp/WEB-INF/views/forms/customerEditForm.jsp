<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp" %>

<h2>Edit Customer | id: ${customer.id} </h2>

<form action="/customer/edit" method="post">

    <input type="hidden" value="${customer.id}" name="customerID">

    <label>
        forename:
        <input type="text" name="forename" required value="${customer.forename}">
    </label></br>
    <label>
        surname:
        <input type="text" name="surname" required value="${customer.surname}">
    </label></br>
    <label>
        phone number:
        <input type="text" name="phoneNumber" required value="${customer.phoneNumber}">
    </label></br>
    <label>
        date of birth:
        <input type="date" name="birthDate" value="${customer.birthDate}">
    </label></br>
    <input type="submit" value="save changes">

</form>

<%@include file="../default/footer.jsp" %>
